package pe.ec3.jurado.dota
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;
import pe.ec3.jurado.dota.databinding.ItemHerolistBinding
import pe.ec3.jurado.dota.model.Heroe


class RVExploraListAdapter(var heroes: List<Heroe>) : RecyclerView.Adapter<ExploraVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploraVH {
        val binding = ItemHerolistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploraVH(binding)
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: ExploraVH, position: Int) {
        holder.bind(heroes[position])
    }

    fun updateHeroes(newHeroes: List<Heroe>) {
        heroes = newHeroes
        notifyDataSetChanged()
    }
}



class ExploraVH(private val binding: ItemHerolistBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(heroe: Heroe) {
        binding.imageHeroe.setImageResource(R.drawable.heroe_dota2)
        //binding.txtPuntuacion.text = "${heroe.puntuacion}"
        binding.txtNombre.text = heroe.localized_name
        binding.txtPuntuacion.text = heroe.id.toString()

        binding.txtDescripcion.text = when (heroe.primary_attr) {
            "str" -> "Fuerza"
            "agi" -> "Agilidad"
            "int" -> "Inteligencia"
            else -> "Descripción no disponible" // Opcional, si hay un valor inesperado
        }
    }
}