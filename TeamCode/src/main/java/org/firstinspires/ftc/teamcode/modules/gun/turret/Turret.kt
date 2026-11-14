package org.firstinspires.ftc.teamcode.modules.gun.turret

import org.firstinspires.ftc.teamcode.hardware.servo.intefaces.Servo
import org.firstinspires.ftc.teamcode.modules.gun.turret.ConfigTurret

class Turret(private val turretServo: Servo) {
    private var angle = 0.0
    fun setAngle(angle: Double) {
        this.angle = angle
        val position = ConfigTurret.minPositionTurret + (angle - ConfigTurret.minAngleTurret) *
                (ConfigTurret.maxPositionTurret - ConfigTurret.minPositionTurret) / (ConfigTurret.maxAngleTurret - ConfigTurret.minAngleTurret)
        turretServo.setPosition(position)
    }

    fun getAngle(): Double {
        return angle
    }
}