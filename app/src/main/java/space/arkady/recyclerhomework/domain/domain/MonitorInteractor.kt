package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.domain.domain.models.DomainMonitor

interface MonitorInteractor {
    fun getMonitor(): List<DomainMonitor>
}