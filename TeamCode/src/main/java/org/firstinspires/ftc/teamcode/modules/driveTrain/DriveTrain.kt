package org.firstinspires.ftc.teamcode.modules.driveTrain

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver
import com.qualcomm.robotcore.hardware.IMU
import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

class DriveTrain(private val leftFront: Motor, private val rightFront: Motor,
                 private val leftBack: Motor, private val rightBack: Motor,
                 private val pinpoint: GoBildaPinpointDriver) {
    fun fieldCentricToRobotCentric(powerYField: Double, powerXField: Double, yawDeg: Double): DoubleArray {
        val yawRad = Math.toRadians(yawDeg)
        val powerXRobot: Double = powerXField * cos(yawRad) - powerYField * sin(yawRad)
        val powerYRobot: Double = powerXField * sin(yawRad) + powerYField * cos(yawRad)
        return doubleArrayOf(powerXRobot, powerYRobot)
    }

    fun moveToDirection(forward: Double, horizontal: Double, heading: Double) {
        var fl = forward + horizontal + heading
        var fr = forward - horizontal - heading
        var bl = forward - horizontal + heading
        var br = forward + horizontal - heading
        val maxPower: Double = max(
            max(abs(fl), abs(bl)),
            max(abs(br), abs(fr)))
        if (maxPower > 1.0) {
            fl /= maxPower
            fr /= maxPower
            bl /= maxPower
            br /= maxPower
        }
        leftFront.setPower(fl)
        rightFront.setPower(fr)
        leftBack.setPower(bl)
        rightBack.setPower(br)
    }

}