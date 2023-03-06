package com.cursoandroid.mysubscribers.ui.subscriberlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.mysubscribers.R
import com.cursoandroid.mysubscribers.data.entity.SubscriberEntity

class SubscriberListAdapter(
    private val subscribers: List<SubscriberEntity>,
    private val onSubscriberClickListener: (subscriber: SubscriberEntity) -> Unit
): RecyclerView.Adapter<SubscriberListAdapter.SubscriberListViewHolder>() {


    class SubscriberListViewHolder(
        itemView: View,
        private val onSubscriberClickListener: (subscriber: SubscriberEntity) -> Unit
    ): RecyclerView.ViewHolder(itemView){
        private val textViewSubscriberName = itemView.findViewById<TextView>(R.id.text_subscriber_name)
        private val textViewSubscriberEmail: TextView = itemView.findViewById(R.id.text_subscriber_email)


        fun bindView(subscriber: SubscriberEntity){
            textViewSubscriberName.text = subscriber.name
            textViewSubscriberEmail.text = subscriber.email

            itemView.setOnClickListener{
                onSubscriberClickListener.invoke(subscriber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subscriber_fragment, parent, false)

        return SubscriberListViewHolder(view, onSubscriberClickListener)
    }

    override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
        holder.bindView(subscribers[position])
    }

    override fun getItemCount(): Int = subscribers.size
}