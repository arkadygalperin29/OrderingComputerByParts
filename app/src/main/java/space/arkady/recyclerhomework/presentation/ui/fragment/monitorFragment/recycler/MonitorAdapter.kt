package space.arkady.recyclerhomework.presentation.ui.fragment.monitorFragment.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.arkady.recyclerhomework.domain.models.DomainMonitor
import space.arkady.recyclerhomework.presentation.clickListeners.OnMonitorClickListener

class MonitorAdapter(private val onMonitorClickListener: OnMonitorClickListener) :
    RecyclerView.Adapter<MonitorViewHolder>() {

    private var domainMonitors: List<DomainMonitor> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonitorViewHolder {
        return MonitorViewHolder.newInstance(parent, onMonitorClickListener)
    }
    override fun onBindViewHolder(monitorHolder: MonitorViewHolder, position: Int) {
       monitorHolder.bindItem(domainMonitors[position])
    }


    override fun getItemCount(): Int {
        return domainMonitors.size
    }

    fun submitCardList(data: List<DomainMonitor>) {
        domainMonitors = data
        notifyDataSetChanged()
    }
}





