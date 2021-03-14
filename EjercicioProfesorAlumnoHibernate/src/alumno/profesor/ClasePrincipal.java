package alumno.profesor;

import java.util.List;

public class ClasePrincipal {

	public static void main(String[] args) {
		int o = EntradaSalida.mostrarOpciones();
		ConexionBBDD.realizarConexion();

		while (o != 6)
			System.out.println("Va bn");
		{
			switch (o) {
			case 1:
				Profesor p = EntradaSalida.pedirDatosProfesor();
				ConexionBBDD.setProfesor(p);

				break;
			case 2:
				Alumnos a = EntradaSalida.solicitarDatosAlumno();
				ConexionBBDD.setAlumno(a);
				break;
			case 3:

				List<Profesor> listaProfesores = ConexionBBDD.getProfesores();
				int idProfesor = EntradaSalida.seleccionarProfesor(listaProfesores);
				List<Alumnos> listAlumnos = ConexionBBDD.getAlumnos();
				String idAlumnos = EntradaSalida.seleccionarAlumnos(listAlumnos);

				ConexionBBDD.setProfesorAlumno(idAlumnos, idProfesor);
				break;
			case 4:

				List<Profesor> listaProfes = ConexionBBDD.getProfesores();
				EntradaSalida.mostrarProfesores(listaProfes);
				break;
			case 5:
				
				break;

			case 6:
				// se sale
				break;
			}

			o = EntradaSalida.mostrarOpciones();
		}
	}

}
