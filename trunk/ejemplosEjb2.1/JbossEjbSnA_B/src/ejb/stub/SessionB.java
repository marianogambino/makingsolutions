package ejb.stub;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class SessionB implements SessionBean {

	SessionContext ctx;
	
	public void ejbCreate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}
	
	public void invocarSessionA() throws RemoteException
	{
		//Seteo las propiedades para llamar
		Properties props= new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		
		String cadena="";
		
		try
		{
			InitialContext ctx = new InitialContext(props);
			
			Object obj=ctx.lookup("sessionA");
			HomeA homeA =(HomeA) PortableRemoteObject.narrow(obj, HomeA.class);
			EjbObjectA ejbA=(EjbObjectA) homeA.create();
			
			System.out.println("Session B invoando al Session : " +  ejbA.soySessionA());
			
		}
		catch(Exception e)
		{
			System.out.println("Exceptio en A");
			e.printStackTrace();
		}
		
	}
	
	public String soySessionB() throws RemoteException
	{
		return "Soy el session B y mi hashCode es : " +  this.hashCode();
	}

}
