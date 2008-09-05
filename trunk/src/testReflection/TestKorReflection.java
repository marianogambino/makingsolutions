package testReflection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import clasesVarias.PaisPlg;
import clasesVarias.ValoresItf;

public class TestKorReflection {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Set<ValoresItf> valores = new HashSet<ValoresItf>();
		PaisPlg plgPais = new PaisPlg();
				
		System.out.println("::::::::::::::::::::::::::::::::::::::");
		System.out.println("              PAISES");
		System.out.println("::::::::::::::::::::::::::::::::::::::");
		
		valores = plgPais.getTodosLosValores();
		mostrarValores(valores);
		
		System.out.println("::::::::::::::::::::::::::::::::::::::");
		System.out.println("              PROVINCIAS");
		System.out.println("::::::::::::::::::::::::::::::::::::::");
		
		valores = plgPais.getValores("arg");
		mostrarValores(valores);
		
	}
	
	public static void mostrarValores(Set<ValoresItf> valores)
	{
		for(Iterator<ValoresItf> it = valores.iterator(); it.hasNext();)
		{
			ValoresItf valor = it.next();
			System.out.println(valor.getValor());
			System.out.println(valor.getDescripcion());
			System.out.println("::::::::::::::::::::::::::::::::::::::");
		}
	}

}
