package clasesVarias;

import java.util.Set;

public interface KorItf 
{
	public Set<ValoresItf> obtenerTodosLosValores(String dtoClassName,String methodName,String metodoGetId);
	public Set<ValoresItf> getValores(String dtoClassName,String methodName,String metodoGetId,String idValor);
	
}
