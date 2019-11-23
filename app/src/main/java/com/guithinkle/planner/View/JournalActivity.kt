package com.guithinkle.planner.View

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
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

        addJournalEntries()
        rvJournalEntries.layoutManager = LinearLayoutManager(this)
        rvJournalEntries.adapter = ListJournalAdapter(journalEntries, this)


    }

    fun onClickBtnJournalBack (v: View){
        startActivity(Intent(this, MainActivity::class.java))
    }




    @RequiresApi(Build.VERSION_CODES.O)
    fun addJournalEntries(){
        journalEntries.add(JournalEntry(1, "Learn Kotlin", LocalDate.now().minusDays(50), LocalDate.MAX, "asdasdasd", 1, null))
        journalEntries.add(JournalEntry(2, "Fix Display glitches", LocalDate.now().minusDays(10), LocalDate.MAX, "blblablalblab", 2, null))
        journalEntries.add(JournalEntry(3, "Buy Food", LocalDate.now().minusDays(100), LocalDate.MAX, "buybuybyuy", 3, 1))


        journalEntries.sortByDescending { it.start_date }
    }

}
