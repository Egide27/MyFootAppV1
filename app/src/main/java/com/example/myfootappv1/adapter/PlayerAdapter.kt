package com.example.myfootappv1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootappv1.R
import com.example.myfootappv1.api.models.Player
import com.example.myfootappv1.api.models.Team

class PlayerAdapter() : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvPlayerFirstName : TextView = view.findViewById(R.id.tv_first_name_item_player)
        val tvPlayerLastName : TextView = view.findViewById(R.id.tv_last_name_item_player)
    }

    private var players : List<Player> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_player, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  players.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = players[position]
        val firstName = player.firtstName
        val lastName = player.lastName
        holder.tvPlayerFirstName.text = firstName
        holder.tvPlayerLastName.text = lastName

    }

    fun updatePlayers(players: List<Player>){
        //this.players = players.sortedBy { it.firtstName+it.lastName }.toList()
        this.players = players
        notifyDataSetChanged()
    }

}