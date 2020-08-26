package com.codingblocks.takephotobasics.textrecog

import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.codingblocks.takephotobasics.BaseLensActivity

class TextRecognitionActivity : BaseLensActivity() {
    override val imageAnalyzer = TextAnalyzer()

    override fun startScanner() {
        startTextRecognition()
    }

    private fun startTextRecognition() {
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }

}