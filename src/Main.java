import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<Contract> cVector = new Vector<>();
	Vector<Permanent> pVector = new Vector<>();
	
	public Main(){
		Integer choice;
		cVector.add(new Contract("Artur", "11", "12", "aaa", "aaa", "aaa", 12));
		do 
		{
				System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
				System.out.println("1. Input Data");
				System.out.println("2. View Data");
				System.out.println("3. Search Data");
				System.out.println("4. Delete Data");
				System.out.println("5. Update Data");
				System.out.println("6. Exit");
				try {
					choice = scan.nextInt();
				} catch (Exception e) {
					choice = 0;
				}finally {
					scan.nextLine();
				};
				
				switch (choice) {
				case 1:
					inputData();
					break;
				case 2:
					viewData();
					scan.nextLine();
					break;
				case 3:
					searchData();
					break;
				case 4:
					deleteData();
					break;
				case 5:
					updateData();
					break;
				}	
		} while (choice !=6);
		
	}

	private void viewData() {
		System.out.println("Contracted Employee");
		if(!cVector.isEmpty()) {
			System.out.println("EMPLOYEE ID | NAME | DATE OF BIRTH | EMPLOYEE DIVISION | JOB LEVEL | DATE OF CONTRACT | CONTRACT LENGTH");
			for (Contract contract : cVector) {
				System.out.println(contract.getId() + " | " +contract.getName() + " | " + contract.getDate() + " | " + contract.getDivision() + " | "
						+ contract.getLevel() + " | " + contract.getContractDate() + " | " + contract.getContractTime());
			}
			System.out.println("-------------------------------------------------------------------------------------------------------");
		}else {
			System.out.println("No Contract Employee");
		}
		System.out.println();
		System.out.println("Permanent Employee");
		if(!pVector.isEmpty()) {
			System.out.println("EMPLOYEE ID | NAME | DATE OF BIRTH | EMPLOYEE DIVISION | JOB LEVEL | DATE OF EMPLOYEMENT | INSURANCE AMOUNT");
			for (Permanent perma : pVector) {
				System.out.println(perma.getId() + " | " +perma.getName() + " | " + perma.getDate() + " | " + perma.getDivision() + " | "
						+ perma.getLevel() + " | " + perma.getEmployDate() + " | " + perma.getInsurance());
			}
			System.out.println("-------------------------------------------------------------------------------------------------------");
		}else {
			System.out.println("No Permanent Employee");
		}
		System.out.println();
	}

	private void updateData() {
		viewData();
		
		String id;
		System.out.println("Please input the ID:"); id = scan.nextLine();
		
		
		if(id.startsWith("C")) {
			boolean flag = false;
			for (Contract contract : cVector) {
				if(contract.getId().equals(id)) {
					cVector.remove(contract);
					flag = !flag;
					break;
				}
				if(!flag) {
					System.out.println("Id not found!");
				}
			}
		}else {
			boolean flag = false;
			for (Permanent perma : pVector) {
				if(perma.getId().equals(id)) {
					pVector.remove(perma);
					flag = !flag;
					break;
				}
				if(!flag) {
					System.out.println("Id not found!");
				}
			}
		}		

		String[] partition = id.split("(?<=\\D)(?=\\d)");
		int temp;
		temp = Integer.parseInt(partition[1]);
		// FOR NAME
		String name;
		System.out.println("Please Enter Your Name: ");
		name = scan.nextLine();
				
				
		// FOR DATE
	    String date = "";
		    
		int year;
		do {
			System.out.println("Please Enter Your Birth Year[1900-2019]: ");
			try {
				year = scan.nextInt();
			} catch (Exception e) {
				year = 0;
			} finally {
				scan.nextLine();
			} 
		} while (year<1900 || year>2019);
		
		int month;
		do {
			System.out.println("Please Enter Your Birth Month[1-12]: ");
			try {
				month = scan.nextInt();
			} catch (Exception e) {
				month = 0;
			} finally{
				scan.nextLine();
			}
		} while (month < 1 || month >12);
		    
		int day;
		do {
			System.out.println("Please Enter Your Birth Day[1-31]: ");
			try {
				day = scan.nextInt();
			} catch (Exception e) {
				day = 0;
			} finally {
				scan.nextLine();
			}
					
			if(!(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >30){
				System.out.println("This Month don't have 31st!");
				day = 0;
			}else if(month == 2 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))&& day > 28){
				System.out.println("This Year is not Leap Year!");
				day = 0;
			}
		} while (day < 1 || day > 31);
				
		date = day + "/" + month + "/" + year;
		System.out.println("Date: " + date);
				
				
		// FOR DIVISION
		String division;
		System.out.println("Please Enter Your Division: ");
		division = scan.nextLine();
		String job;
	    System.out.println("Please Enter Your Job: ");
	    job = scan.nextLine();
			    			    
	    // EMPLOYEE TYPE
	    String type;
	    do {
	    	System.out.println("Type of Employee [Contract/Permanent]: ");
			type = scan.nextLine();
		} while (!type.equals("Contract")&&!type.equals("Permanent"));
	    //CONTRACT TYPE
	    if(type.equals("Contract")){
	    	int cYear;
			do {
				System.out.println("Please Enter Your Contract Year[1900-2019]: ");
				try {
					cYear = scan.nextInt();
				} catch (Exception e) {
					cYear = 0;
				} finally {
					scan.nextLine();
				} 
			} while (cYear<1900 || cYear>2019);
					
			int cMonth;
			do {
				System.out.println("Please Enter Your Contract Month[1-12]: ");
				try {
					cMonth = scan.nextInt();
				} catch (Exception e) {
					cMonth = 0;
				} finally{
					scan.nextLine();
				}
			} while (cMonth < 1 || cMonth >12);
		    
			int cDay;
			do {
				System.out.println("Please Enter Your Contract Day[1-31]: ");
				try {
					cDay = scan.nextInt();
				} catch (Exception e) {
					cDay = 0;
				} finally {
					scan.nextLine();
				}
						
				if(!(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >30){
					System.out.println("This Month don't have 31st!");
					day = 0;
				}else if(month == 2 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))&& day > 28){
					System.out.println("This Year is not Leap Year!");
					day = 0;
				}
			} while (cDay < 1 || cDay > 31);
					
			String cDate = cDay + "/" + cMonth + "/" + cYear;
			System.out.println("Contract Date: " + cDate);
			
			int cTime;
			do {
				try {
					System.out.println("Please Enter The Length of Your Contract[1-5]:");
					cTime = scan.nextInt();
				} catch (Exception e) {
					cTime = 0;
				} finally {
					scan.nextLine();
				} 
			} while (cTime < 1 || cTime >5);
			cVector.add(new Contract(name, date, ""+temp+"", division, job, cDate, cTime));
			
	    } else { // PERMANENT TYPE
	    	int eYear;
			do {
				System.out.println("Please Enter Your Employment Year[1900-2019]: ");
				try {
					eYear = scan.nextInt();
				} catch (Exception e) {
					eYear = 0;
				} finally {
					scan.nextLine();
				} 
			} while (eYear<1900 || eYear>2019);
			
			int eMonth;
			do {
				System.out.println("Please Enter Your Employment Month[1-12]: ");
				try {
					eMonth = scan.nextInt();
				} catch (Exception e) {
					eMonth = 0;
				} finally{
					scan.nextLine();
				}
			} while (eMonth < 1 || eMonth >12);
		    
			int eDay;
			do {
				System.out.println("Please Enter Your Employment Day[1-31]: ");
				try {
					eDay = scan.nextInt();
				} catch (Exception e) {
					eDay = 0;
				} finally {
					scan.nextLine();
				}
				
				if(!(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >30){
					System.out.println("This Month don't have 31st!");
					day = 0;
				}else if(month == 2 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))&& day > 28){
					System.out.println("This Year is not Leap Year!");
					day = 0;
				}
			} while (eDay < 1 || eDay > 31);
			String eDate = eDay + "/" + eMonth + "/" + eYear;
			System.out.println("Employement Date: " + eDate);
	    	
			int insurance;
			do {// INSURANCE FOR PERMANENT
				System.out.println("Please Enter Amount of Insurance: ");
				try {
					insurance = scan.nextInt();
				} catch (Exception e) {
					insurance = 0;
				} finally {
					scan.nextLine();
				} 
			} while (insurance <= 0);
		
			pVector.add(new Permanent(name, date, ""+temp+ "", division, job, eDate, insurance));
	    	
	    }
	    

	}

	private void deleteData() {
		viewData();
		
		String id;
		System.out.println("Please input the ID:"); id = scan.nextLine();
		
		if(id.startsWith("C")) {
			boolean flag = false;
			for (Contract contract : cVector) {
				if(contract.getId().equals(id)) {
					cVector.remove(contract);
					flag = !flag;
					System.out.println("ID "+ id + " has been deleted");
					break;
				}
				if(!flag) {
					System.out.println("Id not found!");
				}
			}
		}else {
			boolean flag = false;
			for (Permanent perma : pVector) {
				if(perma.getId().equals(id)) {
					pVector.remove(perma);
					flag = !flag;
					System.out.println("ID "+ id + " has been deleted");
					break;
				}
				if(!flag) {
					System.out.println("Id not found!");
				}
			}
		}
		scan.nextLine();
	}

	private void searchData() {
		int menu;
		do {
			System.out.println("Search by: ");
			System.out.println("1. ID");
			System.out.println("2. Name");
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				menu=0;
			} finally {
				scan.nextLine();
			}
		
			System.out.println("Contracted Employee");
			if(!cVector.isEmpty()) {
				System.out.println("EMPLOYEE ID | NAME |");
				for (Contract contract : cVector) {
					System.out.println(contract.getId() + " | " +contract.getName());
				}
				System.out.println("-------------------");
			}else {
				System.out.println("No Contract Employee");
			}
			System.out.println();
			System.out.println("Permanent Employee");
			if(!pVector.isEmpty()) {
				System.out.println("EMPLOYEE ID | NAME |");
				for (Permanent perma : pVector) {
					System.out.println(perma.getId() + " | " +perma.getName() + " | ");
				}
				System.out.println("-------------");
			}else {
				System.out.println("No Permanent Employee");
			}
			System.out.println();
			
			switch(menu) {
				case 1:{

					String id;
					System.out.println("Please input the ID:"); id = scan.nextLine();
					
					if(id.startsWith("C")) {
						boolean flag = false;
						for (Contract contract : cVector) {
							if(contract.getId().equals(id)) {
								System.out.println("ID "+ id + " found!");
								System.out.println("--------------------------------------------------------");
								System.out.println("Employee Id				: " + contract.getId());
								System.out.println("Employee Name			: " + contract.getName());
								System.out.println("Employee DoB			: " + contract.getDate());
								System.out.println("Employee Division		: " + contract.getDivision());
								System.out.println("Employee Job			: " + contract.getLevel());
								System.out.println("Employee Contract Date	: " + contract.getContractDate());
								System.out.println("Employee Contract Length: " + contract.getContractTime());
								System.out.println("--------------------------------------------------------");
								flag = true;
								break;
							}
							if(flag==false) {
								System.out.println("Id not found!");
							}
						}
					}else {
						boolean flag = false;
						for (Permanent perma : pVector) {
							if(perma.getId().equals(id)) {
								System.out.println("ID "+ id + " found!");
								System.out.println("--------------------------------------------------------");
								System.out.println("Employee Id				 : " + perma.getId());
								System.out.println("Employee Name			 : " + perma.getName());
								System.out.println("Employee DoB			 : " + perma.getDate());
								System.out.println("Employee Division	 	 : " + perma.getDivision());
								System.out.println("Employee Job			 : " + perma.getLevel());
								System.out.println("Employee Employment Date : " + perma.getEmployDate());
								System.out.println("Employee Insurance Amount: " + perma.getInsurance());
								System.out.println("--------------------------------------------------------");
								flag = !flag;
								break;
							}
							if(!flag) {
								System.out.println("Id not found!");
							}
						}
					}
					scan.nextLine();
					
					break;
				}
				case 2:{
					
					String name;
					System.out.println("Please input the name:"); name = scan.nextLine();
					
					boolean flag = false;
					
					for (Contract contract : cVector) {
						if(contract.getName().equals(name)) {
							System.out.println(name + " found!");
							System.out.println("--------------------------------------------------------");
							System.out.println("Employee Type			: Contract");
							System.out.println("Employee Id				: " + contract.getId());
							System.out.println("Employee Name			: " + contract.getName());
							System.out.println("Employee DoB			: " + contract.getDate());
							System.out.println("Employee Division		: " + contract.getDivision());
							System.out.println("Employee Job			: " + contract.getLevel());
							System.out.println("Employee Contract Date	: " + contract.getContractDate());
							System.out.println("Employee Contract Length: " + contract.getContractTime());
							System.out.println("--------------------------------------------------------");
							flag = !flag;
							break;
						}
					}
					
					if(!flag) {
						for (Permanent perma : pVector) {
							if(perma.getName().equals(name)) {
								System.out.println(name+ " found!");
								System.out.println("--------------------------------------------------------");
								System.out.println("Employee Type 			 : Permanent");
								System.out.println("Employee Id				 : " + perma.getId());
								System.out.println("Employee Name			 : " + perma.getName());
								System.out.println("Employee DoB			 : " + perma.getDate());
								System.out.println("Employee Division	 	 : " + perma.getDivision());
								System.out.println("Employee Job			 : " + perma.getLevel());
								System.out.println("Employee Employment Date : " + perma.getEmployDate());
								System.out.println("Employee Insurance Amount: " + perma.getInsurance());
								System.out.println("--------------------------------------------------------");
								flag = !flag;
								break;
							}
						}
					}
					
					if(!flag) {
						System.out.println(name+ " not found!");
					}
					
					
					
					break;
				}
			}
		} while (menu < 1 || menu > 2);
		
		
			
	}

	private void inputData() {
		// FOR NAME
		String name;
		System.out.println("Please Enter Your Name: ");
		name = scan.nextLine();
		
		
		// FOR DATE
	    String date = "";
	    
		int year;
		do {
			System.out.println("Please Enter Your Birth Year[1900-2001]: ");
			try {
				year = scan.nextInt();
			} catch (Exception e) {
				year = 0;
			} finally {
				scan.nextLine();
			} 
		} while (year<1900 || year>2001);
		
		int month;
		do {
			System.out.println("Please Enter Your Birth Month[1-12]: ");
			try {
				month = scan.nextInt();
			} catch (Exception e) {
				month = 0;
			} finally{
				scan.nextLine();
			}
		} while (month < 1 || month >12);
	    
		int day;
		do {
			System.out.println("Please Enter Your Birth Day[1-31]: ");
			try {
				day = scan.nextInt();
			} catch (Exception e) {
				day = 0;
			} finally {
				scan.nextLine();
			}
			
			if(!(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >30){
				System.out.println("This Month don't have 31st!");
				day = 0;
			}else if(month == 2 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))&& day > 28){
				System.out.println("This Year is not Leap Year!");
				day = 0;
			}
		} while (day < 1 || day > 31);
		
		date = day + "/" + month + "/" + year;
		System.out.println("Date: " + date);
		
		
		// FOR DIVISION
		String division;
		System.out.println("Please Enter Your Division: ");
		division = scan.nextLine();
		String job;
	    System.out.println("Please Enter Your Job: ");
	    job = scan.nextLine();
	    
	    int id=0;
	    for (int i = 0; i < 3; i++) {
	    	id *= 10;
			id += rand.nextInt(10);
		}
	    
	    
	    // EMPLOYEE TYPE
	    String type;
	    do {
	    	System.out.println("Type of Employee [Contract/Permanent]: ");
			type = scan.nextLine();
		} while (!type.equals("Contract")&&!type.equals("Permanent"));
	    //CONTRACT TYPE
	    if(type.equals("Contract")){
	    	int cYear;
	    	int tempyear = year+18;
			do {
				System.out.printf("Please Enter Your Contract Year[%d-2019]: ",tempyear);
				try {
					cYear = scan.nextInt();
				} catch (Exception e) {
					cYear = 0;
				} finally {
					scan.nextLine();
				} 
			} while (cYear<tempyear || cYear>2019);
			
			int cMonth;
			do {
				System.out.println("Please Enter Your Contract Month[1-12]: ");
				try {
					cMonth = scan.nextInt();
				} catch (Exception e) {
					cMonth = 0;
				} finally{
					scan.nextLine();
				}
			} while (cMonth < 1 || cMonth >12);
		    
			int cDay;
			do {
				System.out.println("Please Enter Your Contract Day[1-31]: ");
				try {
					cDay = scan.nextInt();
				} catch (Exception e) {
					cDay = 0;
				} finally {
					scan.nextLine();
				}
				
				if(!(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >30){
					System.out.println("This Month don't have 31st!");
					day = 0;
				}else if(month == 2 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))&& day > 28){
					System.out.println("This Year is not Leap Year!");
					day = 0;
				}
			} while (cDay < 1 || cDay > 31);
			
			String cDate = cDay + "/" + cMonth + "/" + cYear;
			System.out.println("Contract Date: " + cDate);
			
			int cTime;
			do {
				try {
					System.out.println("Please Enter The Length of Your Contract[1-5]:");
					cTime = scan.nextInt();
				} catch (Exception e) {
					cTime = 0;
				} finally {
					scan.nextLine();
				} 
			} while (cTime < 1 || cTime >5);
			cVector.add(new Contract(name, date, ""+id+"", division, job, cDate, cTime));
			
	    } else { // PERMANENT TYPE
	    	int eYear;
	    	int tempyear=year+18;
			do {
				System.out.printf("Please Enter Your Employment Year[%d-2019]: ",tempyear);
				try {
					eYear = scan.nextInt();
				} catch (Exception e) {
					eYear = 0;
				} finally {
					scan.nextLine();
				} 
			} while (eYear<tempyear || eYear>2019);
			
			int eMonth;
			do {
				System.out.println("Please Enter Your Employment Month[1-12]: ");
				try {
					eMonth = scan.nextInt();
				} catch (Exception e) {
					eMonth = 0;
				} finally{
					scan.nextLine();
				}
			} while (eMonth < 1 || eMonth >12);
		    
			int eDay;
			do {
				System.out.println("Please Enter Your Employment Day[1-31]: ");
				try {
					eDay = scan.nextInt();
				} catch (Exception e) {
					eDay = 0;
				} finally {
					scan.nextLine();
				}
				
				if(!(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day >30){
					System.out.println("This Month don't have 31st!");
					day = 0;
				}else if(month == 2 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))&& day > 28){
					System.out.println("This Year is not Leap Year!");
					day = 0;
				}
			} while (eDay < 1 || eDay > 31);
			String eDate = eDay + "/" + eMonth + "/" + eYear;
			System.out.println("Employement Date: " + eDate);
	    	
			int insurance;
			do {// INSURANCE FOR PERMANENT
				System.out.println("Please Enter Amount of Insurance: ");
				try {
					insurance = scan.nextInt();
				} catch (Exception e) {
					insurance = 0;
				} finally {
					scan.nextLine();
				} 
			} while (insurance <= 0);
			
			pVector.add(new Permanent(name, date, ""+id+ "", division, job, eDate, insurance));
	    	
	    }
	    
	}

	public static void main(String[] args) {
		new Main();

	}

}
