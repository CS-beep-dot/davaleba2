package com.example.mobileapplication11.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.mobileapplication11.R
import com.example.mobileapplication11.databinding.FragmentSignInBinding
import com.example.mobileapplication11.fragments.MainFragment
import com.example.mobileapplication11.home.HomeFragment
import com.google.firebase.auth.FirebaseAuth

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        btnSignIn.setOnClickListener {
            val email = etEmailSignIn.text.toString()
            val password = etPasswordSignIn.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(requireContext(), "error!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    goToOtherPage(MainFragment.newInstance())
                } else {
                    Toast.makeText(requireContext(), it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        tvSignUpSignIn.setOnClickListener {
            goToOtherPage(SignUpFragment.newInstance())
        }

        tvForgotPasswordSignIn.setOnClickListener {
            goToOtherPage(ForgotPasswordFragment.newInstance())
        }
    }

    private fun goToOtherPage(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, fragment)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignInFragment()
    }
}