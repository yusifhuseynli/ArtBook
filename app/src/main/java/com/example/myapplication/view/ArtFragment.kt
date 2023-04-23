package com.example.myapplication.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentArtsBinding

class ArtFragment:Fragment(R.layout.fragment_arts) {
    private var fragmentBinding:FragmentArtsBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentArtsBinding.bind(view)
        fragmentBinding=binding
        binding.fab.setOnClickListener{
            findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailesFragment())
        }
    }

    override fun onDestroyView() {
        fragmentBinding=null
        super.onDestroyView()
    }
}