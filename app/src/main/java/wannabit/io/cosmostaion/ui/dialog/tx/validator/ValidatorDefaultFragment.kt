package wannabit.io.cosmostaion.ui.dialog.tx.validator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.cosmos.staking.v1beta1.StakingProto
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.apache.commons.lang3.StringUtils
import wannabit.io.cosmostaion.R
import wannabit.io.cosmostaion.chain.CosmosLine
import wannabit.io.cosmostaion.databinding.FragmentCommonBottomBinding

class ValidatorDefaultFragment(
    private val selectedChain: CosmosLine,
    val listener: ValidatorDefaultListener
) : BottomSheetDialogFragment() {

    private var _binding: FragmentCommonBottomBinding? = null
    private val binding get() = _binding!!

    private lateinit var validatorDefaultAdapter: ValidatorDefaultAdapter

    private var searchValidators: MutableList<StakingProto.Validator> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommonBottomBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initSearchView()
    }

    private fun initView() {
        binding.apply {
            selectTitle.text = getString(R.string.title_select_validator)
            searchBar.visibility = View.VISIBLE
            searchView.queryHint = getString(R.string.str_search_validator)
            searchValidators.addAll(selectedChain.cosmosValidators)

            validatorDefaultAdapter = ValidatorDefaultAdapter(selectedChain)
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(requireContext())
            recycler.adapter = validatorDefaultAdapter
            validatorDefaultAdapter.submitList(searchValidators)

            validatorDefaultAdapter.setOnItemClickListener {
                listener.select(it)
                dismiss()
            }
        }
    }

    private fun initSearchView() {
        binding.apply {
            searchView.setQuery("", false)
            searchView.clearFocus()
            searchView.setOnQueryTextListener(object : OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    searchValidators.clear()
                    if (StringUtils.isEmpty(newText)) {
                        searchValidators.addAll(selectedChain.cosmosValidators)
                    } else {
                        newText?.let { searchTxt ->
                            searchValidators.addAll(selectedChain.cosmosValidators.filter { validator ->
                                validator.description.moniker.contains(searchTxt, ignoreCase = true)
                            })
                        }
                    }
                    validatorDefaultAdapter.notifyDataSetChanged()
                    return true
                }
            })
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

interface ValidatorDefaultListener {
    fun select(validatorAddress: String)
}