package ir.danialchoopan.composecalculator.data.audio

import android.content.Context
import android.media.AudioManager
import android.view.HapticFeedbackConstants
import android.view.View

class SoundManager(private val context: Context) {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    fun playSound() {
        audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK)
    }
}
