package space.arkady.recyclerhomework.presentation.recycler.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.arkady.recyclerhomework.domain.domain.models.*

class SharedViewModel : ViewModel() {

    val user: LiveData<User> get() = _user
    private val _user = MutableLiveData<User>()

    fun setUser(user: User) {
        _user.value = user
    }


    val operationSystem: LiveData<BrandOperationSystem> get() = _operationSystem
    private val _operationSystem = MutableLiveData<BrandOperationSystem>()

    fun setOperationSystem(operationSystem: BrandOperationSystem) {
        _operationSystem.value = operationSystem
    }


    val graphicCard: LiveData<BrandGraphicCard> get() = _graphicCard
    private val _graphicCard = MutableLiveData<BrandGraphicCard>()

    fun setGraphicCard(graphicCard: BrandGraphicCard) {
        _graphicCard.value = graphicCard
    }


    val monitor: LiveData<BrandMonitor> get() = _monitor
    private val _monitor = MutableLiveData<BrandMonitor>()

    fun setMonitor(monitor: BrandMonitor) {
        _monitor.value = monitor
    }
}