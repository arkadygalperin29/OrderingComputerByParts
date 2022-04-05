package space.arkady.recyclerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.fragment.UserRegistrationFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment(
            R.id.container,
            UserRegistrationFragment.newInstance(),
            UserRegistrationFragment.TAG
        )
    }
}

