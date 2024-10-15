package com.example.localizacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MapsMultipleDestinationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_multiple_destinations)

        val originInput = findViewById<EditText>(R.id.origin_input)
        val destinationInput = findViewById<EditText>(R.id.destination_input)
        val openMapsButton = findViewById<Button>(R.id.button_open_maps_multiple_destinations)

        openMapsButton.setOnClickListener {
            val origin = originInput.text.toString().trim()
            val destinations = destinationInput.text.toString().trim().split(",")

            if (origin.isNotEmpty() && destinations.isNotEmpty()) {
                openGoogleMapsWithDestinations(origin, destinations)
            }
        }
    }

    private fun openGoogleMapsWithDestinations(origin: String, destinations: List<String>) {
        // Crear una cadena para todos los destinos
        val destinationString = destinations.joinToString("|") { "via:$it" }

        // Uri para abrir Google Maps con múltiples destinos
        val uri =
            Uri.parse("https://www.google.com/maps/dir/?api=1&origin=$origin&destination=${destinations.last()}&waypoints=$destinationString")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }
}
