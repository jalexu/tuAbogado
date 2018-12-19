package com.example.jalex.tuabogado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mercantil.*

class Mercantil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercantil)

        btnContMercantil.setOnClickListener(){registarse()}
    }

    private fun registarse(){
        val actividad= Intent(this, Registro::class.java)
        actividad.putExtra("tipoDerecho","Derecho Mercantil")
        actividad.putExtra("caso",editMercantil.text.toString())
        startActivity(actividad)
    }
}
