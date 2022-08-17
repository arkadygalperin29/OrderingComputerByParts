package space.arkady.recyclerhomework.domain.repository

import space.arkady.recyclerhomework.domain.models.GraphicCard

interface GraphicCardRepository {
    fun getGraphicCardList(): List<GraphicCard>
}