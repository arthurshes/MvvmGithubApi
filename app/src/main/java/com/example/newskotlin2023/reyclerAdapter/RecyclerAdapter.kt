package com.example.newskotlin2023.reyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newskotlin2023.Models.RepoData
import com.example.newskotlin2023.Models.RepoList
import com.example.newskotlin2023.R
import com.squareup.picasso.Picasso

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var items=ArrayList<RepoData>()

    fun setUP(items:ArrayList<RepoData>){
        this.items=items
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imgAv:ImageView=itemView.findViewById(R.id.imageViewAvatar)
        val textName:TextView=itemView.findViewById(R.id.textView)
        val textDesc:TextView=itemView.findViewById(R.id.textViewDesc)

        fun bind(data: RepoData){
            Picasso.get().load(data.owner.avatar_url).into(imgAv)
            textDesc.text=data.description
            textName.text=data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
 return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.bind(items[position])
    }
}