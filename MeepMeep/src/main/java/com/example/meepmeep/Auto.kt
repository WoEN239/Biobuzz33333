package com.example.meepmeep

import com.acmerobotics.roadrunner.Pose2d
import com.acmerobotics.roadrunner.Vector2d
import com.noahbres.meepmeep.MeepMeep
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object Auto {
    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty("sun.java2d.opengl", "true");
        val meepMeep = MeepMeep(800)

        val myBot = DefaultBotBuilder(meepMeep)
            .setConstraints(60.0, 60.0, Math.toRadians(180.0), Math.toRadians(180.0), 15.0)
            .setStartPose(Pose2d(40.0, -62.0, Math.toRadians(0.0)))
            .build()

        myBot.runAction(
            myBot.drive.actionBuilder(Pose2d(40.0, -62.0, Math.toRadians(0.0)))
                .strafeTo(Vector2d(60.0, -62.0))
                .waitSeconds(2.0)
                .setTangent(Math.toRadians(90.0))
//                .splineToSplineHeading(Pose2d(0.0, -45.0, Math.toRadians(-90.0)), Math.toRadians(180.0))
//                .setTangent(Math.toRadians(180.0))
                .strafeTo(Vector2d(-11.0, -42.0,))
                .splineToSplineHeading(Pose2d(-54.0, -24.0, Math.toRadians(-90.0)), Math.toRadians(180.0))
                .waitSeconds(2.0)
                .setTangent(Math.toRadians(-90.0))
                .splineToSplineHeading(Pose2d(23.0, -53.0, Math.toRadians(-90.0)), Math.toRadians(90.0))
                .waitSeconds(2.0)
                .strafeTo(Vector2d(54.0, -24.0))
                .waitSeconds(2.0)
                .build()
        )

        var biobuzzField: BufferedImage? = null

        val projectRoot = File(System.getProperty("user.dir")).parentFile ?: File(System.getProperty("user.dir"))


        val foundFile = projectRoot.walkTopDown().firstOrNull { it.name == "biobuzz_field.png" }

        biobuzzField = ImageIO.read(foundFile)

        if (biobuzzField == null) {
            biobuzzField = BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB)
            val g = biobuzzField.createGraphics()
            g.color = Color(30, 30, 30)
            g.fillRect(0, 0, 800, 800)
            g.color = Color(0, 200, 0)
            g.drawRect(10, 10, 780, 780)
            g.dispose()
        }

        meepMeep.setBackground(biobuzzField)
            .setDarkMode(true)
            .setBackgroundAlpha(0.95f)
            .addEntity(myBot)
            .start()
    }
}