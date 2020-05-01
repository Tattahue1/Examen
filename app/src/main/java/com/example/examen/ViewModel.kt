package com.example.examen

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel

class ViewModel (val repositorio:Repositorio):ViewModel() {

    val model: LiveData<UImodel>
        get()=_model
    val _model =MutableLiveData<UImodel>()

    sealed class UImodel{
        class Register(val success:Boolean):UImodel()
    }
    fun doRegister(Name:String,Last:String,Email:String)
    {
        _model.value=UImodel.Register( repositorio.register(Name,Last,Email))
    }
}