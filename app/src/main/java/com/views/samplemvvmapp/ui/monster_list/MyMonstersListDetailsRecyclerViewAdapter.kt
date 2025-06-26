package com.views.samplemvvmapp.ui.monster_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.views.samplemvvmapp.R
import com.views.samplemvvmapp.databinding.FragmentMonstersListDetailsBinding
import com.views.samplemvvmapp.domain.MonsterListDetails

class MyMonstersListDetailsRecyclerViewAdapter(
    private val values: List<MonsterListDetails>,
    private val onItemClick: (MonsterListDetails) -> Unit
) : RecyclerView.Adapter<MyMonstersListDetailsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentMonstersListDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.name.first().toString()
        holder.contentView.text = item.name
        holder.contentView.rootView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentMonstersListDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.root.findViewById<TextView>(R.id.first_letter)
        val contentView: TextView = binding.root.findViewById<TextView>(R.id.monster_title)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}