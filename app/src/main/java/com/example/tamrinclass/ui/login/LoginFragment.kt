package com.example.tamrinclass.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tamrinclass.R
import com.example.tamrinclass.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    val viewModel: LoginViewModel by viewModel()
    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClicks()
        observers()
    }

    private fun observers() {
        viewModel.loginSuccessful.observe(viewLifecycleOwner) {
            if (it)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            else
                Toast.makeText(requireContext(), "not found!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onClicks() {
        binding.btnLogin.setOnClickListener {
            if (binding.etId.text.isNullOrBlank() && binding.etPassword.text.isNullOrBlank())
                Toast.makeText(requireContext(), "Fill in all information.", Toast.LENGTH_SHORT)
                    .show()
            else
                viewModel.login(
                    binding.etId.text.toString(),
                    binding.etPassword.text.toString()
                )

        }
    }

}