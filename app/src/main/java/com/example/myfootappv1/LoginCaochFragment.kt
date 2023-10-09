package com.example.myfootappv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myfootappv1.databinding.FragmentLoginCaochBinding

class LoginCaochFragment : Fragment() {

    private var _binding : FragmentLoginCaochBinding? = null
    private val binding : FragmentLoginCaochBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginCaochBinding.inflate(inflater, container, false)
        binding.btnLoginFragment.setOnClickListener {
            findNavController().navigate(R.id.action_loginCaochFragment3_to_homeFragment)
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
            LoginCaochFragment()
            }
    }
