package com.example.jalex.tuabogado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_familiar.*

class Familiar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_familiar)

        btnContFamiliar.setOnClickListener(){registarse()}
    }

    public fun registarse(){

        val actividad= Intent(this, Registro::class.java)
        actividad.putExtra("tipoDerecho","Derecho Familiar")
        actividad.putExtra("caso",editCasoFamiliar.text.toString())
        startActivity(actividad)

    }
}
