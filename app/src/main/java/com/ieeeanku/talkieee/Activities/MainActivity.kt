package com.ieeeanku.talkieee.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ieeeanku.talkieee.R
import com.ieeeanku.talkieee.Services.DataService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataService.instance.getUserInfo("berker")
    }
}
