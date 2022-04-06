package space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder

import space.arkady.recyclerhomework.domain.domain.models.DomainMonitor

interface MonitorResultListener {
    fun onMonitorResult(monitorItem: DomainMonitor)
}