import java.util.Scanner;
import java.io.*;
import java.util.*;

// Clase que viola TODOS los principios SOLID y buenas prácticas
public class CalculadoraMala {
    // Variables públicas (viola encapsulación)
    public double resultado;
    public String operacion_actual;
    public boolean is_debug_mode;
    public ArrayList<String> historial_operaciones;
    public Scanner input_scanner;
    public FileWriter archivo_log;

    // Constructor que hace demasiadas cosas (viola SRP)
    public CalculadoraMala() throws IOException {
        this.resultado = 0;
        this.operacion_actual = "";
        this.is_debug_mode = true;
        this.historial_operaciones = new ArrayList<>();
        this.input_scanner = new Scanner(System.in);
        this.archivo_log = new FileWriter("calculadora_log.txt", true);

        // Inicialización innecesaria en constructor
        System.out.println("=== CALCULADORA INICIADA ===");
        this.archivo_log.write("Calculadora iniciada: " + new Date() + "\n");
        this.archivo_log.flush();
    }

    // Método gigante que hace TODO (viola SRP masivamente)
    public void ejecutar_calculadora() throws IOException {
        while (true) {
            System.out.println("\n--- CALCULADORA MALA ---");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Potencia");
            System.out.println("6. Raiz cuadrada");
            System.out.println("7. Factorial");
            System.out.println("8. Ver historial");
            System.out.println("9. Limpiar historial");
            System.out.println("10. Toggle debug");
            System.out.println("11. Guardar en archivo");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            int opcion = input_scanner.nextInt();

            // Switch gigante sin abstracción (viola OCP)
            switch (opcion) {
                case 1:
                    System.out.print("Primer numero: ");
                    double num1_suma = input_scanner.nextDouble();
                    System.out.print("Segundo numero: ");
                    double num2_suma = input_scanner.nextDouble();
                    resultado = num1_suma + num2_suma;
                    operacion_actual = num1_suma + " + " + num2_suma + " = " + resultado;
                    historial_operaciones.add(operacion_actual);
                    System.out.println("Resultado: " + resultado);
                    if (is_debug_mode) {
                        System.out.println("DEBUG: Operacion suma completada");
                        archivo_log.write("SUMA: " + operacion_actual + "\n");
                        archivo_log.flush();
                    }
                    break;

                case 2:
                    System.out.print("Primer numero: ");
                    double num1_resta = input_scanner.nextDouble();
                    System.out.print("Segundo numero: ");
                    double num2_resta = input_scanner.nextDouble();
                    resultado = num1_resta - num2_resta;
                    operacion_actual = num1_resta + " - " + num2_resta + " = " + resultado;
                    historial_operaciones.add(operacion_actual);
                    System.out.println("Resultado: " + resultado);
                    if (is_debug_mode) {
                        System.out.println("DEBUG: Operacion resta completada");
                        archivo_log.write("RESTA: " + operacion_actual + "\n");
                        archivo_log.flush();
                    }
                    break;

                case 3:
                    System.out.print("Primer numero: ");
                    double num1_mult = input_scanner.nextDouble();
                    System.out.print("Segundo numero: ");
                    double num2_mult = input_scanner.nextDouble();
                    resultado = num1_mult * num2_mult;
                    operacion_actual = num1_mult + " * " + num2_mult + " = " + resultado;
                    historial_operaciones.add(operacion_actual);
                    System.out.println("Resultado: " + resultado);
                    if (is_debug_mode) {
                        System.out.println("DEBUG: Operacion multiplicacion completada");
                        archivo_log.write("MULTIPLICACION: " + operacion_actual + "\n");
                        archivo_log.flush();
                    }
                    break;

                case 4:
                    System.out.print("Primer numero: ");
                    double num1_div = input_scanner.nextDouble();
                    System.out.print("Segundo numero: ");
                    double num2_div = input_scanner.nextDouble();
                    // División sin validación (código frágil)
                    resultado = num1_div / num2_div;
                    operacion_actual = num1_div + " / " + num2_div + " = " + resultado;
                    historial_operaciones.add(operacion_actual);
                    System.out.println("Resultado: " + resultado);
                    if (is_debug_mode) {
                        System.out.println("DEBUG: Operacion division completada");
                        archivo_log.write("DIVISION: " + operacion_actual + "\n");
                        archivo_log.flush();
                    }
                    break;

                case 5:
                    System.out.print("Base: ");
                    double base = input_scanner.nextDouble();
                    System.out.print("Exponente: ");
                    double exponente = input_scanner.nextDouble();
                    resultado = Math.pow(base, exponente);
                    operacion_actual = base + " ^ " + exponente + " = " + resultado;
                    historial_operaciones.add(operacion_actual);
                    System.out.println("Resultado: " + resultado);
                    if (is_debug_mode) {
                        System.out.println("DEBUG: Operacion potencia completada");
                        archivo_log.write("POTENCIA: " + operacion_actual + "\n");
                        archivo_log.flush();
                    }
                    break;

                case 6:
                    System.out.print("Numero: ");
                    double num_raiz = input_scanner.nextDouble();
                    // Sin validación de números negativos
                    resultado = Math.sqrt(num_raiz);
                    operacion_actual = "√" + num_raiz + " = " + resultado;
                    historial_operaciones.add(operacion_actual);
                    System.out.println("Resultado: " + resultado);
                    if (is_debug_mode) {
                        System.out.println("DEBUG: Operacion raiz cuadrada completada");
                        archivo_log.write("RAIZ: " + operacion_actual + "\n");
                        archivo_log.flush();
                    }
                    break;

                case 7:
                    System.out.print("Numero: ");
                    int num_fact = input_scanner.nextInt();
                    // Factorial sin validación y con lógica ineficiente
                    resultado = 1;
                    for (int i = 1; i <= num_fact; i++) {
                        resultado = resultado * i;
                    }
                    operacion_actual = num_fact + "! = " + resultado;
                    historial_operaciones.add(operacion_actual);
                    System.out.println("Resultado: " + resultado);
                    if (is_debug_mode) {
                        System.out.println("DEBUG: Operacion factorial completada");
                        archivo_log.write("FACTORIAL: " + operacion_actual + "\n");
                        archivo_log.flush();
                    }
                    break;

                case 8:
                    System.out.println("\n=== HISTORIAL ===");
                    if (historial_operaciones.size() == 0) {
                        System.out.println("No hay operaciones en el historial");
                    } else {
                        for (int i = 0; i < historial_operaciones.size(); i++) {
                            System.out.println((i + 1) + ". " + historial_operaciones.get(i));
                        }
                    }
                    break;

                case 9:
                    historial_operaciones.clear();
                    System.out.println("Historial limpiado");
                    if (is_debug_mode) {
                        archivo_log.write("HISTORIAL LIMPIADO\n");
                        archivo_log.flush();
                    }
                    break;

                case 10:
                    is_debug_mode = !is_debug_mode;
                    System.out.println("Modo debug: " + (is_debug_mode ? "ACTIVADO" : "DESACTIVADO"));
                    break;

                case 11:
                    // Guardar historial en archivo (lógica duplicada)
                    try {
                        FileWriter archivo_historial = new FileWriter("historial_calculadora.txt");
                        archivo_historial.write("=== HISTORIAL CALCULADORA ===\n");
                        archivo_historial.write("Fecha: " + new Date() + "\n\n");
                        for (String op : historial_operaciones) {
                            archivo_historial.write(op + "\n");
                        }
                        archivo_historial.close();
                        System.out.println("Historial guardado en archivo");
                    } catch (IOException e) {
                        System.out.println("Error al guardar archivo: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Cerrando calculadora...");
                    archivo_log.write("Calculadora cerrada: " + new Date() + "\n");
                    archivo_log.close();
                    input_scanner.close();
                    return;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    // Método main que viola SRP
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando aplicacion calculadora...");
            CalculadoraMala calc = new CalculadoraMala();
            calc.ejecutar_calculadora();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
}