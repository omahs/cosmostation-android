package wannabit.io.cosmostaion.ui.main.chain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import wannabit.io.cosmostaion.common.BaseData
import wannabit.io.cosmostaion.common.visibleOrGone
import wannabit.io.cosmostaion.data.model.Token
import wannabit.io.cosmostaion.databinding.FragmentTokenBinding
import java.math.BigDecimal

class TokenFragment(position: Int) : Fragment() {

    private var _binding: FragmentTokenBinding? = null
    private val binding get() = _binding!!

    private lateinit var tokenAdapter: TokenAdapter
    private val selectedPosition = position

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTokenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val tokens = mutableListOf<Token>()
        val baseAccount = BaseData.baseAccount
        baseAccount?.let { account ->
            val selectedChain = account.displayCosmosLineChains[selectedPosition]
            selectedChain.tokens.forEach { token ->
                if (token.amount?.toBigDecimal() != BigDecimal.ZERO) {
                    tokens.add(token)
                }
            }

            tokens.sortWith { o1, o2 ->
                val value0 = selectedChain.cw20Value(o1.address)
                val value1 = selectedChain.cw20Value(o2.address)
                when {
                    value0 > value1 -> -1
                    value0 < value1 -> 1
                    else -> 0
                }
            }

            tokenAdapter = TokenAdapter(requireContext(), selectedChain)
            binding.recycler.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = tokenAdapter
                tokenAdapter.submitList(tokens)
            }

            binding.recycler.visibleOrGone(selectedChain.tokens.isNotEmpty())
            binding.emptyLayout.visibleOrGone(selectedChain.tokens.isEmpty())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}