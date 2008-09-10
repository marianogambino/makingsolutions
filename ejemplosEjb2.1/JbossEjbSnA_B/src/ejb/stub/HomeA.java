package ejb.stub;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;

public interface HomeA extends EJBHome
{
	public EjbObjectA create() throws CreateException, RemoteException;
}
