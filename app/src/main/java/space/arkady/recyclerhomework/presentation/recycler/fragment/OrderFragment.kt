package space.arkady.recyclerhomework.presentation.recycler.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_order.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class OrderFragment : Fragment(R.layout.fragment_order) {

    companion object {
        const val TAG = "Order"
        fun newInstance() = OrderFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    @SuppressLint("setTextI18N")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.user.observe(viewLifecycleOwner) { user ->
            outputNameSecondName.text = "${user.name} ${user.secondName}"
            outputPhoneNumber.text = user.phone
        }

        sharedViewModel.graphicCard.observe(viewLifecycleOwner) {
            outputGraphicCard
        }
        sharedViewModel.monitor.observe(viewLifecycleOwner) {
            outputMonitor
        }
        sharedViewModel.operationSystem.observe(viewLifecycleOwner) {
            outputOperationSystem
        }
    }
}