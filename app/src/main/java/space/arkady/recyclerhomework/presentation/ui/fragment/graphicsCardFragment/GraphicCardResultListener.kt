package space.arkady.recyclerhomework.presentation.ui.fragment.graphicsCardFragment

import space.arkady.recyclerhomework.domain.models.DomainGraphicCard

interface GraphicCardResultListener {
    fun onGraphicCardResult(graphicCardItem: DomainGraphicCard)
}