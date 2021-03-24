package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "employee")
public class Contact {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "fname")
   private String fname;

   @Column(name = "lname")
   private String lname;
   
   @Column(name = "number")
   private String number;
   
   @Column(name = "dname")
   private String dname;
   
   @Column(name = "email")
   private String email;
   
   @Column(name = "hidden")
   private String hidden;
   
  

   
   public Contact() {
		super();
	}

	public Contact(String fname, String lname, String number, String dname, String email, String hidden) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.number = number;
		this.dname = dname;
		this.email = email;
		this.hidden = hidden;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}


	@Override
	public String toString() {
		return String.format("%d %s %s: %s", id, fname, lname, number);
	}


   

   

  
}