package space.arkady.recyclerhomework.presentation.ui.fragment.graphicsCardFragment.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.arkady.recyclerhomework.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.presentation.clickListeners.OnGraphicCardClickListener

class GraphicCardAdapter(private val onGraphicCardClickListener: OnGraphicCardClickListener) :
    RecyclerView.Adapter<GraphicCardViewHolder>() {

    private var domainGraphicCards: List<DomainGraphicCard> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphicCardViewHolder {
        return GraphicCardViewHolder.newInstance(parent, onGraphicCardClickListener)
    }

    override fun onBindViewHolder(graphicCardsHolder: GraphicCardViewHolder, position: Int) {
        graphicCardsHolder.bindItem(domainGraphicCards[position])
    }

    override fun getItemCount(): Int {
        return domainGraphicCards.size
    }

    fun submitCardList(data: List<DomainGraphicCard>) {
        domainGraphicCards = data

        notifyDataSetChanged()
    }
}





