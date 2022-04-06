package space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem

import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem

interface OperationSystemResultListener {
    fun onOperationSystemResult(operationSystemItem: DomainOperationSystem)
}
