package bd2.model;

import java.util.Date;
/**
 * Las instancias de esta clase se utilizan para representar objetos TareaDeInvestigacion.
 * @author Grupo11
 *
 */
public class TareaDeInvestigacion extends Tarea {
	private String hipotesis="";
	private String resultado="";
	
	public TareaDeInvestigacion(){
		super();
	}
	
	/**
	 * Constructor de la clase. Recibe como par&aacute;metro los valores con los que
	 * inicializar&aacute; la instancia de la clase.Se invoca al contructor padre para que inicialize el valor
     * de sus atributos. 
	 * @param descripcion indica el valor que se le seteara al atributo descripcion.
	 * @param fechaLimite indica la fecha de creacion.
	 */
	public TareaDeInvestigacion(String descripcion, Date fechaLimite) {
		super(descripcion, fechaLimite);
	}
	
	/**
	 * getter del atributo hipotesis.
	 * @return el valor asociado al atributo.
	 */
	public String getHipotesis(){
		return hipotesis;
	}
	
	/**
	 * setter del atributo hipotesis.
	 * @param hipotesis indica el valor que se le seteara al atributo.
	 */
	public void setHipotesis(String hipotesis){
		this.hipotesis=hipotesis;
	}
	
	/**
	 * setter del atributo resultado.
	 * @param resultado indica el valor que se le seteara al atributo.
	 */
	public void setResultado(String resultado){
		this.resultado=resultado;
	}
	
	/**
	 * getter del atributo resultado.
	 * @return el valor asociado al atributo.
	 */
	public String getResultado(){
		return resultado;
	}
	

}
