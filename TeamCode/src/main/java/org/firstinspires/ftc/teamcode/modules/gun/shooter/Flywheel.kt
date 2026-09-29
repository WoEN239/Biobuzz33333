package org.firstinspires.ftc.teamcode.modules.gun.shooter

import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor
import org.firstinspires.ftc.teamcode.hardware.servo.intefaces.Servo
import org.firstinspires.ftc.teamcode.util.pid.PIDCoefficients
import org.firstinspires.ftc.teamcode.util.pid.PIDRegulator
import kotlin.math.max
import kotlin.math.min

class Flywheel(private val flywheel: Motor, private val coefficients: PIDCoefficients) {
    val pid = PIDRegulator(coefficients)
    var currentTPS = 0.0
    var filteredTPS = 0.0
    var targetTPS = 0.0

    fun setTargetTSP(speed: Double) {
        targetTPS = speed
    }

    fun getTargetTPS(): Double {
        return targetTPS
    }

    fun getCurrentTPS(): Double {
        return currentTPS
    }

    fun update() {
        currentTPS = flywheel.getVelocity()
        filteredTPS = currentTPS * 0.9 + filteredTPS * 0.1

        val err: Double = targetTPS - filteredTPS
        val power: Double = targetTPS * ConfigFlywheel.feedforward + err * ConfigFlywheel.kP
        flywheel.setPower(max(-1.0, min(1.0, power)))
    }
}