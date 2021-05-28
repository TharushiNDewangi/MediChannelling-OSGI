package mediadmin;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import medichanneling.ChannelingService;
import medichanneling.ChannellingServiceImpl;
import medipharmacyservice.PharmacyService;

public class Activator implements BundleActivator {


	ServiceRegistration servicereg;
	
	ServiceReference serviceref,serviceref1;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	
	public void start(BundleContext bundleContext) throws Exception {
		//Activator.context = bundleContext;
		System.out.println("starting admin panel ....");
		serviceref =bundleContext.getServiceReference(ChannelingService.class.getName());
		ChannelingService cs=(ChannelingService) bundleContext.getService(serviceref);
		
		serviceref1=bundleContext.getServiceReference(PharmacyService.class.getName());
		PharmacyService ps=(PharmacyService) bundleContext.getService(serviceref1);
		
		Getpatientdetails.select(cs,ps);
		
		
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		System.out.println("good bye admin ....");
		bundleContext.ungetService(serviceref);
		bundleContext.ungetService(serviceref1);
	}

}
