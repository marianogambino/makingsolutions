package clasesVarias;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class KorServices implements KorItf
{
	private KorAPI itfKor = new KorAPI();
	private final String GET_DESCRIPCION = "getDescripcion";
	private final String SET_VALOR = "setValor";
	private final String SET_DESCRIPCION = "setDescripcion";
	
	public Set<ValoresItf> obtenerTodosLosValores(String dtoClassName,String methodName,String metodoGetId) 
	{	 
          Set<ValoresItf> valores = new HashSet<ValoresItf>();
          try
          {
             //Clase que representa el contenedor de los valores.
               Class dtoClass = Class.forName(dtoClassName);
               Object[] arrayDtos = obtenerDtos(methodName, null);	
               valores = convertirDtoAcOBj(arrayDtos, dtoClass,metodoGetId);

           }catch (ClassNotFoundException e){
               e.printStackTrace();
           }catch (SecurityException e){  
               e.printStackTrace();
           }
           return valores;
	}
	
	
	public  Set<ValoresItf> getValores(String dtoClassName,String methodName,String metodoGetId, String idValor)
	{
	      Set<ValoresItf> valores = new HashSet<ValoresItf>();
          try
          {
               Class dtoClass = Class.forName(dtoClassName);                         
               Object[] arrayDtos = obtenerDtos(methodName, idValor);
               valores = convertirDtoAcOBj(arrayDtos, dtoClass,metodoGetId);

           }catch (ClassNotFoundException e){
               e.printStackTrace();
           }catch (SecurityException e){  
               e.printStackTrace();
           }
           return valores;
	}
	
	public Set<ValoresItf> convertirDtoAcOBj(Object[] arrayDtos,Class dtoClass,String metodoGetId)
	{
		Object cobj;
		Object dtoObj;
		Object[] parametrosObjGet = null;
		Set<ValoresItf> valores = new HashSet<ValoresItf>();
		
		try
		{
	   	    Class classCObj = Class.forName("clasesVarias.ValorGenerico");
			Class[] parametrosClsCObj = new Class[1];
			parametrosClsCObj[0] = Class.forName(String.class.getName());
			Object[] parametrosObjCObj = new Object[1];
			Method setValor = classCObj.getMethod(SET_VALOR, parametrosClsCObj);
			Method setDesc = classCObj.getMethod(SET_DESCRIPCION, parametrosClsCObj);
			Class[] parametrosClsGet = null;
			Method getValor = dtoClass.getMethod(metodoGetId, parametrosClsGet); 
			Method getDesc = dtoClass.getMethod(GET_DESCRIPCION, parametrosClsGet);
		
			for(int i=0;i<arrayDtos.length;i++)
			{
				dtoObj = dtoClass.newInstance();
				dtoObj = arrayDtos[i];
				parametrosObjCObj[0] = (String) getValor.invoke(dtoObj, parametrosObjGet);       
				cobj = classCObj.newInstance();
				setValor.invoke(cobj, parametrosObjCObj);               
				parametrosObjCObj[0] = (String) getDesc.invoke(dtoObj, parametrosObjGet);                 
				setDesc.invoke(cobj, parametrosObjCObj);               
				ValoresItf itf = (ValoresItf) cobj;
				valores.add(itf);
			}  
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SecurityException e){  
			e.printStackTrace();
		}catch (NoSuchMethodException e){
			e.printStackTrace();
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}catch (IllegalAccessException e){
			e.printStackTrace();
		}catch (InvocationTargetException e){
			e.printStackTrace();
		}catch (InstantiationException e){
			e.printStackTrace();
		}
		return valores;
	}
	
	public Object[] obtenerDtos(String methodName,String idValor)
	{
		Object[] arrayDtos = null;
		
		try
		{
	        Class[] parametrosCls = null;
	        Object[] parametrosObj = null;
			if(idValor != null)
			{
				parametrosCls = new Class[1];
				parametrosCls[0] = Class.forName(idValor.getClass().getName());	
				parametrosObj = new Object[1];
				parametrosObj[0] = idValor;
			}			
			Method metodo = itfKor.getClass().getMethod(methodName, parametrosCls);
			arrayDtos = (Object []) metodo.invoke(itfKor.getClass().newInstance(), parametrosObj);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SecurityException e){  
			e.printStackTrace();
		}catch (NoSuchMethodException e){
			e.printStackTrace();
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}catch (IllegalAccessException e){
			e.printStackTrace();
		}catch (InvocationTargetException e){
			e.printStackTrace();
		}catch (InstantiationException e){
			e.printStackTrace();
		}
        return arrayDtos;
	}
	
}
	
