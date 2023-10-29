package com.cookandroid.project_k_6_1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.project_k_6_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        title = "시간 예약"

        binding.rdoCal.visibility = View.INVISIBLE
        binding.rdoTime.visibility = View.INVISIBLE
        binding.timePicker1.visibility = View.INVISIBLE
        binding.datePicker1.visibility = View.INVISIBLE

        binding.chronometer1.setOnClickListener {
            binding.rdoCal.visibility = View.VISIBLE
            binding.rdoTime.visibility = View.VISIBLE
            binding.chronometer1.base = SystemClock.elapsedRealtime()
            binding.chronometer1.start()
            binding.chronometer1.setTextColor(Color.RED)
        }

        binding.rdoCal.setOnClickListener {
            binding.timePicker1.visibility = View.INVISIBLE
            binding.datePicker1.visibility = View.VISIBLE
        }

        binding.rdoTime.setOnClickListener {
            binding.timePicker1.visibility = View.VISIBLE
            binding.datePicker1.visibility = View.INVISIBLE
        }

        binding.tvYear.setOnClickListener {
            binding.chronometer1.stop();
            binding.chronometer1.setTextColor(Color.BLUE)
            binding.tvYear.text = selectYear.toString()
            binding.tvMonth.text = selectMonth.toString()
            binding.tvDay.text = selectDay.toString()
            binding.tvHour.text = binding.timePicker1.hour.toString()
            binding.tvMinute.text = binding.timePicker1.minute.toString()
            binding.rdoCal.visibility = View.INVISIBLE
            binding.rdoTime.visibility = View.INVISIBLE
            binding.timePicker1.visibility = View.INVISIBLE
            binding.datePicker1.visibility = View.INVISIBLE
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.datePicker1.setOnDateChangedListener { picker, year, month, day ->
                selectYear = year
                selectMonth = month + 1
                selectDay = day
            }
        }
    }
}