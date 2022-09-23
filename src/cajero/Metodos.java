/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import javax.swing.JOptionPane;

/**
 *
 * @author Gastex
 */
public class Metodos {

    int saldo = 100;                // Inicializar el saldo
    String historial = "";          // Guardar el historial de acciones realizadas

    //Menu de opciones
    public void menu() {
        String opcion = (JOptionPane.showInputDialog(null, "Seleccione una opcion: \n 1: Depositar \n 2: Retirar \n 3: Mostrar saldo \n 4: Acciones realizadas \n 5: Salir"));

        if (isNumeric(opcion) == true) {        // Si el numero ingresado es una de las opciones entra al switch, sino msje de error
            int op;
            op = Integer.parseInt(opcion);      // Convertir string a integer y almacenarlo en la variable entera

            switch (op) {                       // Switch de opciones
                case 1:
                    System.out.println("Ingresó a Depositar");
                    historial += "Depositar\n";                     // Guardar la accion en el historial
                    depositar();                                    // LLamar al metodo depositar
                    break;
                case 2:
                    System.out.println("Ingresó a Retirar");
                    historial += "Retirar\n";                       // Guardar la accion en el historial
                    retirar();                                      // LLamar al metodo retirar
                    break;
                case 3:
                    System.out.println("Ingresó a Mostrar Saldo");
                    historial += "Mostrar saldo\n";                 // Guardar la accion en el historial
                    mostrarSaldo();                                 // LLamar al metodo mostrar saldo
                    break;
                case 4:
                    accionesRealizadas();                           // LLamar al metodo acciones realizadas
                    break;
                case 5:
                    System.out.println("Cerró Sesión");
                    Main.condicion = false;                 // Cambiar la condicion 
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
        }
    }

    //Excepcion                                         // Para agarrar errores por si se colocan numeros o caracteres no validos en el menu
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    //Metodo Depositar
    public void depositar() {
        String sc;
        int deposito = 0;
        sc = (JOptionPane.showInputDialog(null, "Ingrese monto a depositar: "));
        deposito = Integer.parseInt(sc);

        if (deposito > 0) {
            saldo += deposito;
            System.out.println("Depositó: $" + deposito);
            JOptionPane.showMessageDialog(null, "Dinero depositado exitosamente\n" + "Ha depositado $" + deposito);

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un monto valido", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }
    //Metodo Retirar

    public void retirar() {
        String sc;
        int retiro = 0;
        sc = JOptionPane.showInputDialog(null, "Ingrese el monto a retirar: ");
        retiro = Integer.parseInt(sc);
        if (saldo >= retiro) {
            if (retiro > 0) {
                saldo -= retiro;
                System.out.println("Retiró: $" + retiro);
                JOptionPane.showMessageDialog(null, "Dinero retirado exitosamente\n" + "Ha retirado $" + retiro);

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un monto valido", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo Mostrar Saldo
    public void mostrarSaldo() {
        System.out.println("Mostró saldo: $" + saldo);
        JOptionPane.showMessageDialog(null, "Su saldo actual es: $" + saldo);
    }

    //Metodo Acciones Realizadas
    public void accionesRealizadas() {
        JOptionPane.showMessageDialog(null, "Acciones realizadas: \n" + historial);
    }
}
