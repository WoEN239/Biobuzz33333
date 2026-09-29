package org.firstinspires.ftc.teamcode.hardware.colorSensor.interfaces

import com.qualcomm.robotcore.hardware.I2cAddr

interface ColorSensor {
    fun alpha(): Double
    fun argb(): Double
    fun blue(): Double
    fun red(): Double
    fun green(): Double
    fun enableLed(enable: Boolean)
    fun getI2cAddress(): I2cAddr?
    fun setI2cAddress(address: I2cAddr?)
}