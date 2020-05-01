package com.example.examen

class Repositorio {
    fun register(Name:String,LastName:String,Email:String):Boolean {
        if (Name != "" && LastName != "" && Email != "" )
        {
            return true
        }
        else {
            return  false
        }
    }
}