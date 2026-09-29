package org.firstinspires.ftc.teamcode.modules.intake

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit
import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor
import org.firstinspires.ftc.teamcode.hardware.servo.intefaces.Servo

class Intake(private val intakeMotor: Motor,
             private val leftServo: Servo, private val rightServo: Servo) {
    fun setPower(powerFront: Double, powerSide: Double) {
        ConfigIntake.Front.power = powerFront
        ConfigIntake.Side.power = powerSide
    }

    fun update() {
        if (intakeMotor.getCurrent(CurrentUnit.AMPS) < ConfigIntake.Front.maxAmps) {
            intakeMotor.setPower(ConfigIntake.Front.power)
            leftServo.setPosition(ConfigIntake.Side.power)
            rightServo.setPosition(-ConfigIntake.Side.power)
        } else {
            intakeMotor.setPower(ConfigIntake.Front.backPower)
            leftServo.setPosition(ConfigIntake.Side.power)
            rightServo.setPosition(-ConfigIntake.Side.power)
        }
    }

}