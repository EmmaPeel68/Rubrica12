package r12.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r12.model.Author;
import r12.repository.Repository_Author;

@Service
public class ServiceAuthor {

	@Autowired
	Repository_Author rAuthor;
	
	public void insert_Author(Author author){
		rAuthor.insert_Author(author);
	}
	
	public ArrayList<Author> find_Authors(Author author) {
		return rAuthor.find_Authors(author);
	}
	
	public ArrayList<Author> findAuthorsByDate(Date date) {
		return rAuthor.find_Authors_ByDate(date);
	}
}
