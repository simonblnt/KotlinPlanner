package com.guithinkle.planner.View

import kotlinx.android.synthetic.main.activity_edit_journal.*

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.guithinkle.planner.DataAccess.JournalDbHelper
import com.guithinkle.planner.R
import java.lang.Exception

class EditJournalActivity : AppCompatActivity() {
    fun showToast(text: String){
        Toast.makeText(this@EditJournalActivity, text, Toast.LENGTH_LONG).show()
    }
    var itemId: String = ""
    var journalDbHelper = JournalDbHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_journal)

        val extras = getIntent().getExtras()
        if (null != extras) {
            itemId = extras.getString("itemId").toString()
        }
    }

    fun onClickBtnJournalEditBack (view: View){
        startActivity(Intent(this, JournalActivity::class.java))
    }

    fun onClickBtnJournalEditSave (view: View){
        Log.d("ItemId Edit Activity: ", itemId)
        try {
            journalDbHelper.updateJournalEntry(
                itemId.toString(),
                etJournalEditName.text.toString(),
                etJournalEditDate.text.toString(),
                etJournalEditDate.text.toString(),
                etJournalEditDescription.text.toString(),
                etJournalEditCategory.text.toString(),
                0)

        }catch (e: Exception){
            e.printStackTrace()
            showToast(e.message.toString())
        }
        startActivity(Intent(this, JournalActivity::class.java))
    }
}
