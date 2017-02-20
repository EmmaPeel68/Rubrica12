package r12.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import r12.model.Author;
import r12.model.Books;

@org.springframework.stereotype.Repository
public class Repository_Books extends Repository {

	public void insert_Book(Books book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO BOOK (TITLE,ISBN,IDAUTHOR)" + "VALUES (?,?,?)");
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setInt(2, book.getIsbn());
			preparedStatement.setInt(3, book.getIdAuthor());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		close(preparedStatement);
		manager.close(conn);
	}
	
	public ArrayList<Books> find_Books_ByidAuthor(int idAuthor) {
		ArrayList<Books> list = new ArrayList<Books>();
		
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM BOOK WHERE IDAUTHOR  = ?");
			preparedStatement.setInt(1, idAuthor);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Books book = new Books();
				book.setIdBooks(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setIsbn(resultSet.getInt(3));
				book.setIdAuthor(resultSet.getInt(4));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	}

	public List find_Books(Books book) {
		ArrayList<Books> list = new ArrayList<Books>();

		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * FROM BOOK WHERE TITLE like ?");
			if (book.getIsbn() != 0) {
				sb.append("OR ISBN like '%?%'");
			}
			preparedStatement = conn.prepareStatement(sb.toString());
			preparedStatement.setString(1, "%" + book.getTitle() + "%");
			if (book.getIsbn() != 0) {
				preparedStatement.setInt(2, book.getIsbn());
			}

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Books bookTmp = new Books();
				bookTmp.setIdBooks(resultSet.getInt(1));
				bookTmp.setTitle(resultSet.getString(2));
				bookTmp.setIsbn(resultSet.getInt(3));
				bookTmp.setIdAuthor(resultSet.getInt(4));
				list.add(bookTmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	}
}
