package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard

interface GraphicCardInteractor {
    fun getGraphicCard(): List<DomainGraphicCard>
}