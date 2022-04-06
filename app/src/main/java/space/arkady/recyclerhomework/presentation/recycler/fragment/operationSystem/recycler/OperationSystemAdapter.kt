package space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem
import space.arkady.recyclerhomework.presentation.recycler.clickListeners.OnOperationSystemClickListener

class OperationSystemAdapter(private val onOperationSystemClickListener: OnOperationSystemClickListener) :
    RecyclerView.Adapter<OperationSystemViewHolder>() {

    private var domainOperationSystems: List<DomainOperationSystem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationSystemViewHolder {
        return OperationSystemViewHolder.newInstance(parent, onOperationSystemClickListener)
    }
    override fun onBindViewHolder(monitorHolder: OperationSystemViewHolder, position: Int) {
       monitorHolder.bindItem(domainOperationSystems[position])
    }


    override fun getItemCount(): Int {
        return domainOperationSystems.size
    }

    fun submitCardList(data: List<DomainOperationSystem>) {
        domainOperationSystems = data
        notifyDataSetChanged()
    }


}





