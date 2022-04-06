package space.arkady.recyclerhomework.domain.domain.repositories

import space.arkady.recyclerhomework.domain.domain.models.Monitor

interface MonitorRepository {
    fun getMonitorList(): List<Monitor>
}