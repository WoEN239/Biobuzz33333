package org.firstinspires.ftc.teamcode.modules.gun.turret

import org.firstinspires.ftc.teamcode.hardware.servo.intefaces.Servo

class Turret(private val turretServo: Servo) {
    fun setDegree(degree: Double) {
        turretServo.setPosition(degree)
    }
}