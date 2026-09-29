package org.firstinspires.ftc.teamcode.util.pid

class PIDRegulator {
    var kP: Double = 1.0
    var kI: Double = 1.0
    var kD: Double = 1.0
    var err: Double = 0.0
    var errOld: Double = 0.0
    var integral: Double = 0.0

    constructor(kP: Double, kI: Double, kD: Double) {
        this.kP = kP
        this.kI = kI
        this.kD = kD
    }

    constructor(pidCoefficients: PIDCoefficients) {
        this.kP = pidCoefficients.p
        this.kI = pidCoefficients.i
        this.kD = pidCoefficients.d
    }

    fun setPID(kP: Double, kI: Double, kD: Double) {
        this.kP = kP
        this.kI = kI
        this.kD = kD
    }

    fun getPID(input: Double, setpoint: Double): Double {
        val err: Double = setpoint - input
        val d: Double = err - this.errOld
        val i = this.integral
        this.integral += err
        this.errOld = err
        return err * kP + d * kD + i * kI
    }

    fun getPID(err: Double): Double {
        val d: Double = err - this.errOld
        val i = this.integral
        this.integral += err
        this.errOld = err
        return err * kP + d * kD + i * kI
    }
}