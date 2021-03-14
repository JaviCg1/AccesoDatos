package alumno.profesor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class ConexionBBDD {
	static StandardServiceRegistry s = null;
	static SessionFactory sf = null;
	static Session sesion = null;

	public static void realizarConexion() {
		s = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(s).buildMetadata().buildSessionFactory();
		sesion = sf.openSession();
	}

	public static void setProfesor(Profesor p) {
		Transaction t = sesion.beginTransaction();
		sesion.save(p);
		t.commit();

	}

	public static void setAlumno(Alumnos a) {
		Transaction t = sesion.beginTransaction();
		sesion.save(a);
		t.commit();

	}

	public static List<Profesor> getProfesores() {
		Query<Profesor> q = sesion.createQuery("FROM Profesor");

		return q.getResultList();
	}

	public static List<Alumnos> getAlumnos() {
		Query<Alumnos> q = sesion.createQuery("FROM Alumno");
		return q.getResultList();
	}

	public static Profesor getProfesorPorId(int id) {
		Query<Profesor> q = sesion.createQuery("FROM Profesor WHERE id=" + id);
		return q.getSingleResult();
	}

	public static Alumnos getAlumnoPorId(int id) {
		Query<Alumnos> q = sesion.createQuery("FROM Alumno WHERE id=" + id);
		return q.getSingleResult();
	}

	public static void setProfesorAlumno(String idAlumnos, int idProfesor) {
		Profesor p = getProfesorPorId(idProfesor);
		String query = "from Alumno where id in (:id)";
		String[] id = idAlumnos.split(",");
		List<Integer> listaId = new ArrayList();
		for (String i : id) {
			listaId.add(Integer.valueOf(i));
		}
		Query q = sesion.createQuery(query);
		q.setParameter("ids", listaId);
		List<Alumnos> alum = q.getResultList();
		List<Profesor> listaProfesores = new ArrayList();
		listaProfesores.add(p);
		p.setLista_alumnos(alum);
		Transaction t = sesion.beginTransaction();
		for (Alumnos a : alum) {
			a.setProfesores(listaProfesores);
			sesion.update(a);
		}
		sesion.update(p);
		t.commit();
		System.out.println("Todo correcto");
	}

}
