package com.example.myapplication.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentArtDetalsBinding
import com.example.myapplication.databinding.FragmentArtsBinding

class ArtDetailesFragment:Fragment(R.layout.fragment_art_detals) {
    private var fragmentBinding:FragmentArtDetalsBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentArtDetalsBinding.bind(view)
        fragmentBinding=binding
        binding.artimageView2.setOnClickListener{
            findNavController().navigate(ArtDetailesFragmentDirections.actionArtDetailesFragmentToImageApiFragment())

        }
        val callback= object:OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)

    }

    override fun onDestroyView() {
        fragmentBinding=null
        super.onDestroyView()
    }
}