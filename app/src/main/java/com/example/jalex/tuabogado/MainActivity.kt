package com.example.jalex.tuabogado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Patterns
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var txtEmail:EditText
    private lateinit var txtPassword:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.activity_main)
        txtEmail=findViewById(R.id.editEmail)
        txtPassword=findViewById(R.id.editClave)

        btnRegistro.setOnClickListener(){abrirRegistro()}
        btnInicioSesion.setOnClickListener(){abrirSesion()}
    }

    private fun abrirSesion() {
        val email: String= txtEmail.text.toString()
        val password: String= txtPassword.text.toString()


        val actividad= Intent(this,Seguimiento::class.java)

        if(validarEmail(email) && !password.isEmpty()){
            startActivity(actividad)
        }else{
            Toast.makeText(this,"Email inválido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun abrirRegistro() {
        val actividad= Intent(this,Principal::class.java)
        startActivity(actividad)
    }

    private fun validarEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}
