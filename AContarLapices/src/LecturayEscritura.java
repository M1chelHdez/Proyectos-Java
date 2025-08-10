/*import java.util.Scanner;

public class LecturayEscritura {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.print("Ingrese un número de minutos (entre 1 y 100): ");
		        int minutos = scanner.nextInt();
		        if (minutos < 1 || minutos > 100) {
		            System.out.println("Ingrese el número de minutos válido en el rango de 1 a 100 minutos");
		        } else {
		            int segundos = minutos * 60;
		            System.out.println(minutos + " minutos son equivalentes a " + segundos + " segundos");
		        }
		    }
	}*/

import java.util.Scanner;

public class LecturayEscritura {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int minutos;
			do {
				System.out.print("Ingrese un número de minutos (entre 1 y 100): ");
				minutos = scanner.nextInt();
			} while (verificarSegundos(minutos));

			boolean minutosSegundos = verificarSegundos(minutos);
			if (minutosSegundos) {
				System.out.println("Ingrese el número de minutos válido en el rango de 1 a 100 minutos");
			} else {
				int segundos = minutos * 60;
				System.out.println(minutos + " minutos son equivalentes a " + segundos + " segundos");
			}
		}
	}

	public static boolean verificarSegundos(int minutos) {
		return minutos < 1 || minutos >= 100;
	}
}
