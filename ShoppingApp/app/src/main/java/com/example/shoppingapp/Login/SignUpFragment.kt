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
import com.example.shoppingapp.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val showHideButton = binding.btnShowHidePassword
        val passwordEditText = binding.etPasswordSignUp

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



        binding.buttonSignUp.setOnClickListener {
            val email = binding.etEmailSignUp.text.toString()
            val password = binding.etEmailSignUp.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(requireActivity()) {task ->
                        if (task.isSuccessful){
                            Toast.makeText(requireContext(),"Signup Successful", Toast.LENGTH_SHORT).show()
                            Navigation.findNavController(view)
                                .navigate(R.id.action_signUpFragment_to_signInFragment)
                        }else{
                            Toast.makeText(requireContext(),"Signup Unsuccessfu.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(requireContext(),"Enter email and password", Toast.LENGTH_SHORT).show()
            }

        }
        binding.tvNavigateToSignIn.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_signUpFragment_to_signInFragment)
        }


    }}