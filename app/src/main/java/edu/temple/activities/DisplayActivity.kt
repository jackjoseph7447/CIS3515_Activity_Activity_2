package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

const val SEND_KEY = "message"
const val RECEIVE_KEY = "incoming"

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
        if(it.resultCode == RESULT_OK)
        {
            it.data?.apply {
                lyricsDisplayTextView.textSize = getStringExtra(RECEIVE_KEY).toString().toFloat()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener{
            val launcherIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
           // launcherIntent.putExtra(SEND_KEY, it)
            launcher.launch(launcherIntent)
        }

    }
}