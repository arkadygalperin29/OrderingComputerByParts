package space.arkady.recyclerhomework.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user_registration.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import space.arkady.recyclerhomework.R
import space.arkady.recyclerhomework.domain.models.User
import space.arkady.recyclerhomework.presentation.extensionFragment.openFragment
import space.arkady.recyclerhomework.presentation.extensionFragment.showToast
import space.arkady.recyclerhomework.presentation.ui.fragment.operationSystem.OperationSystemFragment
import space.arkady.recyclerhomework.presentation.ui.SharedViewModel

class UserRegistrationFragment : Fragment(R.layout.fragment_user_registration) {
    companion object {
        const val TAG = "LoginFragment"

        fun newInstance() = UserRegistrationFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonRegistration.setOnClickListener {

            if (
                inputName.text.toString().isEmpty() ||
                inputSecondname.text.toString().isEmpty() ||
                inputPhone.text.toString().isEmpty() ||
                inputEmail.text.toString().isEmpty()
            ) {
                requireActivity().showToast("Fill the fields")
            } else {
                sharedViewModel.setUser(createUser())
                requireActivity().apply {
                    openFragment(
                        fragment = OperationSystemFragment.newInstance(),
                        tag = OperationSystemFragment.TAG,
                        containerId = R.id.container,
                    )
                }
            }
        }
    }

    private fun createUser(): User {
        return User(
            inputName.text.toString(),
            inputSecondname.text.toString(),
            inputPhone.text.toString(),
            inputEmail.text.toString()
        )
    }
}
