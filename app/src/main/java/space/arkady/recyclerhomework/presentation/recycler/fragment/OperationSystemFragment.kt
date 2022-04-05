package space.arkady.recyclerhomework.presentation.recycler.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_operationsystem.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.BrandOperationSystem
import space.arkady.recyclerhomework.domain.domain.models.CommonItem
import space.arkady.recyclerhomework.presentation.recycler.ItemClickListener
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class OperationSystemFragment : Fragment(R.layout.fragment_operationsystem) {
    companion object {
        const val TAG = "Operation System"
        fun newInstance() = OperationSystemFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()

        initViews()
    }

    private fun initViews() {
        onButtonOperationSystem()
    }

    private fun onButtonOperationSystem() {
        operationSystemButton.setOnClickListener {
            when {
                checkEmptyField() -> {
                    showToast("Select Operation System")
                }
                showOperationSystemList.text.contains("WINDOWS") -> {
                    BrandOperationSystem.WINDOWS
                }
                showOperationSystemList.text.contains("MACOS") -> {
                    BrandOperationSystem.MACOS
                }
            }
            sharedViewModel.operationSystem.observe(viewLifecycleOwner) {
                requireActivity().apply {
                    openFragment(
                        containerId = R.id.container,
                        fragment = GraphicCardFragment.newInstance(),
                        tag = GraphicCardFragment.TAG
                    )
                }
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showOperationSystemList.setOnClickListener {
            DialogFragment.newInstance(getItem)
                .show(requireActivity().supportFragmentManager, "Show Fragment Manager")
        }

    }

    private fun checkEmptyField(): Boolean {
        return showOperationSystemList.text.isEmpty()
    }

    private val getItem = object : ItemClickListener {
        override fun itemClickListener(item: CommonItem) {
            showOperationSystemList.setText(item.item) //как это делать в случае с брендом
        }
    }
}

