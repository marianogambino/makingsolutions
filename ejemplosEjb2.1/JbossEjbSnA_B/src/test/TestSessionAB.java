package test;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import ejb.stub.EjbObjectA;
import ejb.stub.EjbObjectB;
import ejb.stub.HomeA;
import ejb.stub.HomeB;

public class TestSessionAB {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Properties props= new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		
		try
		{
			InitialContext ctx = new InitialContext(props);
			Object objA = ctx.lookup("sessionA");
			Object objB = ctx.lookup("sessionB");
			
			HomeA homeA= (HomeA) PortableRemoteObject.narrow(objA, HomeA.class);
			HomeB homeB= (HomeB) PortableRemoteObject.narrow(objB, HomeB.class);
			
			EjbObjectA ejbA=homeA.create();
			EjbObjectB ejbB = homeB.create();
			
			
			//Session B invocando al Session A
			System.out.println("Llamando a SessionB");
			System.out.println(ejbB.soySessionB());
			ejbB.invocarSessionA();
			
			//Session A invocando al Session B
			System.out.println("Llamando a Session A");
			System.out.println(ejbA.soySessionA());
			ejbA.invocaSessionB();
			
			
			
				
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (CreateException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
