package space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem
import space.arkady.recyclerhomework.presentation.recycler.clickListeners.OnOperationSystemClickListener

class OperationSystemViewHolder(
    itemView: View,
    private val getOperationSystem: OnOperationSystemClickListener
) :
    RecyclerView.ViewHolder(itemView) {

    companion object {
        fun newInstance(parent: ViewGroup, getOperationSystemClickItem: OnOperationSystemClickListener) =
            OperationSystemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item, parent, false
                ), getOperationSystemClickItem
            )
    }

    private val nameOperationSystems by lazy { itemView.findViewById<TextView>(R.id.nameProduct) }
    private val root by lazy { itemView.findViewById<ConstraintLayout>(R.id.root) }

    fun bindItem(domainOperationSystem: DomainOperationSystem) {
        with(domainOperationSystem) {
            nameOperationSystems.nameProduct.text = domainOperationSystem.brand
            when {
                domainOperationSystem.brand.contains("WINDOWS") -> itemView.brandLogo.setImageResource(R.drawable.windows_logo)
                domainOperationSystem.brand.contains("MACOS") -> itemView.brandLogo.setImageResource(R.drawable.macos_logo)
            }
        }
        itemView.root.setOnClickListener {
            getOperationSystem.onOperationSystemClickListener(domainOperationSystem)
        }
    }
}
