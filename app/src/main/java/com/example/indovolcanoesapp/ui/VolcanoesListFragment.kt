package com.example.indovolcanoesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.indovolcanoesapp.R
import com.example.indovolcanoesapp.databinding.FragmentVolcanoesListBinding

class VolcanoesListFragment : Fragment() {

    private val viewModel: VolcanoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentVolcanoesListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = VolcanoesListAdapter(VolcanoesListener { volcanoes ->
            viewModel.onVolcanoesClicked(volcanoes)
            findNavController()
                .navigate(R.id.action_volcanoesListFragment_to_volcanoesDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}