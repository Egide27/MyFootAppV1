package com.example.myfootappv1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myfootappv1.PlayerViewModel
import com.example.myfootappv1.PlayerViewModelFactory
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentLoginBinding

class OneTeamFragment : Fragment() {

    private val playerViewModel : PlayerViewModel by viewModels(){ PlayerViewModelFactory(requireContext()) }

    private var _binding : FragmentLoginBinding? = null
    private val binding : FragmentLoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_team, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OneTeamFragment()
    }
}