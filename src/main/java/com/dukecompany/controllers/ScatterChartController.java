
package com.dukecompany.controllers;

import com.dukecompany.mavenproject.Calculate;
import com.dukecompany.mavenproject.DataReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ScatterChartController implements Initializable{

        @FXML
        private NumberAxis x;

        @FXML
        private NumberAxis y;

        @FXML
        private ScatterChart<?,?> electricScatter;
        @FXML
        private ScatterChart<?,?> grossThrustScatter;
        @FXML
        private ScatterChart<?,?> motorEfficiencyScatter;
        @FXML
        private ScatterChart<?,?> grossThrustTorqueScatter;
        @FXML
        private ScatterChart<?,?> propellerEfficiencyScatter;
        @FXML
        private ScatterChart<?,?> torqueScatter;
        @FXML
        private ScatterChart<?,?> propellerEfficiencyAlphaScatter;
        @FXML
        private ScatterChart<?,?> liftCurveTgScatter;
        @FXML
        private ScatterChart<?,?> propellerEfficiencyLDScatter;
        @FXML
        private ScatterChart<?,?> dragPolarScatter;
        @FXML
        private ScatterChart<?,?> propellerEfficiencyRnScatter;
        @FXML
        private ScatterChart<?,?> L_DScatter;
        @FXML
        private ScatterChart<?,?> CDfRnScatter;
        @FXML
        private ScatterChart<?,?> linearDragPloarScatter;
        @FXML
        private ScatterChart<?,?> TgFqScatter;

        @FXML
        public ResourceBundle resources;

        @FXML
        public URL location;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                DataReader dr = new DataReader();
                try {
                        dr.ReadData();
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                Calculate cal = new Calculate();

///////////////////////////////////////////////////////////////////////////////////////////////////////
                cal.VoInitial(dr.airspeedList, dr.thrustList);
//                System.out.println("Calculated VoInitialList = " + cal.VoInitialList);

                cal.VoIterate(dr.airspeedList, dr.thrustList,cal.VoInitialList);
//                System.out.println("Calculated voIterList = " + cal.VoIterList10);

                cal.ConvertUnits(dr.torqueList);
//                System.out.println("Calculated torqueList = " + cal.torqueList_lbfFt);

                cal.freestreamInducedQo(cal.VoIterList10, dr.airspeedList);
//                System.out.println("Calculated Induced Freestream qo = "  + cal.inducedQoList);

                cal.Dinst(cal.inducedQoList);
//                System.out.println("Calculated Dinst = " + cal.dInstList);

                cal.GrossThrust(cal.dInstList, dr.thrustList);
//                System.out.println("Calculated Gross Thrust = " + cal.grossThrustList);

                cal.T_Q(cal.grossThrustList,dr.torqueList);
//                System.out.println("Calculated T_Q = " + cal.T_QList);

                cal.ElectricalForwardFlightEfficiency(cal.grossThrustList, dr.airspeedList, dr.electricalPowerInList);
//                System.out.println("Calculated Electrical Forward Flight Efficiency = " + cal.eFFEList);

                cal.NRev_Sec(dr.speedOpticalList);
//                System.out.println("Calculated NRev_Sec = " + cal.nRev_SecList);

                cal.Rad_Sec(cal.nRev_SecList);
//                System.out.println("Calculated Rad_Sec = " + cal.rad_SecList);

                // TODO: put logic in place to check the units of torque
                cal.Q_Omega(cal.rad_SecList, dr.torqueList);
//                System.out.println("Calculated Q Omega = " + cal.qOmegaList);

                cal.P_In(dr.voltageList, dr.currentList);
//                System.out.println("Calculate P_in = " + cal.pInList);

                cal.PropellerEfficiency(cal.grossThrustList, dr.airspeedList, cal.qOmegaList);
//                System.out.println("Calculate Propeller Efficiency = " + cal.nPList);

                cal.GrossThrustCal(dr.thrustList, cal.inducedQoList);
//                System.out.println("Calculate Gross Thrust Cal = " + cal.grossThrustCalList);

                cal.V75r(dr.airspeedList,cal.VoIterList10,cal.rad_SecList);
//                System.out.println("Calculate V75r = " + cal.v75rList);

                cal.VVo_V75r(dr.airspeedList,cal.VoIterList10,cal.rad_SecList);
//                System.out.println("Calculate VVo_V75r = " + cal.vvo_V75rList);

                cal.Phi75r(cal.vvo_V75rList);
//                System.out.println("Calculate phiV75r = " + cal.phi75rList);

                cal.Alpha75r(cal.phi75rList);
//                System.out.println("Calculate alphaV75r = " + cal.alpha75rList);

                cal.SinPhi(cal.phi75rList);
//                System.out.println("Calculate sinPhi = " + cal.sinPhiList);

                cal.CosPhi(cal.phi75rList);
//                System.out.println("Calculate cosPhi = " + cal.cosPhiList);

                cal.QSDisk(cal.nRev_SecList , cal.cosPhiList);
//                System.out.println("Calculate qSdisk = " + cal.qSDiskList);

                cal.Fr(dr.torqueList);
//                System.out.println("Calculate Fr = " + cal.frList);

                cal.Fr_Tg(cal.frList, cal.grossThrustCalList);
//                System.out.println("Calculate Fr/Tg = " + cal.fr_TgList);

                cal.Tg_Fr(cal.fr_TgList);

                cal.D_L(cal.fr_TgList, cal.cosPhiList, cal.sinPhiList);
//                System.out.println("Calculate D/L = " + cal.d_LList);

                cal.L_D(cal.d_LList);
//                System.out.println("Calculate L/D = " + cal.l_DList);

                cal.CLdisk(cal.frList, cal.qSDiskList, cal.cosPhiList, cal.sinPhiList, cal.grossThrustCalList);
//                System.out.println("Calculate CLDisk = " + cal.cldiskList);

                cal.CDdisk(cal.l_DList, cal.cldiskList);
//                System.out.println("Calculate CDdisk = " + cal.cddiskList);

                cal.CLdisk2(cal.cldiskList);
//                System.out.println("Calculate CLdisk2 = " + cal.cldisk2List);

                cal.Rn(cal.v75rList);
//                System.out.println("Calculate Rn = " + cal.rnList);
////////////////////////////////////////////// Current vs Voltage ////////////////////////////////////////////////////////


                ArrayList timeList = (ArrayList) dr.getTimeList();
                ArrayList escList = (ArrayList) dr.getEscList();


                ArrayList voltageList = (ArrayList) dr.getVoltageList();
                ArrayList currentList = (ArrayList) dr.getCurrentList();

                XYChart.Series series = new XYChart.Series();

                int length = 11;
                int ii = 0;
                while(ii<length) {
                        series.getData().add(new XYChart.Data(voltageList.get(ii), currentList.get(ii)));
                        ii++;
                }
                electricScatter.getData().addAll(series);
//////////////////////////////////////////// Gross Thrust vs RPM /////////////////////////////////////////////////////////////////

                ArrayList grossThrustList = (ArrayList) cal.getGrossThrustList();
                ArrayList rpmList = (ArrayList) dr.getSpeedOpticalList();

                XYChart.Series grossThrustSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        grossThrustSeries.getData().add(new XYChart.Data(rpmList.get(ii),grossThrustList.get(ii)));
                        ii++;
                }
                grossThrustScatter.getData().addAll(grossThrustSeries);
///////////////////////////////////////// Motor Efficiency vs RPM ////////////////////////////////////////////////////////////////////

                ArrayList motorEffList = (ArrayList) dr.getEfficiencyMotorList();

                XYChart.Series motorEfficiencySeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        motorEfficiencySeries.getData().add(new XYChart.Data(rpmList.get(ii), motorEffList.get(ii)));
                        ii++;
                }
                motorEfficiencyScatter.getData().addAll(motorEfficiencySeries);
///////////////////////////////////////// Gross Thrust vs RPM ////////////////////////////////////////////////////////////////////

                ArrayList torqueList = (ArrayList) dr.getTorqueList();

                XYChart.Series grossThrustTorqueSeries = new XYChart.Series();

                ii=0;
                while (ii<length){
                        grossThrustTorqueSeries.getData().add(new XYChart.Data(torqueList.get(ii), grossThrustList.get(ii)));
                        ii++;
                }
                grossThrustTorqueScatter.getData().addAll(grossThrustTorqueSeries);

///////////////////////////////////////// Propeller Efficiency  ////////////////////////////////////////////////////////////////////

                ArrayList propellerEfficiencyList = (ArrayList) cal.getnPList();

                XYChart.Series propellerEfficiencySeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        propellerEfficiencySeries.getData().add(new XYChart.Data(rpmList.get(ii), propellerEfficiencyList.get(ii)));
                        ii++;
                }
                propellerEfficiencyScatter.getData().addAll(propellerEfficiencySeries);

///////////////////////////////////////// Torque  ////////////////////////////////////////////////////////////////////

                XYChart.Series torqueSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        torqueSeries.getData().add(new XYChart.Data(rpmList.get(ii), torqueList.get(ii)));
                        ii++;
                }
                torqueScatter.getData().addAll(torqueSeries);
///////////////////////////////////////// Torque  ////////////////////////////////////////////////////////////////////

                ArrayList alphaList = (ArrayList) cal.getAlpha75rList();

                XYChart.Series propellerEfficiencyAlphaSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        propellerEfficiencyAlphaSeries.getData().add(new XYChart.Data(alphaList.get(ii), propellerEfficiencyList.get(ii)));
                        ii++;
                }
                propellerEfficiencyAlphaScatter.getData().addAll(propellerEfficiencyAlphaSeries);

///////////////////////////////////////// Lift Curve  ////////////////////////////////////////////////////////////////////

                ArrayList clDiskList = (ArrayList) cal.getCldiskList();

                XYChart.Series liftCurveTgSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        liftCurveTgSeries.getData().add(new XYChart.Data(alphaList.get(ii), clDiskList.get(ii)));
                        ii++;
                }
                liftCurveTgScatter.getData().addAll(liftCurveTgSeries);

///////////////////////////////////////// Propeller Efficiency L/D  ////////////////////////////////////////////////////////////////////

                ArrayList ldList = (ArrayList) cal.getL_DList();

                XYChart.Series propellerEfficiencyLDSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        propellerEfficiencyLDSeries.getData().add(new XYChart.Data(ldList.get(ii), propellerEfficiencyList.get(ii)));
                        ii++;
                }
                propellerEfficiencyLDScatter.getData().addAll(propellerEfficiencyLDSeries);

///////////////////////////////////////// Drag Polar  ////////////////////////////////////////////////////////////////////

                ArrayList cdDiskList = (ArrayList) cal.getCddiskList();

                XYChart.Series dragPolarSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        dragPolarSeries.getData().add(new XYChart.Data(cdDiskList.get(ii), clDiskList.get(ii)));
                        ii++;
                }
                dragPolarScatter.getData().addAll(dragPolarSeries);

///////////////////////////////////////// Propeller Efficiency Rn  ////////////////////////////////////////////////////////////////////

                ArrayList rnList = (ArrayList) cal.getRnList();

                XYChart.Series propellerEfficiencyRnSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        propellerEfficiencyRnSeries.getData().add(new XYChart.Data(rnList.get(ii), propellerEfficiencyList.get(ii)));
                        ii++;
                }
                propellerEfficiencyRnScatter.getData().addAll(propellerEfficiencyRnSeries);

///////////////////////////////////////// L/D  ////////////////////////////////////////////////////////////////////

                ArrayList L_DList = (ArrayList) cal.getL_DList();

                XYChart.Series L_DSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        L_DSeries.getData().add(new XYChart.Data(alphaList.get(ii), L_DList.get(ii)));
                        ii++;
                }
                L_DScatter.getData().addAll(L_DSeries);

///////////////////////////////////////// CD f(Rn)  ////////////////////////////////////////////////////////////////////

                XYChart.Series CDfRnSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        CDfRnSeries.getData().add(new XYChart.Data(rnList.get(ii), cdDiskList.get(ii)));
                        ii++;
                }
                CDfRnScatter.getData().addAll(CDfRnSeries);

///////////////////////////////////////// Linear Drag Polar  ////////////////////////////////////////////////////////////////////

                ArrayList clDisk2List = (ArrayList) cal.getCldisk2List();

                XYChart.Series linearDragPloarSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        linearDragPloarSeries.getData().add(new XYChart.Data(cdDiskList.get(ii), clDisk2List.get(ii)));
                        ii++;
                }
                linearDragPloarScatter.getData().addAll(linearDragPloarSeries);

///////////////////////////////////////// Tg/Fq  ////////////////////////////////////////////////////////////////////

                ArrayList TgFqList = (ArrayList) cal.getTg_FrList();

                XYChart.Series TgFqSeries = new XYChart.Series();

                ii = 0;
                while(ii<length) {
                        TgFqSeries.getData().add(new XYChart.Data(alphaList.get(ii), TgFqList.get(ii)));
                        ii++;
                }
                TgFqScatter.getData().addAll(TgFqSeries);
        }
}
