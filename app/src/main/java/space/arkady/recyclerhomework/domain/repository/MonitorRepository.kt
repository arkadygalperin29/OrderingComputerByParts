package space.arkady.recyclerhomework.domain.repository

import space.arkady.recyclerhomework.domain.models.Monitor

interface MonitorRepository {
    fun getMonitorList(): List<Monitor>
}