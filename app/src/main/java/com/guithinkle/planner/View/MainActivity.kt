package com.guithinkle.planner.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.guithinkle.planner.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick_btnMainJournal (view: View){
        startActivity(Intent(this, JournalActivity::class.java))
    }

    fun onClick_btnMainPlans (view: View){
        startActivity(Intent(this, PlansActivity::class.java))
    }

    fun onClick_btnMainWallet (view: View){
        startActivity(Intent(this, WalletActivity::class.java))
    }

    fun onClick_btnMainStats (view: View){
        startActivity(Intent(this, StatsActivity::class.java))
    }

    fun onClick_btnMainSettings (view: View){
        startActivity(Intent(this, SettingsActivity::class.java))
    }
}
