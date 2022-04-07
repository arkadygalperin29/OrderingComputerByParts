package space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_monitor.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.BrandMonitor
import space.arkady.recyclerhomework.domain.domain.models.DomainMonitor
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.recycler.fragment.PeripheryFragment
import space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.recycler.MonitorBottomSheetFragment
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class MonitorFragment() : Fragment(R.layout.fragment_monitor) {

    companion object {
        const val TAG = "Monitor"
        fun newInstance() = MonitorFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    private val monitorResult by lazy {
        object : MonitorResultListener {
            override fun onMonitorResult(monitorItem: DomainMonitor) {
                showMonitorList.setText(monitorItem.brand)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initViews() {
        showMonitorList.setOnClickListener {
            onEditTextClick()
        }
        buttonMonitor.setOnClickListener {
            onButtonMonitorClick()
        }
    }

    private fun onButtonMonitorClick() {
        when {
            showMonitorList.text.isEmpty() -> {
                showToast("Select a monitor")
            }
            showMonitorList.text.contains("LG") -> {
                BrandMonitor.LG
            }
            showMonitorList.text.contains("SAMSUNG") -> {
                BrandMonitor.SAMSUNG
            }
            showMonitorList.text.contains("ACER") -> {
                BrandMonitor.ACER
            }
            showMonitorList.text.contains("DELL") -> {
                BrandMonitor.DELL
            }
            else -> {
                BrandMonitor.GIGABYTE
            }
        }

        if (showMonitorList.text.toString().isEmpty()) {
            requireActivity().showToast("Error")
        } else {
            sharedViewModel.setDomainMonitor(
                DomainMonitor(showMonitorList.text.toString())
            )
            requireActivity().apply {
                openFragment(
                    PeripheryFragment.newInstance(),
                    PeripheryFragment.TAG,
                    R.id.container
                )
            }
        }
    }


    private fun onEditTextClick() {
        MonitorBottomSheetFragment.newInstance(monitorResult)
            .show(
                requireActivity().supportFragmentManager,
                MonitorBottomSheetFragment.TAG
            )
    }
}