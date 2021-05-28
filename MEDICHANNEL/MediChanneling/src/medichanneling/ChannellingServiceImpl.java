package medichanneling;

import java.util.ArrayList;
import java.util.Scanner;

import medifilehandler.CSVFILE;

public class ChannellingServiceImpl implements ChannelingService {
private CSVFILE csvFile;
Scanner sc= new Scanner(System.in);
String no;
String fname;
String lname;int age;

	public ChannellingServiceImpl(CSVFILE csvFile) {
	
	this.csvFile = csvFile;
	this.csvFile.createFirestcsv(PatientDetails.getPatientlist(),"no,fname,lname,age");
}
	

	@Override
	public boolean addnewchannel(String no, String fname, String lname, int age) {
		// TODO Auto-generated method stub
		System.out.println("new pation addeding");
		
		PatientDetails pd=new PatientDetails(no,fname,lname,age);
		csvFile.writecsv(pd.toString(),pd.getPatientlist());
		System.out.println("new pation added");
		displaychannel();
		return true;
	}

	
	@Override
	public void displaychannel() {
		// TODO Auto-generated method stub
		ArrayList<String[]> patientlist=getPatientlist();
		System.out.println("*******patients list******* ");
		System.out.println("ID"+"\tFirst Name "+"\tLast Name "+"\tAge");
		for(int i =0;i<patientlist.size();i++)
		{
			
			System.out.println(patientlist.get(i)[0]+"\t "+patientlist.get(i)[1]
					+"\t"+patientlist.get(i)[2]+"\t"+patientlist.get(i)[3]);
			
			
		}
		
	}

	private ArrayList<String[]> getPatientlist() {
		// TODO Auto-generated method stub
		return csvFile.readcsv(PatientDetails.getPatientlist());
	}

	
}
