package org.firstinspires.ftc.teamcode.modules.gun

import com.acmerobotics.dashboard.config.Config


@Config
object ConfigGun {
    @JvmField var minDistanceClose = 12.0
    @JvmField var maxDistanceClose = 50.0
    @JvmField var minDistanceFar = 100.0
    @JvmField var maxDistanceFar = 133.0
    @JvmField var xHiveBack = 0.0
    @JvmField var yHiveBack = 0.0
    @JvmField var xHiveFront = 0.0
    @JvmField var yHiveFront = 0.0


}