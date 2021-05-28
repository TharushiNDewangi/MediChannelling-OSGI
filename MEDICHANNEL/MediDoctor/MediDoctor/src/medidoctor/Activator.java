package medidoctor;

import medichanneling.ChannelingService;
import medipharmacyservice.PharmacyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference dserviceReference;
	

	public void start(BundleContext bundleContext) throws Exception {
		//Activator.context = bundleContext;
		System.out.println("starting Doctor.......");
//		serviceReference = bundleContext.getServiceReference(PharmacyService.class.getName());
//		PharmacyService pharmacyService = (PharmacyService) bundleContext.getService(serviceReference);
//		pharmacyService.displayAllMedicines();
		dserviceReference = bundleContext.getServiceReference(ChannelingService.class.getName());
		ChannelingService channelingService = (ChannelingService) bundleContext.getService(dserviceReference);
		channelingService.displaychannel();

		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		System.out.println("stop client........");
		bundleContext.ungetService(dserviceReference);
	}

}
