package bd2.model;

import java.util.Date;

/**
 * Las instancias de esta clase se utilizan para representar objetos PerfilDeUsuario.
 * @author Grupo11
 *
 */

public class PerfilDeUsuario {
	private Usuario usuario;
	private Date fechaDeCreacion;
	protected  Long idPerfilDeUsuario;
	
	public PerfilDeUsuario(){}
	/**
	 * Constructor de la clase. Permite recibir como par&aacute;metro los valores con los que se 
	 * inicializa&aacute; la instancia de la clase.
	 * @param fechaDeCreacion indica el valor que se le seteara al atributo fechaDeCreacion.
	 * @param usuario indica el valor que se le seteara al atributo usuario.
	 */
	public PerfilDeUsuario(Date fechaDeCreacion, Usuario usuario){
		this.usuario = usuario;
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	/**
	 * getter del atributo usuario.
	 * @return Retorna el valor asociado al atributo.
	 */
	public Usuario getUsuario(){
		return usuario;
	}
	
	/**
	 * Devuelve true si el usuario es el creador del proyecto, false en caso contrario
	 * @return false
	 */
	public boolean esCreador(){
		return false;
	}
	
	/**
	 * Elimina el perfil de un proyecto enviado como parametro.
	 * @param proyecto indica el proyecto del cual se quiere eliminar su pefil.
	 */
	public void eliminarDe(Proyecto proyecto) throws Exception{
		proyecto.eliminarPerfil(this);
	}
	
	protected Long getIdPerfilDeUsuario(){
		return idPerfilDeUsuario;
	}
	
	protected void setIdPerfilDeUsuario(Long idPerfilDeUsuario){
		this.idPerfilDeUsuario=idPerfilDeUsuario;
	}
	
	public Date getFechaDeCreacion(){
		return fechaDeCreacion;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
}
