package medifilehandler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	//private static BundleContext context;
	ServiceRegistration sr;



	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		//Activator.context = bundleContext;
		System.out.println("start file operator");
		CSVFILE csf=new CSVFILE();
		sr = bundleContext.registerService(CSVFILE.class.getName(),csf, null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		System.out.println("stop file operator");
		sr.unregister();
	}

}
