package org.firstinspires.ftc.teamcode.hardware.motor.interfaces

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit

interface Motor {
    fun setPower(power: Double)
    fun getVelocity(): Double
    fun setZeroPowerBehavior(behavior: DcMotor.ZeroPowerBehavior?)
    fun setDirection(direction: DcMotorSimple.Direction?)
    fun getCurrent(amps: CurrentUnit): Double
    fun getPosition(): Double
    fun setMode(runMode: DcMotor.RunMode?)
    fun reset()
}