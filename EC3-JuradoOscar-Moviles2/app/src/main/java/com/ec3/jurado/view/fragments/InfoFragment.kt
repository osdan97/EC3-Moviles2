package com.ec3.jurado.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ec3.jurado.R
import com.ec3.jurado.databinding.FragmentDetailsBinding
import com.ec3.jurado.databinding.FragmentInfoBinding
import com.ec3.jurado.databinding.FragmentListBinding


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

}