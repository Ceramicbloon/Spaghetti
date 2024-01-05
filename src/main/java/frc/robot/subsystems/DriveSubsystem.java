package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class DriveSubsystem extends SubsystemBase{
    public static class Hardware{
        WPI_TalonSRX lMasterMotor;
        WPI_TalonSRX rMasterMotor;
        WPI_TalonSRX lSlaveMotor1;
        WPI_TalonSRX rSlaveMotor1;
        WPI_TalonSRX lSlaveMotor2;
        WPI_TalonSRX rSlaveMotor2;



        public Hardware(WPI_TalonSRX lMasterMotor,
        WPI_TalonSRX rMasterMotor,
        WPI_TalonSRX lSlaveMotor1,
        WPI_TalonSRX rSlaveMotor1,
        WPI_TalonSRX lSlaveMotor2,
        WPI_TalonSRX rSlaveMotor2){

            this.lMasterMotor = lMasterMotor;
            this.rMasterMotor = rMasterMotor;
            this.lSlaveMotor1 = lSlaveMotor1;
            this.rSlaveMotor1 = rSlaveMotor1;
            this.lSlaveMotor2 = lSlaveMotor2;
            this.rSlaveMotor2 = rSlaveMotor2;

        }
    }

    private WPI_TalonSRX m_lMasterMotor;
    private WPI_TalonSRX m_rMasterMotor;
    private WPI_TalonSRX m_lSlaveMotor1;
    private WPI_TalonSRX m_rSlaveMotor1;
    private WPI_TalonSRX m_lSlaveMotor2;
    private WPI_TalonSRX m_rSlaveMotor2;

    private DifferentialDrive m_drivetrain;

    public DriveSubsystem(Hardware drivetrainHardware){
        this.m_lMasterMotor = drivetrainHardware.lMasterMotor;

        this.m_lMasterMotor = drivetrainHardware.rMasterMotor;

        this.m_lSlaveMotor1 = drivetrainHardware.lSlaveMotor1;

        this.m_rSlaveMotor1 = drivetrainHardware.rSlaveMotor1;

        this.m_lSlaveMotor2 = drivetrainHardware.lSlaveMotor2;

        this.m_rSlaveMotor2 = drivetrainHardware.rSlaveMotor2;


        m_drivetrain = new DifferentialDrive(m_lMasterMotor, m_rMasterMotor);

        m_rSlaveMotor1.setInverted(true);
        m_rSlaveMotor2.setInverted(true);
        m_rMasterMotor.setInverted(true);

        m_lSlaveMotor1.follow(m_lMasterMotor);
        m_rSlaveMotor1.follow(m_rMasterMotor);
        m_lSlaveMotor2.follow(m_lMasterMotor);
        m_rSlaveMotor2.follow(m_rMasterMotor);
    }


    public static Hardware initializeHardware(){
        Hardware drivetrainHardware = new Hardware(
            new WPI_TalonSRX(Constants.DriveHardware.LEFT_MASTER_MOTOR),
            new WPI_TalonSRX(Constants.DriveHardware.LEFT_MIDDLE_MOTOR),
            new WPI_TalonSRX(Constants.DriveHardware.LEFT_REAR_MOTOR),
            new WPI_TalonSRX(Constants.DriveHardware.RIGHT_MASTER_MOTOR),
            new WPI_TalonSRX(Constants.DriveHardware.RIGHT_MIDDLE_MOTOR),
            new WPI_TalonSRX(Constants.DriveHardware.RIGHT_REAR_MOTOR) 
            
        
            );

        return drivetrainHardware;
    }

    
    public void set(double speed, double turn){
        m_drivetrain.arcadeDrive(speed, turn);
    }

    public void stop(){
        m_drivetrain.stopMotor();
    }
    @Override
    public void periodic(){
        //sup
    }
}
