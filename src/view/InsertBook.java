package view;

import java.util.Scanner;

import controller.BookController;

public class InsertBook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("* INSERT BOOK *");
			System.out.print("Book Name: ");
			String bookName = scan.nextLine();
			System.out.print("Quantity Pages: ");
			int quantityPages = Integer.parseInt(scan.nextLine());
			System.out.print("Category: ");
			String category = scan.nextLine();
			System.out.print("Author Name: ");
			String authorName = scan.nextLine();
			System.out.print("Biography: ");
			String biography = scan.nextLine();

			BookController controller = new BookController();
			controller.insertBook(bookName, quantityPages, category, authorName, biography);

			System.out.println("Livro Inserido com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao inserir o Livro: " + e);
		} finally {
			scan.close();
		}
	}

}
