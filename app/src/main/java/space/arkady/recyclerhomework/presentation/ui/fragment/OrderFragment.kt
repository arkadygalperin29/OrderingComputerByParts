package space.arkady.recyclerhomework.presentation.ui.fragment

import android.content.Intent
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_order.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.models.Order
import space.arkady.recyclerhomework.presentation.ui.SharedViewModel

class OrderFragment : Fragment(R.layout.fragment_order) {
    companion object {
        const val TAG = "OrderFragment"

        fun newInstance() = OrderFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()

        textOrder.text = createOrder().toString()

        buttonConfirmOrder.setOnClickListener {
            openChatApp()
        }
    }

    private fun createOrder(): Order {
        return Order(
            sharedViewModel.user.value,
            sharedViewModel.domainGraphicCard.value,
            sharedViewModel.domainMonitor.value,
            sharedViewModel.domainOperationSystem.value,
            sharedViewModel.peripheries.value,
        )
    }

    private fun openChatApp() {
        val intent = Intent().apply {
            type = "text/plain"

            action = Intent.ACTION_SEND

            putExtra(Intent.EXTRA_TEXT, createOrder().toString())
        }
        val intentChooser = Intent.createChooser(intent, "")
        startActivity(intentChooser)
    }
}





