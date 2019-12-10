package com.guithinkle.planner.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.guithinkle.planner.DataAccess.JournalDbHelper
import com.guithinkle.planner.R
import kotlinx.android.synthetic.main.activity_add_journal.*
import java.lang.Exception
import java.time.LocalDate

class AddJournalActivity : AppCompatActivity() {
    fun showToast(text: String){
        Toast.makeText(this@AddJournalActivity, text, Toast.LENGTH_LONG).show()
    }

    var journalDbHelper = JournalDbHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_journal)
    }

    fun onClickBtnJournalAddBack (view: View){
        startActivity(Intent(this, JournalActivity::class.java))
    }

    fun onClickBtnJournalAddSave (view: View){

        try {
                journalDbHelper.insertJournalEntry(etJournalAddName.text.toString(),
                etJournalAddDate.text.toString(),
                etJournalAddDate.text.toString(),
                etJournalAddDescription.text.toString(),
                etJournalAddCategory.text.toString(),
                0)

        }catch (e: Exception){
            e.printStackTrace()
            showToast(e.message.toString())
        }
        startActivity(Intent(this, JournalActivity::class.java))
    }
}
