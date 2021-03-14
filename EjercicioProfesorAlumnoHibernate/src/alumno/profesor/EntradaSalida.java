package alumno.profesor;

import java.util.List;
import java.util.Scanner;

public class EntradaSalida {

	public static Profesor pedirDatosProfesor() {
		// TODO Auto-generated method stub
		Profesor p = new Profesor();
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce el nombre del profesor: ");
		String nombre = s.nextLine();
		p.setNombre(nombre);
		return p;
	}

	public static Alumnos solicitarDatosAlumno() {
		Alumnos p = new Alumnos();
		Scanner s = new Scanner(System.in);
		System.out.println("Meter el alumno: ");
		String nombre = s.nextLine();
		p.setNombre(nombre);
		return p;
	}

	public static int mostrarOpciones() {

		System.out.println("Elija una opcion:" + " \n 1-Insertar profesor" + " \n 2-Insertar alumno"
				+ " \n 3-Asociar profesor-alumno" + " \n 4-Listar profesores" + " \n 5-Buscar profesor (por nombre)"
				+ " \n 6-Salir");
		System.out.println();
		Scanner s = new Scanner(System.in);
		int opc = s.nextInt();
		return opc;
	}

	public static int seleccionarProfesor(List<Profesor> lista_profesores) {
		for (Profesor p : lista_profesores) {
			System.out.println(p.getId() + "-" + p.getNombre());
		}
		Scanner s = new Scanner(System.in);
		int opc = s.nextInt();
		return opc;
	}

	public static String seleccionarAlumnos(List<Alumnos> listaAlumnos) {
		for (Alumnos p : listaAlumnos) {
			System.out.println(p.getId() + "-" + p.getNombre());
		}
		Scanner s = new Scanner(System.in);
		String id = s.nextLine();
		return id;
	}

	public static void mostrarProfesores(List<Profesor> profesores) {
		for (Profesor p : profesores) {
			System.out.println("Nombre del Profesor: " + p.getNombre());
			System.out.println("Alumnos: " + "\n");
			for (Alumnos a : p.getLista_alumnos()) {
				if (a != null) {
					System.out.println(a.getNombre() + "\n");
					System.out.println();
				}

			}

		}

	}

}
