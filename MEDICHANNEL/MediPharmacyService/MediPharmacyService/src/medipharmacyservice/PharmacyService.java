package medipharmacyservice;

import java.sql.Date;
import java.util.ArrayList;

public interface PharmacyService {
	public boolean addNewMedicines(String Name,String expireDate,double price);
	public ArrayList<String> displayAllMedicines();
	
	//boolean addNewMedicines(String Name, String expireDate, Float price);

}
