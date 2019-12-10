package com.guithinkle.planner.View

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.guithinkle.planner.DataAccess.JournalDbHelper
import com.guithinkle.planner.Model.JournalEntry
import com.guithinkle.planner.R
import com.guithinkle.planner.ViewHolder.ListJournalAdapter
import com.guithinkle.planner.ViewHolder.ListJournalAdapter.OnItemListener
import kotlinx.android.synthetic.main.activity_journal.*
import java.time.LocalDate


class JournalActivity : AppCompatActivity(), OnItemListener {


    val journalEntries: ArrayList<JournalEntry> = ArrayList()
    var selectedItem: JournalEntry? = null
    var journalDbHelper = JournalDbHelper(this)

    override fun onItemClick(position: Int) {
        if (selectedItem == null) { // If Nothing is selected
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
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

        addJournalEntries()

        rvJournalEntries.layoutManager = LinearLayoutManager(this)
        rvJournalEntries.adapter = ListJournalAdapter(journalEntries, this, this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        journalEntries.clear()
        addJournalEntries()
        rvJournalEntries.layoutManager = LinearLayoutManager(this)
        rvJournalEntries.adapter = ListJournalAdapter(journalEntries, this, this)
    }

    fun onClickBtnJournalAdd (v: View) {
        startActivity(Intent(this, AddJournalActivity::class.java))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onClickBtnJournalDelete (v: View){
        if (selectedItem != null)
        {
            val selectedItemId: String = selectedItem!!.id.toString()
            journalDbHelper.deleteJournalEntry(selectedItemId)
            onResume()
        }
    }

    fun onClickBtnJournalEdit (v: View){

        if (selectedItem != null)
        {
            val itemId: String = selectedItem!!.id.toString()
            Log.d("ItemId Main Activity: ", itemId)
            val intent = Intent(this, EditJournalActivity::class.java)
            intent.putExtra("itemId", itemId)
            startActivity(intent)
        }
    }
        @RequiresApi(Build.VERSION_CODES.O)
    fun addJournalEntries(){
            journalDbHelper.logAll()

        val cursor = journalDbHelper.allData
        if (cursor.moveToFirst()) {
            do{
                val id = cursor.getInt(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val startDate = cursor.getString(cursor.getColumnIndex("start_date"))
                val endDate = cursor.getString(cursor.getColumnIndex("end_date"))
                val description = cursor.getString(cursor.getColumnIndex("description"))
                val category = cursor.getString(cursor.getColumnIndex("category"))
                val walletAmount = cursor.getInt(cursor.getColumnIndex("wallet_amount"))
                journalEntries.add(JournalEntry(id,
                    name,
                    startDate,
                    endDate,
                    description,
                    category,
                    walletAmount))
                rvJournalEntries.layoutManager = LinearLayoutManager(this)
                rvJournalEntries.adapter = ListJournalAdapter(journalEntries, this, this)
            }while (cursor.moveToNext())
        }
    }

}
