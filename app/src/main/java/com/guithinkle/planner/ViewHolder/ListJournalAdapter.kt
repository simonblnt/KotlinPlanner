package com.guithinkle.planner.ViewHolder




import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.guithinkle.planner.Model.JournalEntry
import com.guithinkle.planner.R
import kotlinx.android.synthetic.main.list_item_journal_child.view.*

class ListJournalAdapter(val items : ArrayList<JournalEntry>, val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvJournalEntryName?.text = items[position].name
        holder.tvJournalEntryDate?.text = items[position].start_date
        holder.tvJournalEntryCategory?.text = items[position].category
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_journal_child, parent, false))
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvJournalEntryName = view.listItemJournalActivity
    val tvJournalEntryDate = view.listItemJournalDate
    val tvJournalEntryCategory = view.listItemJournalCategory
}
