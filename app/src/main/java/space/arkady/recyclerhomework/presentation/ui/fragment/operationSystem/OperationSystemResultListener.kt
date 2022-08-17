package space.arkady.recyclerhomework.presentation.ui.fragment.operationSystem

import space.arkady.recyclerhomework.domain.models.DomainOperationSystem

interface OperationSystemResultListener {
    fun onOperationSystemResult(operationSystemItem: DomainOperationSystem)
}
