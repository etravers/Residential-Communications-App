package com.capstone.residentialcommunicationsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PropertySuccessfulCreation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_successful_creation)

        val propertyReturnBtn = findViewById<Button>(R.id.propertyReturnBtn)
        propertyReturnBtn.setOnClickListener {
            val pmId = intent.getIntExtra("propertyManagerId", 0);
            val intent = Intent(this, PropertyHomeScreen::class.java)
            intent.putExtra("propertyManagerId", pmId);
            startActivity(intent)
        }
    }
}
