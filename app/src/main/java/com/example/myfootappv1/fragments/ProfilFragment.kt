package com.example.myfootappv1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentHomeBinding
import com.example.myfootappv1.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {

    private var _binding : FragmentProfilBinding? = null
    private val binding : FragmentProfilBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)

        binding.btnPreviousProfilFragment.setOnClickListener{
            findNavController().navigate(R.id.action_profilFragment_to_homeFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfilFragment()
    }
}