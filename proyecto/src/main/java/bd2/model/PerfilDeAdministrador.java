package bd2.model;

import java.util.Date;

/**
 * Las instancias de esta clase se utilizan para representar objetos PerfilDeUsuario.
 * @author Grupo11
 *
 */

public class PerfilDeAdministrador extends PerfilDeUsuario {
	private boolean creador;
	
	public PerfilDeAdministrador(){}
	
	/**
	 * Constructor de la clase. Permite recibir como parámetro los valores con los que se
     * inicializará la instancia de la clase. 
	 * @param date indica el valor que se le seteara al atributo date.
	 * @param usuario el valor que se le seteara al atributo usuario.
	 */
	public PerfilDeAdministrador(Date date,Usuario usuario){
		super(date, usuario);
		creador=false;
	}
	
	/**
	 * Retorna el valor asociado al atributo creador.
	 */
	public boolean esCreador(){
		return creador;
	}
	
	/**
	 * Marca como creador al PerfilDeAdministrador de un proyecto.
	 */
	public void creador(){
		creador=true;
	}
	
	
	/**
	 * Eimina el perfil del proyecto enviado como parametro. Si es creador, lanza una excepcion.
	 * @param proyecto indica el proyecto al que se le quiere eliminar el perfil.
	 * @throws Exception No se puede eliminar al creador del proyecto.
	 */
	
	public void eliminarDe (Proyecto proyecto) throws Exception{

		if (!this.esCreador()){
			super.eliminarDe(proyecto);		
		}
		else{
			throw new Exception("No se puede eliminar al creador del proyecto");
		}
	}
	

	public boolean isCreador() {
		return creador;
	}

	public void setCreador(boolean creador) {
		this.creador = creador;
	}


}
