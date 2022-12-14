package com.ozancanguz.cartoonsinfoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.cartoonsinfoapp.R
import com.ozancanguz.cartoonsinfoapp.data.model.Cartoon
import com.ozancanguz.cartoonsinfoapp.data.model.CartoonItem
import com.ozancanguz.cartoonsinfoapp.ui.fragments.cartoonlist.CartoonListFragmentDirections
import com.ozancanguz.cartoonsinfoapp.utils.Utils.Companion.loadImage
import kotlinx.android.synthetic.main.row_layout.view.*

class CartoonAdapter:RecyclerView.Adapter<CartoonAdapter.CartoonViewHolder>() {


    var cartoonList= emptyList<CartoonItem>()

    fun setData(newData: Cartoon){
        this.cartoonList=newData
        notifyDataSetChanged()
    }

    class CartoonViewHolder(view: View):RecyclerView.ViewHolder(view){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartoonViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.row_layout,parent,false)
        return CartoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartoonViewHolder, position: Int) {
        var currentCartoon=cartoonList[position]
        holder.itemView.cartoon_name.text=currentCartoon.name
        holder.itemView.cartoon_location.text=currentCartoon.location

        // image load with glide
        holder.itemView.cartoon_img.loadImage(currentCartoon.avatar)

        holder.itemView.setOnClickListener {
            val action=CartoonListFragmentDirections.actionCartoonListFragmentToDetailsFragment(currentCartoon)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return cartoonList.size
    }


}