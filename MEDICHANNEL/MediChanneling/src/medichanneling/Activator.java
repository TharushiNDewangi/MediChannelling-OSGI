package medichanneling;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import medifilehandler.CSVFILE;

public class Activator implements BundleActivator {



	ServiceRegistration servicereg;
	ServiceReference serviceref;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("starting channeling service ....");
		serviceref =bundleContext.getServiceReference(CSVFILE.class.getName());
		CSVFILE csv=(CSVFILE) bundleContext.getService(serviceref);
		ChannelingService channling=new ChannellingServiceImpl(csv);
		servicereg=bundleContext.registerService(ChannelingService.class.getName(), channling, null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		System.out.println("stopping channeling service ....");
		servicereg.unregister();
		bundleContext.ungetService(serviceref);
	}

}
