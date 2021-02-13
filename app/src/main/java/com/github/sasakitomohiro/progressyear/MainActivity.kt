package com.github.sasakitomohiro.progressyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.sasakitomohiro.progressyear.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val now = LocalDate.now()
        val dayOfYear = now.dayOfYear.toFloat()
        val yearDays = LocalDate.of(now.year, 12, 31).dayOfYear.toFloat()
        val progressOfYear = dayOfYear / yearDays
        binding.yearDays.text = (progressOfYear * 100).toString()
        binding.progressBar.setProgressWithAnimation(progressOfYear * 100)
    }
}
