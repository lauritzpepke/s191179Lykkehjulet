package com.example.s191179lykkehjulet.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.s191179lykkehjulet.R
import com.example.s191179lykkehjulet.adapter.RulesAdapter
import com.example.s191179lykkehjulet.databinding.FragmentStartGameBinding


/**
 * Source: https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-3
 * used for inspiration
 */
/**
 * A simple [Fragment] subclass.
 * Use the [StartGame.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartGame : Fragment(R.layout.fragment_start_game) {

    private lateinit var binding: FragmentStartGameBinding

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and Inflate the layout for this fragment
        binding = FragmentStartGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStartGameBinding.bind(view)
        recyclerView = binding.recyclerView

        binding.wheel.setImageResource(R.drawable.wheel)

        binding.buttonStart.setOnClickListener{
            view.findNavController().navigate(R.id.action_StartGame_to_WordList)
        }
        chooseLayout()
    }

    private fun chooseLayout() {
        recyclerView.adapter = RulesAdapter()
    }
}