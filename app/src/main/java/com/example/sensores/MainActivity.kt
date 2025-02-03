package com.example.sensores

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sensores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sensorManager: SensorManager
    private var acelerometro: Sensor? = null
    private var giroscopio: Sensor? = null
    private var sensorLuz: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Inicializamos Sensormanager
        sensorManager = getSystemService(SENSOR_SERVICE)as SensorManager
        iniciarSensores()
        setListeners()

    }

    private fun iniciarSensores() {
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        giroscopio = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    }

    private fun setListeners() {
        binding.btSalir.setOnClickListener {
            finish()
        }
    }

    // ESTO HAY QUE PONERLO DE DEFAULT SIEMPRE QUE METEMOS SENSORES

    override fun onPause() {

        super.onPause()

    }

    override fun onResume() {
        super.onResume()
    }

}