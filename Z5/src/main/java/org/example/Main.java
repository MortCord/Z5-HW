package org.example;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JPanel {
    private final int n;
    private final int squareSize = 100;

    public Main(int n) {
        this.n = n;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(
                5 * squareSize + 6 * n,
                squareSize + 2 * n
        ));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color[] colors = {
                Color.ORANGE,
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW
        };

        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);

            int x = n + i * (squareSize + n);
            int y = n;

            g.fillRect(x, y, squareSize, squareSize);
        }
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(
                "Podaj odległość między kwadratami (n):"
        );

        try {
            int n = Integer.parseInt(input);

            if (n < 0) {
                throw new NumberFormatException();
            }

            JFrame frame = new JFrame("Kolorowe kwadraty");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Main(n));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "Podaj poprawną nieujemną liczbę!"
            );
        }
    }
}
