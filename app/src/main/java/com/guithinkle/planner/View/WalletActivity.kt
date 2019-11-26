package com.guithinkle.planner.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.guithinkle.planner.R

class WalletActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
    }

    fun onClickBtnWalletBack (v: View){
        startActivity(Intent(this, MainActivity::class.java))
    }
}
