package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.models.Monitor

interface MonitorRepository {
    fun getMonitorList(): List<Monitor>
}