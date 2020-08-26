package com.codingblocks.takephotobasics

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.codingblocks.takephotobasics.barcode.BarcodeActivity
import com.codingblocks.takephotobasics.facedetect.FaceDetectActivity
import com.codingblocks.takephotobasics.imagelabeler.ImageLabelingActivity
import com.codingblocks.takephotobasics.textrecog.TextRecognitionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        @JvmStatic
        val PHOTO_REQ_CODE = 234
        @JvmStatic
        val EXTRA_DATA = "data"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTakeExtPhoto.setOnClickListener {
            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePhotoIntent, PHOTO_REQ_CODE)
        }

        btnCameraActivity.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        btnBarcodeActivity.setOnClickListener {
            startActivity(Intent(this, BarcodeActivity::class.java))
        }

        btnFaceDetectActivity.setOnClickListener {
            startActivity(Intent(this, FaceDetectActivity::class.java))
        }

        btnLabelerActivity.setOnClickListener {
            startActivity(Intent(this, ImageLabelingActivity::class.java))
        }

        btnTextRecogActivity.setOnClickListener {
            startActivity(Intent(this, TextRecognitionActivity::class.java))
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == PHOTO_REQ_CODE) {
            val bitmap = data?.extras?.get(EXTRA_DATA) as Bitmap
            imgThumb.setImageBitmap(bitmap)
            return
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}