package bd2.model;

import java.util.Date;

/**
 * Las instancias de esta clase se utilizan para representar objetos Paso.
 * @author Grupo11
 *
 */
public class Paso {
	private Pizarra pizarra;
	private Date fechaDeIngreso;
	private Long idPaso;
	
	 public Paso (){
	 }
	/**
	 * Constructor de la clase. Recibe como par&aacute;metro los valores con los que
	 * inicializar&aacute; la instancia de la clase.
	 * @param pizarra indica el valor que se le seteara al atributo pizarra.
	 * @param date indica el valor que se le seteara al atributo date.
	 */
	public Paso(Pizarra pizarra, Date date){
		this.pizarra = pizarra;
		this.fechaDeIngreso = date;
	}
	
	private Long getIdPaso(){
		return idPaso;
	}
	
	private void setIdPaso(Long idPaso){
		this.idPaso=idPaso;
	}
	/**
	 * getter del atributo pizarra.
	 * @return el valor asociado al atributo.
	 */
	public Pizarra getPizarra(){
		return pizarra;
	}
	
	/**
	 * getter del atributo fechaDeIngreso.
	 * @return el valor asociado al atributo.
	 */
	public Date getFechaDeIngreso(){
		return fechaDeIngreso;
	}
	public void setPizarra(Pizarra pizarra) {
		this.pizarra = pizarra;
	}
	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
}
