package space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.DomainMonitor
import space.arkady.recyclerhomework.presentation.recycler.clickListeners.OnMonitorClickListener

class MonitorViewHolder(
    itemView: View,
    private val getMonitor: OnMonitorClickListener
) :
    RecyclerView.ViewHolder(itemView) {

    companion object {
        fun newInstance(parent: ViewGroup, getMonitorClickItem: OnMonitorClickListener) =
            MonitorViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item, parent, false
                ), getMonitorClickItem
            )
    }

    private val nameMonitors by lazy { itemView.findViewById<TextView>(R.id.nameProduct) }
    private val root by lazy { itemView.findViewById<ConstraintLayout>(R.id.root) }

    fun bindItem(domainMonitor: DomainMonitor) {
        with(domainMonitor) {
            nameMonitors.nameProduct.text = domainMonitor.brand
            when {
                domainMonitor.brand.contains("ACER") -> itemView.brandLogo.setImageResource(R.drawable.acer_logo)
                domainMonitor.brand.contains("DELL") -> itemView.brandLogo.setImageResource(R.drawable.dell_logo)
                domainMonitor.brand.contains("GIGABYTE") -> itemView.brandLogo.setImageResource(R.drawable.gigabyte_logo)
                domainMonitor.brand.contains("LG") -> itemView.brandLogo.setImageResource(R.drawable.lg_emblem)
                domainMonitor.brand.contains("SAMSUNG") -> itemView.brandLogo.setImageResource(R.drawable.samsung_logo)
            }
        }
        itemView.root.setOnClickListener {
            getMonitor.onMonitorClickListener(domainMonitor)
        }
    }
}
