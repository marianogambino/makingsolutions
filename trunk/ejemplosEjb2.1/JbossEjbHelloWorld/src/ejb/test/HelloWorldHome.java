package ejb.test;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface HelloWorldHome extends EJBHome
{
	public HelloWorldEjbObject create() throws CreateException,RemoteException;

}
