package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.models.GraphicCard

interface GraphicCardRepository {
    fun getGraphicCardList(): List<GraphicCard>
}