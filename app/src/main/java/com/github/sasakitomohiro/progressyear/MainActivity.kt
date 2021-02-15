package com.github.sasakitomohiro.progressyear

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.sasakitomohiro.progressyear.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val now = LocalDate.now()
        val dayOfYear = now.dayOfYear.toFloat()
        val yearDays = LocalDate.of(now.year, 12, 31).dayOfYear.toFloat()
        val progressOfYear = (dayOfYear / yearDays) * 100
        binding.yearDays.text = "%.2f".format(progressOfYear)
        binding.progressBar.setProgressWithAnimation(progressOfYear)
    }
}
