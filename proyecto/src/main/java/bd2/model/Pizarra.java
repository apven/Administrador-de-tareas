package bd2.model;

import java.util.Collection;
import java.util.HashSet;
/**
 * Las instancias de esta clase se utilizan para representar objetos Pizarra.
 * @author Grupo11
 *
 */
public class Pizarra {
	private String nombre;
	private Collection<Tarea> tareas;
	private Long idPizarra;
	
	public Pizarra(){}
	/**
	 * Constructor de la clase. Recibe como par&aacute;metro los valores con los que
	 * inicializar&aacute; la instancia de la clase.
	 * @param nombre indica el valor que se le seteara al atributo nombre.
	 */
	public Pizarra(String nombre){
		tareas= new HashSet<Tarea>();
		this.nombre=nombre;
		
	}
	
	/**
	 * getter del atributo nombre.
	 * @return retorna el valor asociado al atributo.
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Devuelve las tareas de la pizarra que recibe el mensaje.
	 * @return tareas indica la coleccion de tareas asociadas a la pizarra.
	 */
	public Collection<Tarea> getTareas(){
		return tareas;
	}
	
	/**
	 * Mueve una tarea propia a la pizarra destino. Luego de esto, la tarea no 
	 * se encuentra m&aacute;s en la pizarra receptora sino en destino.
	 * @param tarea indica la tarea a trasladar.
	 * @param destino inidca la pizarra destino que tendr&aacute; la tarea trasladada.
	 */
	public void moverTareaAPizarra(Tarea tarea, Pizarra destino){
		tareas.remove(tarea);
		destino.agregarTarea(tarea);
	}
	
	/**
	 * Elimina de la pizarra la tarea recibida como par&aacute;metro.
	 * @param tarea indica la tarea a eliminar.
	 */
	public void eliminarTarea (Tarea tarea){
		tareas.remove(tarea);		
	}
	
	/**
	 * Agrega a la pizarra la teare recibida como par&aacute;metro.
	 * @param tarea indica la tarea a agregar.
	 */
	public void agregarTarea(Tarea tarea){
		tarea.agregarAPizarra(this);
		tareas.add(tarea);
	}
	
	private Long getIdPizarra() {
		return this.idPizarra;
	}
	
	private void setIdPizarra(Long idPizarra) {
		this.idPizarra = idPizarra;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTareas(Collection<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	
	
}
