package medipharmacyservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import medifilehandler.CSVFILE;

public class Activator implements BundleActivator {

	//private static BundleContext context;
	ServiceRegistration publishServiceRegistration;
	ServiceReference serviceReference;

//	static BundleContext getContext() {
//		//return context;
//	}

	public void start(BundleContext bundleContext) throws Exception {
		//Activator.context = bundleContext;
		System.out.println("Starting pharmacy service......");
		serviceReference = bundleContext.getServiceReference(CSVFILE.class.getName());
		CSVFILE csv = (CSVFILE)bundleContext.getService(serviceReference);
		
		PharmacyService pharmacyService = new PharmacyServiceImple(csv);
		publishServiceRegistration = bundleContext.registerService(PharmacyService.class.getName(), pharmacyService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		System.out.println("Stopping pharmacy Service......");
		publishServiceRegistration.unregister();
		bundleContext.ungetService(serviceReference);
	}

}
