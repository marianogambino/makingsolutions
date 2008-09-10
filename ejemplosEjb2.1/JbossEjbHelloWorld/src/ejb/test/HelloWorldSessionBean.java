package ejb.test;

import java.rmi.RemoteException;


import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloWorldSessionBean implements SessionBean
{

	private SessionContext ctx;
	
	public void ejbCreate() throws RemoteException
	{
		// TODO Auto-generated method stub

	}
	
	public void ejbActivate() throws RemoteException
	{
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws RemoteException
	{
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws RemoteException
	{
		// TODO Auto-generated method stub

	}

	public void setSessionContext(SessionContext arg0) throws RemoteException 
	{
		// TODO Auto-generated method stub

	}
	
	public void helloWorld() throws RemoteException 
	{
		System.out.println("HOLA TM MAS  :-)");
	}

}
