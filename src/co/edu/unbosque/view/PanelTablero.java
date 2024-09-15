package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTablero extends JPanel {

    private JLabel[][] matrizJL;
    private TableroListener listener;

    public PanelTablero() {
        setLayout(new GridLayout(4, 4));
        setBackground(Color.BLACK);

        this.matrizJL = new JLabel[4][4];
        inicializarComponentes();

        setVisible(true);
    }

    public void inicializarComponentes() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizJL[i][j] = new JLabel("");
                matrizJL[i][j].setOpaque(true); // Para poder cambiar el fondo de color
                matrizJL[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                matrizJL[i][j].setBackground(Color.WHITE);
                final int fila = i;
                final int columna = j;
                matrizJL[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (listener != null) {
                            listener.celdaClickeada(fila, columna);
                        }
                    }
                });
                add(matrizJL[i][j]);
            }
        }
    }

    public void cambiarColor(int fila, int columna, String color) {
        switch (color) {
            case "rojo":
                matrizJL[fila][columna].setBackground(Color.RED);
                break;
            case "azul":
                matrizJL[fila][columna].setBackground(Color.BLUE);
                break;
            default:
                break;
        }
    }

    public void setTableroListener(TableroListener listener) {
        this.listener = listener;
    }

    public interface TableroListener {
        void celdaClickeada(int fila, int columna);
    }
}