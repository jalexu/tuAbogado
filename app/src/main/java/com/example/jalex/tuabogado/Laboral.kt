package com.example.jalex.tuabogado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_laboral.*

class Laboral : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laboral)

        btnContLaboral.setOnClickListener(){registarse()}
    }

    private fun registarse(){
        val actividad= Intent(this, Registro::class.java)
        actividad.putExtra("tipoDerecho","Derecho Laboral")
        actividad.putExtra("caso",editCasoLaboral.text.toString())
        startActivity(actividad)
    }
}
