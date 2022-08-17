package space.arkady.recyclerhomework.domain

import space.arkady.recyclerhomework.domain.models.DomainGraphicCard

interface GraphicCardInteractor {
    fun getGraphicCard(): List<DomainGraphicCard>
}