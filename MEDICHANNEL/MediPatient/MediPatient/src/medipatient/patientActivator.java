package medipatient;

import medipharmacyservice.PharmacyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class patientActivator implements BundleActivator {

	ServiceReference servicereference;
	//static int j = 0;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting patient service.......");
		servicereference = bundleContext.getServiceReference(PharmacyService.class.getName());
		PharmacyService pharmacyService = (PharmacyService) bundleContext.getService(servicereference);
		pharmacyService.displayAllMedicines();
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop the patient.......");
		//j++;
		bundleContext.ungetService(servicereference);
		
	}

}
