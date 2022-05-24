/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hands.on8;

/**
 *
 * @author vdgp_
 */
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import javax.swing.*;
import java.util.*;



public class HandsOn8 extends Agent {

    //    INICIO DE CLASE PERSONA, DONDE SE ALMACENARA LOS DATOS DE LA TABLA QUE NOS PROPORCIONO EN CLASSROOM
    public class Planta implements Comparable<Planta> {
        //Target
        private String Specie     = "";
        
        private double Altura   = 0.0;
        private double Ancho     = 0.0;
        private Double Distancia = 0.0;

        public Planta(double Altura, double Ancho, String Specie) {
            this.Ancho   = Ancho;
            this.Altura = Altura;
            this.Specie   = Specie;
        }

        public Planta() {
        }

        public void setAncho(double Ancho) {
            this.Ancho = Ancho;
        }

        public void setAltura(double Altura) {
            this.Altura = Altura;
        }

        public void setSpecie(String Specie) {
            this.Specie = Specie;
        }

        public double getAncho() {
            return Ancho;
        }

        public double getAltura() {
            return Altura;
        }

        public String getSpecie() {
            return Specie;
        }

        public void setDistancia(Double Distancia) {
            this.Distancia = Distancia;
        }

        public Double getDistancia() {
            return Distancia;
        }

        public int compareTo(Planta x) {
            return Distancia.compareTo(x.getDistancia());
        }
    }
// FIN DE CLASE PERSONA

//    INICIO DE CLASE KNN DONDE SE LLEVARA ACABO EL ALGORIMTO KNN

    public class KNearestNeighbors {

        public ArrayList<Planta> Planta = new ArrayList<Planta>(List.of(new Planta(5.3, 3.7, "Setosa"), new Planta(5.1, 3.8, "Setosa"),
                new Planta(7.2, 3.0, "Virginica"), new Planta(5.4, 3.4, "Setosa"),
                new Planta(5.1, 3.3, "Setosa"), new Planta(5.4, 3.9, "Setosa"),
                new Planta(7.4, 2.8, "Virginica"), new Planta(6.1, 2.8, "Verscicolor"),
                new Planta(7.3, 2.9, "Virginica"), new Planta(6.0, 2.7, "Verscicolor"),
                new Planta(5.8, 2.8, "Virginica"),new Planta(6.3, 2.3, "Verscicolor"),
                new Planta(5.1, 2.5, "Verscicolor"),new Planta(5.3, 2.5,"Verscicolor"),
                new Planta(5.5, 2.4, "Verscicolor")
        ));
        public ArrayList<Planta> PlantaNorm = new ArrayList<Planta>(List.of(new Planta(), new Planta(), new Planta(),
                new Planta(), new Planta(), new Planta(),
                new Planta(), new Planta(), new Planta(), 
                new Planta(), new Planta(),new Planta(),
                new Planta(), new Planta(), new Planta()
        
        ));
        public double k     = 2;
        public double Altura = 0.0;
        public String Specie  ="";
        public double Ancho  = 0.0;
        public double minA  = 100000.0;
        public double maxA  = 0.0;
        public double minH  = 100000.0;
        public double maxH  = 0.0;
        public int setosa=0;
        public int virginica=0;
        public int verscicolor=0;

        public void KNearestNeighbors(double Altura, double Ancho, double k) {
            this.k = k;
            this.Altura = Altura;
            this.Ancho = Ancho;
            
            
            double sum = 0.0;
            Normalizar();
            normalizeGivenValues();
            setDistances();
            Collections.sort(PlantaNorm);
            
            //Se imprimen todos los valores con su distancia 
            for (int i = 0; i < 15; i++) {
                System.out.println("planta mas cercana numero "+i+" Tipo de planta: "+PlantaNorm.get(i).getSpecie());
            }
            encontrarKMenores();
            
            if(this.setosa > this.virginica && this.setosa > this.verscicolor )
                System.out.println("Tipo de planta: Setosa");
            if( this.virginica > this.setosa && this.virginica >this. verscicolor )
                System.out.println("Tipo de planta: Virginica");
            if( this.verscicolor > this.setosa && this.verscicolor > this.virginica )
                System.out.println("Tipo de planta: Verscicolor");
            
            
           
        }
        public void encontrarKMenores(){
            for (int i = 0; i < k; i++) {
                if(PlantaNorm.get(i).getSpecie().equalsIgnoreCase("Setosa"))
                    this.setosa++;
                if(PlantaNorm.get(i).getSpecie().equalsIgnoreCase("Virginica"))
                    this.virginica++;
                if(PlantaNorm.get(i).getSpecie().equalsIgnoreCase("Verscicolor"))
                    this.verscicolor++;
            }
            
            
            
        }

        public void setDistances() {
            
            for (int i = 0; i < 15; i++) {
                PlantaNorm.get(i).setDistancia(DistanciaEuclidiana(PlantaNorm.get(i).getAltura(), PlantaNorm.get(i).getAncho()));
                
            }
        }

        public double DistanciaEuclidiana(double Altura, double Ancho) {
            return Math.sqrt((Math.pow(this.Altura - Altura, 2) + Math.pow(this.Ancho - Ancho, 2)));
        }

        public String getSpecie() {
            return Specie;
        }

        public void calculateMinMax() {
            for (int i = 0; i < 15; i++) {
                double Ancho = Planta.get(i).getAncho();
                double Altura = Planta.get(i).getAltura();
                if (Ancho < minA)
                    minA = Ancho;
                if (Ancho > maxA)
                    maxA = Ancho;
                if (Altura < minH)
                    minH = Altura;
                if (Ancho > maxH)
                    maxH = Altura;
            }
        }

        public void Normalizar() {
            calculateMinMax();
            for (int i = 0; i < 15; i++) {
                Planta planta = new Planta();
                planta.setAncho((Planta.get(i).getAncho() - minA) / (maxA - minA));
                planta.setAltura((Planta.get(i).getAltura() - minH) / (maxH - minH));
                planta.setSpecie(Planta.get(i).getSpecie());
                PlantaNorm.set(i, planta);
            }
        }

        public void normalizeGivenValues() {
            for (int i = 0; i < 15; i++) {
                Altura = ((Altura - minH) / (maxH - minH));
                Ancho = ((Ancho - minA) / (maxA - minA));
            }
        }
    }

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        public void action() {
            KNearestNeighbors KNN = new KNearestNeighbors();
            KNN.KNearestNeighbors(Double.valueOf(JOptionPane.showInputDialog("Altura : ")), Double.valueOf(JOptionPane.showInputDialog("Ancho   : ")), Double.valueOf(JOptionPane.showInputDialog("K      : ")));
            
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

    }    // END of inner class ...Behaviour
}