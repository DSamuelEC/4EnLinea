package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class VistaVentanaEmergente {

    public VistaVentanaEmergente() {
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
    }

    public String leerDatoString(String mensaje) {
        String aux = JOptionPane.showInputDialog(mensaje);
        System.out.println("soy el emergente " + mensaje + aux);
        return aux;
    }
}