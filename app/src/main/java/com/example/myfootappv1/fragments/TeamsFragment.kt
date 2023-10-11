package com.example.myfootappv1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentHomeBinding
import com.example.myfootappv1.databinding.FragmentOneTeamBinding
import com.example.myfootappv1.databinding.FragmentTeamsBinding

class TeamsFragment : Fragment() {

    private var _binding : FragmentTeamsBinding? = null
    private val binding : FragmentTeamsBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamsBinding.inflate(inflater,container, false)

        binding.btnPreviewTeamsFragment.setOnClickListener{
            findNavController().navigate(R.id.action_teamsFragment_to_homeFragment)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TeamsFragment()
    }
}