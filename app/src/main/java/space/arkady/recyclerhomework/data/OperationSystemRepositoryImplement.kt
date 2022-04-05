package space.arkady.recyclerhomework.data

import space.arkady.recyclerhomework.domain.domain.OperationSystemRepository
import space.arkady.recyclerhomework.domain.domain.models.BrandOperationSystem
import space.arkady.recyclerhomework.domain.domain.models.OperationSystem

object OperationSystemRepositoryImplement: OperationSystemRepository {

    private val operationSystem = listOf<OperationSystem>(
        OperationSystem(BrandOperationSystem.WINDOWS, 7.0),
        OperationSystem(BrandOperationSystem.WINDOWS, 10.0),
        OperationSystem(BrandOperationSystem.WINDOWS, 12.0),
        OperationSystem(BrandOperationSystem.MACOS, 10.15),
        OperationSystem(BrandOperationSystem.MACOS, 11.0)
   )

    override fun getOperationSystemList(): List<OperationSystem> {
        return operationSystem
    }
}