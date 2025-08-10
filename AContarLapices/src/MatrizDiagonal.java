/*import java.util.Scanner;

public class MatrizDiagonal {
    public static void main(String[] args) {
    	 int filas, columnas;
         Scanner input = new Scanner(System.in);

         System.out.println("Por favor ingrese el número de filas de la matriz: ");
         filas = input.nextInt();

         System.out.println("Por favor ingrese el número de columnas de la matriz: ");
         columnas = input.nextInt();

         int[][] array = new int[filas][columnas];

         System.out.println("Por favor ingrese los elementos de la matriz: ");
         for (int i = 0; i < filas; i++) {
             for (int j = 0; j < columnas; j++) {
                 array[i][j] = input.nextInt();
             }
         }

         boolean valor = true;
         for (int i = 0; i < filas; i++) {
             for (int j = 0; j < columnas; j++) {
                 if (i == j && array[i][j] != array[0][0]) {
                     valor = false;
                     break;
                 }
             }
         }
         
         if (valor) {
             System.out.println("SI");
         } else {
             System.out.println("NO");
         }    
     }
 }*/

/*
 * El problema en el código es que solo se está verificando si los elementos de la diagonal principal son iguales. 
 * Para solucionar este problema, se debe verificar si todos los elementos de la matriz son iguales a su elemento diagonal principal. 
 * Se puede hacer esto utilizando un bucle anidado.
 * 
 * En este código corregido, se verifica si todos los elementos de la matriz son iguales a su elemento diagonal principal. 
 * Si algún elemento no es igual a su elemento diagonal principal, entonces el valor se establece en "false". 
 * Al final del bucle anidado, si el valor es "true", entonces la matriz es una matriz diagonal. 
 * De lo contrario, la matriz no es una matriz diagonal.

Aquí está el código corregido:*/

/*import java.util.Scanner;

public class MatrizDiagonal {
    public static void main(String[] args) {
        int filas, columnas;
        Scanner input = new Scanner(System.in);

        System.out.println("Por favor ingrese el número de filas de la matriz: ");
        filas = input.nextInt();

        System.out.println("Por favor ingrese el número de columnas de la matriz: ");
        columnas = input.nextInt();

        int[][] array = new int[filas][columnas];

        System.out.println("Por favor ingrese los elementos de la matriz: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                array[i][j] = input.nextInt();
            }
        }

        boolean valor = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == j && array[i][j] != array[0][0]) {
                    valor = false;
                }
                if (i != j && array[i][j] != array[0][0]) {
                    valor = false;
                }
            }
        }

        if (valor) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }
}*/

/*Este programa solicitará al usuario el tamaño de la matriz y el valor para la diagonal principal. 
Luego, generará una matriz diagonal con esos parámetros y la mostrará en la consola.*/
/*import java.util.Scanner;

public class MatrizDiagonal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el tamaño de la matriz
        System.out.print("Ingrese el tamaño de la matriz diagonal: ");
        int n = scanner.nextInt();

        // Solicitar el valor para la diagonal principal
        System.out.print("Ingrese el valor para la diagonal principal: ");
        int valorDiagonal = scanner.nextInt();

        // Crear y mostrar la matriz diagonal
        int[][] matriz = generarMatrizDiagonal(n, valorDiagonal);
        mostrarMatriz(matriz);
    }

    // Método para generar una matriz diagonal con valores coincidentes
    public static int[][] generarMatrizDiagonal(int n, int valorDiagonal) {
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    // Elemento en la diagonal principal
                    matriz[i][j] = valorDiagonal;
                } else {
                    // Elementos fuera de la diagonal principal
                    matriz[i][j] = 0;
                }
            }
        }

        return matriz;
    }

    // Método para mostrar la matriz en la consola
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Matriz diagonal generada:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}*/

/*import java.util.Scanner;

public class MatrizDiagonal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tamaño de la matriz cuadrada:");
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Verificar si la matriz es diagonal
        boolean esDiagonal = verificarMatrizDiagonal(matriz);

        if (esDiagonal) {
            // Verificar si todos los elementos diagonales son iguales
            boolean sonIguales = verificarElementosDiagonalesIguales(matriz);

            if (sonIguales) {
                System.out.println("La matriz es diagonal y todos los elementos diagonales son iguales.");
            } else {
                System.out.println("La matriz es diagonal, pero no todos los elementos diagonales son iguales.");
            }
        } else {
            System.out.println("La matriz no es diagonal.");
        }
    }

    private static boolean verificarMatrizDiagonal(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            return false;
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i != j && matriz[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean verificarElementosDiagonalesIguales(int[][] matriz) {
        int filas = matriz.length;

        for (int i = 0; i < filas - 1; i++) {
            if (matriz[i][i] != matriz[i + 1][i + 1]) {
                return false;
            }
        }

        return true;
    }
}*/

import java.util.Scanner;

public class MatrizDiagonal {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el número de filas de la matriz:");
            int filas = scanner.nextInt();

            System.out.println("Ingrese el número de columnas de la matriz:");
            int columnas = scanner.nextInt();

            int[][] matriz = new int[filas][columnas];
            int valor = 1;

            System.out.println("Ingrese los elementos de la matriz:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            // Verificar si la matriz es diagonal
            boolean esDiagonal = true;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.println("[" + i + "][" + j + "] = " + matriz[i][j]);
                    // Verificar si los elementos fuera de la diagonal principal son cero
                    if (i != j && matriz[i][j] != 0) {
                        esDiagonal = false;
                        break;
                    }
                }
                if (!esDiagonal) {
                    break;
                }
            }

            // Imprimir el resultado
            if (esDiagonal) {
                System.out.println("SI, la matriz es diagonal.");
            } else {
                System.out.println("NO, la matriz no es diagonal.");
            }
        }
    }
}
