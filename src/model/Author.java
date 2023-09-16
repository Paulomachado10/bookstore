package model;

import java.util.Objects;

/**
 * Representa um autor no dominio do problema apresntado
 * 
 * @author Paulo Machado
 *
 */
public class Author {

	private String name;
	private String biography;
		
	public Author(String name, String biography) {
		super();
		this.name = name;
		this.biography = biography;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	@Override
	public int hashCode() {
		return Objects.hash(biography, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(biography, other.biography) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", biography=" + biography + "]";
	}
	
	
	
	
	
}
