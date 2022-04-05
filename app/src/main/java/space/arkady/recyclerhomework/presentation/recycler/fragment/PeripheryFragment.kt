package space.arkady.recyclerhomework.presentation.recycler.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_monitor.*
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment

class PeripheryFragment : Fragment(R.layout.fragment_periphery) {

    companion object {
        const val TAG = "Periphery"
        fun newInstance() = PeripheryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_monitorToPeriphery.setOnClickListener {
            requireActivity().apply {
                openFragment(R.id.container, OrderFragment.newInstance(), OrderFragment.TAG)
            }
        }
    }
}