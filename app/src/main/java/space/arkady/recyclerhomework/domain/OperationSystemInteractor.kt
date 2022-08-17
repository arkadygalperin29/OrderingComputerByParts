package space.arkady.recyclerhomework.domain

import space.arkady.recyclerhomework.domain.models.DomainOperationSystem

interface OperationSystemInteractor {
    fun getOperationSystem(): List<DomainOperationSystem>
}