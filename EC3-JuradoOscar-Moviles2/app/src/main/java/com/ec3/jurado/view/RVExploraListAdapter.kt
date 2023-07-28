package com.ec3.jurado.view
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;

import com.ec3.jurado.databinding.TeamListBinding


import com.ec3.jurado.model.Team


class RVExploraListAdapter(var teams: List<Team>) : RecyclerView.Adapter<ExploraVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploraVH {
        val binding = TeamListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploraVH(binding)
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: ExploraVH, position: Int) {
        holder.bind(teams[position])
    }

    fun updateTeams(newTeams: List<Team>) {
        teams = newTeams
        notifyDataSetChanged()
    }
}



class ExploraVH(private val binding: TeamListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(team: Team) {

        //binding.txtPuntuacion.text = "${heroe.puntuacion}"
        binding.txtNombre.text = team.name
        binding.txtRating.text=team.rating.toString()

        binding.txtWins.text=team.wins.toString()
    }
}