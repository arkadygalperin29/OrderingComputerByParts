package space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.arkady.recyclerhomework.domain.domain.OperationSystemInteractor
import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem

class OperationSystemViewModel(
    val interactor: OperationSystemInteractor
) : ViewModel() {
    val operationSystemLiveData: LiveData<List<DomainOperationSystem>> get() = _operationSystemLiveData
    private val _operationSystemLiveData = MutableLiveData<List<DomainOperationSystem>>()

    init {
        loadOperationSystems()
    }

    private fun loadOperationSystems() {
        _operationSystemLiveData.value = interactor.getOperationSystem()
    }
}
