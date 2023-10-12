package com.example.myfootappv1.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfootappv1.PlayerViewModel
import com.example.myfootappv1.PlayerViewModelFactory
import com.example.myfootappv1.R
import com.example.myfootappv1.TeamsViewModel
import com.example.myfootappv1.TeamsViewModelFactory
import com.example.myfootappv1.adapter.PlayerAdapter
import com.example.myfootappv1.databinding.FragmentLoginBinding
import com.example.myfootappv1.databinding.FragmentOneTeamBinding

class OneTeamFragment : Fragment() {

   // private val playerViewModel : PlayerViewModel by viewModels(){ PlayerViewModelFactory(requireContext()) }
    private val teamsViewModel : TeamsViewModel by viewModels(){ TeamsViewModelFactory(requireContext()) }
    private var _binding : FragmentOneTeamBinding? = null
    private val binding : FragmentOneTeamBinding
        get() = _binding!!

    private lateinit var adapter : PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneTeamBinding.inflate(inflater, container, false)

        setRv()

        var teamId = arguments?.getInt(paramTeamId)
        Log.i("TATATAT", "onCreateView: ${teamId}")
        teamsViewModel.team.observe(viewLifecycleOwner){
            Log.i("TATATAT", "onCreateView: ${it?.name}")
            binding.tvTeamNameOneTeamFragment.text  = it.name
        }
        teamsViewModel.players.observe(viewLifecycleOwner){
            adapter.updatePlayers(it)
            Log.i("TATATAT", "onCreateView: ${it}")
        }
        teamsViewModel.getTeam(teamId!!)
        teamsViewModel.getPlayersByTeam(teamId!!)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setRv() {
        binding.rvPlyersOneTeamsFragment.layoutManager = LinearLayoutManager(requireContext())
        adapter = PlayerAdapter()
        binding.rvPlyersOneTeamsFragment.adapter = adapter
    }

    companion object {
        val paramTeamId : String = "teamId"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OneTeamFragment()
    }
}