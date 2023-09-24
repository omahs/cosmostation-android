package wannabit.io.cosmostaion.ui.main.chain

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import wannabit.io.cosmostaion.R
import wannabit.io.cosmostaion.chain.CosmosLine
import wannabit.io.cosmostaion.common.BaseConstant.EXPLORER_BASE_URL
import wannabit.io.cosmostaion.common.BaseData
import wannabit.io.cosmostaion.common.formatAssetValue
import wannabit.io.cosmostaion.common.visibleOrGone
import wannabit.io.cosmostaion.databinding.FragmentCosmosDetailBinding
import wannabit.io.cosmostaion.ui.dialog.QrCodeFragment
import wannabit.io.cosmostaion.ui.main.MainActivity


class CosmosDetailFragment : Fragment() {

    private var _binding: FragmentCosmosDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var pagerAdapter: AccountPageAdapter

    private var selectedPosition: Int = -1
    private lateinit var selectedChain: CosmosLine

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCosmosDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initTab()
        onClickAction()
    }

    private fun initData() {
        binding.fabMenu.menuIconView.setImageResource(R.drawable.icon_fab)
        val baseAccount = BaseData.baseAccount
        selectedPosition = 1
        val args = arguments
        if (args != null) {
            selectedPosition = arguments?.getInt("selectPosition") ?: -1
        }
        baseAccount?.let {
            binding.accountName.text = baseAccount.name
            selectedChain = baseAccount.displayCosmosLineChains[selectedPosition]
            binding.accountAddress.text = selectedChain.address
            binding.accountValue.text = formatAssetValue(selectedChain.allAssetValue())
        }
    }

    private fun initTab() {
        binding.apply {
            pagerAdapter = AccountPageAdapter(requireActivity(), selectedChain, selectedPosition)
            viewPager.adapter = pagerAdapter
            viewPager.isUserInputEnabled = false
            tabLayout.bringToFront()

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                val supportToken = selectedChain.supportCw20 || selectedChain.supportErc20

                tab.text = when {
                    position == 0 -> getString(R.string.str_coin)
                    supportToken && position == 1 -> getString(R.string.str_token)
                    !supportToken && position == 1 || supportToken && position == 2 -> getString(R.string.str_history)
                    else -> getString(R.string.str_about)
                }
            }.attach()
        }
    }

    private fun onClickAction() {
        view?.isFocusableInTouchMode = true
        view?.requestFocus()
        view?.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                requireActivity().supportFragmentManager.popBackStack()
                (activity as MainActivity?)?.onBackVisibleBottomNavi()
            }
            false
        }

        binding.apply {
            btnBack.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
                (activity as MainActivity?)?.onBackVisibleBottomNavi()
            }

            btnAccount.setOnClickListener {
                val accountUrl = EXPLORER_BASE_URL + "/" + selectedChain.apiName + "/" + selectedChain.address
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(accountUrl)))
            }

            accountAddress.setOnClickListener {
                val bottomSheet = QrCodeFragment(selectedChain)
                bottomSheet.show(parentFragmentManager, QrCodeFragment::class.java.name)
            }

            fabMenu.setOnMenuToggleListener { opened ->
                fabMenu.bringToFront()
                backdropLayout.visibleOrGone(opened)
                if (opened) {
                    tabLayout.elevation = 0.1f
                    requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.color_background_dialog)
                } else {
                    tabLayout.elevation = 0f
                    requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.color_transparent)
                }
            }

            backdropLayout.setOnClickListener {
                fabMenu.close(true)
                backdropLayout.visibility = View.GONE
                tabLayout.elevation = 0f
                requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.color_transparent)
            }

            fabVote.setOnClickListener {

            }

            fabClaimReward.setOnClickListener {

            }

            fabStake.setOnClickListener {

            }

            fabReceive.setOnClickListener {
                val bottomSheet = QrCodeFragment(selectedChain)
                bottomSheet.show(parentFragmentManager, QrCodeFragment::class.java.name)
                fabMenu.close(true)
            }

            fabSend.setOnClickListener {

            }
        }
    }

    class AccountPageAdapter(fragmentActivity: FragmentActivity, selectedChain: CosmosLine, selectedPosition: Int) : FragmentStateAdapter(fragmentActivity) {
        private val fragments = mutableListOf<Fragment>()

        init {
            fragments.add(CoinFragment(selectedPosition))
            fragments.add(HistoryFragment(selectedPosition))

            if (selectedChain.supportCw20 || selectedChain.supportErc20) {
                fragments.add(1, TokenFragment(selectedPosition))
            }
        }

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}