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
import com.example.s191179lykkehjulet.adapter.CategoryAdapter
import com.example.s191179lykkehjulet.data.GameViewModel
import com.example.s191179lykkehjulet.databinding.FragmentWordgameBinding
import com.example.s191179lykkehjulet.model.sportsgrene


/**
 * Fragment where the game is played, should contain the game logic
 *
 * A simple [Fragment] subclass.
 * Use the [WordGame.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordGame : Fragment(R.layout.fragment_wordgame) {

    private lateinit var binding: FragmentWordgameBinding


    private val viewModel: GameViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    private lateinit var categoryId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wordgame, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set the viewModel for data binding - this allows the bound layout access
        // to all the data in the viewModel
        binding.gameViewModel = viewModel
        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner



        // Setup a click listener for the "gæt" button
        //binding.guess.setOnClickListener {onSubmitGuess()}
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("WordGame", "WordGame destroyed!")
    }

    private fun chooseLayout() {
        /*if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 4)
        }*/
        CategoryAdapter()
    }

    /*private fun onSubmitGuess() {
        val playerGuess = binding.guessEditText.text.toString()

        if (viewModel.isPlayerGuessCorrect(playerGuess)) {
            setErrorTextField(false)
        } else {
            setErrorTextField(true)
        }
    }*/

    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.guess.isErrorEnabled = true
            binding.guess.error = "Prøv igen!"
        } else {
            binding.guess.isErrorEnabled = false
            binding.guessEditText.text = null
        }
    }
    /*var secret: String = ""

    fun getHiddenWord(): String {
        var currentHiddenWord = sportsgrene.random()
        val currentHiddenWordArray = Array(currentHiddenWord.length) {"it = $it"}


        for (index in currentHiddenWord.indices)
            currentHiddenWordArray[index] = "-"

        val HiddenWordToList: String = currentHiddenWordArray.toList().toString()
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")
        secret = HiddenWordToList
        return secret

    }*/


}