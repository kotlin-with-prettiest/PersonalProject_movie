package com.example.mycinema.ui.dashboard

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        binding.button.setOnClickListener{
            val bundle = bundleOf("title" to binding.TextTitle.text.toString(), "director" to  binding.TextDirector.text.toString(), "with" to binding.TextWith.text.toString(), "star" to binding.TextStar.text.toString(), "date" to binding.TextDate.text.toString(), "place" to binding.TextPlace.text.toString(), "review" to binding.TextReview.text.toString(), "oneLine" to binding.TextOneLine.text.toString())
//            val diary =

            findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications, bundle)
        }

        return binding.root
    }
}