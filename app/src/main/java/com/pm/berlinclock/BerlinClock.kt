package com.pm.berlinclock

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*

class BerlinClock : AppCompatActivity() {

    private var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer.schedule(object : TimerTask() {
            override fun run() {
                this@BerlinClock.runOnUiThread {
                    val c = Calendar.getInstance()
                    findViewById<TextView>(R.id.clock).text = getTimeText(c)
                    getClock(
                            c[Calendar.HOUR_OF_DAY], c[Calendar.MINUTE],
                            c[Calendar.SECOND]
                    )?.let { updateLights(it) }
                }
            }
        }, 0, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    fun getClock(hours: Int, minutes: Int, seconds: Int): IntArray? {
        val lights = IntArray(5)
        lights[0] = seconds % 2
        lights[1] = hours / 5
        lights[2] = hours % 5
        lights[3] = minutes / 5
        lights[4] = minutes % 5
        return lights
    }

    private fun updateLights(lights: IntArray) {
        findViewById<View>(R.id.sec).background = getColorSec(getStateSec(lights[0], 1))

        for (i in 0..10) {
            if (i < 4) {
                (findViewById<View>(R.id.h5) as ViewGroup).getChildAt(i).background =
                        getColorHours(getStateHours(lights[1], i + 1), i + 1)
                (findViewById<View>(R.id.h1) as ViewGroup).getChildAt(i).background =
                        getColorHours(getStateHours(lights[2], i + 1), i + 1)
                (findViewById<View>(R.id.m1) as ViewGroup).getChildAt(i).background =
                        getColorM1(getStateM1(lights[4], i + 1), i + 1)
            }
            (findViewById<View>(R.id.m5) as ViewGroup).getChildAt(i).background =
                    getColorM5(getStateM5(lights[3], i + 1), i + 1)
        }
    }

    fun getStateSec(data: Int, level: Int): Int {
        return if (data >= level) 0 else 1
    }

    private fun getColorSec(state: Int): Drawable? {
        return if (state == 1) ContextCompat.getDrawable(
                this,
                R.drawable.black_border_circle_yellow
        )
        else ContextCompat.getDrawable(this, R.drawable.black_border_circle_white)
    }

    fun getStateHours(data: Int, level: Int): Int {
        return if (data >= level) 1 else 0
    }

    private fun getColorHours(state: Int, level: Int): Drawable? {
        return if (state == 1) {
            when (level) {
                1 -> ContextCompat.getDrawable(this, R.drawable.black_border_red_first)
                4 -> ContextCompat.getDrawable(this, R.drawable.black_border_red_last)
                else -> ContextCompat.getDrawable(this, R.drawable.black_border_red)
            }
        } else {
            when (level) {
                1 -> ContextCompat.getDrawable(this, R.drawable.black_border_white_first)
                4 -> ContextCompat.getDrawable(this, R.drawable.black_border_white_last)
                else -> ContextCompat.getDrawable(this, R.drawable.black_border_white)
            }
        }
    }

    fun getStateM5(data: Int, level: Int): Int {
        return if (data >= level) 1 else 0
    }

    private fun getColorM5(state: Int, level: Int): Drawable? {
        return if (state == 1) {
            if (level % 3 == 0) {
                ContextCompat.getDrawable(this, R.drawable.black_border_red)
            } else {
                when (level) {
                    1 -> ContextCompat.getDrawable(this, R.drawable.black_border_yellow_first)
                    11 -> ContextCompat.getDrawable(this, R.drawable.black_border_yellow_last)
                    else -> ContextCompat.getDrawable(this, R.drawable.black_border_yellow)
                }
            }
        } else {
            when (level) {
                1 -> ContextCompat.getDrawable(this, R.drawable.black_border_white_first)
                11 -> ContextCompat.getDrawable(this, R.drawable.black_border_white_last)
                else -> ContextCompat.getDrawable(this, R.drawable.black_border_white)
            }
        }
    }

    fun getStateM1(data: Int, level: Int): Int {
        return if (data >= level) 1 else 0
    }

    private fun getColorM1(state: Int, level: Int): Drawable? {
        return if (state == 1) {
            when (level) {
                1 -> ContextCompat.getDrawable(this, R.drawable.black_border_yellow_first)
                4 -> ContextCompat.getDrawable(this, R.drawable.black_border_yellow_last)
                else -> ContextCompat.getDrawable(this, R.drawable.black_border_yellow)
            }
        } else {
            when (level) {
                1 -> ContextCompat.getDrawable(this, R.drawable.black_border_white_first)
                4 -> ContextCompat.getDrawable(this, R.drawable.black_border_white_last)
                else -> ContextCompat.getDrawable(this, R.drawable.black_border_white)
            }
        }
    }

    private fun getTimeText(calendar: Calendar): String? {
        val format = SimpleDateFormat(getString(R.string.date_format),
                Locale.getDefault())
        return format.format(calendar.time)
    }
}
