/*import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    String nombre;
    int prioridad;

    public Cliente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
}

public class ColaBancariaDeLaSuerte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Cliente> colaClientes = new LinkedList<>();

        while (scanner.hasNext()) {
            String evento = scanner.next();

            switch (evento) {
                case "C":
                    String nombre = scanner.next();
                    int prioridad = scanner.nextInt();
                    Cliente cliente = new Cliente(nombre, prioridad);
                    colaClientes.add(cliente);
                    break;
                case "S":
                    char letra = scanner.next().charAt(0);
                    int numero = scanner.nextInt();
                    atenderCuentahabiente(colaClientes);
                    break;
                default:
                    System.out.println("Evento no reconocido.");
            }
        }
    }

    private static void atenderCuentahabiente(Queue<Cliente> cola) {
        if (!cola.isEmpty()) {
            Cliente clienteAtendido = cola.poll();
            System.out.println("Cliente Atendido: " + clienteAtendido.nombre);
        } else {
            System.out.println("No hay clientes en la cola.");
        }
    }
}*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    String nombre;
    int prioridad;

    public Cliente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
}

public class ColaBancariaDeLaSuerte {
    public static void main(String[] args) {
        Queue<Cliente> colaClientes = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            // Evento 1: Ingreso del nombre del cuentahabiente con prioridad inicial
            System.out.print("Ingrese el nombre del cuentahabiente con prioridad inicial: ");
            String nombreCliente = scanner.nextLine();
            System.out.print("Ingrese la prioridad inicial del cuentahabiente: ");
            int prioridadInicial = scanner.nextInt();
            Cliente clienteInicial = new Cliente(nombreCliente, prioridadInicial);
            colaClientes.add(clienteInicial);
            System.out.println("Evento 1: Se ingresó al cuentahabiente " + clienteInicial.nombre);
        }

        // Evento 2: Sorteo y extracción de letra y número asignado al cliente
        // En este ejemplo, simplemente generamos valores aleatorios para representar el sorteo
        char letraSorteo = (char) ('A' + (int) (Math.random() * 26));
        int numeroSorteo = (int) (Math.random() * 100);
        System.out.println("Evento 2: Se extrajo la letra " + letraSorteo + " y el número " + numeroSorteo +
                " asignado al cliente.");

        // Evento 3: Atención al cuentahabiente de mayor prioridad de la cola
        Cliente clienteAtendido = colaClientes.poll();
        System.out.println("Evento 3: Se atendió al cuentahabiente " + clienteAtendido.nombre +
                " con prioridad " + clienteAtendido.prioridad);
    }
}

/*
 *
 * import java.util.LinkedList;
import java.util.Queue;

public class PruebaQueue {

    public static void main(String[] args) {
        Queue<String> cola1 = new LinkedList<String>();
        System.out.println("Insertamos tres elementos en la cola: juan, ana y luis");
        cola1.add("juan");
        cola1.add("ana");
        cola1.add("luis");
        System.out.println("Cantidad de elementos en la cola:" + cola1.size());
        System.out.println("Extraemos un elemento de la cola:" + cola1.poll());
        System.out.println("Cantidad de elementos en la cola:" + cola1.size());
        System.out.println("Consultamos el primer elemento de la cola sin extraerlo:" + cola1.peek());
        System.out.println("Cantidad de elementos en la cola:" + cola1.size());
        System.out.println("Extraemos uno a un cada elemento de la cola mientras no este vacía:");
        while (!cola1.isEmpty())
            System.out.print(cola1.poll() + "-");
        System.out.println();

        Queue<Integer> cola2 = new LinkedList<Integer>();
        cola2.add(70);
        cola2.add(120);
        cola2.add(6);
        System.out.println("Imprimimos la cola de enteros");
        for (Integer elemento : cola2)
            System.out.print(elemento + "-");
        System.out.println();
        System.out.println("Borramos toda la cola");
        cola2.clear();
        System.out.println("Cantidad de elementos en la cola de enteros:" + cola2.size());
    }

}*/
