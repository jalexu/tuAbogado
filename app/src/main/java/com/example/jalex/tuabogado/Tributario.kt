package com.example.jalex.tuabogado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tributario.*

class Tributario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tributario)


        btnContTributario.setOnClickListener(){registarse()}
    }

    private fun registarse(){
        val actividad= Intent(this, Registro::class.java)
        actividad.putExtra("tipoDerecho","Derecho Tributario")
        actividad.putExtra("caso",editTributario.text.toString())
        startActivity(actividad)
    }
}
