package com.example.myfirstapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var textView3 : TextView ? = null
    private var textView5 : TextView ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
        textView3 = findViewById(R.id.textView3)
        textView5 = findViewById(R.id.textView5)
        btnDatePicker.setOnClickListener  {
            clickDatePicker()


        }




    }

    fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month+1}/$year"
            textView3?.setText(selectedDate)

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val selectedDateInMin = theDate.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMin = currentDate.time / 60000
            val difference = currentDateInMin - selectedDateInMin

            textView5?.setText(difference.toString())


        },
            year,
            month,
            day
        ).show()
    }
}

