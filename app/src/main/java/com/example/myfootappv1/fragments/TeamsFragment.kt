package com.example.myfootappv1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentHomeBinding
import com.example.myfootappv1.databinding.FragmentOneTeamBinding

class TeamsFragment : Fragment() {

    private var _binding : FragmentOneTeamBinding? = null
    private val binding : FragmentOneTeamBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneTeamBinding.inflate(inflater,container, false)

//        binding.

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TeamsFragment()
    }
}