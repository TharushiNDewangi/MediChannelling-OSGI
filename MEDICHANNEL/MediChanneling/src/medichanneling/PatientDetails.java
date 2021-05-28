package medichanneling;

public class PatientDetails {
	private final String num;
	private final String fname;
	private final String lname;
	private final int age;
	private final static String PATIENTLIST="D:/csv/patient/patientlist.csv";
	
	public PatientDetails(String no,String fname,String lname,int age)
	{
		this.num=no;
		this.fname=fname;
		this.lname=lname;
		this.age=age;
	}
	

	
	public String getNum() {
		return num;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public int getAge() {
		return age;
	}
	public static String getPatientlist() {
		return PATIENTLIST;
	}
	

	public String toString() {
		return num+","+fname+","+lname+","+age;
	}
	

}
