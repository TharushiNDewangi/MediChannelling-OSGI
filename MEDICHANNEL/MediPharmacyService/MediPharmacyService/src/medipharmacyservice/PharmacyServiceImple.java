package medipharmacyservice;

import java.sql.Date;
import java.util.ArrayList;
import medifilehandler.CSVFILE;
public class PharmacyServiceImple implements PharmacyService{
	
	private CSVFILE csvFile;
	

	public PharmacyServiceImple(CSVFILE csvFile) {
		
		this.csvFile = csvFile;
		
		csvFile.createFirestcsv(Pharmacy.getMedicinescsv(), "Name,expireDate,price");
		
	}

	@Override
	public boolean addNewMedicines(String Name, String expireDate, double price) {
		Pharmacy pharmacy = new Pharmacy(Name,expireDate, price);
		
		csvFile.writecsv(pharmacy.toString(), pharmacy.getMedicinescsv());
		System.out.println("New medicine");
		displayAllMedicines();
		return true;
		
		
	}

	

	@Override
	public ArrayList<String> displayAllMedicines() {
		// TODO Auto-generated method stub
		ArrayList<String[]> medicinelist = getAllMedicines();
		System.out.println("********Displaying all medicines*******");
		System.out.println("Name" + "\tExpire Date" + "\tPrice" );
		for(int i = 0;i <medicinelist.size();i++) {
			
			System.out.println(medicinelist.get(i)[0] +  "\t" +medicinelist.get(i)[1] + "\t" +medicinelist.get(i)[2]);
			
		}
		
		return null;
	}

	public ArrayList<String[]> getAllMedicines() {
		// TODO Auto-generated method stub
		return csvFile.readcsv(Pharmacy.getMedicinescsv());
	}

	
	

	

}
