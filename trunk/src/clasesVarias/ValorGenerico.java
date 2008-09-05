package clasesVarias;

public class ValorGenerico implements ValoresItf {

	private String valor;
	private String descripcion;
	
	
	public String getDescripcion(){
		return descripcion;
	}

	public String getValor() {
		return valor;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
