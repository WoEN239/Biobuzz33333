package org.firstinspires.ftc.teamcode.hardware.motor.implementation

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit
import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor

class MotorImpl(name: String, hardwareMap: HardwareMap) : Motor {
    private val motor: DcMotorEx 

    init {
        motor = hardwareMap.get(DcMotorEx::class.java, name)
    }

    override fun setPower(power: Double) {
        motor.power = power
    }

    override fun getVelocity(): Double {
        return motor.velocity
    }

    override fun setZeroPowerBehavior(behavior: DcMotor.ZeroPowerBehavior?) {
        motor.zeroPowerBehavior = behavior
    }

    override fun setDirection(direction: DcMotorSimple.Direction?) {
        motor.direction = direction
    }

    override fun getCurrent(amps: CurrentUnit): Double {
        return motor.getCurrent(CurrentUnit.AMPS)
    }

    override fun getPosition(): Double {
        return motor.currentPosition.toDouble()
    }

    override fun setMode(runMode: DcMotor.RunMode?) {
        motor.mode = runMode
    }

    override fun reset() {
        val currentMode = motor.mode
        motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        motor.mode = currentMode
    }
}
