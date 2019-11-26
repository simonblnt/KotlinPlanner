package com.guithinkle.planner.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.guithinkle.planner.R

class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
    }

    fun onClickBtnStatsBack (v: View){
        startActivity(Intent(this, MainActivity::class.java))
    }
}
