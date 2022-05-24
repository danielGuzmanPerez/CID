/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hands.on7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vdgp_
 */
public class LogistR {

        public ArrayList<Double> x1 = new ArrayList<Double>(List.of(780.0,750.0,690.0,710.0,680.0,730.0,690.0,720.0,740.0));
        public ArrayList<Double> x2 = new ArrayList<Double>(List.of(4.0,3.9,3.3,3.7,3.9,3.7,2.3,3.3,3.3));
        public ArrayList<Double> x3 = new ArrayList<Double>(List.of(3.0,4.0,3.0,5.0,4.0,6.0,1.0,4.0,5.0));
        public ArrayList<Double> w = new ArrayList<Double>(List.of(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        public double y1 = 1;
        public double y2 = 1;
        public double y3 = 0;
        public double y4 = 1;
        public double y5 = 0;
        public double y6 = 1;
        public double y7 = 0;
        public double y8 = 1;
        public double y9 = 1;
        
        
        public double rep  = 100;
        public double lrp = 0.1;


        public void LogisticRegression() {
            for(int i = 0; i < rep; i++){
                //funciones sigmoideales
                double sigmoide1 = cal(x1);
                double sigmoide2 = cal(x2);
                double sigmoide3 = cal(x3);
                // se asigna el valor de las w's
                w.set(0, w.get(0) - (lrp*(((sigmoide1-y1)*x1.get(0)) + ((sigmoide2-y2)*x2.get(0)) + ((sigmoide3-y3)*x3.get(0)))));
                w.set(1, w.get(1) - (lrp*(((sigmoide1-y1)*x1.get(1)) + ((sigmoide2-y2)*x2.get(1)) + ((sigmoide3-y3)*x3.get(1)))));
                w.set(2, w.get(2) - (lrp*(((sigmoide1-y1)*x1.get(2)) + ((sigmoide2-y2)*x2.get(2)) + ((sigmoide3-y3)*x3.get(2)))));
                 
           }
        }
                //calcular sigmoide
        public double cal(List<Double> x){
            return (1.0/(1.0+Math.exp(-((w.get(0))+(w.get(1)*x.get(1))+(w.get(2)*x.get(2))))));
        }

        public double getw0(){
            return  w.get(0);
        }

        public double getw1(){
            return w.get(1);
        }

        public double getw2(){
            return w.get(2);
        }

    }