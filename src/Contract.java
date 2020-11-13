
public class Contract extends Employee {
	
	private String contractDate;
	private int contractTime;
	private String id;
	
	
	public Contract(String name, String date, String id, String division, String level, String contractDate,
			int contractTime) {
		super(name, date, division, level);
		int temp = Integer.parseInt(id);
		String tempid = id;
		if(temp < 10) {
			tempid = "00" +id;
		}else if(temp <100) {
			tempid ="0" +id;
		}
		this.setId("C" + tempid);
		this.contractDate = contractDate;
		this.contractTime = contractTime;
	}
	public Contract(String name, String date, String id, String division, String level) {
		super(name, date, division, level);
		// TODO Auto-generated constructor stub
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public int getContractTime() {
		return contractTime;
	}
	public void setContractTime(int contractTime) {
		this.contractTime = contractTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
