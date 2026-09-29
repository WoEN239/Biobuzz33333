package org.firstinspires.ftc.teamcode.modules.flow

import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor

class Flow(private val flowMotor: Motor) {
    fun setPower(power: Double) {
        ConfigFlow.power = power
    }

    fun update() {
        flowMotor.setPower(ConfigFlow.power)
    }

}dd