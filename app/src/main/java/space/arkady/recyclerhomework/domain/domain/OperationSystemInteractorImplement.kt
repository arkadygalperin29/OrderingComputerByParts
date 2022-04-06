package space.arkady.recyclerhomework.domain.domain

import space.arkady.recyclerhomework.domain.domain.mapper.toDomainOperationSystem
import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem
import space.arkady.recyclerhomework.domain.domain.repositories.OperationSystemRepository

class OperationSystemInteractorImplement(private val repository: OperationSystemRepository):
    OperationSystemInteractor {

    override fun getOperationSystem(): List<DomainOperationSystem> {
        return repository.getOperationSystemList().map { operationSystem ->
            operationSystem.toDomainOperationSystem()
        }
    }

}