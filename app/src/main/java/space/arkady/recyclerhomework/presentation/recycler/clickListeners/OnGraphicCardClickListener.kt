package space.arkady.recyclerhomework.presentation.recycler.clickListeners

import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard

interface OnGraphicCardClickListener {
    fun onGraphicCardClickListener(domainGraphicCard: DomainGraphicCard)
}