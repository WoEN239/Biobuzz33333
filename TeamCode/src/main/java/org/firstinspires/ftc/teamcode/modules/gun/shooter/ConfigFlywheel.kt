package org.firstinspires.ftc.teamcode.modules.gun.shooter

import com.acmerobotics.dashboard.config.Config

@Config
object ConfigFlywheel {
    @JvmField var kP = 0.0
    @JvmField var feedforward = 0.0
    @JvmField var maxSpeedClose = 1000.0
    @JvmField var minSpeedClose = 400.0
    @JvmField var maxSpeedFar = 1200.0
    @JvmField var minSpeedFar = 1300.0
    @JvmField var targetTPS = 1000.0
}