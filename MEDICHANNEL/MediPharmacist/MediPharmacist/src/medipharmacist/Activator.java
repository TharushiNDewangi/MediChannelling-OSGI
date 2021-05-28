package medipharmacist;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import medipharmacyservice.PharmacyService;

public class Activator implements BundleActivator {

	ServiceReference servicereference;
	
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting pharmacist service........");
		servicereference = bundleContext.getServiceReference(PharmacyService.class.getName());
		PharmacyService pharmacyService = (PharmacyService) bundleContext.getService(servicereference);
		pharmacyService.displayAllMedicines();
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop the parmarcist.........");
		bundleContext.ungetService(servicereference);
		
	}

}
