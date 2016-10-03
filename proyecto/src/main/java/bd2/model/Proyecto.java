package bd2.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Las instancias de esta clase se utilizan para representar objetos Proyecto.
 * @author Grupo11
 *
 */
public class Proyecto {
	
	private Collection<Pizarra> pizarras;
	private Collection<Pizarra> pizarrasArchivadas;
	private Collection<PerfilDeUsuario> perfiles;
	private Long idProyecto;
	
	public Proyecto(){}
	/**
	 * Constructor de la clase. El usuario enviado como par&aacute;metro se agrega al proyecto con
	 * el perfil de administrador y se marca como creador.
	 * @param creador indica el usuario a agregar.
	 */
	public Proyecto(Usuario creador){
		perfiles= new HashSet<PerfilDeUsuario>();
		pizarras= new HashSet<Pizarra>();
		pizarrasArchivadas= new HashSet<Pizarra>();
		Date date = new Date();
		PerfilDeAdministrador admin = new PerfilDeAdministrador(date, creador);
		admin.creador();
		this.perfiles.add(admin);
	} 
	
	/**
	 * getter del atributo pizarras.
	 * @return pizarras indica la coleccion de pizarras de un proyecto.
	 */
	public Collection<Pizarra> getPizarras(){
		return pizarras;		
	}
	
	/**
	 * getter del atributo pizarrasArchivadas.
	 * @return pizarrasArchivadas indica la coleccion de pizarras archivadas.
	 */
	public Collection<Pizarra> getPizarrasArchivadas(){
		return pizarrasArchivadas;
	}
	
	/**
	 * Agrega una pizarra a la coleccion de pizarras de un proyecto.
	 * @param nueva indica la pizarra a agregar.
	 */
	public void agregarPizarra(Pizarra nueva){
		pizarras.add(nueva);
	}
	
	/**
	 * Archiva una pizarra, esto significa que deja de estar en la colecci&oacute;n de pizarras
	 * para pasar a la colecci&oacute;n de pizarrasArchivadas.
	 * @param pizarra indica la pizarra a archivar.
	 */
	public void archivarPizarra(Pizarra pizarra){
		pizarras.remove(pizarra);
		pizarrasArchivadas.add(pizarra);
	}
	
	/**
	 *  getter del atributo perfiles.
	 * @return perfiles indica los perfiles de usuarios que pertenecesn al proyecto.
	 */
	public Collection<PerfilDeUsuario> getPerfiles(){
		return perfiles;
	}
	
	/**
	 * Genera un perfil de usuario Administrador (PerfilDeAdministrador) con el usuario que
	 * recibe como par&aacute;metro y lo agrega a la colecci&oacute;n de perfiles.
	 * @param usuario indica al usuario que se le generara un perfil de administrador.
	 */
	public void agregarAdministrador(Usuario usuario){
		Date date = new Date();
		PerfilDeAdministrador admin = new PerfilDeAdministrador(date,usuario);
		perfiles.add(admin);
	}
	
	/**
	 * Genra un perfil de usuario (PerfilDeUsuario) con el usuario que recibe
	 * como par&aacute;metro y lo agrega a la coleccion de perfiles.
	 * @param usuario indica al usuario que se le generara un perfil de usuario.
	 */
	public void agregarColaborador(Usuario usuario){
		Date date = new Date();
		PerfilDeUsuario user = new PerfilDeUsuario(date, usuario);
		perfiles.add(user);
	}
	
	/**
	 * Retorna los usuarios dentro de los perfiles
	 * @return usuarios 
	 */
	public Collection<Usuario> getIntegrantes(){
		/* Retorna los Usuarios de los perfiles de usuario del proyecto */
		Collection<Usuario> usuarios = new HashSet<Usuario>();
		for (PerfilDeUsuario perfilDeUsuario : this.perfiles){
			usuarios.add(perfilDeUsuario.getUsuario());
		}
		return usuarios;
	}
	
	/**
	 * Busca un usuario dentro de los perfiles del proyecto.
	 * @param usuario indica el usuario a buscar.
	 * @return perfilDeUsuario indica el perfil del usuario enviado como parametro.
	 * @throws Exception El usuario no existe.
	 */
	public PerfilDeUsuario buscarUsuario(Usuario usuario) throws Exception{
		for (PerfilDeUsuario perfilDeUsuario : this.perfiles){
			if (perfilDeUsuario.getUsuario() == usuario ){
				return perfilDeUsuario;
			}
		}
		throw new Exception ("El usuario no existe");
	}
	
	/**
	 * Elimina el perfil de usuario (PerfilDeUsuario) del usuario que recibe como parametro.
	 * Si el usuario que se desea eliminar es creador, lanza una excepci&oacute;n.
	 * @param usuario indica el usuario al que se le quiere eliminar su perfil.
	 * @throws Exception No se puede eliminar al creador del proyecto.
	 */
	public void eliminarUsuario(Usuario usuario) throws Exception{
		PerfilDeUsuario perfil = this.buscarUsuario(usuario);
		if (perfil != null){
			if (!perfil.esCreador()){
				this.eliminarPerfil(perfil);
			}
			else{
				throw new Exception("No se puede eliminar al creador del proyecto");
			}
		}
	}
		
	
	/**
	 * Elimina un perfil de usuario del proyecto.
	 * @param perfil indica el perfil a eliminar.
	 */
	public void eliminarPerfil(PerfilDeUsuario perfil){
		if (!perfil.esCreador()){
			perfiles.remove(perfil);
		}
		
	}
	
	/**
	 * Devuelve el usuario asignado como creador del proyecto.
	 * @return usuario creador.
	 */
	public Usuario getCreador(){
		Usuario usuario = null;
		for (PerfilDeUsuario perfilDeUsuario : this.perfiles){
			if (perfilDeUsuario.esCreador()){
				usuario = perfilDeUsuario.getUsuario();
			}
		}
		return usuario;
	}
	
	
	private Long getIdProyecto(){
		return idProyecto;
	}
	
	private void setIdProyecto(Long idProyecto){
		this.idProyecto=idProyecto;
	}
	public void setPizarras(Collection<Pizarra> pizarras) {
		this.pizarras = pizarras;
	}
	public void setPizarrasArchivadas(Collection<Pizarra> pizarrasArchivadas) {
		this.pizarrasArchivadas = pizarrasArchivadas;
	}
	public void setPerfiles(Collection<PerfilDeUsuario> perfiles) {
		this.perfiles = perfiles;
	}
}
