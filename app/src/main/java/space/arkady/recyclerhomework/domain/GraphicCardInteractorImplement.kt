package space.arkady.recyclerhomework.domain

import space.arkady.recyclerhomework.domain.mapper.toDomainGraphicCard
import space.arkady.recyclerhomework.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.domain.repository.GraphicCardRepository

class GraphicCardInteractorImplement(
    private val repository: GraphicCardRepository
) :
    GraphicCardInteractor {

    override fun getGraphicCard(): List<DomainGraphicCard> {
        return repository.getGraphicCardList().map { graphicCard ->
            graphicCard.toDomainGraphicCard()
        }
    }
}