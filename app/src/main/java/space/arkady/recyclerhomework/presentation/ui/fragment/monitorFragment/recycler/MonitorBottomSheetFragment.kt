package space.arkady.recyclerhomework.presentation.ui.fragment.monitorFragment.recycler


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.models.DomainMonitor
import space.arkady.recyclerhomework.presentation.clickListeners.OnMonitorClickListener
import space.arkady.recyclerhomework.presentation.ui.fragment.monitorFragment.MonitorResultListener
import space.arkady.recyclerhomework.presentation.ui.fragment.monitorFragment.MonitorViewModel


class MonitorBottomSheetFragment(monitorResultListener: MonitorResultListener) :
    BottomSheetDialogFragment() {

    private val sharedViewModel: MonitorViewModel by sharedViewModel()

    companion object {
        const val TAG = "MonitorBottomSheetFragment"
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

        recycler.adapter = adapter

        sharedViewModel.monitorLiveData.observe(viewLifecycleOwner) { monitor ->
            adapter.submitCardList(monitor)
        }
    }
}

