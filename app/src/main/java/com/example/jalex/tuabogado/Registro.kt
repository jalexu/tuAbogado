package com.example.jalex.tuabogado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registro.*


import android.util.Log
import com.google.firebase.database.core.Tag


class Registro : AppCompatActivity() {


    /*private lateinit var txtdocumento:EditText
    private lateinit var txtNombres:EditText
    private lateinit var txtApellidos:EditText
    private lateinit var txtDireccion:EditText
    private lateinit var txtTelefono:EditText
    private lateinit var txtCorreo:EditText
    private lateinit var txtPassword:EditText
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        txtdocumento=findViewById(R.id.editDocumento)
        txtNombres=findViewById(R.id.editNombre)
        txtApellidos=findViewById(R.id.editApellidos)
        txtDireccion=findViewById(R.id.editDireccion)
        txtTelefono=findViewById(R.id.editTelefono)
        txtCorreo=findViewById(R.id.editCorreo)
        txtPassword=findViewById(R.id.editContrasena)

        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        dbReference=database.reference.child("CasosClientes")

        btnEnviar.setOnClickListener(){enviandoInformacion()}
    }

    private fun enviandoInformacion() {

        val cc: String= txtdocumento.text.toString()
        val nombres: String= txtNombres.text.toString()
        val apellidos: String= txtApellidos.text.toString()
        val direccion: String= txtDireccion.text.toString()
        val telefono: String= txtTelefono.text.toString()
        val correo: String= txtCorreo.text.toString()

        val contrasena: String= txtPassword.text.toString()


        //Toast.makeText(this,tipo.toString(),Toast.LENGTH_SHORT).show()


        if(cc.isEmpty()){
            Toast.makeText(this,"El campo identificación no puede estar vacío", Toast.LENGTH_SHORT).show()
        }else if(nombres.isEmpty()){
            Toast.makeText(this,"El campo nombres no puede estar vacío", Toast.LENGTH_SHORT).show()
        } else if(apellidos.isEmpty()){
            Toast.makeText(this,"El campo apellidos no puede estar vacío", Toast.LENGTH_SHORT).show()
        }else if(direccion.isEmpty()){
            Toast.makeText(this,"El campo direccion no puede estar vacío", Toast.LENGTH_SHORT).show()
        } else if(telefono.isEmpty()){
            Toast.makeText(this,"El campo teléfono no puede estar vacío", Toast.LENGTH_SHORT).show()
        } else if (correo.isEmpty()) {
            Toast.makeText(this,"El campo correo no puede estar vacío", Toast.LENGTH_SHORT).show()
        } else if (contrasena.isEmpty()) {
            Toast.makeText(this,"El campo contraseña no puede estar vacío", Toast.LENGTH_SHORT).show()
        }else {

            //val persona:Personas=Personas(cc,nombre,apellidos,direccion,telefono,correo)

            //val casos:Casos=Casos(persona,caso)

            auth.createUserWithEmailAndPassword(correo,contrasena).addOnCompleteListener(this){
                    task ->
                if(task.isSuccessful){
                    //obtiene el usuario registrado
                    val user:FirebaseUser?=auth.currentUser
                    verificarCorreo(user)

                    val tipo=intent.extras.getString("tipoDerecho")
                    val caso=intent.extras.getString("caso")

                    if(tipo.equals("Derecho Familiar")){

                        val userDB=dbReference.child("Derecho Familiar")
                        userDB.child("Caso: ").setValue(caso)
                        userDB.child("CC: ").setValue(cc)
                        userDB.child("Nombres: ").setValue(nombres)
                        userDB.child("Apellidos: ").setValue(apellidos)
                        userDB.child("Dirección: ").setValue(direccion)
                        userDB.child("Teléfono: ").setValue(telefono)
                        userDB.child("Correo: ").setValue(correo)
                        Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                        limpiar()
                        volverInicio()
                    }else if(tipo.equals("Derecho Laboral")){
                        val userDB=dbReference.child("Derecho Laboral")
                        userDB.child("Caso: ").setValue(caso)
                        userDB.child("CC: ").setValue(cc)
                        userDB.child("Nombres: ").setValue(nombres)
                        userDB.child("Apellidos: ").setValue(apellidos)
                        userDB.child("Dirección: ").setValue(direccion)
                        userDB.child("Teléfono: ").setValue(telefono)
                        userDB.child("Correo: ").setValue(correo)
                        Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                        limpiar()
                        volverInicio()
                    }else if(tipo.equals("Derecho Mercantil")){
                        val userDB=dbReference.child("Derecho Mercantil")
                        userDB.child("Caso: ").setValue(caso)
                        userDB.child("CC: ").setValue(cc)
                        userDB.child("Nombres: ").setValue(nombres)
                        userDB.child("Apellidos: ").setValue(apellidos)
                        userDB.child("Dirección: ").setValue(direccion)
                        userDB.child("Teléfono: ").setValue(telefono)
                        userDB.child("Correo: ").setValue(correo)
                        Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                        limpiar()
                        volverInicio()
                    } else if(tipo.equals("Derecho Penal")){
                        val userDB=dbReference.child("Derecho Penal")
                        userDB.child("Caso: ").setValue(caso)
                        userDB.child("CC: ").setValue(cc)
                        userDB.child("Nombres: ").setValue(nombres)
                        userDB.child("Apellidos: ").setValue(apellidos)
                        userDB.child("Dirección: ").setValue(direccion)
                        userDB.child("Teléfono: ").setValue(telefono)
                        userDB.child("Correo: ").setValue(correo)
                        Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                        limpiar()
                        volverInicio()
                    } else{
                        val userDB=dbReference.child("Derecho Tributario")
                        userDB.child("Caso: ").setValue(caso)
                        userDB.child("CC: ").setValue(cc)
                        userDB.child("Nombres: ").setValue(nombres)
                        userDB.child("Apellidos: ").setValue(apellidos)
                        userDB.child("Dirección: ").setValue(direccion)
                        userDB.child("Teléfono: ").setValue(telefono)
                        userDB.child("Correo: ").setValue(correo)
                        Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                        limpiar()
                        volverInicio()
                    }
                }
            }
        }

    }

    //verificar correo
    private fun verificarCorreo(user: FirebaseUser?){
        user?.sendEmailVerification()?.addOnCompleteListener(this){
            task ->

            if(task.isComplete){
                Toast.makeText(this,"Correo enviado",Toast.LENGTH_LONG)
            }else{
                Toast.makeText(this,"Error al enviar correo",Toast.LENGTH_LONG)
            }
        }
    }

    private fun limpiar() {
        editDocumento.text=null
        editNombre.text=null
        editApellidos.text=null
        editDireccion.text=null
        editTelefono.text=null
        editCorreo.text=null
        editContrasena.text=null

    }

    private fun volverInicio(){
        val actividad= Intent(this,MainActivity::class.java)
        startActivity(actividad)
    }*/

    private lateinit var conexionDB:DatabaseReference
    private lateinit var mAuth:FirebaseAuth

    private lateinit var txtPassword:EditText
    private lateinit var txtEmail:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        txtEmail=findViewById(R.id.editCorreo)
        txtPassword=findViewById(R.id.editContrasena)

        conexionDB=FirebaseDatabase.getInstance().getReference("CasoCliente")

        mAuth= FirebaseAuth.getInstance()
        btnEnviar.setOnClickListener(){enviandoInformacion()}
    }

    private fun enviandoInformacion() {

        val cc= editDocumento.text.toString()
        val nombre= editNombre.text.toString()
        val apellidos= editApellidos.text.toString()
        val direccion= editDireccion.text.toString()
        val telefono= editTelefono.text.toString()
        val correo: String= txtEmail.text.toString()
        val contrasena: String= txtPassword.text.toString()


        val tipo=intent.extras.getString("tipoDerecho")
        val caso=intent.extras.getString("caso")
        //Toast.makeText(this,tipo.toString(),Toast.LENGTH_SHORT).show()


        if(cc==""){
            Toast.makeText(this,"El campo identificación no puede estar vacío",Toast.LENGTH_SHORT).show()
        }else if(nombre==""){
            Toast.makeText(this,"El campo nombres no puede estar vacío",Toast.LENGTH_SHORT).show()
        } else if(apellidos==""){
            Toast.makeText(this,"El campo apellidos no puede estar vacío",Toast.LENGTH_SHORT).show()
        }else if(direccion==""){
            Toast.makeText(this,"El campo direccion no puede estar vacío",Toast.LENGTH_SHORT).show()
        } else if(telefono==""){
            Toast.makeText(this,"El campo teléfono no puede estar vacío",Toast.LENGTH_SHORT).show()
        } else if (correo=="") {
            Toast.makeText(this,"El campo correo no puede estar vacío",Toast.LENGTH_SHORT).show()
        } else {

            val persona:Personas=Personas(cc,nombre,apellidos,direccion,telefono)

            val casos:Casos=Casos(persona,caso,correo)

            if(tipo=="Derecho Familiar"){
                this.conexionDB.child("Derecho_Familiar").push().setValue(casos)
                Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                mAuth.createUserWithEmailAndPassword(correo,contrasena).addOnCompleteListener(this){
                        task ->
                    if(task.isSuccessful){
                        //obtiene el usuario registrado
                        val user:FirebaseUser?=mAuth.currentUser
                        verificarCorreo(user)


                    }
                }
                limpiar()
                volverInicio()
            }else if(tipo=="Derecho Laboral"){
                this.conexionDB.child("Derecho_Laboral").push().setValue(casos)
                Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                limpiar()
                volverInicio()
            }else if(tipo=="Derecho Mercantil"){
                this.conexionDB.child("Derecho_Mercantil").push().setValue(casos)
                Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                limpiar()
                volverInicio()
            } else if(tipo=="Derecho Penal"){
                this.conexionDB.child("Derecho_Penal").push().setValue(casos)
                Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                limpiar()
                volverInicio()
            } else if(tipo=="Derecho Penal"){
                this.conexionDB.child("Derecho_Penal").push().setValue(casos)
                Toast.makeText(this,"Su información se ha registrado con éxito!!!",Toast.LENGTH_SHORT).show()
                limpiar()
                volverInicio()
            }

            //Toast.makeText(this,persona.toString(),Toast.LENGTH_SHORT).show()
        }
    }
    private fun limpiar() {
        editDocumento.text=null
        editNombre.text=null
        editApellidos.text=null
        editDireccion.text=null
        editTelefono.text=null
        editCorreo.text=null
        editContrasena.text=null

    }

    private fun volverInicio(){
        val actividad=Intent(this,MainActivity::class.java)
        startActivity(actividad)
    }

    //verificar correo
    private fun verificarCorreo(user: FirebaseUser?){
        user?.sendEmailVerification()?.addOnCompleteListener(this){
                task ->

            if(task.isComplete){
                Toast.makeText(this,"Correo enviado",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Error al enviar correo",Toast.LENGTH_LONG).show()
            }
        }
    }



}
