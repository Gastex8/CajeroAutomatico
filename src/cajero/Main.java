/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import cajero.Metodos;
import javax.swing.JOptionPane;

/**
 *
 * @author Gastex
 */
public class Main {

    public static boolean condicion = true;     // Variable global booleana para el bucle del login

    public static void setCondicion(boolean condicion) {
        Main.condicion = condicion;
    }

    public static boolean isCondicion() {
        return condicion;
    }

    public static void main(String[] args) {
        String u = "gaston";                // Inicializar el usuario
        String p = "1234";                  // Inicializar la contraseña
        String user;                        // Variable para leer usuario por teclado
        String pass;                        // Variable para leer contraseña por teclado

        Metodos obj = new Metodos();        // Creacion de objeto para llamar al metodo menu

        do {
            
            condicion = true;               // Para poder salir y volver a loguearme
            JOptionPane.showMessageDialog(null, "Bienvenido, Inicie Sesion");   // Cartel para iniciar sesion
            user = JOptionPane.showInputDialog("Usuario: ");                    // Cartel para ingresar usuario

            if (user.equals("0")) {
                JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto!"); // Si se ingresa un 0 se sale del programa
                System.out.println("Salió");
                System.exit(0);

            }

            pass = JOptionPane.showInputDialog("Contraseña: ");                 // Cartel para ingresar contraseña

            if (user.equals(u) && pass.equals(p)) {                             // Verificar si el usuario y contraseña ingresados son iguales a los inicializados
                System.out.println("Inició Sesión");
                JOptionPane.showMessageDialog(null, "Bienvenido: " + u);        // Si son iguales se ingresa al sistema con msje de bienvenida
                while (condicion == true) {                                             
                    obj.menu();                                                 // LLamar al objeto del metodo menu

                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña invalida", "Error!", JOptionPane.ERROR_MESSAGE);    // Msje en el caso que se ingrese usuario y/o contraseña invalida
            }

        } while (true);                                                         // Repetir el bucle mientras se mantenga la condicion

    }
}
