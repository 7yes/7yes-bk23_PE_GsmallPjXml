package com.jess.gsmallpjxml.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jess.gsmallpjxml.databinding.FragmentHomeBinding
import com.jess.gsmallpjxml.domain.model.MyItem
import com.jess.gsmallpjxml.ui.home.adapter.ItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewmod: HomeViewModel by viewModels()

    private lateinit var adapter: ItemAdapter
    private var lista = mutableListOf<MyItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewmod.lista.observe(viewLifecycleOwner){
            lista.clear()
            lista.addAll(it)
            adapter.notifyDataSetChanged()
        }
        initRV()
       // binding.tvHome.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_detailFragment) }
        return binding.root
    }
    private fun initRV() {
        adapter = ItemAdapter(lista){
            Toast.makeText(requireContext(), "${it.name}", Toast.LENGTH_SHORT).show()
        }
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHome.adapter = adapter
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