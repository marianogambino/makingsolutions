package ejb.stub;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBObject;

public interface EjbObjectA extends EJBObject
{
	public void invocaSessionB() throws RemoteException;
	public String soySessionA() throws RemoteException;
}
