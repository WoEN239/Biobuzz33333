package org.firstinspires.ftc.teamcode.hardware.colorSensor.interfaces

import com.qualcomm.robotcore.hardware.I2cAddr

interface ColorSensor {
    fun alpha(): Int
    fun argb(): Int
    fun blue(): Int
    fun red(): Int
    fun green(): Int
    fun enableLed(enable: Boolean)
    fun getI2cAddress(): I2cAddr?
    fun setI2cAddress(address: I2cAddr?)
}