package org.firstinspires.ftc.teamcode.Qualifier_1.Components.Navigations;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Qualifier_1.Components.Accesories.Shooter;
import org.firstinspires.ftc.teamcode.Qualifier_1.Robot;


@Autonomous(name= "track")
public class track extends LinearOpMode{
    Robot robot=new Robot();
    Odometry odom = new Odometry();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Ready to go");
        telemetry.update();
        robot.initChassis(this);
        odom.init(this);
        telemetry.addData("Status", "InitComplete, Ready to Start");
        telemetry.update();
        waitForStart();
        while(isStopRequested()==false){
            odom.track();
        }
        stop();
    }



}

