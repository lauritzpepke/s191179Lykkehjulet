package com.example.s191179lykkehjulet.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.s191179lykkehjulet.R
import com.example.s191179lykkehjulet.data.GameViewModel
import com.example.s191179lykkehjulet.databinding.FragmentWordgameBinding
import com.example.s191179lykkehjulet.model.WheelList


/**
 * Source: https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-3
 * used for inspiration
 */

/**
 * Fragment where the game is played, should contain the game logic
 */
class WordGame : Fragment(R.layout.fragment_wordgame) {

    private lateinit var binding: FragmentWordgameBinding

    private val viewModel: GameViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wordgame, container, false)
        return binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set the viewModel for data binding - this allows the bound layout access
        // to all the data in the viewModel
        binding.gameViewModel = viewModel
        // Puts the fragment view as the lifecycle owner of the binding.
        // Binding can then observe LiveData
        binding.lifecycleOwner = viewLifecycleOwner


        // Setup a click listener for the "gæt" button
        binding.guess.setOnClickListener {
            onSubmitGuess(view)
        }
        binding.spinButton.setOnClickListener {
            binding.spinResult.setText(WheelList.random())
        }
    }

    private fun onSubmitGuess(view: View) {
        val playerGuess = binding.guessEditText.text.toString()

        viewModel.isPlayerGuessCorrect(playerGuess)
        if (viewModel.gameWon()) {
            setErrorTextField(false)
        } else {
            setErrorTextField(true)
        }
    }

    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.guess.isErrorEnabled = true
            binding.guess.error = "Prøv igen!"
        } else {
            binding.guess.isErrorEnabled = false
            binding.guessEditText.text = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("WordGame", "WordGame destroyed!")
    }
}