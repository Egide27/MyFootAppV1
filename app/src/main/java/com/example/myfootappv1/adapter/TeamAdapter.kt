import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootappv1.R
import com.example.myfootappv1.api.models.Team

class TeamAdapter (val teamEventListener: TeamEventListener) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    interface TeamEventListener {
//        fun onDelete(position : Int)
//        fun onEdit(team: Team, position : Int)
    }

    private var teams : List<Team> = mutableListOf()


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvTeamName : TextView = view.findViewById(R.id.tv_team_name_item_product)
        val tvTeamCategory : TextView = view.findViewById(R.id.tv_team_category_item_product)
//        val btnDelete : FloatingActionButton = view.findViewById(R.id.btn_delete_product_item_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return teams.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teams[position]
        val name = team.name
        val category = team.category
        holder.tvTeamName.text = name
        holder.tvTeamCategory.text = category


//        holder.btnDelete.setOnClickListener {
//            productEventListener.onDelete(position)
//        }
        holder.itemView.setOnClickListener {
            // Voir les jouers de l'equipes!!!
            //productEventListener.onEdit(team, position)

        }
    }

    fun updateTeams(teams: List<Team>){
        this.teams = teams
        notifyDataSetChanged()
    }

}