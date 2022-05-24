/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hands.on5;

/**
 *
 * @author vdgp_
 */


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HandsOn5 extends Agent {

    

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        public void action() {
            GradientDescent  linear = new GradientDescent ();
            linear.setXvalue(Integer.valueOf(JOptionPane.showInputDialog("Insert value for X: ")));
            linear.gradientDescent();
            linear.LinearRegression();
            System.out.println("y = Beta0: " + String.valueOf(linear.getBeta0()) +
                    " + (" + " Beta1: "+String.valueOf(linear.getBeta1()) +
                    ")("+String.valueOf(linear.getxValue()) + ")");
            System.out.println("y = " + String.valueOf(linear.getResult()));
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

    }    // END of inner class ...Behaviour
}