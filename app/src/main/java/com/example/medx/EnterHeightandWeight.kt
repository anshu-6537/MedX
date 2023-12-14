package com.example.medx

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class EnterHeightandWeight : AppCompatActivity() {

    var heightstart=0
    var heightend=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_height_and_weight)

        val img = findViewById<ImageView>(R.id.height_image)
        val heightSeekbar = findViewById<SeekBar>(R.id.heightseekbar)
        val weightSeekbar = findViewById<SeekBar>(R.id.weightseekbar)
        val htext = findViewById<TextView>(R.id.heighttext)
        val wtext = findViewById<TextView>(R.id.weighttext)
        var previousProcess = 0


        heightSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                htext.text=progress.toString()
                val diff: Int = progress - previousProcess
                val scale = progress.toFloat() / 100

                img.setScaleY(scale)
                previousProcess = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    heightstart = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    heightend = seekBar.progress
                    previousProcess=seekBar.progress
                }


                Toast.makeText(this@EnterHeightandWeight,"height increased by %${heightend-heightstart}", Toast.LENGTH_SHORT).show()
            }

        })


        var weightstart=0
        var weightend=0
        weightSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                wtext.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    weightstart=seekBar.progress
                }
            }



            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    weightend=seekBar.progress
                }
                Toast.makeText(this@EnterHeightandWeight,"weight increased by %${weightend-weightstart}", Toast.LENGTH_SHORT).show()
            }

        })


//Toast.makeText(this,heightend.toString(),Toast.LENGTH_SHORT).show()
        val click_me = findViewById<Button>(R.id.enter)
        //Toast.makeText(this,,Toast.LENGTH_SHORT).show()
        click_me.setOnClickListener {
            val intent = Intent(this,DisplayBMI::class.java)

            intent.putExtra("heightvalue", heightend.toString())
            intent.putExtra("weightvalue", weightend.toString())

            startActivity(intent)
        }
    }
//    fun scaleImage(img: ImageView, scale: Int) {
//        var bitmap = (img.drawable as BitmapDrawable).bitmap
//        var width = bitmap.width.toFloat()
//        var height = bitmap.height.toFloat()
//        width += scale * WIDTH_SCALE_RATIO
//        height += scale * HEIGHT_SCALE_RATIO
//        bitmap = Bitmap.createScaledBitmap(
//            bitmap, width.toInt(), height.toInt(),
//            true
//        )
//        img.setImageBitmap(bitmap)
//    }
}