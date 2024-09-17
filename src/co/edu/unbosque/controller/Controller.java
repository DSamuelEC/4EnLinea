package co.edu.unbosque.controller;

import co.edu.unbosque.model.Tablero;
import co.edu.unbosque.view.VistaPrincipal;
import co.edu.unbosque.view.VistaVentanaEmergente;
import co.edu.unbosque.view.PanelTablero.TableroListener;
import co.edu.unbosque.view.VistaConsola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private VistaPrincipal ventana;
    private Tablero tablero;
    private VistaVentanaEmergente emergente;
    private VistaConsola consola;
    private String turno;
    private String movimientosPartida;

    public Controller() {
        this.emergente = new VistaVentanaEmergente();
        this.ventana = new VistaPrincipal();
        this.tablero = new Tablero();
        this.consola = new VistaConsola();
        this.turno = "rojo"; // El juego empieza con el turno del rojo
        movimientosPartida = "";
        asignarOyentes();
    }

    public void asignarOyentes() {
        ventana.getpTablero().setTableroListener(new TableroListener() {
            @Override
            public void celdaClickeada(int fila, int columna) {
                manejarClicEnCelda(fila, columna);
            }
        });

        ventana.getpMenu().getBtnNuevaPartida().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNuevaPartida();
            }
        });

        ventana.getpMenu().getBtnCargarHistorial().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorial();
            }
        });
    }

    public void manejarClicEnCelda(int fila, int columna) {
        if (tablero.getMatriz()[fila][columna] == null) {
            cambiarColor(fila, columna, turno);
            registrarMovimiento(fila, columna, turno);
            String ganador = tablero.verificarGanador();
            if (ganador != null) {
                emergente.mostrarInformacion("¡El ganador es " + ganador + "!");
                victoria();
            } else {
                cambiarTurno();
            }
        } else {
            emergente.mostrarInformacion("La celda ya está ocupada.");
        }
        consola.mostrarInformacion(tablero.mostrarMatriz());
    }

    public void victoria() {
        tablero.actualizarHistorial(movimientosPartida);
    }

    public void cambiarColor(int fila, int columna, String color) {
        tablero.cambiarColor(fila, columna, color);
        ventana.getpTablero().cambiarColor(fila, columna, color);
    }

    public void registrarMovimiento(int fila, int columna, String color) {
        String movimiento = "Fila: " + fila + ", Columna: " + columna + ", Color: " + color;
        movimientosPartida += movimiento + ", ";
        System.out.println(movimientosPartida);
        ventana.getpHistorial().añadirMovimientos(movimiento);
        tablero.actualizarHistorial(movimientosPartida);
    }

    public void cambiarTurno() {
        turno = turno.equals("rojo") ? "azul" : "rojo";
    }

    public void iniciarNuevaPartida() {
        tablero = new Tablero();
        ventana.getpTablero().removeAll();
        ventana.getpTablero().inicializarComponentes();
        ventana.getpHistorial().añadirMovimientos("Nueva partida iniciada");
        turno = "rojo";
    }

    public void mostrarHistorial() {
        String historial = tablero.leerHistorial();
        emergente.mostrarInformacion(historial);
    }
}