package ejb.test.testing;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.test.HelloWorldEjbObject;
import ejb.test.HelloWorldHome;

public class HelloWorldTest 
{

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws CreateException 
	 * @throws RemoteException 
	 * @throws RemoveException 
	 */
	public static void main(String[] args)
	{
		Properties props=new Properties();
				
		props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL,"jnp://localhost:1099");	
		
		try
		{
			Context ctx = new InitialContext(props);
			Object obj=	ctx.lookup("helloWorld");
			HelloWorldHome homeRemote= (HelloWorldHome)javax.rmi.PortableRemoteObject.narrow(obj,HelloWorldHome.class);	
			HelloWorldEjbObject home= homeRemote.create();
			
			//System.out.println("ESTOY ANTES DEL HELLO WORLD");
			home.helloWorld();
			//System.out.println("ESTOY DESPUES DEL HELLO WORLD");
			home.remove();
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CreateException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoveException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
