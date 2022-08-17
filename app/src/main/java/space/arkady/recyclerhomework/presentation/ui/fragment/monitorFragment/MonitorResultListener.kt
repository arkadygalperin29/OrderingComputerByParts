package space.arkady.recyclerhomework.presentation.ui.fragment.monitorFragment

import space.arkady.recyclerhomework.domain.models.DomainMonitor

interface MonitorResultListener {
    fun onMonitorResult(monitorItem: DomainMonitor)
}