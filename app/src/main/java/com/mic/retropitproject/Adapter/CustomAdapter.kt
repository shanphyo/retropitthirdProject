package com.mic.webservice.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mic.retropitproject.MainActivity
import com.mic.retropitproject.R
import com.mic.retropitproject.model.Article

import kotlinx.android.synthetic.main.itemresource.view.*


class TitleAdapter(var datalist:List<Article>, var rd: RecyclerData):RecyclerView.Adapter<TitleAdapter.TitleViewHolder>(){

    inner  class  TitleViewHolder (itemView:View):
        RecyclerView.ViewHolder(itemView){
        fun bindPerson(t: Article){
            itemView.txt_title.text=t.title
            itemView.cv.setOnClickListener {
                rd.onFunClick(t)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        var view=LayoutInflater.from(parent.context)
            .inflate(R.layout.itemresource,parent,false)
        return TitleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  datalist.size
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.bindPerson(datalist[position])


    }
    fun setData( ar:List<Article>){
        datalist=ar
        notifyDataSetChanged()

    }




}




