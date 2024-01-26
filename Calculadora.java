package calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JButton resta;
    private JButton Igual;
    private JButton cero;
    private JButton c;
    private JButton suma;
    private JButton siete;
    private JButton ocho;
    private JButton nueve;
    private JButton division;
    private JButton cuatro;
    private JButton cinco;
    private JButton seis;
    private JButton multiplicacion;
    private JButton uno;
    private JButton dos;
    private JButton tres;
    private JButton PotenciaCuadrado;
    private JButton PotenciaCubo;
    private JButton Potencia;
    private JButton RaizCuadrada;
    private JButton RaizCubica;
    private JButton Seno;
    private JButton Coseno;
    private JButton Tangente;
    private JTextField pantalla;
    private JPanel Calculadora;

    private double primerNumero;
    private String operacionPendiente;

    public Calculadora() {
        primerNumero = 0;
        operacionPendiente = "";

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setText("");
                primerNumero = 0;
                operacionPendiente = "";
            }
        });

        cero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("0");
            }
        });

        uno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("1");
            }
        });

        dos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("2");
            }
        });

        tres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("3");
            }
        });

        cuatro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("4");
            }
        });

        cinco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("5");
            }
        });

        seis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("6");
            }
        });

        siete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("7");
            }
        });

        ocho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("8");
            }
        });

        nueve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNumero("9");
            }
        });

        suma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("+");
            }
        });

        resta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("-");
            }
        });

        multiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("*");
            }
        });

        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("/");
            }
        });

        PotenciaCuadrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPotencia(2);
            }
        });

        PotenciaCubo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPotencia(3);
            }
        });

        Potencia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("^");
            }
        });

        RaizCuadrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularRaiz(2);
            }
        });

        RaizCubica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularRaiz(3);
            }
        });

        Seno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFuncionTrigonometrica("sen");
            }
        });

        Coseno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFuncionTrigonometrica("cos");
            }
        });

        Tangente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFuncionTrigonometrica("tan");
            }
        });

        Igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
    }

    private void agregarNumero(String numero) {
        pantalla.setText(pantalla.getText() + numero);
    }

    private void realizarOperacion(String operacion) {
        if (!pantalla.getText().isEmpty()) {
            primerNumero = Double.parseDouble(pantalla.getText());
            operacionPendiente = operacion;
            pantalla.setText("");
        }
    }

    private void calcularPotencia(int exponente) {
        if (!pantalla.getText().isEmpty()) {
            double base = Double.parseDouble(pantalla.getText());
            double resultado = Math.pow(base, exponente);
            pantalla.setText(String.valueOf(resultado));
        }
    }

    private void calcularRaiz(int indice) {
        if (!pantalla.getText().isEmpty()) {
            double numero = Double.parseDouble(pantalla.getText());
            double resultado = Math.pow(numero, 1.0 / indice);
            pantalla.setText(String.valueOf(resultado));
        }
    }

    private void calcularFuncionTrigonometrica(String funcion) {
        if (!pantalla.getText().isEmpty()) {
            double angulo = Double.parseDouble(pantalla.getText());
            switch (funcion) {
                case "sen":
                    pantalla.setText(String.valueOf(Math.sin(Math.toRadians(angulo))));
                    break;
                case "cos":
                    pantalla.setText(String.valueOf(Math.cos(Math.toRadians(angulo))));
                    break;
                case "tan":
                    pantalla.setText(String.valueOf(Math.tan(Math.toRadians(angulo))));
                    break;
            }
        }
    }

    private void calcularResultado() {
        if (!pantalla.getText().isEmpty()) {
            double segundoNumero = Double.parseDouble(pantalla.getText());

            switch (operacionPendiente) {
                case "+":
                    pantalla.setText(String.valueOf(primerNumero + segundoNumero));
                    break;
                case "-":
                    pantalla.setText(String.valueOf(primerNumero - segundoNumero));
                    break;
                case "*":
                    pantalla.setText(String.valueOf(primerNumero * segundoNumero));
                    break;
                case "/":
                    if (segundoNumero != 0) {
                        pantalla.setText(String.valueOf(primerNumero / segundoNumero));
                    } else {
                        pantalla.setText("Error: División por cero");
                    }
                    break;
                case "^":
                    pantalla.setText(String.valueOf(Math.pow(primerNumero, segundoNumero)));
                    break;
            }

            primerNumero = 0;
            operacionPendiente = "";
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().Calculadora);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
