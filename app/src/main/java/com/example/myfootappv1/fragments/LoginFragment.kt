package com.example.myfootappv1.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myfootappv1.PlayerViewModel
import com.example.myfootappv1.PlayerViewModelFactory
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val viewModel : PlayerViewModel by viewModels(){ PlayerViewModelFactory(requireContext()) }

    private var _binding : FragmentLoginBinding? = null
    private val binding : FragmentLoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnLoginFragment.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.btnRegisterLoginFragment.setOnClickListener{
            val mail = binding.etEmailLoginFragment.text?.toString()
            val mdp = binding.etPswdLoginFragment.text?.toString()
            if (mail.isNullOrBlank()){
                Toast.makeText(requireContext(), "Entrez un mail ET un mot de passe ", Toast.LENGTH_LONG).show()
            }
            else {
                val id: Int = mail.toInt()
                Log.d("PLAYER", viewModel.getPlayer(id).toString())
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment()
            }
    }
