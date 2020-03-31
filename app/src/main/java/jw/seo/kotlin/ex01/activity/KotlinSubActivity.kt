package jw.seo.kotlin.ex01.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import jw.seo.secondgitpj.R

import kotlinx.android.synthetic.main.activity_kotlin_sub.*
import kotlinx.android.synthetic.main.content_kotlin_sub.*

class KotlinSubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_sub)
        setSupportActionBar(toolbar)

        text.text = intent.getStringExtra("data").toString()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
