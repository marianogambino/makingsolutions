package ejb.stub;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface EjbObjectB extends EJBObject
{
	public void invocarSessionA() throws RemoteException;
	public String soySessionB() throws RemoteException;
}
