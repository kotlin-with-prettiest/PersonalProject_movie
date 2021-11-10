package com.example.mycinema.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycinema.R
import com.example.mycinema.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    lateinit var binding: FragmentNotificationsBinding //ViewBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)

//        binding.textNotifications.text = "제목 : ".plus(arguments?.getString("title"))
        binding.textTitle.text = "제목 : ".plus(arguments?.getString("title"))
        binding.textDirector.text = "감독 : ".plus(arguments?.getString("director"))
        binding.textWith.text = "함께 본 사람 : ".plus(arguments?.getString("with"))
        binding.textStar.text = "평점 : ".plus(arguments?.getString("star"))
        binding.textDate.text = "날짜 : ".plus(arguments?.getString("date"))
        binding.textPlace.text = "장소 : ".plus(arguments?.getString("place"))
        binding.textReview.text = "리뷰 : ".plus(arguments?.getString("review"))
        binding.textOneLine.text = "한줄평 : ".plus(arguments?.getString("oneLine"))

        return binding.root
    }


}