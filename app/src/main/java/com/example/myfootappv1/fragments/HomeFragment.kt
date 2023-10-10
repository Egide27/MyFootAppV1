package com.example.myfootappv1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding : FragmentHomeBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //Go to profile fragment
        binding.btnProfileHomeFragment.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_profilFragment)
        }
        //GO to teams
        binding.btnTeamsHomeFragment.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_teamsFragment)
        }

        //Go to sessions
        binding.btnSessionHomeFragment.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_sessionsFragment)
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
            HomeFragment()
    }
}