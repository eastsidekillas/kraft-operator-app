package com.example.kraft_operator_app;
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val audioFiles = intArrayOf(
        R.raw.sound1,
        R.raw.sound2,
        R.raw.sound3,
        R.raw.sound4,
        R.raw.sound5,
        R.raw.sound6,
        R.raw.sound7,
        R.raw.sound8,
        R.raw.sound9,
        R.raw.sound10,
        R.raw.sound11,
        R.raw.sound12,
        R.raw.sound13,
        R.raw.sound14,
        R.raw.sound15,
        R.raw.sound16,
        R.raw.sound17,
        R.raw.sound18,
        R.raw.sound19,
        R.raw.sound20,
        R.raw.sound21,
        R.raw.sound22,
        R.raw.sound23,
        R.raw.sound24,
        R.raw.sound25,
    )

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout: ViewGroup = findViewById(R.id.mainLayout)
        val preloaderLayout: View = layoutInflater.inflate(R.layout.preloader_layout, mainLayout, false)
        mainLayout.addView(preloaderLayout)

        val handler = Handler()
        handler.postDelayed({
            mainLayout.removeView(preloaderLayout)
            loadContent()
        }, 2000) // Имитация загрузки в течение 2 секунд

        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.setDisplayShowCustomEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)
        val view = layoutInflater.inflate(R.layout.custom_actionbar, null)
        actionBar?.customView = view

    }

    private fun loadContent() {
        // Загрузка контента, например, инициализация адаптера и кнопок
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 5)
        val buttonAdapter = ButtonAdapter { position -> playSound(position) }
        recyclerView.adapter = buttonAdapter
    }


    private fun playSound(buttonIndex: Int) {
        val audioFile = audioFiles[buttonIndex]

        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }

        mediaPlayer = MediaPlayer.create(this, audioFile)
        mediaPlayer.start()
    }

    fun playSound() {}
}
