package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem

interface OperationSystemInteractor {
    fun getOperationSystem(): List<DomainOperationSystem>
}