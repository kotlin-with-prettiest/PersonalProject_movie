package com.example.mycinema.ui.dashboard

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycinema.R
import com.example.mycinema.databinding.FragmentDashboardBinding


//import com.example.mycinema.databinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)

//        binding.TextTitle.text = arguments?.getString("title")
        binding.TextTitle.setText(arguments?.getString("title"))
        binding.TextDirector.setText(arguments?.getString("director"))
        binding.TextStar.setText(arguments?.getString("star"))

        return binding.root
    }
}