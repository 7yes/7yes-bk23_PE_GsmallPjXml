package com.jess.gsmallpjxml.ui.extra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.gsmallpjxml.R
import com.jess.gsmallpjxml.databinding.FragmentDetailBinding
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