package org.firstinspires.ftc.teamcode.hardware

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver
import com.qualcomm.hardware.limelightvision.Limelight3A
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
//import org.firstinspires.ftc.teamcode.hardware.analogInput.implemetation.AnalogInputImpl
import org.firstinspires.ftc.teamcode.hardware.analogInput.intefaces.AnalogInput
import org.firstinspires.ftc.teamcode.hardware.colorSensor.implementation.ColorSensorImpl
import org.firstinspires.ftc.teamcode.hardware.colorSensor.interfaces.ColorSensor
import org.firstinspires.ftc.teamcode.hardware.motor.implementation.MotorImpl
import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor
import org.firstinspires.ftc.teamcode.hardware.servo.implementation.ServoImpl
import org.firstinspires.ftc.teamcode.hardware.servo.intefaces.Servo

class Factory(private val hardwareMap: HardwareMap) {
    fun createMotor(name: String, direction: DcMotorSimple.Direction,
                    mode: DcMotor.RunMode,
                    behavior: DcMotor.ZeroPowerBehavior): Motor {
        val motor: Motor = MotorImpl(name, hardwareMap)
        motor.setZeroPowerBehavior(behavior)
        motor.setMode(mode)
        motor.setDirection(direction)
        return motor
    }

    fun createServo(name: String): Servo {
        val servo: Servo = ServoImpl(name, hardwareMap)
        return servo
    }

    fun createPinpoint(name: String): GoBildaPinpointDriver {
        val pinpoint: GoBildaPinpointDriver =
            hardwareMap.get(GoBildaPinpointDriver::class.java, name);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
        return pinpoint
    }

    fun createLimelight(name: String): Limelight3A {
        val limelight = hardwareMap.get(Limelight3A::class.java, name)
        return limelight
    }

    fun createColorSensor(name: String): ColorSensor {
        val colorSensor = ColorSensorImpl(name, hardwareMap)
        return colorSensor
    }

//    fun createAnalogInput(name: String): AnalogInput {
//        val analogInput = AnalogInputImpl(name, hardwareMap)
//        return analogInput
//    }

}