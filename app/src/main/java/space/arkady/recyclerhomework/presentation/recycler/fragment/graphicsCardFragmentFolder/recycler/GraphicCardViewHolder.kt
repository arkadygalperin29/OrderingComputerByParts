package space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.presentation.recycler.clickListeners.OnGraphicCardClickListener

class GraphicCardViewHolder(
    itemView: View,
    private val getItem: OnGraphicCardClickListener) :
    RecyclerView.ViewHolder(itemView) {

    companion object {
        fun newInstance(parent: ViewGroup, getCardClickItem: OnGraphicCardClickListener) =
            GraphicCardViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item, parent, false
                ), getCardClickItem
            )
    }

    private val nameGraphicCards by lazy { itemView.findViewById<TextView>(R.id.nameProduct) }
    private val root by lazy { itemView.findViewById<ConstraintLayout>(R.id.root) }

    fun bindItem(domainGraphicCard: DomainGraphicCard) {
        with(domainGraphicCard) {
            nameGraphicCards.nameProduct.text = domainGraphicCard.brand
            when {
                domainGraphicCard.brand.contains("NVIDIA") -> itemView.brandLogo.setImageResource(R.drawable.nvidia_logo)
                domainGraphicCard.brand.contains("AMD") -> itemView.brandLogo.setImageResource(R.drawable.amd_logo)
            }
        }
        root.setOnClickListener {
            getItem.onGraphicCardClickListener(domainGraphicCard)
        }
    }
}
