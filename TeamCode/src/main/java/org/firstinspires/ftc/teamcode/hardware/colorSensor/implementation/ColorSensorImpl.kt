package org.firstinspires.ftc.teamcode.hardware.colorSensor.implementation

import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.I2cAddr
import org.firstinspires.ftc.teamcode.hardware.colorSensor.interfaces.ColorSensor

class ColorSensorImpl(name: String, hardwareMap: HardwareMap): ColorSensor {

    private val sensor = hardwareMap.get(com.qualcomm.robotcore.hardware.ColorSensor::class.java, name)

    override fun alpha(): Int {
        return sensor.alpha()
    }

    override fun argb(): Int {
        return sensor.argb()
    }

    override fun blue(): Int {
        return sensor.blue()
    }

    override fun red(): Int {
        return sensor.red()
    }

    override fun green(): Int {
        return sensor.green()
    }

    override fun enableLed(enable: Boolean) {
        sensor.enableLed(enable)
    }

    override fun getI2cAddress(): I2cAddr? {
        return sensor.i2cAddress
    }

    override fun setI2cAddress(address: I2cAddr?) {
        sensor.i2cAddress = address
    }
}