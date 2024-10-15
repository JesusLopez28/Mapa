package com.example.localizacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var boton: Button
    private lateinit var botonMultipleDestinations: Button
    private lateinit var botonSelectPointsRoute: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton = findViewById(R.id.btnMaps)
        botonMultipleDestinations = findViewById(R.id.btnMultipleDestinations)
        botonSelectPointsRoute = findViewById(R.id.btnSelectPointsRoute)

        // Evento de click
        boton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        botonMultipleDestinations.setOnClickListener {
            val intent = Intent(this, MapsMultipleDestinationsActivity::class.java)
            startActivity(intent)
        }

        botonSelectPointsRoute.setOnClickListener {
            val intent = Intent(this, SelectPointsRouteActivity::class.java)
            startActivity(intent)
        }
    }
}
