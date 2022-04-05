package space.arkady.recyclerhomework.presentation.recycler.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.CommonItem
import space.arkady.recyclerhomework.presentation.recycler.ItemClickListener
import space.arkady.recyclerhomework.presentation.recycler.RecyclerAdapter
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModelData

class DialogFragment(getItem: ItemClickListener) : BottomSheetDialogFragment() {

    private val sharedViewModelData: SharedViewModelData by sharedViewModel()

    companion object {
        const val TAG = "DialogFragment"
        fun newInstance(getItem: ItemClickListener) = DialogFragment(getItem)
    }

    private val selectItem = object : ItemClickListener {
        override fun itemClickListener(item: CommonItem) {
            getItem.itemClickListener(item)
            dismiss()
        }
    }

    private val adapter = RecyclerAdapter(selectItem)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        sharedViewModelData.sharedLiveData.observe(viewLifecycleOwner) { listItem ->
            adapter.submitCardList(listItem)
        }

        recycler.adapter = adapter
    }
}