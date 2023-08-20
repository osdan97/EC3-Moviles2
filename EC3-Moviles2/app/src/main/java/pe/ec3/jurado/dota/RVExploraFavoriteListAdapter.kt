package pe.ec3.jurado.dota

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.ec3.jurado.dota.databinding.ItemFavoriteBinding
import pe.ec3.jurado.dota.model.Heroe


class RVExploraFavoriteListAdapter (var heroes: List<Heroe>) : RecyclerView.Adapter<ExploraFavoriteVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploraFavoriteVH {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploraFavoriteVH(binding)
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: ExploraFavoriteVH, position: Int) {
        holder.bind(heroes[position])
    }

    fun updateHeroes(newHeroes: List<Heroe>) {
        heroes = newHeroes
        notifyDataSetChanged()
    }
}


class ExploraFavoriteVH(private val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(heroe: Heroe) {
        binding.imageHeroe.setImageResource(R.drawable.heroe_dota2)
        //binding.txtPuntuacion.text = "${heroe.puntuacion}"
        binding.txtNombre.text = heroe.localizedName
        binding.txtPuntuacion.text = heroe.id.toString()
        binding.txtAtaque.text = heroe.attackType
        binding.txtRoles.text = heroe.roles.toString()
        binding.txtDescripcion.text = when (heroe.primaryAttr) {
            "str" -> "Fuerza"
            "agi" -> "Agilidad"
            "int" -> "Inteligencia"
            else -> "Descripción no disponible" // Opcional, si hay un valor inesperado
        }
    }
}