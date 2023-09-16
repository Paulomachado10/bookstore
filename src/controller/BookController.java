package controller;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import repository.BookDAO;

/**
 * Representa o controlador de atividades para um livro 
 * 
 * @author Paulo Machado
 *
 */
public class BookController {
	BookDAO dao = new BookDAO();
	
	public void insertBook(String bookName, int quantityPages, String category, String authorName, String biography) throws SQLException {
		Book book = new Book(bookName, quantityPages, null, authorName, biography);
		
		dao.insert(book);
	}

	public List<Book> listBook(String bookName, String authorName) {
		List<Book> books = dao.list(bookName, authorName);
		return books;
	}
	
	public void editBook(String bookName, int id) {
		dao.atualizar(bookName, id);		
		
	}


	public void deleteBooK(String bookName, String authorName) {
		Book book = new Book(bookName, 0, null, authorName, null);
		dao.remover(book);
		
	}

	

}
