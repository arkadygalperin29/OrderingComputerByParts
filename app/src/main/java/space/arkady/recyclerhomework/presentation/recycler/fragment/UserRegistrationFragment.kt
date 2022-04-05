package space.arkady.recyclerhomework.presentation.recycler.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user_registration.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.domain.models.User
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.recycler.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.recycler.viewmodel.SharedViewModel

class UserRegistrationFragment : Fragment(R.layout.fragment_user_registration) {

    companion object {
        const val TAG = "userRegistrationFragment"
        fun newInstance() = UserRegistrationFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registrationUser()
    }

    private fun registrationUser() {
        buttonToOperationSystem.setOnClickListener {
            when {
                checkEmptyFieldUser() -> showToast("Fill empty fields")
                else -> sharedViewModel.setUser(createUser())
            }
            sharedViewModel.user.observe(viewLifecycleOwner) {
                requireActivity().apply {
                    openFragment(
                        R.id.container,
                        OperationSystemFragment.newInstance(),
                        OperationSystemFragment.TAG
                    )
                }
            }
        }
    }

    private fun createUser(): User {
        return User(
            inputName.text.toString(),
            inputSecondname.text.toString(),
            inputEmail.text.toString(),
            inputPhone.text.toString()
        )
    }


    private fun checkEmptyFieldUser(): Boolean {
        return inputName.text.isEmpty() ||
                inputSecondname.text.isEmpty() ||
                inputEmail.text.isEmpty() ||
                inputPhone.text.isEmpty()
    }
}