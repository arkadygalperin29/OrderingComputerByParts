package space.arkady.recyclerhomework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.presentation.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.ui.fragment.UserRegistrationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment(
            UserRegistrationFragment.newInstance(),
            UserRegistrationFragment.TAG,
            R.id.container,
        )
    }
}

