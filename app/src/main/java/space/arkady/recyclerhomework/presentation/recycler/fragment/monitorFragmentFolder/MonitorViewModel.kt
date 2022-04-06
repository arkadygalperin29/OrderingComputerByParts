package space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.arkady.recyclerhomework.domain.domain.MonitorInteractor
import space.arkady.recyclerhomework.domain.domain.models.DomainMonitor

class MonitorViewModel(
    val interactor: MonitorInteractor
) : ViewModel() {
    val monitorLiveData: LiveData<List<DomainMonitor>> get() = _monitorLiveData
    private val _monitorLiveData = MutableLiveData<List<DomainMonitor>>()

    init {
        loadMonitor()
    }

    private fun loadMonitor() {
        _monitorLiveData.value = interactor.getMonitor()
    }
}
