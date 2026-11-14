package org.firstinspires.ftc.teamcode.opMode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit
import org.firstinspires.ftc.teamcode.modules.Robot
import org.firstinspires.ftc.teamcode.modules.flow.ConfigFlow
import org.firstinspires.ftc.teamcode.modules.gun.ConfigGun
import org.firstinspires.ftc.teamcode.modules.intake.ConfigIntake

@TeleOp(name = "TeleOpRed", group = "TeleOp")
class TeleOpRed : LinearOpMode() {
    private lateinit var robot: Robot

    override fun runOpMode() {
        robot = Robot(hardwareMap)
        waitForStart()
        while(opModeIsActive()) {
            val xFieldRobot = robot.DriveTrain().pinpoint.position.getX(DistanceUnit.MM)
            val yFieldRobot = robot.DriveTrain().pinpoint.position.getY(DistanceUnit.MM)
            val yawFieldRobot = robot.DriveTrain().pinpoint.position.getHeading(AngleUnit.DEGREES)

            var dx: Double
            var dy: Double

            if (xFieldRobot > 0) {
                dx = xFieldRobot - ConfigGun.xHiveBack
                dy = yFieldRobot + ConfigGun.yHiveBack
            } else {
                dx = xFieldRobot - ConfigGun.xHiveFront
                dy = yFieldRobot + ConfigGun.yHiveFront
            }
            val distance: Double = Math.hypot(dy, dx)

            robot.DriveTrain().driveTrain.fieldCentricToRobotCentric(yFieldRobot, xFieldRobot, yawFieldRobot - 90)
            robot.Gun().gunControl.aimToHive(dx, dy, yawFieldRobot)
            robot.Gun().gunControl.setSpeedFromDistanceFar(distance)
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
        }
    }
}