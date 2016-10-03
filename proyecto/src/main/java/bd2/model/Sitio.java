package bd2.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Las instancias de esta clase se utilizan para representar objetos Sitio.
 * @author Grupo11
 *
 */
public class Sitio {
	
	private Collection<Usuario> usuarios;
	private Collection<Proyecto> proyectos;
	private Long idSitio;

	
	/**
	 * Constructor de la clase. Inicializa sus variables.
	 */
	
	public Sitio(){
		this.usuarios= new HashSet<Usuario>();
		this.proyectos= new HashSet<Proyecto>();
	}
	
	/**
	 * getter de la variable usuarios.
	 * @return usuarios indica la colecci&oacute;n de usuarios de un sitio.
	 */
	public Collection<Usuario> getUsuarios(){
		return usuarios;
	}
	
	/**
	 * getter de la variable proyectos.
	 * @return proyectos indica la colecci&oacute;n de proyectos de un sitio.
	 */
	public Collection<Proyecto> getProyectos(){
		return proyectos;
	}
	
	/**
	 * Agrega un proyecto a la colecci&oacute;n de proyectos de un sitio.
	 * @param proyecto indica el proyecto a agregar.
	 */
	public void agregarProyecto(Proyecto proyecto){
		proyectos.add(proyecto);
	}
	
	/**
	 * Agrega un usuario a la colecci&oacute;n de usuarios de un sitio.
	 * @param usuario indica el usuario a agregar
	 */
	public void registrarUsuario(Usuario usuario){
		usuarios.add(usuario);
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setProyectos(Collection<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	private Long getIdSitio(){
		return idSitio;
	}
	
	private void setIdSitio(Long idSitio){
		this.idSitio=idSitio;
	}
}
