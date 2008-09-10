package ejb.stub;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface HomeB extends EJBHome
{
	public EjbObjectB create() throws CreateException, RemoteException;
}
