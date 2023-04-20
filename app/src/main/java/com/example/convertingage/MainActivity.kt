package com.example.convertingage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.age)
        button.setOnClickListener { view ->
            printage(view)}
        }
        private fun printage(view: View ){
            var myCalendar = Calendar.getInstance()
            var year = myCalendar.get(Calendar.YEAR)
            var month = myCalendar.get(Calendar.MONTH)
            var day = myCalendar.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                val selectedDate = "$day/${month + 1}/$year"
                var dull = findViewById<TextView>(R.id.dull)
                dull.text = selectedDate
                var dob2 = Calendar.getInstance()
                dob2.set(year, month, day)
                var agey = myCalendar.get(Calendar.YEAR) - dob2.get(Calendar.YEAR)
                var agem: Int = 0
                var aged: Int = 0
                if (myCalendar.get(Calendar.MONTH) < dob2.get(Calendar.MONTH)) {
                    agey--
                    agem = myCalendar.get(Calendar.MONTH) - dob2.get(Calendar.MONTH) + 12
                    if (myCalendar.get(Calendar.DAY_OF_MONTH) < dob2.get(Calendar.DAY_OF_MONTH)) {
                        agem--
                        aged =
                            myCalendar.get(Calendar.DAY_OF_MONTH) - dob2.get(Calendar.DAY_OF_MONTH) + 30
                    } else {
                        aged =
                            myCalendar.get(Calendar.DAY_OF_MONTH) - dob2.get(Calendar.DAY_OF_MONTH)
                    }

                } else {
                    agem = myCalendar.get(Calendar.MONTH) - dob2.get(Calendar.MONTH)
                    if (myCalendar.get(Calendar.DAY_OF_MONTH) < dob2.get(Calendar.DAY_OF_MONTH)) {
                        agem--
                        aged =
                            myCalendar.get(Calendar.DAY_OF_MONTH) - dob2.get(Calendar.DAY_OF_MONTH) + 30
                    } else {
                        aged =
                            myCalendar.get(Calendar.DAY_OF_MONTH) - dob2.get(Calendar.DAY_OF_MONTH)
                    }
                }
                var agemon=agey*12+agem
                var agedays=agemon*30+aged
                var agehrs=agedays*24
                var agesecs=agehrs*3600
                var years=findViewById<TextView>(R.id.years)
                years.text="You are $agey years $agem months $aged days old"
                var months=findViewById<TextView>(R.id.months)
                months.text="$agemon months old"
                var days=findViewById<TextView>(R.id.days)
                days.text="$agedays days old"
                var hours=findViewById<TextView>(R.id.hours)
                hours.text="$agehrs hours old"
                var seconds=findViewById<TextView>(R.id.seconds)
                seconds.text="$agesecs secs old"
            }, year, month, day).show()
        }

}