package space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_operationsystem.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.BrandOperationSystem
import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder.GraphicCardFragment
import space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.recycler.MonitorBottomSheetFragment
import space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem.recycler.OperationBottomSheetFragment
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class OperationSystemFragment() : Fragment(R.layout.fragment_operationsystem) {

    companion object {
        const val TAG = "OperationSystem"
        fun newInstance() = OperationSystemFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    private val operationSystemResult by lazy {
        object : OperationSystemResultListener {
            override fun onOperationSystemResult(operationSystemItem: DomainOperationSystem) {
                showOperationSystemList.setText(operationSystemItem.brand)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initViews() {
        showOperationSystemList.setOnClickListener {
            onEditTextClick()
        }
        operationSystemButton.setOnClickListener {
            onButtonMonitorClick()
        }
    }

    private fun onButtonMonitorClick() {
        when {
            showOperationSystemList.text.isEmpty() -> {
                showToast("Select a monitor")
            }
            showOperationSystemList.text.contains("WINDOWS") -> {
                BrandOperationSystem.WINDOWS
            }
            showOperationSystemList.text.contains("MACOS") -> {
                BrandOperationSystem.MACOS
            }
        }

        if (showOperationSystemList.text.toString().isEmpty()) {
            requireActivity().showToast("Error")
        } else {
            sharedViewModel.setOperationSystem(
                DomainOperationSystem(showOperationSystemList.text.toString())
            )
            requireActivity().apply {
                openFragment(
                    R.id.container,
                    GraphicCardFragment.newInstance(),
                    GraphicCardFragment.TAG,
                )
            }
        }
    }


    private fun onEditTextClick() {
        OperationBottomSheetFragment.newInstance(operationSystemResult)
            .show(
                requireActivity().supportFragmentManager,
                MonitorBottomSheetFragment.TAG
            )
    }
}