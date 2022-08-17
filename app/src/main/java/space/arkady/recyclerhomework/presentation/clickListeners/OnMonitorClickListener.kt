package space.arkady.recyclerhomework.presentation.clickListeners

import space.arkady.recyclerhomework.domain.models.DomainMonitor

interface OnMonitorClickListener {
    fun onMonitorClickListener(domainMonitor: DomainMonitor)
}