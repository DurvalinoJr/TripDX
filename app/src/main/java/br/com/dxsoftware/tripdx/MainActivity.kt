package br.com.dxsoftware.tripdx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val id = v.id

        if (id == R.id.buttonCalculate){
            handleCalculate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    private fun handleCalculate() = if (isValid()) {
        try {
            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            val result = ((distance * price) / autonomy)
            textResult.text = "Total: $ $result"

        } catch (nfe: NumberFormatException) {
            Toast.makeText(this, R.string.strValidValues, Toast.LENGTH_LONG).show()
        }
    } else {
        Toast.makeText(this, R.string.strValidValues, Toast.LENGTH_LONG).show()
    }
    private fun isValid(): Boolean{
        return editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0"
    }
}
