package space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem.recycler


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.DomainOperationSystem
import space.arkady.recyclerhomework.presentation.recycler.clickListeners.OnOperationSystemClickListener
import space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem.OperationSystemResultListener
import space.arkady.recyclerhomework.presentation.recycler.fragment.operationSystem.OperationSystemViewModel


class OperationBottomSheetFragment(operationSystemResultListener: OperationSystemResultListener) :
    BottomSheetDialogFragment() {

    private val sharedViewModel: OperationSystemViewModel by sharedViewModel()

    companion object {
        const val TAG = "OperationSystemBottomSheetFragment"
        fun newInstance(operationSystemResultListener: OperationSystemResultListener) =
            OperationBottomSheetFragment(operationSystemResultListener)
    }

    private val adapter by lazy { OperationSystemAdapter(selectOperationSystem) }


    private val selectOperationSystem = object : OnOperationSystemClickListener {
        override fun onOperationSystemClickListener(domainOperationSystem: DomainOperationSystem) {
            operationSystemResultListener.onOperationSystemResult(domainOperationSystem)
            dismiss()
        }
    }


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

        sharedViewModel.operationSystemLiveData.observe(viewLifecycleOwner) { operationSystem ->
            adapter.submitCardList(operationSystem)
        }

    }
}

