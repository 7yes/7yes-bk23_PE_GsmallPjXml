package com.jess.gsmallpjxml.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jess.gsmallpjxml.databinding.FragmentExtraBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExtraFragment : Fragment() {
    private var _binding: FragmentExtraBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExtraBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}