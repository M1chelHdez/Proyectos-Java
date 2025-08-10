//import java.util.Scanner;
//
//public class AContarLapices {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//        // Leer el número y el dígito
//        System.out.print("Ingrese el número de lapices seguido por los lápices de ese tipo: ");
//        int NN = scanner.nextInt();
//        int KK = scanner.nextInt();
//
//        int contador = 0;
//
//        for (int i = 0; i < NN; i++) {
//            System.out.print("Ingrese un número: ");
//            int numero = scanner.nextInt();
//            
//          
//            contador += contarDigitos(numero, KK);
//        }
//
//        System.out.println("Número de lápices del tipo " + KK + ": " + contador);
//    }
//
//    public static int contarDigitos(int numero, int digito) {
//        int contador = 0;
//
//        while (numero > 0) {
//            int ultimoDigito = numero % 10;
//            if (ultimoDigito == digito) {
//                contador++;
//            }
//            numero /= 10;
//        }
//
//        return contador;
//    }
//
//}

import java.util.Scanner;

public class AContarLapices {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Leer el número y el dígito
            System.out.print("Ingrese el número de lapices a contar: ");
            int NN = scanner.nextInt();
            System.out.print("Ingrese el número de tipo de lapiz: ");
            int KK = scanner.nextInt();

            // Leer todos los números en un array
            int[] numeros = new int[NN];
            for (int i = 0; i < NN; i++) {
                System.out.print("Ingrese un tipo de número de lapiz: ");
                numeros[i] = scanner.nextInt();
            }

            // Contar los dígitos del tipo especificado en todos los números del array
            int contador = 0;
            for (int numero : numeros) {
                contador += contarDigitos(numero, KK);
            }

            System.out.println("Número de lápices del tipo " + KK + ": " + contador);
        }
    }

    public static int contarDigitos(int numero, int digito) {
        int contador = 0;

        while (numero > 0) {
            int ultimoDigito = numero % 10;
            if (ultimoDigito == digito) {
                contador++;
            }
            numero /= 10;
        }

        return contador;
    }

}