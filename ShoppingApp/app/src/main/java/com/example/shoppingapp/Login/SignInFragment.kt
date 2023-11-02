package com.example.shoppingapp.Login

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val showHideButton = binding.btnShowHidePassword
        val passwordEditText = binding.etPasswordSignin

        showHideButton.setOnClickListener {
            if(passwordEditText.inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD){
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                showHideButton.setImageResource(R.drawable.password_icon)
            }
            else {
                // Şifre gösteriliyorsa, gizle
                passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                showHideButton.setImageResource(R.drawable.password_icon)
            }
            passwordEditText.setSelection(passwordEditText.text.length)
        }

        binding.buttonSignin.setOnClickListener {
            val email = binding.etEmailSignin.text.toString()
            val password = binding.etPasswordSignin.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if(task.isSuccessful){
                            Toast.makeText(requireContext(),"SignIn Successful", Toast.LENGTH_SHORT).show()
                            Navigation.findNavController(view)
                                .navigate(R.id.action_signInFragment_to_mainFragment)
                        }else{
                            Toast.makeText(requireContext(),"Login failed. Please try again", Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(requireContext(),"Some Fields are Empty", Toast.LENGTH_SHORT).show()

            }
        }
        binding.tvNavigateToSignUp.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.forgotText.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_signInFragment_to_resetPasswordFragment)
        }



    }}
