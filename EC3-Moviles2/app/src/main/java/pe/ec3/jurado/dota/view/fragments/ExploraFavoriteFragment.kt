package pe.ec3.jurado.dota.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.ec3.jurado.dota.RVExploraFavoriteListAdapter
import pe.ec3.jurado.dota.databinding.FragmentExploraFavoriteBinding

class ExploraFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentExploraFavoriteBinding
    private lateinit var viewModel: FavoriteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(FavoriteListViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentExploraFavoriteBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVExploraFavoriteListAdapter(listOf())
        binding.rvFavoriteList.adapter = adapter
        binding.rvFavoriteList.layoutManager = GridLayoutManager(requireContext(),1,
            RecyclerView.VERTICAL,false )
        viewModel.heroesList.observe(requireActivity()){
            if (it != null) {
                adapter.heroes=it
            }
            adapter.notifyDataSetChanged()
        }
        viewModel.getHeroesFromService()
    }


}