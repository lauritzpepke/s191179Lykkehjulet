package com.example.s191179lykkehjulet.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s191179lykkehjulet.R
import com.example.s191179lykkehjulet.adapter.ItemAdapter
import com.example.s191179lykkehjulet.databinding.FragmentWordlistBinding


/**
 * A simple [Fragment] subclass.
 * Use the [WordList.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordList : Fragment() {

    private var _binding: FragmentWordlistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    //Keeps track of whick LayoutManager is in use for the [RecyclerView]
    private var isLinearLayoutManager = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Retrieve and Inflate the layout for this fragment
        _binding = FragmentWordlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        // Sets the layoutManager of the recyclerView
        // On the first run of the app, it will be LinearLayoutManager
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /** taget fra GUIDE!!!!!
     * Sets the LayoutManager for the [RecyclerView] based on the desired orientation of the list.
     *
     * Notice that because the enclosing class has changed from an Activity to a Fragment,
     * the signature of the LayoutManagers has to slightly change.
     */
    private fun chooseLayout() {
        /*if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 4)
        }*/
        recyclerView.adapter = ItemAdapter()
    }

    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment wordguessing.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            WordList().apply {
                arguments = Bundle().apply {
                }
            }
    }*/
}