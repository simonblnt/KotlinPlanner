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
import kotlinx.android.synthetic.main.activity_journal.*
import java.time.LocalDate

class JournalActivity : AppCompatActivity() {
    val journalEntries: ArrayList<JournalEntry> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

        addInitialJournalEntries()

        rvJournalEntries.layoutManager = LinearLayoutManager(this)
        rvJournalEntries.adapter = ListJournalAdapter(journalEntries, this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        addJournalEntries()
        rvJournalEntries.layoutManager = LinearLayoutManager(this)
        rvJournalEntries.adapter = ListJournalAdapter(journalEntries, this)
    }

    fun onClickBtnJournalBack (v: View){
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun onClickBtnJournalAdd (v: View) {
        startActivity(Intent(this, AddJournalActivity::class.java))
    }

    fun onClickBtnJournalDelete (v: View){

    }

    fun onClickBtnJournalEdit (v: View){

    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun addInitialJournalEntries() {
        journalEntries.add(
            JournalEntry(
                3,
                "Buy Food",
                LocalDate.now().minusDays(100).toString(),
                LocalDate.MAX.toString(),
                "buybuybyuy",
                "Shopping",
                0
            )
        )
    }

        @RequiresApi(Build.VERSION_CODES.O)
    fun addJournalEntries(){
            var helper = JournalDbHelper(this)
            helper.logAll()

        val cursor = helper.allData
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
                rvJournalEntries.adapter = ListJournalAdapter(journalEntries, this)
            }while (cursor.moveToNext())
        }
    }

}
