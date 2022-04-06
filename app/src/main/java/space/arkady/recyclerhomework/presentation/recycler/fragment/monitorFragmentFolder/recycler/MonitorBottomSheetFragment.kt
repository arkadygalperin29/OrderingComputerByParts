package space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.recycler


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.DomainMonitor
import space.arkady.recyclerhomework.presentation.recycler.clickListeners.OnMonitorClickListener
import space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.MonitorResultListener
import space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.MonitorViewModel


class MonitorBottomSheetFragment(monitorResultListener: MonitorResultListener) :
    BottomSheetDialogFragment() {

    private val sharedViewModel: MonitorViewModel by sharedViewModel()

    companion object {
        const val TAG = "Monitor"
        fun newInstance(monitorResultListener: MonitorResultListener) =
            MonitorBottomSheetFragment(monitorResultListener)
    }

    private val adapter by lazy { MonitorAdapter(selectMonitor) }


    private val selectMonitor = object : OnMonitorClickListener {
        override fun onMonitorClickListener(domainMonitor: DomainMonitor) {
            monitorResultListener.onMonitorResult(domainMonitor)
            dismiss()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        sharedViewModel.monitorLiveData.observe(viewLifecycleOwner) { monitor ->
            adapter.submitCardList(monitor)
        }

    }
}

