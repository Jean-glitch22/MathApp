package vcmsa.jean.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
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

        val rbAdd = findViewById<RadioButton>(R.id.rbAdd)
        val rbMinus = findViewById<RadioButton>(R.id.rbMinus)
        val rbTimes = findViewById<RadioButton>(R.id.rbTimes)
        val rbDivide = findViewById<RadioButton>(R.id.rbDivide)

        btnMath.setOnClickListener {
            val inputOneText = edTInputOne.text.toString().trim()
            val inputTwoText = edTInputTwo.text.toString().trim()

            if (inputOneText.isNotEmpty() && inputTwoText.isNotEmpty()) {
                try {
                    val inputOne = inputOneText.toDouble()
                    val inputTwo = inputTwoText.toDouble()
                    var resultText = "\uD835\uDD50\uD835\uDD46\uD835\uDD4Cℝ \uD835\uDD38ℕ\uD835\uDD4A\uD835\uDD4E\uD835\uDD3Cℝ \uD835\uDD40\uD835\uDD4A"

                    if (rbAdd.isChecked) {
                        val result = inputOne + inputTwo
                        resultText = "\uD835\uDD38\uD835\uDD55\uD835\uDD55\uD835\uDD5A\uD835\uDD65\uD835\uDD5A\uD835\uDD60\uD835\uDD5F \uD835\uDD63\uD835\uDD56\uD835\uDD64\uD835\uDD66\uD835\uDD5D\uD835\uDD65:\n $result"
                    } else if (rbMinus.isChecked) {
                        val result = inputOne - inputTwo
                        resultText = "\uD835\uDD4A\uD835\uDD66\uD835\uDD53\uD835\uDD65\uD835\uDD63\uD835\uDD52\uD835\uDD54\uD835\uDD65\uD835\uDD5A\uD835\uDD60\uD835\uDD5F \uD835\uDD63\uD835\uDD56\uD835\uDD64\uD835\uDD66\uD835\uDD5D\uD835\uDD65: $result"
                    } else if (rbTimes.isChecked) {
                        val result = inputOne * inputTwo
                        resultText = "\uD835\uDD44\uD835\uDD66\uD835\uDD5D\uD835\uDD65\uD835\uDD5A\uD835\uDD61\uD835\uDD5D\uD835\uDD5A\uD835\uDD54\uD835\uDD52\uD835\uDD65\uD835\uDD5A\uD835\uDD60\uD835\uDD5F \uD835\uDD63\uD835\uDD56\uD835\uDD64\uD835\uDD66\uD835\uDD5D\uD835\uDD65: $result"
                    } else if (rbDivide.isChecked) {
                        if (inputTwo != 0.0) {
                            val result = inputOne / inputTwo
                            resultText = "\uD835\uDD3B\uD835\uDD5A\uD835\uDD67\uD835\uDD5A\uD835\uDD64\uD835\uDD5A\uD835\uDD60\uD835\uDD5F \uD835\uDD63\uD835\uDD56\uD835\uDD64\uD835\uDD66\uD835\uDD5D\uD835\uDD65: $result"
                        } else {
                            resultText = "ℂ\uD835\uDD52\uD835\uDD5F\uD835\uDD5F\uD835\uDD60\uD835\uDD65 \uD835\uDD55\uD835\uDD5A\uD835\uDD67\uD835\uDD5A\uD835\uDD55\uD835\uDD56 \uD835\uDD53\uD835\uDD6A \uD835\uDD6B\uD835\uDD56\uD835\uDD63\uD835\uDD60!"
                        }
                    } else {
                        resultText = "ℙ\uD835\uDD5D\uD835\uDD56\uD835\uDD52\uD835\uDD64\uD835\uDD56 \uD835\uDD64\uD835\uDD56\uD835\uDD5D\uD835\uDD56\uD835\uDD54\uD835\uDD65 \uD835\uDD52\uD835\uDD5F \uD835\uDD60\uD835\uDD61\uD835\uDD56\uD835\uDD63\uD835\uDD52\uD835\uDD65\uD835\uDD5A\uD835\uDD60\uD835\uDD5F!"
                    }

                    tVAnswer.text = resultText

                } catch (e: NumberFormatException) {
                    tVAnswer.text = "\uD835\uDD40\uD835\uDD5F\uD835\uDD67\uD835\uDD52\uD835\uDD5D\uD835\uDD5A\uD835\uDD55 \uD835\uDD5F\uD835\uDD66\uD835\uDD5E\uD835\uDD53\uD835\uDD56\uD835\uDD63 \uD835\uDD56\uD835\uDD5F\uD835\uDD65\uD835\uDD56\uD835\uDD63\uD835\uDD56\uD835\uDD55!"
                }
            } else {
                tVAnswer.text = "ℙ\uD835\uDD5D\uD835\uDD56\uD835\uDD52\uD835\uDD64\uD835\uDD56 \uD835\uDD56\uD835\uDD5F\uD835\uDD65\uD835\uDD56\uD835\uDD63 \uD835\uDD53\uD835\uDD60\uD835\uDD65\uD835\uDD59 \uD835\uDD5F\uD835\uDD66\uD835\uDD5E\uD835\uDD53\uD835\uDD56\uD835\uDD63\uD835\uDD64!"
            }
        }
    }
}
