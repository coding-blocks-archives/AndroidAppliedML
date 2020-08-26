package com.codingblocks.takephotobasics.barcode

import androidx.core.content.ContextCompat
import com.codingblocks.takephotobasics.BaseLensActivity

class BarcodeActivity : BaseLensActivity() {

    override val imageAnalyzer = BarcodeAnalyzer()
    override fun startScanner() {
        scanBarcode()
    }

    private fun scanBarcode() {

        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )

    }

}