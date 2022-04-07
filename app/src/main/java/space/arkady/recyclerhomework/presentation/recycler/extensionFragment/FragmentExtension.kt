package space.arkady.recyclerhomework.presentation.recycler.extensionFragment

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.openFragment(fragment: Fragment, tag: String, containerId: Int) {
    supportFragmentManager.beginTransaction().replace(containerId, fragment, tag)
        .addToBackStack(tag).commit()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}