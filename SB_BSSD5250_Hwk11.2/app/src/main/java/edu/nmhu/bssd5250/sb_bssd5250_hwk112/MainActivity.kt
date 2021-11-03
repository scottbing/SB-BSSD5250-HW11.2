package edu.nmhu.bssd5250.sb_bssd5250_hwk112

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

private const val EXTRA_MESSAGE = "edu.nmhu.bssd5250.sb_bssd5250_hwk112.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById<LinearLayout>(R.id.main_layout)

        val radiobutton1 = RadioButton(this).apply {
            id = View.generateViewId()
            setText(R.string.blue)
            isChecked = true
        }

        val radiobutton2 = RadioButton(this).apply {
            id = View.generateViewId()
            setText(R.string.yellow)
        }

        val radiobutton3 = RadioButton(this).apply {
            id = View.generateViewId()
            setText(R.string.green)
        }

        val radioGroup = RadioGroup(this).apply {
            addView(radiobutton1)
            addView(radiobutton2)
            addView(radiobutton3)
        }
        
        linearLayout.addView(radioGroup, 1)

        val submit = findViewById<Button>(R.id.submit_button)
        submit.setOnClickListener { view: View? ->
            val checkedID = radioGroup.checkedRadioButtonId
            val radio = findViewById<RadioButton>(checkedID)
            val choice = radio.text.toString()
            Log.d("MACT", choice)
            val intent = Intent(applicationContext, MoodActivity::class.java)
            intent.putExtra(OldMainActivity.EXTRA_MESSAGE, choice)
            startActivity(intent)
        }
    }
}