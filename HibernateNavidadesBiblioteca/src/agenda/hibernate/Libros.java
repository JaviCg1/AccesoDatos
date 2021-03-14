package agenda.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@NamedQuery(name = "consulta_por_nombre", query = "FROM Libro where nombre =: nombre")
@Entity
@Table(name = "listaLibros")
public class Libros {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private String titulo, autor, isbn;
	
	
	

	

	@Override
	public String toString() {
		return "Libros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + "]";
	}






	public Libros(String titulo, String autor, String isbn) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
	}






	public String getTitulo() {
		return titulo;
	}






	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}






	public String getAutor() {
		return autor;
	}






	public void setAutor(String autor) {
		this.autor = autor;
	}






	public String getIsbn() {
		return isbn;
	}






	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}






	public int getId() {
		return id;
	}






	Libros() {
		System.out.println("Alguien llama al constructor vac�o...");
	}

	

	

}
