package space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder

import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard

interface GraphicCardResultListener {
    fun onGraphicCardResult(graphicCardItem: DomainGraphicCard)
}