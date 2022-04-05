package space.arkady.recyclerhomework.presentation.recycler.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_monitor.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.BrandMonitor
import space.arkady.recyclerhomework.domain.domain.models.CommonItem
import space.arkady.recyclerhomework.presentation.recycler.ItemClickListener
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class MonitorFragment : Fragment(R.layout.fragment_monitor) {

    companion object {
        const val TAG = "Monitor"
        fun newInstance() = MonitorFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()


    override fun onStart() {
        super.onStart()

        initViews()
    }

    private fun initViews() {
        onButtonMonitor()
    }

    private fun onButtonMonitor() {
        button_monitorToPeriphery.setOnClickListener {

            when {
                checkEmptyField() -> {
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

            sharedViewModel.monitor.observe(viewLifecycleOwner) {
                requireActivity().apply {
                    openFragment(
                        containerId = R.id.container,
                        fragment = PeripheryFragment.newInstance(),
                        tag = PeripheryFragment.TAG
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showMonitorList.setOnClickListener {
            DialogFragment.newInstance(getItem)
                .show(requireActivity().supportFragmentManager, (DialogFragment.TAG))
        }
    }


    private fun checkEmptyField(): Boolean {
        return showMonitorList.text.isEmpty()
    }

    private val getItem = object : ItemClickListener {
        override fun itemClickListener(item: CommonItem) {
            showMonitorList.setText(item.item)
        }
    }
}