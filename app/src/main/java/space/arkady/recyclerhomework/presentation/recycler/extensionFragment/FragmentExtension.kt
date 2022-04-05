package space.arkady.recyclerhomework.presentation.recycler.extensionFragment

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.openFragment(containerId: Int, fragment: Fragment, tag: String) {
    supportFragmentManager.beginTransaction().replace(containerId, fragment, tag)
        .addToBackStack(tag).commit()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
}