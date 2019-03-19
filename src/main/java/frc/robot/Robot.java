package frc.robot;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Robot extends TimedRobot {
  AnalogInput input;
  int channel = 0;
  @Override
  public void robotInit() {
    //put which port you plugs into roborio
    input = new AnalogInput(channel);
    CameraServer.getInstance().startAutomaticCapture();
  }
  @Override
  public void teleopInit() {
    SmartDashboard.setDefaultNumber("distance", 0);
  }

  @Override
  public void teleopPeriodic() {
    double rawVoltage = input.getVoltage();
    double distance = rawVoltage/0.008543;
    System.out.println(rawVoltage);
    SmartDashboard.putNumber("distance", distance);
  }



}
