package space.arkady.recyclerhomework.presentation.recycler

import space.arkady.recyclerhomework.domain.domain.models.CommonItem

interface ItemClickListener {
    fun itemClickListener(item: CommonItem)
}