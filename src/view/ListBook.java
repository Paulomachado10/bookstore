package view;

import java.util.List;
import java.util.Scanner;

import controller.BookController;
import model.Book;

public class ListBook {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("* LIST BOOK: *");
			System.out.println("*TYPE A BOOK NAME: *");
			String bookName = scan.nextLine();
			System.out.println("* TYPE AUTHOR NAME: *");
			String authorName = scan.nextLine();	
			
			BookController controller = new BookController();
			List<Book> books = controller.listBook(bookName, authorName);
			
			if(books.size() >0) {
				books.forEach(book -> System.out.println(book));
			} else {
				System.out.println("Nenhum livro encontrado");
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar livros: " + e);
		} finally {
			scan.close();
		}
	}

}
