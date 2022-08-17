package space.arkady.recyclerhomework.presentation.ui.fragment.operationSystem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.arkady.recyclerhomework.domain.OperationSystemInteractor
import space.arkady.recyclerhomework.domain.models.DomainOperationSystem

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
