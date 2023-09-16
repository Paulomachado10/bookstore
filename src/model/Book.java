package model;

import java.util.Objects;

/**
 * Representa o modelo de um livro dentro do domínio do problema apresentado
 * 
 * @author Paulo Machado
 *
 */
public class Book {

	private String name;
	private int quatityPages;
	private Author author;
	private String category;
	
	public Book(String name, int quatityPages, String category, String authorName, String biography) {
		super();
		this.name = name;
		this.quatityPages = quatityPages;
		this.category = category;
		this.author = new Author(authorName, biography);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuatityPages() {
		return quatityPages;
	}

	public void setQuatityPages(int quatityPages) {
		this.quatityPages = quatityPages;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public int hashCode() {
		return Objects.hash(author, category, name, quatityPages);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(category, other.category)
				&& Objects.equals(name, other.name) && quatityPages == other.quatityPages;
	}


	@Override
	public String toString() {
		return "Book [name=" + name + ", quatityPages=" + quatityPages + ", author=" + author + ", category=" + category
				+ "]";
	}
	
	
}
