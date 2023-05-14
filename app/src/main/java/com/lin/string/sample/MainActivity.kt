package com.lin.string.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lin.string.helper.StringFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, StringFragment())
            .commit()
    }
}
