package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
/**
 * La clase Tarea es una clase abstracta, no se puede instanciar.
 * @author Grupo 11
 *
 */
public abstract class Tarea {
	private boolean completa;
	private Date fechaLimite;
	private String descripcion;
	private Collection<Paso> pasos;
	protected Long idTarea;
	
	public Tarea(){
		this.pasos= new ArrayList<Paso>();
	}
	
	/**Constructor de la clase. Recibe como parametros los valores con los inicializara. 
	 * Dado que es una clase abstracta, no se podran crear isntancias de la misma, 
	 * pero si se podra hacer super(clase) desde las subclases de la clase.
     * @param descripcion indica el valor que se le seteara al atributo descripcion.
	 * @param fechaLimite indica el valor que se le seteara al atributo fechaLimite.
     */
	public Tarea(String descripcion, Date fechaLimite){
		this.descripcion=descripcion;
		this.fechaLimite=fechaLimite;
		pasos= new ArrayList<Paso>();
	}
	
	/**
	 * getter del atributo descripcion.
	 * @return descripcion el valor asociado al atributo.
	 */
	public String getDescripcion(){
		return descripcion;
	}
	
	/**
	 * getter del atributo completa.
	 * @return completa el valor asociado al atributo.
	 */
	public boolean completa(){
		return completa;
	}
	
	/**
	 * Marca como completada una tarea.
	 */
	public void completar(){
		completa=true;
	}
	
	/**
	 * getter del atributo fechaLimite.
	 * @return fechaLimite el valor asociado al atributo.
	 */
	public Date getFechaLimite(){
		return fechaLimite;
	}
	
	/**
	 * Peermite verificar el estado de la fecha limite de la tarea.
	 * @return true si la fecha limite ya paso, false en caso contrario.
	 */
	public boolean vencida(){
		Date date = new Date();
		return date.after(fechaLimite);
	}
	
	/**
	 * Retorna el historial de pasos, donde cada objeto Paso representa la incorporaci&oacute;n
	 * de la tarea en una pizarra, en una fecha dada.
	 * @return pasos indica la coleccion de pasos de la tarea.
	 */
	public Collection<Paso> getPasos(){
		return pasos;
	}
	
	/**
	 * Permite agregar a la pizarra enviada como parametro. Registra este movimiento
	 * generando un nuevo Paso y agregandolo a su coleccion de pasos, con la fecha actual
	 * y la pizarra en cuesti&oacute;n.
	 * @param pizarra indica la pizarra a agregar.
	 */
	public void agregarAPizarra(Pizarra pizarra){
		Date date = new Date();
		Paso paso = new Paso(pizarra,date);
		pasos.add(paso);	
	}

	protected Long getIdTarea(){
		return idTarea;
	}
	
	protected void setIdTarea(Long idTarea){
		this.idTarea=idTarea;
	}

	public boolean isCompleta() {
		return completa;
	}

	public void setCompleta(boolean completa) {
		this.completa = completa;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPasos(Collection<Paso> pasos) {
		this.pasos = pasos;
	}

}
