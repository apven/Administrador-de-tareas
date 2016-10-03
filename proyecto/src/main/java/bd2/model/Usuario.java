package bd2.model;

/**
 * Las instancias de esta clase se utilizan para representar objetos Usuario.
 * @author Grupo11
 *
 */
public class Usuario {
	private String email;
	private String nombre;
	private Long idUsuario;
	
	public Usuario(){}
	
	/**
	 * Constructor de la clase. Recibe como par&aacute;metro los valores con los que
	 * inicializar&aacute; la instancia de la clase.
	 * @param email indica el valor que se le seteara al atriburo email.
	 * @param nombre indica el valor que se le seteara al atributo nombre.
	 */
	public Usuario(String email, String nombre){
		this.email = email;
		this.nombre = nombre;
	}
	
	/**
	 * getter del atributo email.
	 * @return Retorna el valor asociado al atributo.
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * getter del atributo nombre.
	 * @return Retorna el valor asociado al atributo.
	 */
	public String getNombre(){
		return nombre;
	}
	
	private Long getIdUsuario(){
		return idUsuario;
	}
	
	private void setIdUsuario(Long idUsuario){
		this.idUsuario=idUsuario;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
