package space.arkady.recyclerhomework.domain.domain.repositories

import space.arkady.recyclerhomework.domain.domain.models.OperationSystem

interface OperationSystemRepository {
    fun getOperationSystemList(): List<OperationSystem>
}