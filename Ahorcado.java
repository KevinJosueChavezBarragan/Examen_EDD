package examen_avanzado;

import java.util.Arrays;
import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        char[][] ahorcado = {{'p', 'e', 'r', 'r', 'o'},
        {'l', 'a', 'p', 'i', 'z'},
        {'d', 'a', 't', 'o', 's'},
        {'n', 'u', 'm', 'e', 'r', 'o'},
        {'m', 'e', 'm', 'o','r', 'i', 'a'}};

        int intentos = 0, termi = 0, avanzar = 0, opor = 0;
        String palabra = "", progreso = "";
        do {
            System.out.println("*~~~~~~~~ AHORCADO ~~~~~~~~*");
            while (intentos <= 4) {
                int r = (int) (Math.random() * 4);
                System.out.println(r);
                char[] word = ahorcado[r];
                progreso += palabra;
                for (int i = 0; i < word.length; i++) {
                    System.out.print("[ ] ");
                }
                System.out.println("\nSabes la palabra?: \n1.Si  0.No");
                avanzar = leer.nextInt();

                switch (avanzar) {
                    case 1:
                        System.out.print("Escribe la palabra: ");
                        palabra = leer.next();
                        if (Arrays.equals(word, palabra.toCharArray())) {
                            System.out.println("Felicidades, has acertado");
                        } else {
                            System.out.println("Sigue intentando");
                            break;
                        }
                        break;

                    case 0:
                        do {
                            System.out.print("Que letra quieres buscar?: ");
                            palabra = leer.next();

                            for (int i = 0; i < word.length; i++) {
                                if (palabra.equals(word[i])) {
                                    System.out.println("[" + palabra + "]");
                                } else {
                                    System.out.println("[ ]");
                                }
                            }

                            if (progreso.equals(Arrays.toString(word))) {
                                System.out.println("Adivinaste la palabra ");
                            } else {
                                System.out.println("Esa letra no existe");
                                intentos++;
                                opor = 4 - intentos;
                                System.out.println("Te quedan " + (opor) + " oportunidades");
                            }
                        } while (opor > 0);

                        break;
                    default:
                        System.out.println("Entrada no valida");
                        break;

                }
            }
            System.out.println("Quieres seguir jugando? \n1.Si   0.No");
            termi = leer.nextInt();
        } while (termi > 0);
    }
}
