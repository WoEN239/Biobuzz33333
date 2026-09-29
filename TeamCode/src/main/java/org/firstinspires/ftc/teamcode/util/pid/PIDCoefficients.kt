package org.firstinspires.ftc.teamcode.util.pid

class PIDCoefficients {
    var p: Double
    var i: Double
    var d: Double

    constructor() {
        this.p = 1.0
        this.i = 1.0
        this.d = 1.0
    }

    constructor(kP: Double, kI: Double, kD: Double) {
        this.p = kP
        this.i = kI
        this.d = kD
    }
}