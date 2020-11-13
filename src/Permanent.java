
public class Permanent extends Employee {
	
	private String employDate;
	private int insurance;
	private String id;
	
	
	public Permanent(String name, String date, String id, String division, String level, String employDate,
			int insurance) {
		super(name, date, division, level);
		int temp = Integer.parseInt(id);
		String tempid=id;
		if(temp < 10) {
			tempid = "00" +id;
		}else if(temp <100) {
			tempid = "0" +id;
		}
		this.id = "P" + tempid;
		this.employDate = employDate;
		this.insurance = insurance;
	}

	public Permanent(String name, String date, String id, String division, String level) {
		super(name, date, division, level);
		// TODO Auto-generated constructor stub
	}

	public String getEmployDate() {
		return employDate;
	}

	public void setEmployDate(String employDate) {
		this.employDate = employDate;
	}

	public int getInsurance() {
		return insurance;
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

}
