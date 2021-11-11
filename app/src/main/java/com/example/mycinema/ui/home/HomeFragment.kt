package com.example.mycinema.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mycinema.R
import com.example.mycinema.api.API
import com.example.mycinema.data.Movie
import com.example.mycinema.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding //ViewBinding
    private lateinit var homeViewModel: HomeViewModel
    var movies = "";
    var initHtml = listOf<Movie>()
    var cla = this;

    var api = API()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.recyclerView.setHasFixedSize(true)

        binding.recyclerView.adapter = context?.let { it1 -> ItemAdapter(it1, initHtml) } //

        binding.searchButton.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {
                val html = CoroutineScope(Dispatchers.IO).async {
                    api.searchMovieToMovie(binding.textInput.text.toString())
                }.await()

                for (h in html) {
                    println(h)
                }

                initHtml = html
                binding.recyclerView.adapter = context?.let { it1 -> ItemAdapter(it1, html) }
            }
        }
        return binding.root
    }
}