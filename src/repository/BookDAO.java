package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

/**
 * Classe que representa o objeto de acesso a dados
 * 
 * @author Paulo Machado
 *
 */
public class BookDAO {

	public String url = "jdbc:mysql://localhost:3306/bookstore";
	public String user = "root";
	public String pass = "";
	public Connection con = null;

	/**
	 * Abre uma conexão com o banco de dados
	 * 
	 * @return Connection através das credenciais fornecidas
	 */
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado com sucesso");
			return con;
		} catch (Exception e) {
			System.out.println("Falha ao conectar");
			return null;
		}
	}

	/**
	 * Fecha uma conexão caso não seja nula
	 * 
	 */
	public void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("Falha ao fechar conexão");
		}
	}

	/**
	 * Insere um novo livro na base da dados
	 * 
	 * @param book Objeto que representa um livro 
	 * @throws SQLException
	 */
	public void insert(Book book)throws SQLException {
		Connection cn = this.getConnection();
		String query = "insert into book (name, quantityPages, author , category) values (?,?,?,?) ";
		try {
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, book.getName());
			pst.setInt(2, book.getQuatityPages());
			pst.setString(3, book.getAuthor().getName());
			pst.setString(4, book.getCategory());
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir");
		}

	}
	
	/**
	 * Realiza a listagem dos livros de acordo com o filtro recebido
	 * 
	 * 
	 * @param bookName String que representa o nome do livro
	 * @param authorName String que representa o nome do autor do libro
	 * @return
	 */
	public List<Book> list(String bookName, String authorName) {
		List<Book> listBooks = new ArrayList<>();
		Connection cn = this.getConnection();
		String query = "select * from book where name like ? and author like ?";
		
		try {
			PreparedStatement st = cn.prepareStatement(query);
			
			st.setString(1, '%'+bookName+'%');
			st.setString(2, '%'+authorName+'%');
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				listBooks.add(new Book(rs.getString("name"), rs.getInt("quantityPages"), rs.getString("category"), rs.getString("author"), null));
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar: " +e);
		}
		
		return listBooks;
	}
	
	/**
	 * Realiza a remoção de um livro da base de dados
	 * 
	 * @param book Objeto que representa um livro 
	 */
	public void remover(Book book) {
		Connection cn = this.getConnection();
		String query = "delete from book where name like ? and author like ?";
		try {
			PreparedStatement st = cn.prepareStatement(query);
			
			st.setString(1, '%'+book.getName()+'%');
			st.setString(2, '%'+book.getAuthor().getName()+'%');
			st.execute();
		} catch (Exception e) {
			System.out.println("Erro ao remover: " +e);
		}
	}
	
	/**
	 * Atualiza um livro na base de dados
	 * 
	 * @param bookName String que representa o novo titulo para o livro
	 * @param id Int que representa o id de qual livro irá sofrer a alteração
	 */
	public void atualizar(String bookName, int id) {
		Connection cn = this.getConnection();
		String query = "update book set `name` = ? where idbook = ?";
		try {
			PreparedStatement st = cn.prepareStatement(query);
			
			st.setString(1, bookName);
			st.setInt(2, id);
			st.execute();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar: " +e);
		}
	}
}
	
