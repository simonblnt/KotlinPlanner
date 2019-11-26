package com.guithinkle.planner.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.guithinkle.planner.R

class PlansActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plans)
    }

    fun onClickBtnPlansBack (v: View){
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun onClickBtnPlansAdd (v: View) {
        startActivity(Intent(this, AddPlanActivity::class.java))
    }

    fun onClickBtnPlansDelete (v: View){

    }

    fun onClickBtnPlansEdit (v: View){

    }
}
