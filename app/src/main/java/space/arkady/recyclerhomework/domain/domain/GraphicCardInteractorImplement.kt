package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.mapper.toDomainGraphicCard
import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.domain.domain.repositories.GraphicCardRepository

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