package jw.seo.kotlin.ex01.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import jw.seo.kotlin.ex01.net.ApiService
import jw.seo.kotlin.ex01.viewmodel.MainViewModel
import jw.seo.secondgitpj.R
import jw.seo.secondgitpj.databinding.ActivityMainKotlinBinding
import kotlinx.android.synthetic.main.activity_main_kotlin.*
import org.koin.android.ext.android.inject

class KotlinMainActivity : AppCompatActivity() {

    private val service:ApiService by inject()
    private lateinit var binding: ActivityMainKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_kotlin)

        binding.button.setOnClickListener { getInfo() }

        binding.viewModel = MainViewModel()
    }

    private fun getInfo() {
        val compositeDisposable = CompositeDisposable()

        val disposable = service.getGithubUserObservable("bearkinf")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("KotlinMainActivity", "response : $it")
                    var intent = Intent(this,KotlinSubActivity::class.java)
                    intent.putExtra("data",it.toString())
                    startActivity(intent)
                }

        compositeDisposable.add(disposable)
    }
}
