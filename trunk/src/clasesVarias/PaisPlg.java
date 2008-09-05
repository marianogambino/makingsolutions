package clasesVarias;

import java.util.Set;

public class PaisPlg 
{	
	private KorItf korItf = KorFactory.getInstance();
	private final String METHOD_TODOS_LOS_PAISES = "getTodosLosPaises";
	private final String METHOD_GET_PROVINCIAS = "getProvincias";
	private final String PAIS_DTO = "clasesVarias.KorPaisDto";
	private final String PROVINCIA_DTO = "clasesVarias.KorProvinciaDto";
	private final String METHOD_GET_ID = "getId";
	private final String METHOD_GET_VALOR = "getId";
	
	public Set<ValoresItf> getTodosLosValores()
	{
		return korItf.obtenerTodosLosValores(PAIS_DTO,METHOD_TODOS_LOS_PAISES,METHOD_GET_ID);
	}
	
	public Set<ValoresItf> getValores(String idPais)
	{
		return korItf.getValores(PROVINCIA_DTO, METHOD_GET_PROVINCIAS, METHOD_GET_VALOR, idPais);
	}
}
