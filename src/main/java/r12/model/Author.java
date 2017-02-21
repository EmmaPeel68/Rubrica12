package r12.model;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {

	private String nameAuthor;
	private Date dateOfBirth;
	private int idAuthor;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String name_Author) {
		this.nameAuthor = name_Author;
	}

	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	

}
