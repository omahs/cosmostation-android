package wannabit.io.cosmostaion.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import agency.tango.android.avatarview.AvatarPlaceholder;
import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.activities.MainActivity;
import wannabit.io.cosmostaion.base.BaseFragment;
import wannabit.io.cosmostaion.dao.BondingState;
import wannabit.io.cosmostaion.dao.Reward;
import wannabit.io.cosmostaion.model.type.Validator;
import wannabit.io.cosmostaion.network.ApiClient;
import wannabit.io.cosmostaion.network.res.ResKeyBaseUser;
import wannabit.io.cosmostaion.test.TestAdapter;
import wannabit.io.cosmostaion.utils.WDp;
import wannabit.io.cosmostaion.utils.WLog;

public class MainRewardFragment extends BaseFragment {

    private SwipeRefreshLayout          mSwipeRefreshLayout;
    private RecyclerView                mRecyclerView;
    private LinearLayoutManager         mLinearLayoutManager;

    private RewardAdapter                mRewardAdapter;

    private ArrayList<Validator>        mMyValidators = new ArrayList<>();
    private ArrayList<Validator>        mElseValidators = new ArrayList<>();
    private ArrayList<BondingState>     mBondings = new ArrayList<>();
    private ArrayList<Reward>           mRewards = new ArrayList<>();

    private IImageLoader                mImageLoader;

    public static MainRewardFragment newInstance(Bundle bundle) {
        MainRewardFragment fragment = new MainRewardFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_reward, container, false);
        mSwipeRefreshLayout     = rootView.findViewById(R.id.layer_refresher);
        mRecyclerView           = rootView.findViewById(R.id.recycler);

        mImageLoader = new PicassoLoader();

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        mLinearLayoutManager = new LinearLayoutManager(getBaseActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRewardAdapter = new RewardAdapter(mImageLoader);
        mRecyclerView.setAdapter(mRewardAdapter);
        return rootView;
    }


    @Override
    public void onRefreshTab() {
//        WLog.w("MainRewardFragment onRefreshTab");
        if(!isAdded()) return;
        mMyValidators   = getMainActivity().mMyValidators;
        mElseValidators = getMainActivity().mElseValidators;
        mBondings       = getMainActivity().mBondings;
        mRewards        = getMainActivity().mRewards;
//        WLog.w("MainRewardFragment onRefreshTab : " + mMyValidators.size());
//        WLog.w("MainRewardFragment onRefreshTab : " + mElseValidators.size());
//        WLog.w("MainRewardFragment onRefreshTab : " + mRewards.size());
//        WLog.w("MainRewardFragment onRefreshTab  : " + mRewards.get(0).amount.get(0).denom);
//        WLog.w("MainRewardFragment onRefreshTab  : " + mRewards.get(0).amount.get(0).amount);
        if(mMyValidators.size() <= 0 && mElseValidators.size() <= 0) return;
        mRewardAdapter.notifyDataSetChanged();
    }



    public MainActivity getMainActivity() {
        return (MainActivity)getBaseActivity();
    }




    private class RewardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_HEADER_MY_VALIDATOR       = 0;
        private static final int TYPE_MY_VALIDATOR              = 1;
        private static final int TYPE_HEADER_VALIDATOR          = 2;
        private static final int TYPE_VALIDATOR                 = 3;
        private static final int TYPE_PROMOTION                 = 4;
        private static final int TYPE_HEADER_WITHDRAW_ALL       = 5;

        IImageLoader    mImageLoader;

        public RewardAdapter(IImageLoader imageloader) {
            this.mImageLoader = imageloader;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            if(viewType == TYPE_HEADER_MY_VALIDATOR) {
                View v = getLayoutInflater().inflate(R.layout.item_reward_my_validator_header, viewGroup, false);
                return  new RewardHeaderHolder(v);

            } else if(viewType == TYPE_MY_VALIDATOR) {
                View v = getLayoutInflater().inflate(R.layout.item_reward_my_validator, viewGroup, false);
                return  new RewardMyValidatorHolder(v);

            } else if(viewType == TYPE_HEADER_VALIDATOR) {
                View v = getLayoutInflater().inflate(R.layout.item_reward_validator_header, viewGroup, false);
                return  new RewardHeaderHolder(v);

            } else if(viewType == TYPE_VALIDATOR) {
                View v = getLayoutInflater().inflate(R.layout.item_reward_validator, viewGroup, false);
                return  new RewardValidatorHolder(v);

            } else if(viewType == TYPE_PROMOTION) {
                View v = getLayoutInflater().inflate(R.layout.item_reward_promotion, viewGroup, false);
                return  new RewardPromotionHolder(v);

            } else if(viewType == TYPE_HEADER_WITHDRAW_ALL) {
                View v = getLayoutInflater().inflate(R.layout.item_reward_withdraw_all, viewGroup, false);
                return  new RewardWithdrawHolder(v);

            }
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
//            WLog.w(" "+ position + " " + getItemViewType(position));
            if (getItemViewType(position) == TYPE_PROMOTION) {
                final RewardPromotionHolder holder = (RewardPromotionHolder)viewHolder;
                holder.itemBtnDelegateStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WLog.w("START DELEGATE");
                    }
                });

            } else if (getItemViewType(position) == TYPE_HEADER_WITHDRAW_ALL) {
                final RewardWithdrawHolder holder = (RewardWithdrawHolder)viewHolder;
                holder.itemTvAllRewards.setText(WDp.getDpAllAtomRewardAmount(getContext(), mRewards));
                holder.itemBtnWithdrawAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WLog.w("WITHDRAW ALL");
                    }
                });

            } else if (getItemViewType(position) == TYPE_MY_VALIDATOR) {
                final RewardMyValidatorHolder holder = (RewardMyValidatorHolder)viewHolder;
                final Validator validator = mMyValidators.get(position - 2);
                holder.itemTvMoniker.setText(validator.description.moniker);
                holder.itemTvDelegateAmount.setText(WDp.getDpDelegatedAmount(getContext(), mBondings, validator.operator_address));
                holder.itemTvRewardAtom.setText(WDp.getDpAtomRewardAmount(getContext(), mRewards, validator.operator_address));
                holder.itemTvRewardPhoton.setText(WDp.getDpPhotonRewardAmount(getContext(), mRewards, validator.operator_address));
                holder.itemRoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WLog.w("SHOW Detail");
                    }
                });
                mImageLoader.loadImage(holder.itemAvatar, "error", validator.description.moniker);
                if(!TextUtils.isEmpty(validator.description.identity)) {
                    ApiClient.getKeybaseService(getMainActivity()).getUserInfo("pictures", validator.description.identity).enqueue(new Callback<ResKeyBaseUser>() {
                        @Override
                        public void onResponse(Call<ResKeyBaseUser> call, Response<ResKeyBaseUser> response) {
                            mImageLoader.loadImage(holder.itemAvatar, response.body().getUrl(), validator.description.moniker);
                        }
                        @Override
                        public void onFailure(Call<ResKeyBaseUser> call, Throwable t) { }
                    });
                }

            } else if (getItemViewType(position) == TYPE_VALIDATOR) {
                final RewardValidatorHolder holder = (RewardValidatorHolder)viewHolder;
                final Validator validator;
                if(mMyValidators.size() == 0) {
                    validator = mElseValidators.get(position - 2);
                } else {
                    validator = mElseValidators.get(position - 3 - mMyValidators.size());
                }
                holder.itemTvMoniker.setText(validator.description.moniker);
                holder.itemTvDescription.setText(validator.description.details);
                mImageLoader.loadImage(holder.itemAvatar, "error", validator.description.moniker);
                if(!TextUtils.isEmpty(validator.description.identity)) {
                    ApiClient.getKeybaseService(getMainActivity()).getUserInfo("pictures", validator.description.identity).enqueue(new Callback<ResKeyBaseUser>() {
                        @Override
                        public void onResponse(Call<ResKeyBaseUser> call, Response<ResKeyBaseUser> response) {
                            mImageLoader.loadImage(holder.itemAvatar, response.body().getUrl(), validator.description.moniker);
                        }
                        @Override
                        public void onFailure(Call<ResKeyBaseUser> call, Throwable t) { }
                    });
                }
            }

        }

        @Override
        public int getItemCount() {
//            if (mMyValidators.size() > 0 && mElseValidators.size() > 0) {
//                return mMyValidators.size() + mElseValidators.size() + 3;
//
//            } else if (mMyValidators.size() == 0) {
//                return mElseValidators.size() + 2;
//
//            } else if (mElseValidators.size() == 0) {
//                return mMyValidators.size() + 2;
//            }
            if (mMyValidators.size() > 0 && mElseValidators.size() > 0) {
                return mMyValidators.size() + mElseValidators.size() + 3;

            } else {
                return mElseValidators.size() + mMyValidators.size() + 2;
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (mMyValidators.size() > 0 && mElseValidators.size() > 0) {
                if(position == 0) {
                    return TYPE_HEADER_MY_VALIDATOR;
                } else if (position == 1) {
                    return TYPE_HEADER_WITHDRAW_ALL;
                } else if (position < mMyValidators.size() + 2) {
                    return TYPE_MY_VALIDATOR;
                } else if (position == mMyValidators.size() + 2) {
                    return TYPE_HEADER_VALIDATOR;
                } else {
                    return TYPE_VALIDATOR;
                }

            } else if (mMyValidators.size() == 0) {
                if(position == 0) {
                    return TYPE_HEADER_VALIDATOR;
                } else if (position == 1) {
                    return TYPE_PROMOTION;
                } else  {
                    return TYPE_VALIDATOR;
                }

            } else if (mElseValidators.size() == 0) {
                if(position == 0) {
                    return TYPE_HEADER_MY_VALIDATOR;
                } else if (position == 1) {
                    return TYPE_HEADER_WITHDRAW_ALL;
                } else {
                    return TYPE_MY_VALIDATOR;
                }
            }
            return TYPE_PROMOTION;

        }



        public class RewardHeaderHolder extends RecyclerView.ViewHolder {
            public RewardHeaderHolder(View v) {
                super(v);
            }
        }

        public class RewardPromotionHolder extends RecyclerView.ViewHolder {
            Button      itemBtnDelegateStart;

            public RewardPromotionHolder(@NonNull View itemView) {
                super(itemView);
                itemBtnDelegateStart    = itemView.findViewById(R.id.btn_start_delegate);
            }
        }

        public class RewardWithdrawHolder extends RecyclerView.ViewHolder {
            TextView    itemTvAllRewards;
            Button      itemBtnWithdrawAll;

            public RewardWithdrawHolder(@NonNull View itemView) {
                super(itemView);
                itemTvAllRewards        = itemView.findViewById(R.id.tx_all_rewards);
                itemBtnWithdrawAll      = itemView.findViewById(R.id.btn_withdraw_all);
            }
        }

        public class RewardValidatorHolder extends RecyclerView.ViewHolder {
            CardView    itemRoot;
            AvatarView  itemAvatar;
            TextView    itemTvMoniker;
            TextView    itemTvDescription;

            public RewardValidatorHolder(@NonNull View itemView) {
                super(itemView);
                itemRoot            = itemView.findViewById(R.id.card_validator);
                itemAvatar          = itemView.findViewById(R.id.avatar_validator);
                itemTvMoniker       = itemView.findViewById(R.id.moniker_validator);
                itemTvDescription   = itemView.findViewById(R.id.description_validator);
            }
        }

        public class RewardMyValidatorHolder extends RecyclerView.ViewHolder {
            CardView    itemRoot;
            AvatarView  itemAvatar;
            TextView    itemTvMoniker;
            TextView    itemTvDelegateAmount;
            TextView    itemTvRewardAtom;
            TextView    itemTvRewardPhoton;

            public RewardMyValidatorHolder(@NonNull View itemView) {
                super(itemView);
                itemRoot            = itemView.findViewById(R.id.card_validator);
                itemAvatar          = itemView.findViewById(R.id.avatar_validator);
                itemTvMoniker       = itemView.findViewById(R.id.moniker_validator);
                itemTvDelegateAmount = itemView.findViewById(R.id.delegate_amount_validator);
                itemTvRewardAtom    = itemView.findViewById(R.id.reward_atom_validator);
                itemTvRewardPhoton  = itemView.findViewById(R.id.reward_photon_validator);
            }
        }
    }
}

/*
public class MainRewardFragment extends BaseFragment {

    public static MainRewardFragment newInstance(Bundle bundle) {
        MainRewardFragment fragment = new MainRewardFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_reward, container, false);
        return rootView;
    }
}
*/