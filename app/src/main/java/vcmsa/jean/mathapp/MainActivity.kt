package vcmsa.jean.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//code starts here
        val btnMath = findViewById<Button>(R.id.btnMath)
        val edTInputOne = findViewById<EditText>(R.id.edTInputOne)
        val edTInputTwo = findViewById<EditText>(R.id.edTInputTwo)
        val tVAnswer = findViewById<TextView>(R.id.tVAnswer)

        btnMath.setOnClickListener {
            val inputOneText = edTInputOne.text.toString().trim()
            val inputTwoText = edTInputTwo.text.toString().trim()

            if (inputOneText.isNotEmpty() && inputTwoText.isNotEmpty()) {
                try {
                    val inputOne = inputOneText.toInt()
                    val inputTwo = inputTwoText.toInt()

                    val answer = inputOne + inputTwo

                    tVAnswer.text = answer.toString()
                } catch (e: NumberFormatException) {
                    tVAnswer.text = "Non-numeric input."
                }
            } else {
                tVAnswer.text = "Empty input."
            }
        }
    }
}