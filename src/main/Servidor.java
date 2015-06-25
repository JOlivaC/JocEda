/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Xarxa.Servidor.Escoltador;
import java.util.Scanner;

/**
 *
 * @author JOAN
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Escoltador().start();
        Scanner in = new Scanner(System.in);
        while (in.nextLine().compareTo("exit") != 0);
    }
    
}
