package org.firstinspires.ftc.teamcode.hardware.servo.implementation

import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.teamcode.hardware.servo.intefaces.Servo

class ServoImpl(name: String, hardwareMap: HardwareMap) : Servo {
    private val servo: com.qualcomm.robotcore.hardware.Servo
    init {
        servo = hardwareMap.get(com.qualcomm.robotcore.hardware.Servo::class.java, name)
    }
    override fun setPosition(position: Double) {
        servo.setPosition(position)
    }
}