/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hands.on5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vdgp_
 */
public class GradientDescent {

        public ArrayList<Integer> x = new ArrayList<Integer>(List.of(3,6,9,12,15,18,21,24,27));
        public ArrayList<Integer> y = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,8,9));
        public double beta0 = 0;
        public double beta1 = 0;
        public double Result = 0;
        public double xValue  = 0;
        public double n = Double.valueOf(x.size());

        public void LinearRegression() {
            Result = beta0 + (beta1* xValue);
        }

        public void gradientDescent() {
            beta0 = 0.0;
            beta1 = 0.0;
            //ratio de aprendizaje, la distancia que se recorrera en cada iteracion
            double alpha = 0.0005;
             //Mientras que el calculo sea mayor que 0
            while (calculateValues() > 0.0001){
                //derivadas 
                double tempB0 = 0.0;
                double tempB1 = 0.0;
                for(int i =0; i < n; i++) {
                    tempB0 +=  (y.get(i) - (beta0 + beta1 * x.get(i)));
                    tempB1 += ((x.get(i) * (y.get(i) - (beta0 + beta1 * x.get(i)))));
                }

                tempB0 *= (-2/n);
                tempB1 *= (-2/n);

                beta0 -= (alpha * tempB0);
                beta1 -= (alpha * tempB1);
            }
        }

        public void setXvalue(double x) {
            this.xValue = x;
        }
         //se calculan los datos ya existentes
        public double calculateValues() {
            double temp= 0.0;
            for(int i = 0; i < n; i++){
                temp += (y.get(i) - (beta0 + (beta1*x.get(i))));
            }
            return (temp*temp) * (1.0/n);
        }


        public double getResult() {
            return Result;
        }

        public double getxValue() {
            return xValue;
        }

        public double getBeta0() {
            return beta0;
        }

        public double getBeta1() {
            return beta1;
        }

    }