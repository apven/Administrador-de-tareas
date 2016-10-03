package bd2.model;

import java.util.Date;
/**
 * Las instancias de esta clase se utilizan para representar objetos TareaDeDesarrollo
 * @author Grupo11
 *
 */
public class TareaDeDesarrollo extends Tarea {
	
	private String requerimientos;
	
	
	public TareaDeDesarrollo(){
		super();
	}
	
	/**
	 * Constructor de la clase. Recibe como par&aacute;metro los valores con los que
	 * inicializar&aacute; la instancia de la clase.Se invoca al contructor padre para que inicialize el valor
     * de sus atributos.  
	 * @param descripcion indica el valor que se le seteara al atributo descripcion.
	 * @param date indica la fecha de creacion.
	 */
	public TareaDeDesarrollo(String descripcion, Date date){
		super(descripcion,date);
		this.requerimientos= "";
	}
	
	/**
	 * getter del atributo requerimientos.
	 * @return Retorna el valor asociado al atributo. 
	 */
	public String getRequerimientos(){
		return requerimientos;
	}
	
	/**
	 * setter del atributo requerimientos.
	 * @param requerimientos indica el valor que se le seteara al atributo.
	 */
	public void setRequerimientos(String requerimientos){
		this.requerimientos = requerimientos;
	}
	
	
}
