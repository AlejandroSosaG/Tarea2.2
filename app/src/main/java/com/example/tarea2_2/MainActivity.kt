package com.example.tarea2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.tarea2_2.databinding.ActivityMainBinding
import com.example.tarea2_2.databinding.CalculadoraBinding

class MainActivity : AppCompatActivity() {
    val usuario: String = ""
    val contraseña: String = ""
    var sol: Double = 0.0
    var num1: Double = 0.0
    var num2: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val main = ActivityMainBinding.inflate(layoutInflater)
        val calculadora = CalculadoraBinding.inflate(layoutInflater)
        setContentView(main.root)
        /**
         * Método que pasa a la pantalla de calculadora.
         */
        main.acceder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                if (usuario == main.completaUsuario.text.toString() && contraseña == main.completaContraseA.text.toString()) {
                    setContentView(calculadora.root)
                    val tostada = Toast.makeText(
                        applicationContext,
                        "Estoy en calculadora",
                        Toast.LENGTH_SHORT
                    ).show()
                }else{
                    val toast = Toast.makeText(applicationContext, "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show()
                }
            }
        })
        /**
         * Método que vuelve a la pantalla de login.
         */
        calculadora.Vuelta.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                setContentView(main.root)
                val main = Toast.makeText(applicationContext, "Estoy en main", Toast.LENGTH_SHORT).show()
            }
        })
        /**
         * Método que calcula la suma del primer número más el segundo.
         */
        calculadora.mas.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                num1 = comprobarNulos()
                num2 = comprobarNulos2()
                sol = num1 + num2
                calculadora.sol.text = sol.toString()
            }
        })
        /**
         * Método que calcula la resta del primer número menos el segundo.
         */
        calculadora.menos.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                num1 = comprobarNulos()
                num2 = comprobarNulos2()
                sol = num1 - num2
                calculadora.sol.text = sol.toString()
            }
        })
        /**
         * Método que calcula la multiplicación del primer número por el segundo.
         */
        calculadora.por.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                num1 = comprobarNulos()
                num2 = comprobarNulos2()
                sol = num1 * num2
                calculadora.sol.text = sol.toString()
            }
        })
        /**
         * Método que calcula la división del primer número entre el segundo.
         */
        calculadora.entre.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                num1 = comprobarNulos()
                num2 = comprobarNulos2()
                if (num2!=0.0) {
                    sol = num1 / num2
                    calculadora.sol.text = sol.toString()
                }else
                    calculadora.sol.text = "No se puede"
            }
        })
    }

    /**
     * Método que comprueba si el segundo factor es nulo.
     */
    private fun comprobarNulos2(): Double {
        val calculadora = CalculadoraBinding.inflate(layoutInflater)
        if (calculadora.numero2.text.toString().isNotBlank()){
            num2 = calculadora.numero1.text.toString().toDouble()
        }
        return num2
    }

    /**
     * Método que se encarga de comprobar si el valor del primer factor es nulo.
     */
    private fun comprobarNulos(): Double {
        val calculadora = CalculadoraBinding.inflate(layoutInflater)
        if (calculadora.numero1.text.toString().isNotBlank()){
            num1 = calculadora.numero1.text.toString().toDouble()
        }
        return num1
    }
}