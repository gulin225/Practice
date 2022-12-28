package org.firstinspires.ftc.teamcodekt.components

import com.qualcomm.hardware.rev.RevColorSensorV3
import com.qualcomm.robotcore.hardware.ColorSensor
import com.qualcomm.robotcore.hardware.DistanceSensor
import com.qualcomm.robotcore.hardware.HardwareMap
import ftc.rouge.blacksmith.util.kt.invoke
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive

abstract class BaseBotComponents {
    abstract val claw: Claw
    abstract val intake: Intake
    abstract val arm: Arm
    abstract val wrist: Wrist
    abstract val lift: Lift

    fun updateComponents(telemetry: Telemetry) {
        claw.update()
        arm.update()
        wrist.update()
        lift.update(telemetry)
    }
}

fun createTeleOpBotComponents(hwMap: HardwareMap, voltageScaler: VoltageScaler) =
    TeleOpBotComponents(
        hwMap(DeviceNames.COLOR_SENSOR),
        Drivetrain(hwMap),
        Claw(hwMap),
        Intake(hwMap),
        Arm(hwMap),
        Wrist(hwMap),
        Lift(hwMap, voltageScaler)
    )

data class TeleOpBotComponents(
    val rcs: RevColorSensorV3,
    val drivetrain: Drivetrain,
    override val claw: Claw,
    override val intake: Intake,
    override val arm: Arm,
    override val wrist: Wrist,
    override val lift: Lift,
) : BaseBotComponents()

fun createAutoBotComponents(hwMap: HardwareMap, voltageScaler: VoltageScaler) =
    AutoBotComponents(
        SampleMecanumDrive(hwMap),
        Claw(hwMap),
        Intake(hwMap),
        Arm(hwMap),
        Wrist(hwMap),
        Lift(hwMap, voltageScaler),
    )

data class AutoBotComponents(
    val drive: SampleMecanumDrive,
    override val claw: Claw,
    override val intake: Intake,
    override val arm: Arm,
    override val wrist: Wrist,
    override val lift: Lift,
) : BaseBotComponents()
