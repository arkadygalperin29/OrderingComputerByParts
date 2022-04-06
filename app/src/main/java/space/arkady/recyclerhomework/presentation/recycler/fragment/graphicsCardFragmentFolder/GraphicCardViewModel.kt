package space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.arkady.recyclerhomework.domain.domain.GraphicCardInteractor
import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard

class GraphicCardViewModel(
    val interactor: GraphicCardInteractor
) : ViewModel() {
    val graphicCardLiveData: LiveData<List<DomainGraphicCard>> get() = _graphicCardLiveData
    private val _graphicCardLiveData = MutableLiveData<List<DomainGraphicCard>>()

    init {
        loadGraphicCards()
    }

    private fun loadGraphicCards() {
        _graphicCardLiveData.value = interactor.getGraphicCard()
    }
}
