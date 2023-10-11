package com.example.myfootappv1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myfootappv1.R
import com.example.myfootappv1.databinding.FragmentSessionsBinding

class SessionsFragment : Fragment() {

    private var _binding : FragmentSessionsBinding? = null
    private val binding : FragmentSessionsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionsBinding.inflate(inflater,container, false)

        binding.btnPreviewSessionsFragment.setOnClickListener{
            findNavController().navigate(R.id.action_sessionsFragment_to_homeFragment)
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
            SessionsFragment()
    }
}