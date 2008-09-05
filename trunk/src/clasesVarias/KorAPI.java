package clasesVarias;

public class KorAPI 
{
	
	public KorPaisDto[] getTodosLosPaises()
	{
		KorPaisDto[] paises = new KorPaisDto[7];
		
		//1
		KorPaisDto pais = new KorPaisDto();
		pais.setDescripcion("Argentina");
		pais.setId("arg");
		paises[0] = pais;
		
//		2
		pais = new KorPaisDto();
		pais.setDescripcion("Brasil");
		pais.setId("bra");
		paises[1] = pais;
		
//		3
		pais = new KorPaisDto();
		pais.setDescripcion("Uruguay");
		pais.setId("uru");
		paises[2] = pais;
		
//		4
		pais = new KorPaisDto();
		pais.setDescripcion("Chile");
		pais.setId("chi");
		paises[3] = pais;
		
//		5
		pais = new KorPaisDto();
		pais.setDescripcion("España");
		pais.setId("esp");
		paises[4] = pais;
		
//		6
		pais = new KorPaisDto();
		pais.setDescripcion("Venezuela");
		pais.setId("ven");
		paises[5] = pais;
		
//		7
		pais = new KorPaisDto();
		pais.setDescripcion("Italia");
		pais.setId("ita");
		paises[6] = pais;
		
		return paises;
	}
	
	public KorProvinciaDto[] getProvincias(String idPais)
	{
		KorProvinciaDto[] provincias = new KorProvinciaDto[7];
		
		if(idPais.equalsIgnoreCase("arg"))
		{
//		1
			KorProvinciaDto provincia = new KorProvinciaDto();
			provincia.setDescripcion("Buenos Aires");
			provincia.setId("BA");
			provincias[0] = provincia;
		
//		2
			provincia = new KorProvinciaDto();
			provincia.setDescripcion("La Pampa");
			provincia.setId("LP");
			provincias[1] = provincia;
		
//		3
			provincia = new KorProvinciaDto();
			provincia.setDescripcion("Misiones");
			provincia.setId("MI");
			provincias[2] = provincia;
		
//		4
			provincia = new KorProvinciaDto();
			provincia.setDescripcion("Corrientes");
			provincia.setId("CO");
			provincias[3] = provincia;
		
//		5
			provincia = new KorProvinciaDto();
			provincia.setDescripcion("Mendoza");
			provincia.setId("ME");
			provincias[4] = provincia;
		
//		6
			provincia = new KorProvinciaDto();
			provincia.setDescripcion("Santa Fe");
			provincia.setId("SF");
			provincias[5] = provincia;
		
//		7
			provincia = new KorProvinciaDto();
			provincia.setDescripcion("Entre Rios");
			provincia.setId("ER");
			provincias[6] = provincia;
		}
			return provincias;
	}
}
