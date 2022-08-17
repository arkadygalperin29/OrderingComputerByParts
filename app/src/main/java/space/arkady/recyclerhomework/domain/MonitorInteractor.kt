package space.arkady.recyclerhomework.domain

import space.arkady.recyclerhomework.domain.models.DomainMonitor

interface MonitorInteractor {
    fun getMonitor(): List<DomainMonitor>
}