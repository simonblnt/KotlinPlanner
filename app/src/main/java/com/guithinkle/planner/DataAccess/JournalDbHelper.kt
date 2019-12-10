package com.guithinkle.planner.DataAccess

import android.content.ClipDescription
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.guithinkle.planner.Model.JournalEntry
import java.time.LocalDate


/*String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_PASSWORD + " TEXT,"
            + KEY_QUESTION + " TEXT,"
            + KEY_ANSWER + " TEXT" + ")";*/

class JournalDbHelper(context: Context):
    SQLiteOpenHelper(context, database_name, null, 3){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $table_name (id INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, name TEXT, start_date TEXT, end_date TEXT, " +
                "description TEXT, category TEXT, wallet_amount INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + table_name)
        onCreate(db)
    }

    fun insertJournalEntry(name: String,
                   start_date: String,
                   end_date: String,
                   description: String,
                   category: String,
                   wallet_amount: Int) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(column_name, name)
        contentValues.put(column_start_date, start_date)
        contentValues.put(column_end_date, end_date)
        contentValues.put(column_description, description)
        contentValues.put(column_category, category)
        contentValues.put(column_wallet_amount, wallet_amount)

        db.insert(table_name, null, contentValues)
    }

    fun updateJournalEntry(
                    id: String,
                   name: String,
                   start_date: String,
                   end_date: String,
                   description: String,
                   category: String,
                   wallet_amount: Int):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(column_name, name)
        contentValues.put(column_start_date, start_date)
        contentValues.put(column_end_date, end_date)
        contentValues.put(column_description, description)
        contentValues.put(column_category, category)
        contentValues.put(column_wallet_amount, wallet_amount)
        db.update(table_name, contentValues, "id = ?", arrayOf(id))
        return true
    }

    fun deleteJournalEntry(id : String) : Int {
        val db = this.writableDatabase
        return db.delete(table_name,"id = ?", arrayOf(id))
    }

    fun logAll(){
        val csr = allData
        var sb = StringBuilder()
        while (csr.moveToNext()) {
            sb = StringBuilder().append("Row is " + csr.position.toString())
            sb.append("\n\t id is :" + csr.getString(csr.getColumnIndex(column_id)))
            sb.append("\n\t Name is :" + csr.getString(csr.getColumnIndex(column_name)))
            sb.append("\n\t StartDate is :" + csr.getString(csr.getColumnIndex(column_start_date)))
            sb.append("\n\t EndDate is " + csr.getInt(csr.getColumnIndex(column_end_date)).toString())
            sb.append("\n\t Description is " + csr.getString(csr.getColumnIndex(column_description)).toString())
            sb.append("\n\t Category is " + csr.getString(csr.getColumnIndex(column_category)).toString())
            sb.append("\n\t Walletamount is " + csr.getString(csr.getColumnIndex(column_wallet_amount)).toString())
            Log.d("LOGDATA", sb.toString())
        }
    }


    val allData : Cursor
        get() {
            val db = this.writableDatabase
            return db.rawQuery("SELECT * FROM " + table_name, null)
        }

    companion object {
        val database_name = "planner.db"
        val table_name = "journal_entries"
        val column_id = "id"
        val column_name = "name"
        val column_start_date = "start_date"
        val column_end_date = "end_date"
        val column_description = "description"
        val column_category = "category"
        val column_wallet_amount = "wallet_amount"
    }
}
