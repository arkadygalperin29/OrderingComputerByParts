package space.arkady.recyclerhomework.presentation.clickListeners

import space.arkady.recyclerhomework.domain.models.DomainGraphicCard

interface OnGraphicCardClickListener {
    fun onGraphicCardClickListener(domainGraphicCard: DomainGraphicCard)
}