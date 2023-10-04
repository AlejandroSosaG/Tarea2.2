package com.example.tarea2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.tarea2_2.databinding.ActivityMainBinding
import com.example.tarea2_2.databinding.CalculadoraBinding

class MainActivity : AppCompatActivity() {
    var usuario: String = ""
    var contraseña: String = ""
    var sol: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        val calculadora = CalculadoraBinding.inflate(layoutInflater)
        main.acceder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                usuario = main.completaUsuario.text.toString()
                setContentView(calculadora.root)
                val tostada = Toast.makeText(applicationContext, "Estoy en calculadora", Toast.LENGTH_SHORT).show()
            }
        })
        calculadora.Vuelta.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                setContentView(main.root)
                val main = Toast.makeText(applicationContext, "Estoy en main", Toast.LENGTH_SHORT).show()
            }
        })
        var uno: Double = calculadora.numero1.text.toString().toDouble()
        var dos: Double = calculadora.numero2.text.toString().toDouble()
        calculadora.mas.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                sol = uno + dos
                calculadora.resultado.text = sol.toString()
            }
        })
    }
}