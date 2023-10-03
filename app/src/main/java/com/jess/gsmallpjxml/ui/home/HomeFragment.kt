package com.jess.gsmallpjxml.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jess.gsmallpjxml.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewmodel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.go.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    "paco"
                )
            )
        }

        //livedata
        binding.btnLivedata.setOnClickListener {
            viewmodel.triggerLiveData()
        }
        viewmodel.livedata.observe(viewLifecycleOwner) {
            binding.tvLivedata.text = it
            if (binding.cbLivedata.isChecked) {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
            }
        }

        //flow
        binding.btnFlow.setOnClickListener {
// no cabe SnackBar
            lifecycleScope.launch {
                viewmodel.triggerFlow().collectLatest {
                    binding.tvFlow.text = it
                    it.forEach { }
                    it.map { }
                }
            }
        }

        //stateflow
        binding.btnStateflow.setOnClickListener {
            viewmodel.triggerStateFlow()
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.stateFlow.collectLatest {
                    binding.tvStateflow.text = it
                    if (binding.cbStateflow.isChecked) {
                        Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }

        //sharedFlow
        binding.btnSharedflow.setOnClickListener {
            viewmodel.triggerSharedFlow()
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.sharedFlow.collectLatest {
                    binding.tvSharedflow.text = it
                    if (binding.cbSharedflow.isChecked) {
                        Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}