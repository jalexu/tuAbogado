package com.example.jalex.tuabogado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        btnDerFamiliar.setOnClickListener(){abrirDerFamiliar() }
        btnDerLaboral.setOnClickListener(){abrirDerLaboral()}
        btnDerMercantil.setOnClickListener(){abrirDerMercantil()}
        btnDerPenal.setOnClickListener(){abrirDerPenal()}
        btnDerTributario.setOnClickListener(){abrirDerTributario()}
    }

    private fun abrirDerFamiliar() {
        val actividad=Intent(this,Familiar::class.java)
        startActivity(actividad)
    }

    private fun abrirDerLaboral(){
        val actividad=Intent(this,Laboral::class.java)
        startActivity(actividad)

    }

    private fun abrirDerMercantil(){
        val actividad=Intent(this,Mercantil::class.java)
        startActivity(actividad)
    }

    private fun abrirDerPenal(){
        val actividad=Intent(this,Penal::class.java)
        startActivity(actividad)

    }

    private fun abrirDerTributario(){
        val actividad=Intent(this,Tributario::class.java)
        startActivity(actividad)

    }

}
