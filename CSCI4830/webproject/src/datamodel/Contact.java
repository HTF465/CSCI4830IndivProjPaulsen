package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE Contact(
  id INT NOT NULL AUTO_INCREMENT,
  fname VARCHAR(30) NOT NULL,
  lname VARCHAR(30) NOT NULL,
  number int NOT NULL,
  dname VARCHAR(30),
  email VARCHAR(30),
  hidden int NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "Contact")
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
   private int hidden;
   
  

   
   public Contact() {
		super();
	}

	public Contact(String fname, String lname, String number, String dname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.number = number;
		this.dname = dname;
		this.email = email;
		this.hidden = 0;

	}
	
	public Contact(int id, String fname, String lname, String number, String dname, String email, int hidden) {
		super();
		this.id = id;
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

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}


	@Override
	public String toString() {
		String out = "";
		if (hidden != 0)
		{
			if ((dname == null || dname.isEmpty()) && (email == null || email.isEmpty()))
			{
				out = String.format("%d %s %s: %s", id, fname, lname, number);
			}
			else if (dname == null || dname.isEmpty())
			{
				out = String.format("%d %s %s: %s %s", id, fname, lname, number, email);
			}
			else
			{
				out = String.format("%d %s: %s %s", id, dname, number, email);
			}
		}
		return out;
	}


   

   

  
}