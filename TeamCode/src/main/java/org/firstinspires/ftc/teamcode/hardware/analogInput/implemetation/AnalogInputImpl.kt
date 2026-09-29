package org.firstinspires.ftc.teamcode.hardware.analogInput.implemetation

import com.qualcomm.robotcore.hardware.AnalogInput
import com.qualcomm.robotcore.hardware.HardwareMap

class AnalogInputImpl(hardwareMap: HardwareMap, name: String?) :
    org.firstinspires.ftc.teamcode.hardware.analogInput.intefaces.AnalogInput {
    private val analogInput: AnalogInput

    init {
        this.analogInput = hardwareMap.get(AnalogInput::class.java, name)
    }

    override fun getValue(): Double {
        return analogInput.getVoltage()
    }
}