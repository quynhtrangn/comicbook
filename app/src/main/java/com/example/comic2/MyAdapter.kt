package com.example.comic2
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comic2.databinding.ActivityMainBinding
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private var comicsList: ArrayList<comic>, var clickListner: OnComicItemClickListner):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent,false)
        return  MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentItem = comicsList[position]
//        holder.imgImage.setImageResource(currentItem.imgImage)
//        holder.txtName.setText(currentItem.name)
//        holder.txtDescrip.setText((currentItem.descrip))
        holder.initialize(comicsList.get(position), clickListner)

    }

    override fun getItemCount(): Int {
        return comicsList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgImage : ShapeableImageView = itemView.findViewById(R.id.img_image)
        val txtName : TextView = itemView.findViewById(R.id.txt_name)
        val txtDescrip : TextView = itemView.findViewById(R.id.txt_descrip)

        fun initialize(item: comic, action: OnComicItemClickListner){
            txtName.setText(item.name)
            txtDescrip.setText(item.descrip)
            imgImage.setImageResource(item.imgImage)
            itemView.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }
        }
    }
}

interface OnComicItemClickListner{
    fun onItemClick(item: comic, position: Int)
}