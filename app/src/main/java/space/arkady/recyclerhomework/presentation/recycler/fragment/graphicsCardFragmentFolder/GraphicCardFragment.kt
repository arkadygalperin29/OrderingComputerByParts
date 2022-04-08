package space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_graphiccard.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.BrandGraphicCard
import space.arkady.recyclerhomework.domain.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.recycler.fragment.graphicsCardFragmentFolder.recycler.GraphicCardBottomSheetFragment
import space.arkady.recyclerhomework.presentation.recycler.fragment.monitorFragmentFolder.MonitorFragment
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class GraphicCardFragment : Fragment(R.layout.fragment_graphiccard) {
    companion object {
        const val TAG = "GraphicCard"
        fun newInstance() = GraphicCardFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()


    private val graphicCardResult by lazy {
        object : GraphicCardResultListener {
            override fun onGraphicCardResult(graphicCardItem: DomainGraphicCard) {
                showgraphicCardList.setText(graphicCardItem.brand)
            }
        }
    }



    override fun onStart() {
        super.onStart()

        initViews()
    }

    private fun initViews() {
        showgraphicCardList.setOnClickListener {
            onEditTextClick()
        }
        button_GraphicCardToMonitor.setOnClickListener {
            onButtonGraphicCardClick()
        }

    }

    private fun onButtonGraphicCardClick() {

        when {
            showgraphicCardList.text.isEmpty() -> {
                showToast("Select Graphics Card")
            }
            showgraphicCardList.text.contains("NVIDIA") -> {
                BrandGraphicCard.NVIDIA
            }
            showgraphicCardList.text.contains("AMD") -> {
                BrandGraphicCard.AMD
            }
        }

        if (showgraphicCardList.text.toString().isEmpty()) {
            requireActivity().showToast("Error")
        } else {
            sharedViewModel.setGraphicCard(
                DomainGraphicCard(showgraphicCardList.text.toString())
            )
            requireActivity().apply {
                openFragment(
                    fragment = MonitorFragment.newInstance(),
                    tag = MonitorFragment.TAG,
                    containerId = R.id.container
                )
            }
        }
    }

    private fun onEditTextClick() {
        GraphicCardBottomSheetFragment.newInstance(graphicCardResult)
            .show(
                requireActivity().supportFragmentManager,
                GraphicCardBottomSheetFragment.TAG
            )
    }
}
