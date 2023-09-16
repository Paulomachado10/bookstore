package view;

import java.util.Scanner;

import controller.BookController;

public class DeleteBook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System .in);
		
		try {
			System.out.println("* LIST BOOK: *");
			System.out.println("*TYPE A BOOK NAME: *");
			String bookName = scan.nextLine();
			System.out.println("* TYPE AUTHOR NAME: *");
			String authorName = scan.nextLine();	
			
			BookController controller = new BookController();
			controller.deleteBooK(bookName, authorName);
			System.out.println("Livro removido com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao remover livro: " + e);
		} finally {
			scan.close();
		}
	}

}
