package com.example.tamrinclass.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tamrinclass.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.tamrinclass.databinding.FragmentRegisterBinding
import com.example.tamrinclass.model.Status
import com.example.tamrinclass.model.User

class RegisterFragment : Fragment() {
    lateinit var binding:FragmentRegisterBinding
    val viewModel:RegisterViewModel  by viewModel()
    var RegisterClicked = false

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
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       observe()
        onClick()
    }

    private fun onClick() {
        binding.btnRegister.setOnClickListener {
            if (!RegisterClicked) {
                if (dataIsValid()) {
                    viewModel.registerUser(
                        User(
                            name = binding.etName.text.toString(),
                            avatarUrl = binding.etAvatarUrl.text.toString(),
                            password = binding.etPassword.text.toString(),
                            status = "${Status.NEW_USER}"
                        )
                    )
                    RegisterClicked = true
                } else
                    Toast.makeText(requireContext(), "data is not valid", Toast.LENGTH_SHORT).show()
            } else findNavController().navigate(R.id.action_registerFragment_to_homeFragment2)
        }
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun dataIsValid(): Boolean {
        var dataIsValid = true
        if (binding.etName.text.isNullOrBlank() ||
            binding.etAvatarUrl.text.isNullOrBlank() ||
            binding.etPassword.text.isNullOrBlank()
        )
            dataIsValid = false
        return dataIsValid
    }


    private fun observe() {
        TODO("Not yet implemented")
    }

}