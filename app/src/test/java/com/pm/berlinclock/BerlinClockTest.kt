package com.pm.berlinclock

import org.junit.Assert.assertEquals
import org.junit.Test

class BerlinClockTest {

    private var berlinClock = BerlinClock()

    /**
     * The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.
     */
    @Test
    fun testSeconds() {
        val clockEvenSec = berlinClock.getClock(0, 0, 2)
        val clockOddSec = berlinClock.getClock(0, 0, 1)
        val resultEvenSecs = berlinClock.getStateSec(clockEvenSec!![0], 1)
        val resultOddSecs = berlinClock.getStateSec(clockOddSec!![0], 1)
        assertEquals(1, resultEvenSecs)
        assertEquals(0, resultOddSecs)
    }

    /**
     * The upper row represents 5 hour blocks and is made up of
     * 4 red lamps.
     */

    @Test
    fun testHoursFirstRow() {
        val clock0Lights = berlinClock.getClock(3, 0, 0)
        val clock1Lights = berlinClock.getClock(5, 0, 0)
        val clock2Lights = berlinClock.getClock(11, 0, 0)
        val clock3Lights = berlinClock.getClock(16, 0, 0)
        val clock4Lights = berlinClock.getClock(23, 0, 0)

        val result0Lights = IntArray(5)
        val result1Lights = IntArray(5)
        val result2Lights = IntArray(5)
        val result3Lights = IntArray(5)
        val result4Lights = IntArray(5)

        for (i in 0..4) {
            result0Lights[i] = berlinClock.getStateHours(clock0Lights!![1], i + 1)
            result1Lights[i] = berlinClock.getStateHours(clock1Lights!![1], i + 1)
            result2Lights[i] = berlinClock.getStateHours(clock2Lights!![1], i + 1)
            result3Lights[i] = berlinClock.getStateHours(clock3Lights!![1], i + 1)
            result4Lights[i] = berlinClock.getStateHours(clock4Lights!![1], i + 1)
        }

        /** 0 lights on */
        assertEquals(0, result0Lights[0])
        assertEquals(0, result0Lights[1])
        assertEquals(0, result0Lights[2])
        assertEquals(0, result0Lights[3])

        /** 1 light on */
        assertEquals(1, result1Lights[0])
        assertEquals(0, result1Lights[1])
        assertEquals(0, result1Lights[2])
        assertEquals(0, result1Lights[3])

        /** 2 lights on */
        assertEquals(1, result2Lights[0])
        assertEquals(1, result2Lights[1])
        assertEquals(0, result2Lights[2])
        assertEquals(0, result2Lights[3])

        /** 3 lights on */
        assertEquals(1, result3Lights[0])
        assertEquals(1, result3Lights[1])
        assertEquals(1, result3Lights[2])
        assertEquals(0, result3Lights[3])

        /** 4 lights on */
        assertEquals(1, result4Lights[0])
        assertEquals(1, result4Lights[1])
        assertEquals(1, result4Lights[2])
        assertEquals(1, result4Lights[3])
    }

    /**
     * The lower row represents 1 hour blocks and is also made up of 4 red lamps.
     */
    @Test
    fun testHoursSecondRow() {
        val clock0Lights = berlinClock.getClock(5, 0, 0)
        val clock1Lights = berlinClock.getClock(16, 0, 0)
        val clock2Lights = berlinClock.getClock(7, 0, 0)
        val clock3Lights = berlinClock.getClock(3, 0, 0)
        val clock4Lights = berlinClock.getClock(19, 0, 0)

        val result0Lights = IntArray(5)
        val result1Lights = IntArray(5)
        val result2Lights = IntArray(5)
        val result3Lights = IntArray(5)
        val result4Lights = IntArray(5)

        for (i in 0..3) {
            result0Lights[i] = berlinClock.getStateHours(clock0Lights!![2], i + 1)
            result1Lights[i] = berlinClock.getStateHours(clock1Lights!![2], i + 1)
            result2Lights[i] = berlinClock.getStateHours(clock2Lights!![2], i + 1)
            result3Lights[i] = berlinClock.getStateHours(clock3Lights!![2], i + 1)
            result4Lights[i] = berlinClock.getStateHours(clock4Lights!![2], i + 1)
        }

        /** 0 lights on */
        assertEquals(0, result0Lights[0])
        assertEquals(0, result0Lights[1])
        assertEquals(0, result0Lights[2])
        assertEquals(0, result0Lights[3])

        /** 1 light on */
        assertEquals(1, result1Lights[0])
        assertEquals(0, result1Lights[1])
        assertEquals(0, result1Lights[2])
        assertEquals(0, result1Lights[3])

        /** 2 lights on */
        assertEquals(1, result2Lights[0])
        assertEquals(1, result2Lights[1])
        assertEquals(0, result2Lights[2])
        assertEquals(0, result2Lights[3])

        /** 3 lights on */
        assertEquals(1, result3Lights[0])
        assertEquals(1, result3Lights[1])
        assertEquals(1, result3Lights[2])
        assertEquals(0, result3Lights[3])

        /** 4 lights on */
        assertEquals(1, result4Lights[0])
        assertEquals(1, result4Lights[1])
        assertEquals(1, result4Lights[2])
        assertEquals(1, result4Lights[3])
    }

    /**
    The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow.
     */

    @Test
    fun testMinutesFirstRow() {
        val clock0Lights = berlinClock.getClock(0, 0, 0)
        val clock1Lights = berlinClock.getClock(0, 5, 0)
        val clock2Lights = berlinClock.getClock(0, 10, 0)
        val clock3Lights = berlinClock.getClock(0, 15, 0)
        val clock4Lights = berlinClock.getClock(0, 20, 0)
        val clock5Lights = berlinClock.getClock(0, 25, 0)
        val clock6Lights = berlinClock.getClock(0, 30, 0)
        val clock7Lights = berlinClock.getClock(0, 35, 0)
        val clock8Lights = berlinClock.getClock(0, 40, 0)
        val clock9Lights = berlinClock.getClock(0, 45, 0)
        val clock10Lights = berlinClock.getClock(0, 50, 0)
        val clock11Lights = berlinClock.getClock(0, 55, 0)

        val result0Lights = IntArray(12)
        val result1Lights = IntArray(12)
        val result2Lights = IntArray(12)
        val result3Lights = IntArray(12)
        val result4Lights = IntArray(12)
        val result5Lights = IntArray(12)
        val result6Lights = IntArray(12)
        val result7Lights = IntArray(12)
        val result8Lights = IntArray(12)
        val result9Lights = IntArray(12)
        val result10Lights = IntArray(12)
        val result11Lights = IntArray(12)

        for (i in 0..10) {
            result0Lights[i] = berlinClock.getStateM5(clock0Lights!![3], i + 1)
            result1Lights[i] = berlinClock.getStateM5(clock1Lights!![3], i + 1)
            result2Lights[i] = berlinClock.getStateM5(clock2Lights!![3], i + 1)
            result3Lights[i] = berlinClock.getStateM5(clock3Lights!![3], i + 1)
            result4Lights[i] = berlinClock.getStateM5(clock4Lights!![3], i + 1)
            result5Lights[i] = berlinClock.getStateM5(clock5Lights!![3], i + 1)
            result6Lights[i] = berlinClock.getStateM5(clock6Lights!![3], i + 1)
            result7Lights[i] = berlinClock.getStateM5(clock7Lights!![3], i + 1)
            result8Lights[i] = berlinClock.getStateM5(clock8Lights!![3], i + 1)
            result9Lights[i] = berlinClock.getStateM5(clock9Lights!![3], i + 1)
            result10Lights[i] = berlinClock.getStateM5(clock10Lights!![3], i + 1)
            result11Lights[i] = berlinClock.getStateM5(clock11Lights!![3], i + 1)
        }

        /** 0 lights on */
        assertEquals(0, result0Lights[0])
        assertEquals(0, result0Lights[1])
        assertEquals(0, result0Lights[2])
        assertEquals(0, result0Lights[3])
        assertEquals(0, result0Lights[4])
        assertEquals(0, result0Lights[5])
        assertEquals(0, result0Lights[6])
        assertEquals(0, result0Lights[7])
        assertEquals(0, result0Lights[8])
        assertEquals(0, result0Lights[9])
        assertEquals(0, result0Lights[10])
        assertEquals(0, result0Lights[11])

        /** 1 light on */
        assertEquals(1, result1Lights[0])
        assertEquals(0, result1Lights[1])
        assertEquals(0, result1Lights[2])
        assertEquals(0, result1Lights[3])
        assertEquals(0, result1Lights[4])
        assertEquals(0, result1Lights[5])
        assertEquals(0, result1Lights[6])
        assertEquals(0, result1Lights[7])
        assertEquals(0, result1Lights[8])
        assertEquals(0, result1Lights[9])
        assertEquals(0, result1Lights[10])

        /** 2 lights on */
        assertEquals(1, result2Lights[0])
        assertEquals(1, result2Lights[1])
        assertEquals(0, result2Lights[2])
        assertEquals(0, result2Lights[3])
        assertEquals(0, result2Lights[4])
        assertEquals(0, result2Lights[5])
        assertEquals(0, result2Lights[6])
        assertEquals(0, result2Lights[7])
        assertEquals(0, result2Lights[8])
        assertEquals(0, result2Lights[9])
        assertEquals(0, result2Lights[10])
        assertEquals(0, result2Lights[11])

        /** 3 lights on */
        assertEquals(1, result3Lights[0])
        assertEquals(1, result3Lights[1])
        assertEquals(1, result3Lights[2])
        assertEquals(0, result3Lights[3])
        assertEquals(0, result3Lights[4])
        assertEquals(0, result3Lights[5])
        assertEquals(0, result3Lights[6])
        assertEquals(0, result3Lights[7])
        assertEquals(0, result3Lights[8])
        assertEquals(0, result3Lights[9])
        assertEquals(0, result3Lights[10])
        assertEquals(0, result3Lights[11])

        /** 4 lights on */
        assertEquals(1, result4Lights[0])
        assertEquals(1, result4Lights[1])
        assertEquals(1, result4Lights[2])
        assertEquals(1, result4Lights[3])
        assertEquals(0, result4Lights[4])
        assertEquals(0, result4Lights[5])
        assertEquals(0, result4Lights[6])
        assertEquals(0, result4Lights[7])
        assertEquals(0, result4Lights[8])
        assertEquals(0, result4Lights[9])
        assertEquals(0, result4Lights[10])
        assertEquals(0, result4Lights[11])

        /** 5 lights on */
        assertEquals(1, result5Lights[0])
        assertEquals(1, result5Lights[1])
        assertEquals(1, result5Lights[2])
        assertEquals(1, result5Lights[3])
        assertEquals(1, result5Lights[4])
        assertEquals(0, result5Lights[5])
        assertEquals(0, result5Lights[6])
        assertEquals(0, result5Lights[7])
        assertEquals(0, result5Lights[8])
        assertEquals(0, result5Lights[9])
        assertEquals(0, result5Lights[10])
        assertEquals(0, result5Lights[11])

        /** 6 lights on */
        assertEquals(1, result6Lights[0])
        assertEquals(1, result6Lights[1])
        assertEquals(1, result6Lights[2])
        assertEquals(1, result6Lights[3])
        assertEquals(1, result6Lights[4])
        assertEquals(1, result6Lights[5])
        assertEquals(0, result6Lights[6])
        assertEquals(0, result6Lights[7])
        assertEquals(0, result6Lights[8])
        assertEquals(0, result6Lights[9])
        assertEquals(0, result6Lights[10])
        assertEquals(0, result6Lights[11])

        /** 7 lights on */
        assertEquals(1, result7Lights[0])
        assertEquals(1, result7Lights[1])
        assertEquals(1, result7Lights[2])
        assertEquals(1, result7Lights[3])
        assertEquals(1, result7Lights[4])
        assertEquals(1, result7Lights[5])
        assertEquals(1, result7Lights[6])
        assertEquals(0, result7Lights[7])
        assertEquals(0, result7Lights[8])
        assertEquals(0, result7Lights[9])
        assertEquals(0, result7Lights[10])
        assertEquals(0, result7Lights[11])

        /** 8 lights on */
        assertEquals(1, result8Lights[0])
        assertEquals(1, result8Lights[1])
        assertEquals(1, result8Lights[2])
        assertEquals(1, result8Lights[3])
        assertEquals(1, result8Lights[4])
        assertEquals(1, result8Lights[5])
        assertEquals(1, result8Lights[6])
        assertEquals(1, result8Lights[7])
        assertEquals(0, result8Lights[8])
        assertEquals(0, result8Lights[9])
        assertEquals(0, result8Lights[10])
        assertEquals(0, result8Lights[11])

        /** 9 lights on */
        assertEquals(1, result9Lights[0])
        assertEquals(1, result9Lights[1])
        assertEquals(1, result9Lights[2])
        assertEquals(1, result9Lights[3])
        assertEquals(1, result9Lights[4])
        assertEquals(1, result9Lights[5])
        assertEquals(1, result9Lights[6])
        assertEquals(1, result9Lights[7])
        assertEquals(1, result9Lights[8])
        assertEquals(0, result9Lights[9])
        assertEquals(0, result9Lights[10])
        assertEquals(0, result9Lights[11])

        /** 10 lights on */
        assertEquals(1, result10Lights[0])
        assertEquals(1, result10Lights[1])
        assertEquals(1, result10Lights[2])
        assertEquals(1, result10Lights[3])
        assertEquals(1, result10Lights[4])
        assertEquals(1, result10Lights[5])
        assertEquals(1, result10Lights[6])
        assertEquals(1, result10Lights[7])
        assertEquals(1, result10Lights[8])
        assertEquals(1, result10Lights[9])
        assertEquals(0, result10Lights[10])
        assertEquals(0, result10Lights[11])

        /** 11 lights on */
        assertEquals(1, result11Lights[0])
        assertEquals(1, result11Lights[1])
        assertEquals(1, result11Lights[2])
        assertEquals(1, result11Lights[3])
        assertEquals(1, result11Lights[4])
        assertEquals(1, result11Lights[5])
        assertEquals(1, result11Lights[6])
        assertEquals(1, result11Lights[7])
        assertEquals(1, result11Lights[8])
        assertEquals(1, result11Lights[9])
        assertEquals(1, result11Lights[10])
    }

    /**
     * The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps.
     */
    @Test
    fun testMinutesSecondRow() {
        val clock0Lights = berlinClock.getClock(0, 15, 0)
        val clock1Lights = berlinClock.getClock(0, 6, 0)
        val clock2Lights = berlinClock.getClock(0, 27, 0)
        val clock3Lights = berlinClock.getClock(0, 38, 0)
        val clock4Lights = berlinClock.getClock(0, 59, 0)

        val result0Lights = IntArray(5)
        val result1Lights = IntArray(5)
        val result2Lights = IntArray(5)
        val result3Lights = IntArray(5)
        val result4Lights = IntArray(5)

        for (i in 0..3) {
            result0Lights[i] = berlinClock.getStateM1(clock0Lights!![4], i + 1)
            result1Lights[i] = berlinClock.getStateM1(clock1Lights!![4], i + 1)
            result2Lights[i] = berlinClock.getStateM1(clock2Lights!![4], i + 1)
            result3Lights[i] = berlinClock.getStateM1(clock3Lights!![4], i + 1)
            result4Lights[i] = berlinClock.getStateM1(clock4Lights!![4], i + 1)
        }

        /** 0 lights on */
        assertEquals(0, result0Lights[0])
        assertEquals(0, result0Lights[1])
        assertEquals(0, result0Lights[2])
        assertEquals(0, result0Lights[3])

        /** 1 light on */
        assertEquals(1, result1Lights[0])
        assertEquals(0, result1Lights[1])
        assertEquals(0, result1Lights[2])
        assertEquals(0, result1Lights[3])

        /** 2 lights on */
        assertEquals(1, result2Lights[0])
        assertEquals(1, result2Lights[1])
        assertEquals(0, result2Lights[2])
        assertEquals(0, result2Lights[3])

        /** 3 lights on */
        assertEquals(1, result3Lights[0])
        assertEquals(1, result3Lights[1])
        assertEquals(1, result3Lights[2])
        assertEquals(0, result3Lights[3])

        /** 4 lights on */
        assertEquals(1, result4Lights[0])
        assertEquals(1, result4Lights[1])
        assertEquals(1, result4Lights[2])
        assertEquals(1, result4Lights[3])
    }
}