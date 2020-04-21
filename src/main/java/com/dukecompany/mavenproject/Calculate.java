package com.dukecompany.mavenproject;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Calculate
{

    ////////////////  java built-in variables  //////////////////////////
    final double pi = Math.PI;
    ////////////  make these inputs to the GUI  ////////////////
    final double sigma = 1.02589;
    final double ro = 0.0023769;
    final double roPi3_8 = 0.00921235238017558;
    final double D = 0.75; // units in ft
    final double Kr = 0.75; // TODO: how do we get this term?
    final int length = 11;
    final double Dinst_q = 0.05825318;
    final double dBetao = 0.57;
    final double diameter = 9;
    final double pitch = 6;
    final double P_D = pitch/diameter;
    final double Beta75r = Math.atan(P_D/(Kr*pi)) * (180/pi) + dBetao;
    final double CrR_dp = 0.103/2; //?
    final double Rn_IV = 6360.16452844311; //?
    final double CrR = D * CrR_dp;
    ////////////////////////////////////////////////////////////////////

        public List<Double> VoInitialList = new ArrayList<Double>();

        public void VoInitial (List < Double > airspeedList, List < Double > thrustList)
        {
// TODO: sqrt((airspeedList^2 + (8/(pi*ro*sigma*D^2)*(thrustList/sigma))-airspeedList)/2

            int ii = 0;
            while (ii < length) {
                double VoInitial = (Math.sqrt(Math.pow(airspeedList.get(ii), 2) + (8 / (pi * ro * Math.pow(D, 2))) * (thrustList.get(ii) / sigma)) - airspeedList.get(ii)) / 2;
                VoInitialList.add(VoInitial);
                ii++;
                //System.out.println(Vo_int);
            }
//            System.out.println();
//            System.out.println("Vo_intList = " + VoInitialList);
        }

        List<Double> VoIterList1 = new ArrayList<Double>();
        List<Double> VoIterList2 = new ArrayList<Double>();
        List<Double> VoIterList3 = new ArrayList<Double>();
        List<Double> VoIterList4 = new ArrayList<Double>();
        List<Double> VoIterList5 = new ArrayList<Double>();
        List<Double> VoIterList6 = new ArrayList<Double>();
        List<Double> VoIterList7 = new ArrayList<Double>();
        List<Double> VoIterList8 = new ArrayList<Double>();
        List<Double> VoIterList9 = new ArrayList<Double>();
        public List<Double> VoIterList10 = new ArrayList<Double>();

    public void VoIterate (List < Double > airspeedList, List < Double > thrustList, List < Double > VoInitialList)
        {
            int ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoInitialList.get(ii));
                double VoIter1 = ((airspeedList.get(ii) + VoInitialList.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList1.add(VoIter1);
                ii++;
            }
            //System.out.println("VoIterList1 = " + VoIterList1);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList1.get(ii));
                double VoIter2 = ((airspeedList.get(ii) + VoIterList1.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList2.add(VoIter2);
                ii++;
            }
            //System.out.println("VoIterList2 = " + VoIterList2);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList2.get(ii));
                double VoIter3 = ((airspeedList.get(ii) + VoIterList2.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList3.add(VoIter3);
                ii++;
            }
            //System.out.println("VoIterList3 = " + VoIterList3);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList3.get(ii));
                double VoIter4 = ((airspeedList.get(ii) + VoIterList3.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList4.add(VoIter4);
                ii++;
            }
            //System.out.println("VoIterList4 = " + VoIterList4);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList4.get(ii));
                double VoIter5 = ((airspeedList.get(ii) + VoIterList4.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList5.add(VoIter5);
                ii++;
            }
            //System.out.println("VoIterList5 = " + VoIterList5);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList5.get(ii));
                double VoIter6 = ((airspeedList.get(ii) + VoIterList5.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList6.add(VoIter6);
                ii++;
            }
            //System.out.println("VoIterList6 = " + VoIterList6);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList6.get(ii));
                double VoIter7 = ((airspeedList.get(ii) + VoIterList6.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList7.add(VoIter7);
                ii++;
            }
            //System.out.println("VoIterList7 = " + VoIterList7);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList7.get(ii));
                double VoIter8 = ((airspeedList.get(ii) + VoIterList7.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList8.add(VoIter8);
                ii++;
            }
            //System.out.println("VoIterList8 = " + VoIterList8);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList8.get(ii));
                double VoIter9 = ((airspeedList.get(ii) + VoIterList8.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList9.add(VoIter9);
                ii++;
            }
            //System.out.println("VoIterList9 = " + VoIterList9);

            ii = 0;
            while (ii < length) {
                double ASL_VOINIT = (airspeedList.get(ii) + VoIterList9.get(ii));
                double VoIter10 = ((airspeedList.get(ii) + VoIterList9.get(ii)) / (pi * Math.pow(D, 2))) * (Dinst_q + thrustList.get(ii) / ((sigma / 841.43) * Math.pow(ASL_VOINIT, 2)));
//            System.out.println(VoIter);
                VoIterList10.add(VoIter10);
                ii++;
            }
//            System.out.println("VoIterList10 = " + VoIterList10);
        }

        //TODO: ///////////////////////////////////////////
        /** units from lbf*in --> lbf*ft
         * need conditional for the case units come in lbf*ft
         */
        //TODO: ///////////////////////////////////////////

        public List<Double> torqueList_lbfFt = new ArrayList<Double>();

        public void ConvertUnits (List < Double > torqueList)
        {
            int ii = 0;
            while (ii < 11) {
                double torque = torqueList.get(ii) / 12;
                ii++;
                torqueList_lbfFt.add(torque);
            }
        }

        public List<Double> inducedQoList = new ArrayList<Double>();


    public void freestreamInducedQo (List < Double > voIterList10, List < Double > airspeedList)
        {
            int ii = 0;
            while (ii < length) {
                double term = voIterList10.get(ii) + airspeedList.get(ii);
                double inducedQo = (sigma / 841.43) * (Math.pow(term, 2));
                inducedQoList.add(inducedQo);
                ii++;
            }
        }


        public List<Double> dInstList = new ArrayList<Double>();

    public void Dinst (List < Double > inducedQoList)
        {
            int ii = 0;
            while (ii < length) {
                double dInst = Dinst_q * inducedQoList.get(ii);
                dInstList.add(dInst);
                ii++;
            }
        }

        public List<Double> grossThrustList = new ArrayList<Double>();

        public void GrossThrust (List < Double > dInstList, List < Double > thrustList)
        {
            int ii = 0;
            while (ii < length) {
                double grossThrust = dInstList.get(ii) + thrustList.get(ii);
                grossThrustList.add(grossThrust);
                ii++;
            }
        }

        public List<Double> T_QList = new ArrayList<Double>();



    public void T_Q (List < Double > grossThrustList, List < Double > torqueList_lbfFt)
        {
            int ii = 0;
            while (ii < length) {
                double t_q = grossThrustList.get(ii) / torqueList_lbfFt.get(ii);
                T_QList.add(t_q);
                ii++;
            }
        }

        public List<Double> eFFEList = new ArrayList<Double>();

    public void ElectricalForwardFlightEfficiency
        (List < Double > grossThrustList, List < Double > airspeedList, List < Double > electricalPowerInList)
        {
            int ii = 0;
            while (ii < length) {
                double eFFE = (100 * 745.6 * grossThrustList.get(ii) * airspeedList.get(ii)) / (electricalPowerInList.get(ii) * 550);
                eFFEList.add(eFFE);
                ii++;
            }
        }

        public List<Double> nRev_SecList = new ArrayList<Double>();


    public void NRev_Sec (List < Double > speedOpticalList)
        {
            int ii = 0;
            while (ii < length) {
                double nRev_Sec = speedOpticalList.get(ii) / 60;
                nRev_SecList.add(nRev_Sec);
                ii++;
            }
        }

    public List<Double> getnRev_SecList() {
        return nRev_SecList;
    }

    public List<Double> rad_SecList = new ArrayList<Double>();

    public void Rad_Sec (List < Double > nRev_SecList)
        {
            int ii = 0;
            while (ii < length) {
                double rad_Sec = nRev_SecList.get(ii) * 2 * pi;
                rad_SecList.add(rad_Sec);
                ii++;
            }
        }
    public List<Double> getRad_SecList() {
        return rad_SecList;
    }

        public List<Double> qOmegaList = new ArrayList<Double>();

    public void Q_Omega (List < Double > rad_SecList, List < Double > torqueList_lbfFt)
        {
            int ii = 0;
            while (ii < length) {
                double qOmega = rad_SecList.get(ii) * torqueList_lbfFt.get(ii);
                qOmegaList.add(qOmega);
                ii++;
            }
        }
    public List<Double> getqOmegaList() {
        return qOmegaList;
    }

        public List<Double> pInList = new ArrayList<Double>();

    public void P_In (List < Double > voltageList, List < Double > currentList)
        {
            int ii = 0;
            while (ii < length) {
                double pIn = voltageList.get(ii) * currentList.get(ii) * (550 / 745.7);
                pInList.add(pIn);
                ii++;
            }
        }
    public List<Double> getpInList() {
        return pInList;
    }

        public List<Double> nPList = new ArrayList<Double>();

    public void PropellerEfficiency
        (List < Double > grossThrustList, List < Double > airspeedList, List < Double > qOmegaList)
        {
            int ii = 0;
            while (ii < length) {
                double nP = grossThrustList.get(ii) * airspeedList.get(ii) / qOmegaList.get(ii);
                nPList.add(nP);
                ii++;
            }
        }

        public List<Double> getnPList() {
        return nPList;
    }

        public List<Double> grossThrustCalList = new ArrayList<Double>();

    public void GrossThrustCal (List < Double > thrustNetList, List < Double > inducedQoList)
        {
            int ii = 0;
            while (ii < length) {
                double grossThrustCal = thrustNetList.get(ii) + Dinst_q * inducedQoList.get(ii);
                grossThrustCalList.add(grossThrustCal);
                ii++;
            }
        }
    public List<Double> getGrossThrustCalList() {
        return grossThrustCalList;
    }

        public List<Double> v75rList = new ArrayList<Double>();

    public void V75r (List < Double > airspeedList, List < Double > VoIterList10, List < Double > rad_SecList)
        {
            int ii = 0;
            while (ii < length) {
                double term1 = airspeedList.get(ii) + VoIterList10.get(ii);
                double term2 = Kr * D / 2 * rad_SecList.get(ii);
                double v75r = Math.sqrt(Math.pow(term1, 2) + Math.pow(term2, 2));
                v75rList.add(v75r);
                ii++;
            }
        }
    public List<Double> getV75rList() {
        return v75rList;
    }

        public List<Double> vvo_V75rList = new ArrayList<Double>();

    public void VVo_V75r (List < Double > airspeedList, List < Double > VoIterList10, List < Double > rad_SecList)
        {
            int ii = 0;
            while (ii < length) {
                double vvo_V75r = (airspeedList.get(ii) + VoIterList10.get(ii)) / (Kr * (D / 2) * rad_SecList.get(ii));
                vvo_V75rList.add(vvo_V75r);
                ii++;
            }
        }
    public List<Double> getVvo_V75rList() {
        return vvo_V75rList;
    }

        public List<Double> phi75rList = new ArrayList<Double>();

    public void Phi75r (List < Double > vvo_V75rList)
        {
            int ii = 0;
            while (ii < length) {
                double phi75r = Math.atan(vvo_V75rList.get(ii)) * (180 / pi);
                phi75rList.add(phi75r);
                ii++;
            }
        }

    public List<Double> getPhi75rList() {
        return phi75rList;
    }

        public List<Double> alpha75rList = new ArrayList<Double>();

    public void Alpha75r (List < Double > phi75rList)
        {
            int ii = 0;
//            System.out.println("P_D = " + P_D);
//            System.out.println("Beta75r = " + Beta75r);
            while (ii < length) {
                double alpha75r = Beta75r - phi75rList.get(ii);
                alpha75rList.add(alpha75r);
                ii++;
            }
        }
    public List<Double> getAlpha75rList() {
        return alpha75rList;
    }

        public List<Double> sinPhiList = new ArrayList<Double>();

    public void SinPhi (List < Double > phi75rList)
        {
            int ii = 0;
            while (ii < length) {
                double sinPhi = Math.sin(phi75rList.get(ii) * pi / 180);
                sinPhiList.add(sinPhi);
                ii++;
            }
        }

    public List<Double> getSinPhiList() {
        return sinPhiList;
    }

        public List<Double> cosPhiList = new ArrayList<Double>();

    public void CosPhi (List < Double > phi75rList)
        {
            int ii = 0;
            while (ii < length) {
                double cosPhi = Math.cos(phi75rList.get(ii) * pi / 180);
                cosPhiList.add(cosPhi);
                ii++;
            }
        }

    public List<Double> getCosPhiList() {
        return cosPhiList;
    }

        public List<Double> qSDiskList = new ArrayList<Double>();

    public void QSDisk (List < Double > nRev_SecList, List < Double > cosPhiList)
        {
            int ii = 0;
            while (ii < length) {
                double term1 = Kr * nRev_SecList.get(ii) * Math.pow(D, 2) / cosPhiList.get(ii);
                double qSDisk = roPi3_8 * sigma * Math.pow(term1, 2);
                qSDiskList.add(qSDisk);
                ii++;
            }
        }
    public List<Double> getqSDiskList() {
        return qSDiskList;
    }

        public List<Double> frList = new ArrayList<Double>();

    public void Fr (List < Double > torqueList)
        {
            int ii = 0;
            while (ii < length) {
                double fr = 2 * torqueList.get(ii) / (Kr * D);
                frList.add(fr);
                ii++;
            }
        }
    public List<Double> getFrList() {
        return frList;
    }

        public List<Double> fr_TgList = new ArrayList<Double>();

    public void Fr_Tg (List < Double > Fr, List < Double > grossThrustCalList)
        {
            int ii = 0;
            while (ii < length) {
                double fr_Tg = Fr.get(ii) / grossThrustCalList.get(ii);
                fr_TgList.add(fr_Tg);
                ii++;
            }
        }

    public List<Double> getFr_TgList() {
        return fr_TgList;
    }

    public List<Double> tg_FrList = new ArrayList<Double>();

    public void Tg_Fr (List < Double > fr_TgList)
    {
        int ii = 0;
        while (ii < length) {
            double tg_Fr =  1/fr_TgList.get(ii);
            tg_FrList.add(tg_Fr);
            ii++;
        }
    }

    public List<Double> getTg_FrList() {
        System.out.println(tg_FrList);
        return tg_FrList;
    }

        public List<Double> d_LList = new ArrayList<Double>();

    public void D_L (List < Double > Fr_TgList, List < Double > cosPhiList, List < Double > sinPhiList)
        {
            int ii = 0;
            while (ii < length) {
                double d_L = Fr_TgList.get(ii) - sinPhiList.get(ii) / cosPhiList.get(ii);
                d_LList.add(d_L);
                ii++;
            }
        }

    public List<Double> getD_LList() {
        return d_LList;
    }

        public List<Double> l_DList = new ArrayList<Double>();

    public void L_D (List < Double > d_LList)
        {
            int ii = 0;
            while (ii < length) {
                double l_D = 1 / d_LList.get(ii);
                l_DList.add(l_D);
                ii++;
            }
        }

    public List<Double> getL_DList() {
        return l_DList;
    }


    public List<Double> cldiskList = new ArrayList<Double>();

    public void CLdisk
        (List < Double > frList, List < Double > qSDiskList, List < Double > cosPhiList, List < Double > sinPhiList, List < Double > grossThrustCalList)
        {
            int ii = 0;
            while (ii < length) {
                double cldisk = (frList.get(ii) * sinPhiList.get(ii) + grossThrustCalList.get(ii) * cosPhiList.get(ii)) / qSDiskList.get(ii);
                cldiskList.add(cldisk);
                ii++;
            }
        }

    public List<Double> getCldiskList() {
        return cldiskList;
    }

    public List<Double> cddiskList = new ArrayList<Double>();
        public void CDdisk (List < Double > l_DList, List < Double > cldiskList)
        {
            int ii = 0;
            while (ii < length) {
                double cddisk = cldiskList.get(ii) / l_DList.get(ii);
                cddiskList.add(cddisk);
                ii++;
            }
        }

    public List<Double> getCddiskList() {
        return cddiskList;
    }

    public List<Double> cldisk2List = new ArrayList<Double>();
        public void CLdisk2 (List < Double > cldiskList)
        {
            int ii = 0;
            while (ii < length) {
                double cldisk2 = Math.pow(cldiskList.get(ii), 2);
                cldisk2List.add(cldisk2);
                ii++;
            }
        }


    public List<Double> getCldisk2List() {
        return cldisk2List;
    }


    public List<Double> rnList = new ArrayList<Double>();

    public void Rn (List < Double > v75rList)
        {
            int ii = 0;
            while (ii < length) {
                double rn = Rn_IV * CrR * v75rList.get(ii);
                rnList.add(rn);
                ii++;
            }
        }

    public List<Double> getRnList() {
        return rnList;
    }

    /////////////////// Getters ////////////////////////////////////
        public List<Double> getGrossThrustList () {
            System.out.println(grossThrustList);
            return grossThrustList;
        }

        public List<Double> getInducedQoList() {
            return inducedQoList;
        }

    public List<Double> getVoIterList10() {
        return VoIterList10;
    }

    public List<Double> getdInstList() {
        return dInstList;
    }
    public List<Double> getT_QList() {
        return T_QList;
    }
    public List<Double> geteFFEList() {
        return eFFEList;
    }


} /** End Of Function -----------------------------------

    /*List<Double> ListName = new ArrayList<Double>();

    public void className(List<Double> ListIn)
    {
        int ii = 0;
        while (ii<length) {
            double term = equation;
            termList.add(term);
            ii++;
        }
    }*/


