/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hands.on7;

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


public class HandsOn7 extends Agent {
    LogistR logistR;
    

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        public void action() {
             logistR = new LogistR();
            logistR.LogisticRegression();
            System.out.println("w = (   W1: " + logistR.getw0() + ",    W2: " + logistR.getw1() + ",    W3: " +  logistR.getw2() + ")");
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

    }    // END of inner class ...Behaviour
}