package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    lateinit var ViewModel:ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        ViewModel=ViewModel(Repositorio())
        ViewModel.model.observe(this, Observer(::updateUI))
        button.setOnClickListener{
            ViewModel.doRegister(name.text.toString(),lastName.text.toString(),email.text.toString())
        }
    }
    private fun updateUI(model:ViewModel.UImodel?)
    {
        when (model)
        {
            is ViewModel.UImodel.Register ->validarReg(model.success)
        }
    }

    private fun validarReg(resp:Boolean) {
        val builder=AlertDialog.Builder(this) // Builder needs a context
        builder.setTitle("Registro de usuario")

        if (resp){
            builder.setMessage("Usuario creado")
            builder.setPositiveButton("Ok") { _,_ ->
                Toast.makeText(this, "Creado", Toast.LENGTH_LONG).show()
            }
        }
        else{
            builder.setMessage("Usuario no creado")
            builder.setPositiveButton("Ok") { _,_ ->
                Toast.makeText(this, "No creado", Toast.LENGTH_LONG).show()
            }
        }
        builder.show()
    }
}