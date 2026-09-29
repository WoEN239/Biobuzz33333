package org.firstinspires.ftc.teamcode.modules.intake

import com.acmerobotics.dashboard.config.Config

@Config
object ConfigIntake {
    object Front {
        @JvmField var power: Double = 1.0
        @JvmField var maxAmps: Double = 3.0
        @JvmField var backPower: Double = -0.3
    }

    object Side {
        @JvmField var power: Double = 1.0
    }
}
