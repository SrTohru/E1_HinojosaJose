package mx.itson.edu.e1hinojosajose

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var inputPrice: EditText
    private lateinit var textPercentage: TextView
    private lateinit var textTotal: TextView
    private var percentage: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputPrice = findViewById(R.id.inputPrice)
        textPercentage = findViewById(R.id.textPercentage)
        textTotal = findViewById(R.id.textTotal)

        findViewById<Button>(R.id.button10).setOnClickListener { setPercentage(10.0) }
        findViewById<Button>(R.id.button15).setOnClickListener { setPercentage(15.0) }
        findViewById<Button>(R.id.button20).setOnClickListener { setPercentage(20.0) }
        findViewById<Button>(R.id.button25).setOnClickListener { setPercentage(25.0) }
        findViewById<Button>(R.id.button30).setOnClickListener { setPercentage(30.0) }
        findViewById<Button>(R.id.button35).setOnClickListener { setPercentage(35.0) }

        findViewById<Button>(R.id.buttonTip).setOnClickListener { calculateTotal(true) }
        findViewById<Button>(R.id.buttonDiscount).setOnClickListener { calculateTotal(false) }
    }

    private fun setPercentage(value: Double) {
        percentage = value
        textPercentage.text = "Porcentaje calculado: $percentage%"
    }

    private fun calculateTotal(isTip: Boolean) {
        val price = inputPrice.text.toString().toDoubleOrNull()
        if (price != null) {
            val calculatedPercentage = price * (percentage / 100)
            val total = if (isTip) {
                price + calculatedPercentage
            } else {
                price - calculatedPercentage
            }
            textTotal.text = "Total: $total"
        } else {
            Toast.makeText(this, "Por favor ingrese un precio válido", Toast.LENGTH_SHORT).show()
        }
    }

}