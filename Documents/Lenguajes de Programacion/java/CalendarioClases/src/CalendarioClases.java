import java.util.Scanner;

// PASO 1: Crear la esctructura basica del programa
// creamos la estructura basica del programa

public class CalendarioClases {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] clases = new String[10]; //Array para almacenar los nombres de las clases
        String[][] horario = new String[5][6]; //Array bidimensional para el horario (5 dias, 6 horas)

        // Inicializar el horario vacio
        for (int i = 0; i < 5; i++) {   //para los días
            for (int j = 0; j < 6; j++) {   //para las horas
                horario[i][j] = "Vacio";
            }
        }
        
        boolean Salir = false;

        // Paso 3: Integrar el menú en el programa principal
        // Ahora, vamos a integrar el menú dentro de un ciclo para que el usuario pueda interactuar con el programa.
        while (!Salir) {
            mostrarMenu();
            System.out.print("Elige una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // para evitar el salto de linea
            switch (opcion) {
                case 1:
                    agregarClase(horario, null, scanner);
                    break;
                case 2:
                    eliminarClase(horario, scanner);
                    break;
                case 3:
                    verHorario(horario);
                    break;
                case 4:
                    Salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
        System.out.println("Programa finalizado");
    }

    //logica del programa

    // PASO: 2 Crear un menú de opciones
    //declarando un metodo, crear un menú que permita al usuario agregar o eliminar clases del horario
    public static void mostrarMenu(){
        System.out.println("1. Agregar clase al horario");
        System.out.println("2. Eliminar clase del horario");
        System.out.println("3. Ver horario");
        System.out.println("4. Salir");
    }

    public static int obtenerDia(String dia){
        switch(dia.toLowerCase()){
            case "lunes": return 0;
            case "martes": return 1;
            case "miercoles": return 2;
            case "jueves": return 3;
            case "viernes": return 4;
            default: return -1;
        }
    }

    public static void agregarClase(String[][] horario, String[] clases, Scanner scanner){
        System.out.print("Introduce el nombre de la clase: ");
        String clase = scanner.nextLine();
        System.out.print("Introduce el dia de la clase (Lunes  a viernes): ");
        String dia = scanner.nextLine();
        int diaIndex = obtenerDia(dia);

        System.out.print("Introduce la hora(1 a 6): ");
        int hora = scanner.nextInt();
        scanner.nextLine(); // limpiar el buffer

        if (diaIndex >= 0 && diaIndex < 5 && hora >= 1 && hora <= 6) {
            horario[diaIndex][hora-1] = clase;
            System.out.println("Clase agregada correctamente");
        } else {
            System.out.println("Dia o hora no válida");
        }
    }

    public static void eliminarClase(String[][] horario, Scanner scanner) {
        System.out.print("Introduce el dia (Lunes  a viernes): ");
        String dia = scanner.nextLine();
        int diaIndex = obtenerDia(dia);

        System.out.print("Introduce la hora (1 a 6): ");
        int hora = scanner.nextInt();
        scanner.nextLine(); // limpiar el buffer

        if (diaIndex >= 0 && diaIndex < 5 && hora >= 1 && hora <= 6) {
            horario[diaIndex][hora-1] = "Vacio";
            System.out.println("Clase eliminada correctamente");            
        } else {
            System.out.println("Dia o hora no válida");
        }         
    }   
    
    public static void verHorario(String[][] horario){
        String [] dias ={"Lunes ", "martes ", "miercoles ", "jueves", "viernes"};

        for (int i = 0; i < 5; i++) {
            System.out.println(dias[i] + ": ");
            for (int j = 0; j < 6; j++) {
                System.out.println("Hora " + (j+1) + ": " + horario[i][j]);
            }
            System.out.println();
        }

    }
}
