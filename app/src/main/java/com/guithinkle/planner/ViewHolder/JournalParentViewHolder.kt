package com.guithinkle.planner.ViewHolder

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.guithinkle.planner.R

class ListJournalAdapter(private val context: Activity,
                         private val name: Array<String>,
                         private val category: Array<String>)
    :ArrayAdapter<String>(context, R.layout.list_item_journal_child){
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_item_journal_child, null, true)

        val activityText = rowView.findViewById(R.id.listItemJournalActivity) as TextView
        val categoryText = rowView.findViewById(R.id.listItemJournalCategory) as TextView

        activityText.text = name[position]
        categoryText.text = category[position]

        return rowView
    }
}
