package org.firstinspires.ftc.teamcode.modules.gun.shooter

import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor
import kotlin.math.max
import kotlin.math.min

class Flywheel(private val flywheel: Motor) {
    var currentTPS = 0.0
        private set

    var filteredTPS = 0.0
        private set

    var tarTPS = 0.0

    fun setTargetTPS(speed: Double) {
        tarTPS = speed
    }

    fun update() {
        currentTPS = flywheel.getVelocity()
        filteredTPS = currentTPS * 0.9 + filteredTPS * 0.1

        val err: Double = tarTPS - filteredTPS
        val power: Double = tarTPS * ConfigFlywheel.feedforward + err * ConfigFlywheel.kP
        flywheel.setPower(max(-1.0, min(1.0, power)))
    }
}
