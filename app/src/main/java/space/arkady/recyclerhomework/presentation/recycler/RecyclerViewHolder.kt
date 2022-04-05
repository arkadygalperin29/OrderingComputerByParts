package space.arkady.recyclerhomework.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.CommonItem

class RecyclerViewHolder(
    itemView: View,
    private val getItem: ItemClickListener
) :
    RecyclerView.ViewHolder(itemView) {

    companion object {
        fun newInstance(parent: ViewGroup, getCardClickItem: ItemClickListener) =
            RecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item, parent, false
                ), getCardClickItem
            )
    }


    fun bindItem(commonItem: CommonItem) {
        with(commonItem) {
            itemView.nameProduct.text = commonItem.item
            when {
                commonItem.item.contains("NVIDIA") -> itemView.brandLogo.setImageResource(R.drawable.nvidia_logo)
                commonItem.item.contains("AMD") -> itemView.brandLogo.setImageResource(R.drawable.amd_logo)
                commonItem.item.contains("LG") -> itemView.brandLogo.setImageResource(R.drawable.lg_emblem)
                commonItem.item.contains("ACER") -> itemView.brandLogo.setImageResource(R.drawable.acer_logo)
                commonItem.item.contains("DELL") -> itemView.brandLogo.setImageResource(R.drawable.dell_logo)
                commonItem.item.contains("MACOS") -> itemView.brandLogo.setImageResource(R.drawable.macos_logo)
                commonItem.item.contains("WINDOWS") -> itemView.brandLogo.setImageResource(R.drawable.windows_logo)
                commonItem.item.contains("GIGABYTE") -> itemView.brandLogo.setImageResource(R.drawable.gigabyte_logo)
                commonItem.item.contains("SAMSUNG") -> itemView.brandLogo.setImageResource(R.drawable.samsung_logo)
            }
        }
        itemView.root.setOnClickListener {
            getItem.itemClickListener(commonItem)
        }
    }
}
