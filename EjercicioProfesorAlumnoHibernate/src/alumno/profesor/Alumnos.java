package alumno.profesor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Alumnos {

	@Id
	@GeneratedValue
	private int id;

	private String nombre;

	@ManyToMany
	private List<Profesor> listaProfesores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Profesor> getProfesores() {
		return listaProfesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.listaProfesores = profesores;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", profesores=" + listaProfesores + "]";
	}

}
