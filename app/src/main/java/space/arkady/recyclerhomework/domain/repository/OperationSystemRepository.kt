package space.arkady.recyclerhomework.domain.repository

import space.arkady.recyclerhomework.domain.models.OperationSystem

interface OperationSystemRepository {
    fun getOperationSystemList(): List<OperationSystem>
}