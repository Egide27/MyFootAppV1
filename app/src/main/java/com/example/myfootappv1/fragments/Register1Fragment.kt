package com.example.myfootappv1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentRegister1Binding

class Register1Fragment : Fragment() {

    private var _binding : FragmentRegister1Binding? = null
    private val binding : FragmentRegister1Binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegister1Binding.inflate(inflater,container,false)

        //Go to home
        binding.btnConfirmationRegisterFragment.setOnClickListener{
            findNavController().navigate(R.id.action_register1Fragment_to_homeFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Register1Fragment()
    }
}