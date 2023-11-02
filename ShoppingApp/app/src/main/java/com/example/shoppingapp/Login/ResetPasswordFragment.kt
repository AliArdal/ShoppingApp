package com.example.shoppingapp.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.FragmentResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth


class ResetPasswordFragment : Fragment() {

    private lateinit var binding: FragmentResetPasswordBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.buttonReset.setOnClickListener {
            val email = binding.etResetEmail.text.toString()
            auth.sendPasswordResetEmail(email)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(),"Please Check Your Email" , Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(),it.toString() , Toast.LENGTH_SHORT).show()
                }
        }
        binding.tvNavigateToSignIn.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_signInFragment_to_resetPasswordFragment)
        }
    }}