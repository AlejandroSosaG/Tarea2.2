package com.example.tarea2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.tarea2_2.databinding.ActivityMainBinding
import com.example.tarea2_2.databinding.CalculadoraBinding

class MainActivity : AppCompatActivity() {
    var usuario: String = "ale"
    var contraseña: String = "1234"
    var sol: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val main = ActivityMainBinding.inflate(layoutInflater)
        val calculadora = CalculadoraBinding.inflate(layoutInflater)
        setContentView(main.root)
        main.acceder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                if (usuario == main.completaUsuario.text.toString() && contraseña == main.completaContraseA.text.toString()) {
                    setContentView(calculadora.root)
                    val tostada = Toast.makeText(
                        applicationContext,
                        "Estoy en calculadora",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
        calculadora.Vuelta.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                setContentView(main.root)
                val main = Toast.makeText(applicationContext, "Estoy en main", Toast.LENGTH_SHORT).show()
            }
        })
        calculadora.mas.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                sol = calculadora.numero1.text.toString().toDouble() + calculadora.numero2.text.toString().toDouble()
                calculadora.sol.text = sol.toString()
            }
        })
        calculadora.menos.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                sol = calculadora.numero1.text.toString().toDouble() - calculadora.numero2.text.toString().toDouble()
                calculadora.sol.text = sol.toString()
            }
        })
        calculadora.por.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                sol = calculadora.numero1.text.toString().toDouble() * calculadora.numero2.text.toString().toDouble()
                calculadora.sol.text = sol.toString()
            }
        })
        calculadora.entre.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (comprobarNulos() == true)
                    sol = calculadora.numero1.text.toString().toDouble() / calculadora.numero2.text.toString().toDouble()
                calculadora.sol.text = sol.toString()
            }
        })

    }

    private fun comprobarNulos(): Boolean {
        val calculadora = CalculadoraBinding.inflate(layoutInflater)
        var num1 = calculadora.numero1.text.toString().toDouble()
        var num2 = calculadora.numero2.text.toString().toDouble()
        var nulo: Boolean = true
        if (num1 == null || num1 == 0.0){
            num1 = 0.0
            nulo = false
        }else if (num2 == null || num2 == 0.0){
            num2 = 0.0
            nulo = false
        }
        return nulo
    }
}