package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.interactor.CommonInteractor
import space.arkady.recyclerhomework.domain.domain.models.CommonItem

class GraphicCardInteractorImplement(
    private val repository: GraphicCardRepository
) :
    CommonInteractor<CommonItem> {
    override fun getItem(): List<CommonItem> {
        return repository.getGraphicCardList().map { item ->
            CommonItem("${item.brand} ${item.number} ${item.postfix} ${item.series}")
        }
    }
}