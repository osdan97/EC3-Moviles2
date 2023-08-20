package pe.ec3.jurado.dota.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import pe.ec3.jurado.dota.databinding.FragmentExploraInfoBinding


class ExploraInfoFragment : Fragment() {

    private lateinit var binding: FragmentExploraInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentExploraInfoBinding.inflate(inflater,container,false)
        return binding.root
    }


}