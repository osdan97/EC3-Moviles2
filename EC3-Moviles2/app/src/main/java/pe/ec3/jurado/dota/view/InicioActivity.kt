package pe.ec3.jurado.dota.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import pe.ec3.jurado.dota.databinding.ActivityInicioBinding

private fun isValidEmail(email: String): Boolean {
    return email == "ejemplo@idat.edu.pe"
}

private fun isValidPassword(password: String): Boolean {
    return password == "123456"
}


private fun validateInputs(email:String,pass:String): Boolean {
    val isEmailOk=email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordOk= pass.length>=6
    return isEmailOk && isPasswordOk
}

class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()


    }


    @SuppressLint("SuspiciousIndentation")
    private fun setupViews() {

        binding.tilEmail.editText?.addTextChangedListener { text ->
            binding.btnIngresar.isEnabled =
                validateInputs(text.toString(), binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener { text ->
            binding.btnIngresar.isEnabled =
                validateInputs(binding.tilEmail.editText?.text.toString(), text.toString(),)
        }

        binding.btnIngresar.setOnClickListener {
            val correo = binding.et1.text.toString()
            val pass = binding.et2.text.toString()
            if (isValidEmail(correo) && isValidPassword(pass)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Correo o contraseña inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}