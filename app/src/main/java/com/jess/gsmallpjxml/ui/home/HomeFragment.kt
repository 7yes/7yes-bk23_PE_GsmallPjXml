package com.jess.gsmallpjxml.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jess.gsmallpjxml.R
import com.jess.gsmallpjxml.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewmod: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.tvHome.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_detailFragment) }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewmod.getAll()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}