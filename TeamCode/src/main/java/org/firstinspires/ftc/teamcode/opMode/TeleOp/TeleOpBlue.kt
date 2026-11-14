package org.firstinspires.ftc.teamcode.opMode.TeleOp

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit
import org.firstinspires.ftc.teamcode.modules.Robot
import org.firstinspires.ftc.teamcode.modules.flow.ConfigFlow
import org.firstinspires.ftc.teamcode.modules.gun.ConfigGun
import org.firstinspires.ftc.teamcode.modules.gun.shooter.ConfigFlywheel
import org.firstinspires.ftc.teamcode.modules.intake.ConfigIntake

@TeleOp(name = "TeleOpBlue", group = "TeleOp")
class TeleOpBlue : LinearOpMode() {
    private var robot: Robot = Robot(hardwareMap)
    private var xFieldRobot: Double = 0.0
    private var yFieldRobot: Double = 0.0
    private var yawFieldRobot: Double = 0.0
    private var speedFlywheel: Double = 0.0

    init {
        telemetry = MultipleTelemetry(FtcDashboard.getInstance().telemetry, telemetry)
    }

    override fun runOpMode() {
        waitForStart()
        while(opModeIsActive()) {
            xFieldRobot = robot.DriveTrain().pinpoint.position.getX(DistanceUnit.MM)
            yFieldRobot = robot.DriveTrain().pinpoint.position.getY(DistanceUnit.MM)
            yawFieldRobot = robot.DriveTrain().pinpoint.position.getHeading(AngleUnit.DEGREES)
            speedFlywheel = robot.Gun().flywheel.currentTPS

            var dx: Double
            var dy: Double

            if (xFieldRobot > 0) {
                dx = xFieldRobot - ConfigGun.xHiveBack
                dy = yFieldRobot - ConfigGun.yHiveBack
            } else {
                dx = xFieldRobot - ConfigGun.xHiveFront
                dy = yFieldRobot - ConfigGun.yHiveFront
            }
            val distance: Double = Math.hypot(dy, dx)

            val (forward, horizontal) = robot.DriveTrain().driveTrain.fieldToRobotPowers(gamepad1.left_stick_x.toDouble(), gamepad1.left_stick_y.toDouble(), yawFieldRobot + 90) ?: doubleArrayOf(0.0, 0.0)
            val turnGamepad: Double = gamepad1.right_stick_x.toDouble()
            robot.DriveTrain().driveTrain.moveToDirection(forward, horizontal, turnGamepad)
            robot.Gun().flywheel.setTargetTPS(ConfigFlywheel.targetTPS)
//            robot.Gun().gunControl.aimToHive(dx, dy, yawFieldRobot)
//            robot.Gun().gunControl.setSpeedFromDistanceFar(distance)
            if (gamepad1.left_bumper) {
                robot.Transfer().intake.setPower(ConfigIntake.Front.power)
                robot.Transfer().flow.setPower(ConfigFlow.power)
            } else {
                robot.Transfer().flow.setPower(0.0)
                robot.Transfer().intake.setPower(ConfigIntake.Front.backPower)
            }
            if (gamepad1.right_bumper) {
                robot.Transfer().intake.setPower(ConfigIntake.Front.power)
                robot.Transfer().flow.setPower(ConfigFlow.power)
                robot.Transfer().door.setPosition(ConfigFlow.openDoor)
            } else {
                robot.Transfer().door.setPosition(ConfigFlow.closeDoor)
            }
            if (gamepad1.right_trigger > 0.01) {
                robot.Transfer().intake.setPower(ConfigIntake.Front.backPower)
                robot.Transfer().flow.setPower(-ConfigFlow.power)
            }
            updateInfo()
        }
    }

    private fun updateInfo() {
        telemetry.addData("x; ", xFieldRobot)
        telemetry.addData("y: ", yFieldRobot)
        telemetry.addData("yaw: ", yawFieldRobot)
        telemetry.addData("flywheelSpeed: ", speedFlywheel)
        telemetry.update()
    }
}