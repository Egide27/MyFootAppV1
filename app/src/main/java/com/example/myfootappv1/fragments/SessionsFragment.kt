package com.example.myfootappv1.fragments

import TeamAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootappv1.R
import com.example.myfootappv1.SessionViewModel
import com.example.myfootappv1.SessionViewModelFactory
import com.example.myfootappv1.TeamsViewModel
import com.example.myfootappv1.TeamsViewModelFactory
import com.example.myfootappv1.adapter.SessionAdapter
import com.example.myfootappv1.databinding.FragmentSessionsBinding

class SessionsFragment : Fragment(), SessionAdapter.SessionEventListener {

    private val viewModel : SessionViewModel by viewModels(){ SessionViewModelFactory(requireContext()) }

    private var _binding : FragmentSessionsBinding? = null
    private val binding : FragmentSessionsBinding
        get() = _binding!!


    private lateinit var adapter : SessionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionsBinding.inflate(inflater,container, false)

        getTeams()
        setListener()
        setRv()
        obserVm()

        return binding.root
    }

    private fun getTeams() {
        viewModel.getTeams()
    }

    private fun setListener() {
        binding.btnPreviewSessionsFragment.setOnClickListener {
            findNavController().navigate(R.id.action_sessionsFragment_to_homeFragment)
        }
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

    private fun setRv() {
        binding.rvSessionsFragment.layoutManager = LinearLayoutManager(requireContext())
        adapter = SessionAdapter(this)
        binding.rvSessionsFragment.adapter = adapter
    }

    fun obserVm(){
        viewModel.sessions.observe(viewLifecycleOwner){
            adapter.updateSessions(it)
        }
    }
}