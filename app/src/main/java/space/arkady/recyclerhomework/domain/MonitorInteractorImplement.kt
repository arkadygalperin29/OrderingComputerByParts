package space.arkady.recyclerhomework.domain

import space.arkady.recyclerhomework.domain.mapper.toDomainMonitor
import space.arkady.recyclerhomework.domain.models.DomainMonitor
import space.arkady.recyclerhomework.domain.repository.MonitorRepository

class MonitorInteractorImplement(
    private val repository: MonitorRepository
) : MonitorInteractor {

    override fun getMonitor(): List<DomainMonitor> {
        return repository.getMonitorList().map { monitor ->
            monitor.toDomainMonitor()
        }
    }
}