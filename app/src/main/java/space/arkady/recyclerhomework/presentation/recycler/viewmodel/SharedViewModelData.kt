package space.arkady.recyclerhomework.presentation.recycler.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.arkady.recyclerhomework.domain.domain.interactor.CommonInteractor
import space.arkady.recyclerhomework.domain.domain.models.CommonItem

class SharedViewModelData(private val interactor: CommonInteractor<CommonItem>) : ViewModel() {

    val sharedLiveData: LiveData<List<CommonItem>> get() = _sharedLiveData
    private val _sharedLiveData = MutableLiveData<List<CommonItem>>()


    init {
        loadData()
    }

    private fun loadData() {
        _sharedLiveData.value = interactor.getItem()
    }
}