package com.dukecompany.mavenproject;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class DataReader {

    // clay
    String csvPath = "/Users/isaacduke/Desktop/CV_ 9_6_40knots_2018-07-05_165459.csv";

    public List<Double> timeList = new ArrayList<Double>();
    public List<Double> escList = new ArrayList<Double>();
    public List<Double> accXList = new ArrayList<Double>();
    public List<Double> accYList = new ArrayList<Double>();
    public List<Double> accZList = new ArrayList<Double>();
    public List<Double> torqueList = new ArrayList<Double>();
    public List<Double> thrustList = new ArrayList<Double>();
    public List<Double> voltageList = new ArrayList<Double>();
    public List<Double> currentList = new ArrayList<Double>();
    public List<Double> speedElectricalList = new ArrayList<Double>();
    public List<Double> speedOpticalList = new ArrayList<Double>();
    public List<Double> electricalPowerInList = new ArrayList<Double>();
    public List<Double> mechanicalPowerOutList = new ArrayList<Double>();
    public List<Double> efficiencyMotorList = new ArrayList<Double>();
    public List<Double> efficiencyPropellerList = new ArrayList<Double>();
    public List<Double> efficiencyOverallList = new ArrayList<Double>();
    public List<Double> airspeedList = new ArrayList<Double>();
    public List<Double> airspeedPressureList = new ArrayList<Double>();
    public List<Double> vibrationList = new ArrayList<Double>();
    public List<Double> temperatureList = new ArrayList<Double>();


    public void ReadData() throws FileNotFoundException {

        File f = new File(csvPath);
        Scanner s = new Scanner(f);
        s.nextLine(); // skips header

        while (s.hasNext()) {

            String line = s.nextLine();
            String[] values = line.split(",");
// column A Time
            String time_S = values[0];
            //System.out.println(timeS);
            double time_V = Double.valueOf(time_S.trim());
            timeList.add(time_V);
// column B ESC signal μs
            String esc_S = values[1];
            double esc_V = Double.valueOf(esc_S.trim());
            escList.add(esc_V);
//accX
            String accX_S = values[5];
            double accX_V = Double.valueOf(accX_S.trim());
            accXList.add(accX_V);
//accY
            String accY_S = values[6];
            double accY_V = Double.valueOf(accY_S.trim());
            accYList.add(accY_V);
//accZ
            String accZ_S = values[7];
            double accZ_V = Double.valueOf(accZ_S.trim());
            accZList.add(accZ_V);
//torque_lbf_in convert to lbf-ft
            String torque_S = values[8];
            double torque_V = Double.valueOf(torque_S.trim());
            torqueList.add(torque_V);
//netThrust_lbf
            String thrust_S = values[9];
            double thrust_V = Double.valueOf(thrust_S.trim());
            thrustList.add(thrust_V);
//voltage_V
            String voltage_S = values[10];
            double voltage_V = Double.valueOf(voltage_S.trim());
            voltageList.add(voltage_V);
//current_A Check on this
            String current_S = values[11];
            double current_V = Double.valueOf(current_S.trim());
            currentList.add(current_V);
//speedElectrical_RPM
            String speedElectrical_S = values[12];
            double speedElectrical_V = Double.valueOf(speedElectrical_S.trim());
            speedElectricalList.add(speedElectrical_V);
//speedOptical_RPM
            String speedOptical_S = values[13];
            double speedOptical_V = Double.valueOf(speedOptical_S.trim());
            speedOpticalList.add(speedOptical_V);
//electricalPowerIn
            String electricalPowerIn_S = values[14];
            double electricalPowerIn_V = Double.valueOf(electricalPowerIn_S.trim());
            electricalPowerInList.add(electricalPowerIn_V);
//mechanicalPowerOut
            String mechanicalPowerOut_S = values[15];
            double mechanicalPowerOut_V = Double.valueOf(mechanicalPowerOut_S.trim());
            mechanicalPowerOutList.add(mechanicalPowerOut_V);
//efficiencyMotor_%
            String efficiencyMotor_S = values[16];
            double efficiencyMotor_V = Double.valueOf(efficiencyMotor_S.trim());
            efficiencyMotorList.add(efficiencyMotor_V);
//efficiencyPropeller_lbf_W
            String efficiencyPropeller_S = values[17];
            double efficiencyPropeller_V = Double.valueOf(efficiencyPropeller_S.trim());
            efficiencyPropellerList.add(efficiencyPropeller_V);
//efficiencyOverall
            String efficiencyOverall_S = values[18];
            double efficiencyOverall_V = Double.valueOf(efficiencyOverall_S.trim());
            efficiencyOverallList.add(efficiencyOverall_V);
//velocityAirSpeed_ft_s
            String airspeed_S = values[19];
            double airspeed_V = Double.valueOf(airspeed_S.trim());
            airspeedList.add(airspeed_V);
//pressureAirSpeed_Pa
            String airspeedPressure_S = values[20];
            double airspeedPressure_V = Double.valueOf(airspeedPressure_S.trim());
            airspeedPressureList.add(airspeedPressure_V);
//vibration_g
            String vibration_S = values[25];
            double vibration_V = Double.valueOf(vibration_S.trim());
            vibrationList.add(vibration_V);
//temp79AF_Far
            String temperature_F_S = values[35];
            double temperature_F_V = Double.valueOf(temperature_F_S.trim());
            temperatureList.add(temperature_F_V);
        }

/** Check that output matches excel calculator's output

//        System.out.println("timeList = " + timeList);
//        System.out.println("escList = " + escList);
//        System.out.println("accXList = " + accXList);
//        System.out.println("accYList = " + accYList);
//        System.out.println("accZList = " + accZList);
//        System.out.println("torqueList = " + torqueList);
//        System.out.println("thrustList = " + thrustList);
//        System.out.println("voltageList = " + voltageList);
//        System.out.println("currentList = " + currentList);
//        System.out.println("speedElectricalList = " + speedElectricalList);
//        System.out.println("speedOpticalList = " + speedOpticalList);
//        System.out.println("electricalPowerInList = " + electricalPowerInList);
//        System.out.println("mechanicalPowerOutList = " + mechanicalPowerOutList);
//        System.out.println("efficiencyMotorList = " + efficiencyMotorList);
//        System.out.println("efficiencyPropellerList = " + efficiencyPropellerList);
//        System.out.println("efficiencyOverallList = " + efficiencyOverallList);
//        System.out.println("airspeedList = " + airspeedList);
//        System.out.println("airspeedPressureList = " + airspeedPressureList);
//        System.out.println("vibrationList = " + vibrationList);
//        System.out.println("temperatureList = " + temperatureList);
        Check values with excel calculator **/


//////////////////////////////// Getters //////////////////////////////////////////

    }

    public List<Double> getTimeList() {
        return timeList;
    }

    public List<Double> getEscList() {
        return escList;
    }

    public List<Double> getVoltageList() {
        return voltageList;
    }

    public List<Double> getCurrentList() {
        return currentList;
    }

    public List<Double> getAccXList() {
        return accXList;
    }

    public List<Double> getAccYList() {
        return accYList;
    }

    public List<Double> getAccZList() {

        return accZList;
    }
    public List<Double> getSpeedOpticalList() {
        return speedOpticalList;
    }
    public List<Double> getMechanicalPowerOutList() {
        return mechanicalPowerOutList;
    }
    public List<Double> getElectricalPowerInList() {
        return electricalPowerInList;
    }
    public List<Double> getTorqueList() {
        return torqueList;
    }
    public List<Double> getThrustList() {
        return thrustList;
    }
    public List<Double> getSpeedElectricalList() {
        return speedElectricalList;
    }
    public List<Double> getEfficiencyMotorList() {
        return efficiencyMotorList;
    }
    public List<Double> getTemperatureList() {
        return temperatureList;
    }
    public List<Double> getEfficiencyOverallList() {
        return efficiencyOverallList;
    }
    public List<Double> getEfficiencyPropellerList() {
        return efficiencyPropellerList;
    }
    public List<Double> getAirspeedList() {
        return airspeedList;
    }
    public List<Double> getAirspeedPressureList() {
        return airspeedPressureList;
    }

    public List<Double> getVibrationList() {
        return vibrationList;
    }

    }
