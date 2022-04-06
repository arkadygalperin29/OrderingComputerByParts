package space.arkady.recyclerhomework.presentation.recycler.fragment

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_periphery.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.Periphery
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class PeripheryFragment : Fragment(R.layout.fragment_periphery) {

    companion object {
        const val TAG = "PeripheryFragment"
        fun newInstance() = PeripheryFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()

        buttonPeriphery.setOnClickListener {

            sharedViewModel.setPeriphery(createAdditional())
            requireActivity().apply {
                openFragment(
                    R.id.container,
                    OrderFragment.newInstance(),
                    OrderFragment.TAG
                )
            }
        }
    }

    private fun createAdditional(): Periphery {

        val peripherals: Periphery = Periphery()

        if (keyboardButton.isChecked) {
            peripherals.keyboard = getString(R.string.keyboard)
        }
        if (mouseButton.isChecked) {
            peripherals.mouse = getString(R.string.mouse)
        }
        if (webcamButton.isChecked) {
            peripherals.webcam = getString(R.string.webcam)
        }

        return peripherals
    }


}