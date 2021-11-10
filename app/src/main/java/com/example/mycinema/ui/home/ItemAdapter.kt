package com.example.mycinema.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mycinema.data.Movie
import com.example.mycinema.R
import androidx.navigation.fragment.findNavController


class ItemAdapter(private val context: Context, private val dataset: List<Movie>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView = view.findViewById(R.id.item_title)
        val textViewDirector: TextView = view.findViewById(R.id.item_director)
        val textViewStar: TextView = view.findViewById(R.id.item_star)

//        fun bind(title: String) {
//            view.setOnClickListener {
//                println("click".plus(title))
////                findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
//
//
//            }
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)


        return ItemViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        var navController: NavController? = null
        val item = dataset[position]
        holder.textViewTitle.text = item.title.replace("<b>", "").replace("</b>", "")
        holder.textViewDirector.text = item.director.replace("|", "")
        holder.textViewStar.text = "⭐".plus(item.star.toString())
//        holder.bind(item.title)

        holder.apply {
            with(holder.itemView) {
                itemView.setOnClickListener{
                    navController = Navigation.findNavController(itemView)
                    val bundle = bundleOf("title" to item.title.replace("<b>", "").replace("</b>", ""), "director" to item.director.replace("|", ""), "star" to "⭐".plus(item.star.toString()))
                    navController!!.navigate(R.id.action_navigation_home_to_navigation_dashboard, bundle)
                }
            }
        }
    }

    override fun getItemCount() = dataset.size
    // 데이터 세트의 크기 반환
    // = (==) return

}