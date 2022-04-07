package space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder.recycler


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.presentation.recycler.clickListeners.OnGraphicCardClickListener
import space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder.GraphicCardResultListener
import space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder.GraphicCardViewModel


class GraphicCardBottomSheetFragment(graphicCardResultListener: GraphicCardResultListener) :
    BottomSheetDialogFragment() {

    private val sharedViewModel: GraphicCardViewModel by sharedViewModel()

    companion object {
        const val TAG = "GraphicCardSheetFragment"
        fun newInstance(graphicCardResultListener: GraphicCardResultListener) =
            GraphicCardBottomSheetFragment(graphicCardResultListener)
    }

    private val selectGraphicCard = object : OnGraphicCardClickListener {
        override fun onGraphicCardClickListener(domainGraphicCard: DomainGraphicCard) {
            graphicCardResultListener.onGraphicCardResult(domainGraphicCard)
            dismiss()
        }
    }

    private val adapter by lazy {GraphicCardAdapter(selectGraphicCard)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        recycler.adapter = adapter

        sharedViewModel.graphicCardLiveData.observe(viewLifecycleOwner) { graphicCard ->
            adapter.submitCardList(graphicCard)
        }
    }
}