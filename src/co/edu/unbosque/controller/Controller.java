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
    private int contadorPartidas;

    public Controller() {
        this.emergente = new VistaVentanaEmergente();
        this.ventana = new VistaPrincipal();
        this.tablero = new Tablero();
        this.consola = new VistaConsola();
        this.turno = "rojo"; // El juego empieza con el turno del rojo
        this.movimientosPartida = "";
        this.contadorPartidas = 1;
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
            	ventana.setVisible(false);
            	Controller c = new Controller();
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
        System.out.println(movimientosPartida);
    }

    public void cambiarColor(int fila, int columna, String color) {
        tablero.cambiarColor(fila, columna, color);
        ventana.getpTablero().cambiarColor(fila, columna, color);
    }

    public void registrarMovimiento(int fila, int columna, String color) {
        String movimiento = "Fila: " + fila + ", Columna: " + columna + ", Color: " + color;
        movimientosPartida += movimiento + "; ";
        ventana.getpHistorial().añadirMovimientos(movimiento);
    }

    public void cambiarTurno() {
        turno = turno.equals("rojo") ? "azul" : "rojo";
    }

    public void iniciarNuevaPartida() {
        // Almacenar la partida actual con un título diferenciador
        String tituloPartida = "Partida " + contadorPartidas;
        tablero.actualizarHistorial("\n" + tituloPartida + "\n" + movimientosPartida);
        contadorPartidas++;
        
        // Reiniciar el tablero y la matriz
        tablero = new Tablero();
        ventana.getpTablero().removeAll();
        ventana.getpTablero().inicializarComponentes();
        ventana.getpHistorial().añadirMovimientos("Nueva partida iniciada");
        turno = "rojo";
        movimientosPartida = "";
    }

    public void mostrarHistorial() {
    	String aux = tablero.leerHistorial();
    	
        //ventana.getpHistorial().cargarHistorial();;
    }
}