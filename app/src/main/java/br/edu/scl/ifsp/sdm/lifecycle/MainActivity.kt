package br.edu.scl.ifsp.sdm.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import br.edu.scl.ifsp.sdm.lifecycle.databinding.ActivityMainBinding
import br.edu.scl.ifsp.sdm.lifecycle.databinding.TilePhoneBinding

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var filledChars: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
        activityMainBinding.apply {
            setSupportActionBar(toolbarIn.toolbar)
            addPhoneBt.setOnClickListener {
                val tilePhoneBinding = TilePhoneBinding.inflate(layoutInflater)
                phonesLl.addView(tilePhoneBinding.root)
            }
            nameEt.doAfterTextChanged {
                "${getString(R.string.filled_chars)} ${++filledChars}".also{
                    filledCharsTv.text = it
                }
            }
            openAnotherActivityBt.setOnClickListener {
                startActivity(Intent(this@MainActivity, AnotherActivity::class.java))
            }
        }
        supportActionBar?.subtitle = getString(R.string.main)
        Log.v(getString(R.string.app_name), "Main - onCreate(): inicio COMPLETO")
    }

    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "Main - onsTART(): inicio VISIVEL")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }
}