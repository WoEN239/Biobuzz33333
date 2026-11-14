package org.firstinspires.ftc.teamcode.modules.gun

import org.firstinspires.ftc.teamcode.modules.gun.shooter.ConfigFlywheel
import org.firstinspires.ftc.teamcode.modules.gun.shooter.Flywheel
import org.firstinspires.ftc.teamcode.modules.gun.turret.Turret

class GunControl(private val flywheel: Flywheel, private val turret: Turret) {
    fun setSpeedFromDistanceClose(distance: Double) {
        val speed = (ConfigFlywheel.minSpeedClose + (distance - ConfigGun.minDistanceClose) *
                (ConfigFlywheel.maxSpeedClose - ConfigFlywheel.minSpeedClose)
                / (ConfigGun.maxDistanceClose - ConfigGun.minDistanceClose));
        flywheel.setTargetTPS(speed)
    }

    fun setSpeedFromDistanceFar(distance: Double) {
        if (distance > ConfigGun.maxDistanceFar) { val speed = ConfigFlywheel.maxSpeedFar }
        else {
            val speed = (ConfigFlywheel.minSpeedFar + (distance - ConfigGun.minDistanceFar) *
                    (ConfigFlywheel.maxSpeedFar - ConfigFlywheel.minSpeedFar)
                    / (ConfigGun.maxDistanceFar - ConfigGun.minDistanceFar));
            flywheel.setTargetTPS(speed)
        }
    }

    fun aimToHive(dx: Double, dy: Double, yawRobot: Double) {
        val angleTurret = Math.atan2(dy, dx)
        turret.setAngle(angleTurret - yawRobot)
    }
}