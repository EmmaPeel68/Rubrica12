package r12.model;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {

	private String name_Author;
	private Date date_OfBirth;
	private int idAuthor;

	public Date getDateOfBirth() {
		return date_OfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.date_OfBirth = dateOfBirth;
	}

	public String getNameAuthor() {
		return name_Author;
	}

	public void setNameAuthor(String name_Author) {
		this.name_Author = name_Author;
	}

	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	

}
