package org.firstinspires.ftc.teamcode.modules.intake

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit
import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor
import org.firstinspires.ftc.teamcode.hardware.servo.intefaces.Servo

class Intake(private val intakeMotor: Motor) {
    fun setPower(powerFront: Double) {
        ConfigIntake.Front.power = powerFront
    }

    fun update() {
        if (intakeMotor.getCurrent(CurrentUnit.AMPS) < ConfigIntake.Front.maxAmps) {
            intakeMotor.setPower(ConfigIntake.Front.power)
        } else {
            intakeMotor.setPower(ConfigIntake.Front.backPower)
        }
    }

}