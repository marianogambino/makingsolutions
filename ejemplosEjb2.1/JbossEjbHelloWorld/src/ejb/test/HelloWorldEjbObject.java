package ejb.test;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface HelloWorldEjbObject extends EJBObject
{
	public void helloWorld() throws RemoteException;
	
}
