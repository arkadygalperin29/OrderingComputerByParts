package space.arkady.recyclerhomework.domain

import space.arkady.recyclerhomework.domain.mapper.toDomainOperationSystem
import space.arkady.recyclerhomework.domain.models.DomainOperationSystem
import space.arkady.recyclerhomework.domain.repository.OperationSystemRepository

class OperationSystemInteractorImplement(private val repository: OperationSystemRepository):
    OperationSystemInteractor {

    override fun getOperationSystem(): List<DomainOperationSystem> {
        return repository.getOperationSystemList().map { operationSystem ->
            operationSystem.toDomainOperationSystem()
        }
    }

}