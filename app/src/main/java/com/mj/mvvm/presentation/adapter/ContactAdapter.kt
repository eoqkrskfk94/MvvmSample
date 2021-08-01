package com.mj.mvvm.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mj.mvvm.R
import com.mj.mvvm.data.model.ContactEntity

class ContactAdapter(val contactItemClick: (ContactEntity) -> Unit, val contactItemLongClick: (ContactEntity) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private var contacts: List<ContactEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ContactAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int = contacts.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTv = itemView.findViewById<TextView>(R.id.item_tv_name)
        private val numberTv = itemView.findViewById<TextView>(R.id.item_tv_number)
        private val initialTv = itemView.findViewById<TextView>(R.id.item_tv_initial)

        fun bind(contact: ContactEntity) {
            nameTv.text = contact.name
            numberTv.text = contact.number
            initialTv.text = contact.initial.toString()

            itemView.setOnClickListener {
                contactItemClick(contact)
            }

            itemView.setOnLongClickListener {
                contactItemLongClick(contact)
                true
            }
        }
    }

    fun setContacts(contacts: List<ContactEntity>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }
}