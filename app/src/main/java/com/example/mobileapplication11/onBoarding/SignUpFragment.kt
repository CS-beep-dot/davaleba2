package com.example.mobileapplication11.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mobileapplication11.R
import com.example.mobileapplication11.databinding.FragmentSignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    private val auth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        btnSignUp.setOnClickListener {
            val email = etEmailSignUp.text.toString()
            val password = etPasswordSignUp.text.toString()

            if (email.isEmpty() || password.isEmpty() || password.length < 6 || password.contains(
                    ' '
                )
            ) {
                Toast.makeText(requireContext(), "Error!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        "user is successfully created!",
                        Toast.LENGTH_SHORT
                    ).show()
                    goToSignIn()
                } else {
                    Toast.makeText(requireContext(), "user error!!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        tvSignInSignUp.setOnClickListener {
            goToSignIn()
        }
    }


    private fun goToSignIn() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, SignInFragment.newInstance())
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}