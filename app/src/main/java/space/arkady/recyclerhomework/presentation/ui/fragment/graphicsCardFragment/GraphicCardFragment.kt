package space.arkady.recyclerhomework.presentation.ui.fragment.graphicsCardFragment

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_graphiccard.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.models.BrandGraphicCard
import space.arkady.recyclerhomework.domain.models.DomainGraphicCard
import space.arkady.recyclerhomework.presentation.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.ui.fragment.graphicsCardFragment.recycler.GraphicCardBottomSheetFragment
import space.arkady.recyclerhomework.presentation.ui.fragment.monitorFragment.MonitorFragment
import space.arkady.recyclerhomework.presentation.ui.SharedViewModel

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
