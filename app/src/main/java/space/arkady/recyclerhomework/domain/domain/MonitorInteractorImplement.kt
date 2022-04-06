package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.mapper.toDomainMonitor
import space.arkady.recyclerhomework.domain.domain.models.DomainMonitor
import space.arkady.recyclerhomework.domain.domain.repositories.MonitorRepository

class MonitorInteractorImplement(
    private val repository: MonitorRepository
) : MonitorInteractor {

    override fun getMonitor(): List<DomainMonitor> {
        return repository.getMonitorList().map { monitor ->
            monitor.toDomainMonitor()
        }
    }
}