package jw.seo.kotlin.ex01.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import jw.seo.secondgitpj.R
import jw.seo.secondgitpj.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding
    var list = arrayListOf<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test)

        list.add(binding.btn1)
        list.add(binding.btn2)
        list.add(binding.btn3)

        binding.btn1.setOnClickListener{
            test(it as Button)
        }
        binding.btn2.setOnClickListener{
            test(it as Button)
        }
        binding.btn3.setOnClickListener{
            test(it as Button)
        }

    }

    private fun test(selectedBtn: Button) {
        for (btn in list) {
            if (btn == selectedBtn) {
                btn.isSelected = true
                btn.text = "selected"
            } else {
                btn.isSelected = false
                btn.text = "button"
            }
        }
    }
}
