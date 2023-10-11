package com.example.myfootappv1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootappv1.R
import com.example.myfootappv1.api.models.Session
import com.example.myfootappv1.api.models.Team

class SessionAdapter(val sessionEventListener: SessionEventListener) : RecyclerView.Adapter<SessionAdapter.ViewHolder>() {
    interface SessionEventListener {

    }

    private var sessions : List<Session> = mutableListOf()

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvDateSession : TextView = view.findViewById(R.id.tv_date_item_session)
        val tvTypeSession : TextView = view.findViewById(R.id.tv_type_item_session)
        val tvDurationSession : TextView = view.findViewById(R.id.tv_duration_item_session)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_session, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SessionAdapter.ViewHolder, position: Int) {
        val session = sessions[position]
        val date = session.date
        val type = session.sessionType
        val duration = session.duration

        holder.tvDateSession.text = date
        holder.tvTypeSession.text = type
        holder.tvDurationSession.text = "$duration min"

    }

    override fun getItemCount(): Int {
        return sessions.size
    }

    fun updateSessions(sessions: List<Session>){
        this.sessions = sessions
        notifyDataSetChanged()
    }


}