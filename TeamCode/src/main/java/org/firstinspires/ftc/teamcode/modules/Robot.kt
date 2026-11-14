package org.firstinspires.ftc.teamcode.modules

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.teamcode.hardware.Factory
import org.firstinspires.ftc.teamcode.hardware.motor.implementation.MotorImpl
import org.firstinspires.ftc.teamcode.hardware.motor.interfaces.Motor
import org.firstinspires.ftc.teamcode.modules.driveTrain.DriveTrain
import org.firstinspires.ftc.teamcode.modules.flow.Flow
import org.firstinspires.ftc.teamcode.modules.gun.ConfigGun
import org.firstinspires.ftc.teamcode.modules.gun.GunControl
import org.firstinspires.ftc.teamcode.modules.gun.shooter.ConfigFlywheel
import org.firstinspires.ftc.teamcode.modules.gun.shooter.Flywheel
import org.firstinspires.ftc.teamcode.modules.gun.turret.Turret
import org.firstinspires.ftc.teamcode.modules.intake.Intake

class Robot(private val hardwareMap: HardwareMap) {
    val factory = Factory(hardwareMap)

    inner class Gun {
        val flywheelMotor = factory.createMotor("flywheel", DcMotorSimple.Direction.FORWARD,
            DcMotor.RunMode.RUN_WITHOUT_ENCODERS, DcMotor.ZeroPowerBehavior.FLOAT)
        val turretServo = factory.createServo("turret")
        val turret = Turret(turretServo)
        val flywheel = Flywheel(flywheelMotor)
        val gunControl = GunControl(flywheel, turret)
    }

    inner class Transfer {
        val intakeMotor = factory.createMotor("intake", DcMotorSimple.Direction.FORWARD,
            DcMotor.RunMode.RUN_WITHOUT_ENCODERS, DcMotor.ZeroPowerBehavior.BRAKE)

        val flowMotor = factory.createMotor("flow", DcMotorSimple.Direction.FORWARD,
            DcMotor.RunMode.RUN_WITHOUT_ENCODERS, DcMotor.ZeroPowerBehavior.BRAKE)
//        val leftServoIntake = factory.createServo("lsi")
//        val rightServoIntake = factory.createServo("rsi")
        val door = factory.createServo("door")
        val intake = Intake(intakeMotor)
        val flow = Flow(flowMotor)
    }

    inner class DriveTrain {
        val frontRightMotor = factory.createMotor("fr", DcMotorSimple.Direction.FORWARD,
            DcMotor.RunMode.RUN_WITHOUT_ENCODERS, DcMotor.ZeroPowerBehavior.BRAKE)
        val frontLeftMotor = factory.createMotor("fl", DcMotorSimple.Direction.FORWARD,
            DcMotor.RunMode.RUN_WITHOUT_ENCODERS, DcMotor.ZeroPowerBehavior.BRAKE)
        val backRightMotor = factory.createMotor("br", DcMotorSimple.Direction.FORWARD,
            DcMotor.RunMode.RUN_WITHOUT_ENCODERS, DcMotor.ZeroPowerBehavior.BRAKE)
        val backLeftMotor = factory.createMotor("bl", DcMotorSimple.Direction.FORWARD,
            DcMotor.RunMode.RUN_WITHOUT_ENCODERS, DcMotor.ZeroPowerBehavior.BRAKE)
        val pinpoint = factory.createPinpoint("pinpoint")
        val driveTrain = DriveTrain(frontLeftMotor, frontRightMotor,
            backLeftMotor, backRightMotor, pinpoint)
    }


}