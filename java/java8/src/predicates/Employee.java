package predicates;

public class Employee {

	public Employee(Integer id, Integer age, String gender, String fname, String lname) {
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.fName = fname;
		this.lName = lname;
	}

	private Integer id;
	private Integer age;
	private String gender;
	private String fName;
	private String lName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return this.id.toString() + " - " + this.age.toString();
	}
}
