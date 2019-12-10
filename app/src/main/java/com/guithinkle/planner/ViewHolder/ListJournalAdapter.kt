package com.guithinkle.planner.ViewHolder

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.guithinkle.planner.Model.JournalEntry
import com.guithinkle.planner.R
import kotlinx.android.synthetic.main.list_item_journal_child.view.*


class ListJournalAdapter(
    val items: ArrayList<JournalEntry>,
    val context: Context,
    private var onItemListener: OnItemListener
) : RecyclerView.Adapter<ListJournalAdapter.ViewHolder>(){

    private var onItemClickListener: View.OnClickListener? = null
    var selectedPosition: Int? = null


    fun setItemClickListener(clickListener: View.OnClickListener) {
        onItemClickListener = clickListener
    }

/*if (selectedItem == null) { // If Nothing is selected
            selectedItem = journalEntries[position]
            Log.d("Message", "Selected, position: " + position)
        } else
        {
            if (selectedItem == journalEntries[position]) // If the selected item is already selected
            {
                selectedItem = null
                Log.d("Message", "Deselected, position: " + position)
            }
            else // If the selected item is not already selected
            {
                selectedItem = journalEntries[position]
                Log.d("Message", "Selected, position: " + position)
            }
        }*/
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(selectedPosition==position)
            holder.tvJournalEntryName.setTextColor(Color.RED);
        else
            holder.tvJournalEntryName.setTextColor(Color.BLACK);
        holder.tvJournalEntryName.text = items[position].name
        holder.tvJournalEntryDate.text = items[position].start_date
        holder.tvJournalEntryCategory.text = items[position].category
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_journal_child, parent, false), onItemListener)
    }

    inner class ViewHolder (view: View, onItemListener: OnItemListener) : RecyclerView.ViewHolder(view), View.OnClickListener{
        var tvJournalEntryName: TextView
        var tvJournalEntryDate: TextView
        var tvJournalEntryCategory: TextView
        var onItemListener: OnItemListener

        init {
            tvJournalEntryName = view.listItemJournalActivity
            tvJournalEntryDate = view.listItemJournalDate
            tvJournalEntryCategory = view.listItemJournalCategory
            view.setOnClickListener(this)
            this.onItemListener = onItemListener
        }
        override fun onClick(v: View?) {
            if (adapterPosition == selectedPosition) {
                onItemListener.onItemClick(adapterPosition)
                selectedPosition = null
                notifyDataSetChanged()
            } else {
                onItemListener.onItemClick(adapterPosition)
                selectedPosition = adapterPosition
                notifyDataSetChanged()
            }

        }

    }

    public interface OnItemListener{
        fun onItemClick(position: Int)
    }
}




