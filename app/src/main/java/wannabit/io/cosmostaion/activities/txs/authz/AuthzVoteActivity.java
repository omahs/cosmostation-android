package wannabit.io.cosmostaion.activities.txs.authz;

import static wannabit.io.cosmostaion.base.BaseConstant.CONST_PW_TX_AUTHZ_VOTE;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.common.collect.Lists;

import java.util.ArrayList;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.activities.PasswordCheckActivity;
import wannabit.io.cosmostaion.activities.TxDetailgRPCActivity;
import wannabit.io.cosmostaion.base.BaseBroadCastActivity;
import wannabit.io.cosmostaion.base.BaseChain;
import wannabit.io.cosmostaion.base.BaseFragment;
import wannabit.io.cosmostaion.base.chains.ChainFactory;
import wannabit.io.cosmostaion.fragment.StepFeeSetFragment;
import wannabit.io.cosmostaion.fragment.StepMemoFragment;
import wannabit.io.cosmostaion.fragment.txs.authz.AuthzVoteStep0Fragment;
import wannabit.io.cosmostaion.fragment.txs.authz.AuthzVoteStep1Fragment;
import wannabit.io.cosmostaion.fragment.txs.authz.AuthzVoteStep4Fragment;
import wannabit.io.cosmostaion.network.res.ResProposal;
import wannabit.io.cosmostaion.task.gRpcTask.broadcast.AuthzVoteGrpcTask;

public class AuthzVoteActivity extends BaseBroadCastActivity {

    private Toolbar mToolbar;
    private TextView mTitle;
    private ImageView mIvStep;
    private TextView mTvStep;
    private ViewPager2 mViewPager;
    private AuthzVotePageAdapter mPageAdapter;

    public ArrayList<ResProposal> mProposalsList = Lists.newArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        mToolbar = findViewById(R.id.tool_bar);
        mTitle = findViewById(R.id.toolbar_title);
        mIvStep = findViewById(R.id.send_step);
        mTvStep = findViewById(R.id.send_step_msg);
        mViewPager = findViewById(R.id.view_pager);
        mTitle.setText(getString(R.string.str_authz_vote_title));

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mIvStep.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.step_1_img));
        mTvStep.setText(getString(R.string.str_authz_vote_step_0));

        mAccount = getBaseDao().onSelectAccount(getBaseDao().getLastUser());
        mBaseChain = BaseChain.getChain(mAccount.baseChain);
        mChainConfig = ChainFactory.getChain(mBaseChain);
        mTxType = CONST_PW_TX_AUTHZ_VOTE;

        mGranter = getIntent().getStringExtra("granter");

        mPageAdapter = new AuthzVotePageAdapter(getSupportFragmentManager(), getLifecycle());
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setUserInputEnabled(false);
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    mIvStep.setImageDrawable(ContextCompat.getDrawable(AuthzVoteActivity.this, R.drawable.step_1_img));
                    mTvStep.setText(getString(R.string.str_authz_vote_step_0));
                } else if (i == 1) {
                    mIvStep.setImageDrawable(ContextCompat.getDrawable(AuthzVoteActivity.this, R.drawable.step_2_img));
                    mTvStep.setText(getString(R.string.str_authz_vote_step_1));
                } else if (i == 2) {
                    mIvStep.setImageDrawable(ContextCompat.getDrawable(AuthzVoteActivity.this, R.drawable.step_3_img));
                    mTvStep.setText(getString(R.string.str_tx_step_memo));
                } else if (i == 3) {
                    mIvStep.setImageDrawable(ContextCompat.getDrawable(AuthzVoteActivity.this, R.drawable.step_4_img));
                    mTvStep.setText(getString(R.string.str_tx_step_fee));
                } else if (i == 4) {
                    mIvStep.setImageDrawable(ContextCompat.getDrawable(AuthzVoteActivity.this, R.drawable.step_5_img));
                    mTvStep.setText(getString(R.string.str_tx_step_confirm));
                }
            }
        });
        mViewPager.setCurrentItem(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAccount == null) finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        onHideKeyboard();
        if (mViewPager.getCurrentItem() > 0) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
        } else {
            super.onBackPressed();
        }
    }

    public void onNextStep() {
        if (mViewPager.getCurrentItem() < mPageAdapter.getItemCount() - 1) {
            onHideKeyboard();
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
        }
    }

    public void onBeforeStep() {
        if (mViewPager.getCurrentItem() > 0) {
            onHideKeyboard();
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
        } else {
            onBackPressed();
        }
    }

    public void onAuthzVote() {
        if (getBaseDao().isAutoPass()) {
            onBroadCastTx();
        } else {
            Intent intent = new Intent(AuthzVoteActivity.this, PasswordCheckActivity.class);
            activityResultLauncher.launch(intent);
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.fade_out);
        }
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            onShowWaitDialog();
            onBroadCastTx();
        }
    });

    private void onBroadCastTx() {
        new AuthzVoteGrpcTask(getBaseApplication(), result -> {
            Intent txIntent = new Intent(AuthzVoteActivity.this, TxDetailgRPCActivity.class);
            txIntent.putExtra("isGen", true);
            txIntent.putExtra("isSuccess", result.isSuccess);
            txIntent.putExtra("errorCode", result.errorCode);
            txIntent.putExtra("errorMsg", result.errorMsg);
            String hash = String.valueOf(result.resultData);
            if (!TextUtils.isEmpty(hash)) txIntent.putExtra("txHash", hash);
            startActivity(txIntent);
        }, mBaseChain, mAccount, mGranter, mSelectedOpinion, mTxMemo, mTxFee, getBaseDao().getChainIdGrpc()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private static class AuthzVotePageAdapter extends FragmentStateAdapter {

        private final ArrayList<BaseFragment> mFragments = new ArrayList<>();

        public AuthzVotePageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            mFragments.clear();
            mFragments.add(AuthzVoteStep0Fragment.newInstance());
            mFragments.add(AuthzVoteStep1Fragment.newInstance());
            mFragments.add(StepMemoFragment.newInstance());
            mFragments.add(StepFeeSetFragment.newInstance());
            mFragments.add(AuthzVoteStep4Fragment.newInstance());
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragments.size();
        }
    }
}
