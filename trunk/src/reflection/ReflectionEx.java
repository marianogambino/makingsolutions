package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import clasesVarias.ValorGenerico;

public class ReflectionEx 
{

	public void obtenerReflection() throws ClassNotFoundException,
	InstantiationException, IllegalAccessException, 
	SecurityException, NoSuchMethodException, IllegalArgumentException, 
	InvocationTargetException
	{
		//La clase propia 
        ValorGenerico cp1 = new ValorGenerico(); 
        
        //Otra Clase propia - con Array *******EJEMPLO CON ARRAYs *****************************************************

        Class pClasePrueba  = Class.forName(cp1.getClass().getName()); 
        Object obj2 = pClasePrueba.newInstance(); 
        Object obj3 = pClasePrueba.newInstance(); 
        Object obj4 = pClasePrueba.newInstance(); 
        
         //Argumentos 
        Object[] param1 = new Object[1]; //Cantidad 
        param1[0] = "HOLA"; // seteo un valor al primer argumento 
        Object[] param2 = new Object[1]; 
        param2[0] = " MUNDO"; 
        Object[] param3 = new Object[1]; 
        param3[0] = " Reflection"; 

        //Tipo de Dato del Parametro - argumento 
        Class[] classeParam1 = new Class[1]; 
        classeParam1[0] = Class.forName(String.class.getName()); 

        //Set 
        Method metodo1 = pClasePrueba.getMethod("setDescripcion", classeParam1); 
        metodo1.invoke(obj2, param1); 
        metodo1.invoke(obj3, param2); 
        metodo1.invoke(obj4, param3); 
                
        //Object[] clasePruebaArray = new ClasePrueba[1]; // 
        Object[] clasePruebaArray = new Object[3]; 
        
        clasePruebaArray[0] = obj2; 
        clasePruebaArray[1] = obj3; 
        clasePruebaArray[2] = obj4;     
        
        Class[] paramClsNull = null; 
        Object[] paramObjNull = null; 
        Method metodo2 = pClasePrueba.getMethod("getDescripcion", paramClsNull); 
        String desc = ""; 
        
        
        for(int i=0;i<clasePruebaArray.length;i++) 
        { 
                desc = (String) metodo2.invoke(clasePruebaArray[i], paramObjNull); 
                System.out.println(desc); 
        } 
        
        //Metodos de la clase; 
        Method[] metodos = pClasePrueba.getMethods(); 
        for(int j=0;j<metodos.length;j++) 
        { 
                String e =metodos[j].getName(); 
                //System.out.println(e); 
                if(e.indexOf("Descripcion") != -1) 
                { 
                        System.out.println(e); 
                }       
        } 
                        
        System.out.println(obj2.getClass().getName()); 
        System.out.println(clasePruebaArray.getClass().getName()); 
                
        //******************************************************************************************* 
        
        //************************** OTRO EJEMPLO *************************************************** 
        
        //Nombre de la clase; 
        String nomClass = cp1.getClass().getName();  

        //Obtengo la clase 
        Class cn = Class.forName(nomClass); 

        //Tipo de Dato del Parametro 
        Class[] classeParam = new Class[1]; 
        classeParam[0] = Class.forName("java.lang.String"); 
 
        //Instancia de la clase 
        Object obj = cn.newInstance(); 

        //Argumentos 
        Object[] param = new Object[1]; //Cantidad 
        param[0] = "HOLA"; // seteo un valor al primer argumento 

        //Set 
        Method metodo = cn.getMethod("setDescripcion", classeParam); 
        metodo.invoke(obj, param); 

        //Get 
        Class[] paramClsNull1 = null; 
        Object[] paramObjNull1 = null; 
        metodo = cn.getMethod("getDescripcion", paramClsNull1); 
        String a = (String)metodo.invoke(obj, paramObjNull1); 

        System.out.println(a); 
        System.out.println(cn.getName()); 
	} 
}
