package controller;

import agent.Alumno;

import java.util.*;

public class AlumnoMenu {

    private HashMap<String , Alumno> alumnos;
    private Scanner s = new Scanner(System.in);

    public HashMap<String, Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(HashMap<String, Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public AlumnoMenu() {
        alumnos = new HashMap<>();
    }

    public void menuAlumnos(){
        int opcion = 0;
        while (opcion!=6){
            System.out.printf("""
                    ----------- Menu profesorado -----------
                    1. Introducir alumno
                    2. Buscar nota por DNI
                    3. Ver mejores expedientes
                    4. Ver expedientes superiores a X nota
                    5. Vaciar lista
                    6. Salir del programa
                    """);
            System.out.print("\nIntroduce una opción: ");
            opcion = s.nextInt();
            s.nextLine();
            switch (opcion){
                case 1 ->anadirAlumno();
                case 2 ->{
                    String dni;
                    System.out.print("\nIntroduce el DNI: ");
                    dni = s.nextLine();
                    notaAlumno(dni);
                }
                case 3 -> {
                    int cantidad;
                    System.out.println("De que cantidad quieres el top: ");
                    cantidad = s.nextInt();
                    mostrarMejores(cantidad);
                }
                case 4 -> {
                    double notaMinima;
                    System.out.print("\nNota mínima: ");
                    notaMinima = s.nextDouble();
                    mostrarSuperior(notaMinima);
                }
                case 5 -> limpiarAlumnos();
            }
        }
        System.out.println("---- Saliendo del programa ----");

    }

    private void anadirAlumno(){
        String dni = "", nombre, apellido;
        double nota;
        System.out.print("Introduce el DNI: ");
        dni = s.nextLine();
        while (dniRepetido(dni)||dni.length()!=9){
            System.out.print("\nDni repetido o no valido, intentalo de nuevo: ");
            dni = s.nextLine();
        }
        System.out.print("\nIntroduce el nombre: ");
        nombre = s.nextLine();
        System.out.print("\nIntroduce el apellido: ");
        apellido = s.nextLine();
        System.out.print("\nIntroduce la nota: ");
        nota = s.nextDouble();
        while (nota<0||nota>10){
            System.out.print("\nNota no valida, introducela de nuevo: ");
            nota = s.nextDouble();
        }
        alumnos.put(dni,new Alumno(dni, nombre, apellido));
        alumnos.get(dni).setNota(nota);
    }

    private void notaAlumno(String dni){
        if (!dniRepetido(dni)){
            System.out.println("No hay alumno con ese DNI");
            return;
        }
        alumnos.get(dni).mostrarDatos();
    }

    private void mostrarMejores(int numero){
        if (alumnos.isEmpty()){
            System.out.println("No hay alumnos registrados.");
        }
        /*
        Forma con stream, sencillisima pero no la entiendo
        System.out.println("\n--- Top " + numero + " Mejores Alumnos ---");
        alumnos.values().stream().sorted(Comparator.comparingDouble(Alumno::getNota).reversed()).limit(numero).forEach(Alumno::mostrarDatos);*/

        //forma mas sencilla, hacemos un ArrayList de apoyo y lo ordenamos.
        ArrayList<Alumno> listaAlumnos = new ArrayList<>(alumnos.values());

        // Función lambda para comparar.
        listaAlumnos.sort((a1, a2) -> Double.compare(a2.getNota(), a1.getNota()));

        // Límite para no romper el programa
        // Si pides 5 alumnos pero solo hay 2, el bucle solo debe llegar a 2.
        int limite = Math.min(numero, listaAlumnos.size());

        System.out.println("\n--- Top " + limite + " Mejores Alumnos ---");

        // Recorrer con un for normal hasta el límite
        for (int i = 0; i < limite; i++) {
            listaAlumnos.get(i).mostrarDatos();
            System.out.println("----------------");
        }
    }

    private void mostrarSuperior(double notaminima){
        System.out.println("----- Alumnos con nota mayor a " + notaminima + " -----");
        for (String item : alumnos.keySet()) {
            if (alumnos.get(item).getNota()>=notaminima){
                alumnos.get(item).mostrarDatos();
            }
        }
    }

    private void limpiarAlumnos(){
        alumnos.clear();
    }

    private boolean dniRepetido(String dni){
        if (alumnos.isEmpty()){
            return false;
        }
        for (String item : alumnos.keySet()) {
            if (dni.equalsIgnoreCase(item)){
                return true;
            }
        }
        return false;
    }


}
