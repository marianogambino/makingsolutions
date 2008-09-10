package ejb.stub;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class SessionA implements SessionBean
{

	SessionContext ctx;
	
	public void ejbCreate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}
	
	public void ejbActivate() throws EJBException, RemoteException
	{
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws EJBException, RemoteException
	{
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException
	{
		// TODO Auto-generated method stub

	}

	public void setSessionContext(SessionContext arg0) throws EJBException,	RemoteException
	{
		// TODO Auto-generated method stub

	}
	
	public void invocaSessionB() throws EJBException, RemoteException
	{
		
		Properties props= new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		
		try
		{
			InitialContext ctx =  new InitialContext(props);
			Object obj = ctx.lookup("sessionB");
			HomeB homeB=(HomeB) PortableRemoteObject.narrow(obj, HomeB.class);
			EjbObjectB ejbB= homeB.create();
			
			System.out.println("Estoy en session A invocando a : " + ejbB.soySessionB());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String soySessionA() throws RemoteException
	{
		return "Soy el session A y mi hashCode es : " +  this.hashCode();
	}

}
