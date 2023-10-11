package com.example.myfootappv1.fragments

import TeamAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootappv1.TeamsViewModelFactory
import com.example.myfootappv1.PlayerViewModel
import com.example.myfootappv1.R
import com.example.myfootappv1.TeamsViewModel
import com.example.myfootappv1.databinding.FragmentTeamsBinding

class TeamsFragment : Fragment(), TeamAdapter.TeamEventListener {

    private val viewModel : TeamsViewModel by viewModels(){ TeamsViewModelFactory(requireContext()) }
    private var _binding : FragmentTeamsBinding? = null
    private val binding : FragmentTeamsBinding
        get() = _binding!!

    private lateinit var adapter : TeamAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamsBinding.inflate(inflater,container, false)
        getTeams()
        setListener()
        setRv()

        obserVm()

        return binding.root
    }

    private fun getTeams(){
        viewModel.getTeams()
    }
    private fun setRv() {
        binding.rvTeamsFragment.layoutManager = LinearLayoutManager(requireContext())
        adapter = TeamAdapter(this)
        binding.rvTeamsFragment.adapter = adapter
    }

    private fun setListener(){
        binding.btnPreviewTeamsFragment.setOnClickListener{
            findNavController().navigate(R.id.action_teamsFragment_to_homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TeamsFragment()
    }

    fun obserVm(){
        viewModel.teams.observe(viewLifecycleOwner){
            adapter.updateTeams(it)
        }
    }
}