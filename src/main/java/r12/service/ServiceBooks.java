package r12.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r12.model.Books;
import r12.repository.Repository_Books;

@Service
public class ServiceBooks {

	@Autowired
	Repository_Books repositoryBook;
	
	public void insertBook(Books book){
		repositoryBook.insert_Book(book);
	}
	
	public List find_Books(Books book) {
		return repositoryBook.find_Books(book);
	}
	
	public ArrayList<Books> find_Books_ByidAuthor(int idAuthor) {
		return repositoryBook.find_Books_ByidAuthor(idAuthor);
	}
}

