package space.arkady.recyclerhomework.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.arkady.recyclerhomework.domain.models.*

class SharedViewModel : ViewModel() {

    val user: LiveData<User> get() = _user
    private val _user = MutableLiveData<User>()

    fun setUser(user: User) {
        _user.value = user
    }


    val domainOperationSystem: LiveData<DomainOperationSystem> get() = _domainOperationSystem
    private val _domainOperationSystem = MutableLiveData<DomainOperationSystem>()

    fun setOperationSystem(domainOperationSystem: DomainOperationSystem) {
        _domainOperationSystem.value = domainOperationSystem
    }


    val domainGraphicCard: LiveData<DomainGraphicCard> get() = _domainGraphicCard
    private val _domainGraphicCard = MutableLiveData<DomainGraphicCard>()

    fun setGraphicCard(domainGraphicCard: DomainGraphicCard) {
        _domainGraphicCard.value = domainGraphicCard
    }


    val domainMonitor: LiveData<DomainMonitor> get() = _domainMonitor
    private val _domainMonitor = MutableLiveData<DomainMonitor>()

    fun setDomainMonitor(domainMonitor: DomainMonitor) {
         _domainMonitor.value = domainMonitor
    }

    val peripheries: LiveData<Periphery> get() = _peripheries
    private val _peripheries = MutableLiveData<Periphery>()

    fun setPeriphery(periphery: Periphery) {
        _peripheries.value = periphery
    }
}