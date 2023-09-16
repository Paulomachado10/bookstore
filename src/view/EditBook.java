package view;

import java.util.Scanner;

import controller.BookController;

public class EditBook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("* EDIT BOOK *");
			System.out.print("Book Name: ");
			String bookName = scan.nextLine();
			System.out.print("Book ID: ");
			int bookID = scan.nextInt();
			
			BookController controller = new BookController();
			controller.editBook(bookName, bookID);

			System.out.println("Livro editado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao editar livro: " + e);
		} finally {
			scan.close();
		}

	}

}
