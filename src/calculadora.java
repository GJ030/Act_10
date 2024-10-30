import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora extends JFrame {

    private JTextField Numero1;
    private JTextField Numero2;
    private JLabel Resultado;
    private JButton botonSumar;
    private JButton botonRestar;
    private JButton botonMultiplicar;
    private JButton botonDividir;

    public calculadora() {
        setTitle("Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));


        JLabel lblNumero1 = new JLabel("Número 1:");
        Numero1 = new JTextField();
        JLabel lblNumero2 = new JLabel("Número 2:");
        Numero2 = new JTextField();
        Resultado = new JLabel("Resultado:");

        botonSumar = new JButton("Sumar");
        botonRestar = new JButton("Restar");
        botonMultiplicar = new JButton("Multiplicar");
        botonDividir = new JButton("Dividir");

        add(lblNumero1);
        add(Numero1);
        add(lblNumero2);
        add(Numero2);
        add(Resultado);
        add(new JLabel(""));
        add(botonSumar);
        add(botonRestar);
        add(botonMultiplicar);
        add(botonDividir);

        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion("+");
            }
        });

        botonRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion("-");
            }
        });

        botonMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion("*");
            }
        });

        botonDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion("/");
            }
        });
    }

    private void Operacion(String operacion) {
        try {
            double num1 = Double.parseDouble(Numero1.getText());
            double num2 = Double.parseDouble(Numero2.getText());
            double resultado = 0;

            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    Resultado.setText("La suma es: " + resultado);
                    break;
                case "-":
                    resultado = num1 - num2;
                    Resultado.setText("La resta es: " + resultado);
                    break;
                case "*":
                    resultado = num1 * num2;
                    Resultado.setText("La multiplicación es: " + resultado);
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        Resultado.setText("La división es: " + resultado);
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            Resultado.setText("Error: Ingrese números válidos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            calculadora calculadora = new calculadora();
            calculadora.setVisible(true);
        });
    }
}

