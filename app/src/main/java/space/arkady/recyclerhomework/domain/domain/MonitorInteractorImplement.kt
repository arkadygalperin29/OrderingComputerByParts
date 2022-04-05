package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.interactor.CommonInteractor
import space.arkady.recyclerhomework.domain.domain.models.CommonItem

class MonitorInteractorImplement(
    private val repository: MonitorRepository
) : CommonInteractor<CommonItem> {
    override fun getItem(): List<CommonItem> {
        return repository.getMonitorList()
            .map { item -> CommonItem("${item.brand}${item.model}${item.inches}${item.resolution}") }
    }
}