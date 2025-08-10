import java.util.Scanner;

public class BisiestoSencillo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Leer el año N
            //System.out.print("Ingrese un año (mayor a 1600 y menor a 3000): ");
            int anio;
            do {
                System.out.print("Ingrese un año que sea mayor a 1600 y menor a 3000: ");
                anio = scanner.nextInt();
            } while (anio < 1600 || anio >= 3000);

            // Verificar si el año es bisiesto
            boolean esBisiesto = verificarBisiesto(anio);

            // Mostrar el resultado
            if (esBisiesto) {
                System.out.println("S significa que es bisiesto");
            } else {
                System.out.println("N significa que no es bisiesto");
            }
        }
    }

    // Función para verificar si un año es bisiesto
    public static boolean verificarBisiesto(int anio) {
        // Un año es bisiesto si es divisible por 4, excepto si también es divisible por 100
        // Pero si es divisible por 400, entonces es bisiesto nuevamente
        //return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
        return anio % 4 == 0 && anio % 100 != 0;
    }
}


/*
 * La lógica del programa es correcta, pero hay un pequeño error en la verificación del año bisiesto. 
 * La condición (anio % 4 == 0 && anio % 100 != 0) verifica que el año sea divisible por 4 y no sea divisible por 100, 
 * lo cual es correcto para los años bisiestos. 
 * Sin embargo, la condición (anio % 400 == 0) no es necesaria, ya que si un año es divisible por 400, 
 * entonces también es divisible por 4 y no es divisible por 100. 
 * Por lo tanto, la función verificarAnioBisiesto puede simplificarse a:

public static boolean verificarAnioBisiesto(int anio) {
    return anio % 4 == 0 && anio % 100 != 0;
}
Además, para garantizar que el programa funcione correctamente, 
s necesario agregar una verificación adicional para asegurar que el año ingresado esté dentro del rango válido 
(mayor a 1600 y menor a 3000). Esto se puede hacer modificando la función main de la siguiente manera:*/
		 