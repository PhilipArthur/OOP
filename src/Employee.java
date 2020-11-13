
public class Employee {
	private String name;
	private String date;
	private String division;
	private String level;
	
	public Employee(String name, String date, String division, String level) {
		super();
		this.name = name;
		this.date = date;
		this.division = division;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	

}
