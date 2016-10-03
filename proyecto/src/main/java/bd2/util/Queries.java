package bd2.util;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd2.model.Pizarra;
import bd2.model.Tarea;
import bd2.model.Usuario;

/**
 * Proyecto Integrador - Etapa 3
 * @author Grupo11
 *
 */

/**
 * Clase Queries, se ejecutan las consultas pedidas a la Base de Datos.
 *
 */
public class Queries {
	
	/**
	 * M&eacute;todo main, llama a las consultas de la clase Queries.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		consultaA(cfg);
		consultaB(cfg, "%news%");
		consultaC(cfg);
		consultaD(cfg);
		consultaE(cfg,"backlogproyecto8149");
		consultaF(cfg,2);
		consultaG(cfg);
		consultaH(cfg);
	}
	
	/**
	 * Lista los nombres de todas las pizarras.
	 * @param cfg
	 */
	
	public static void consultaA(Configuration cfg) {
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			Query hqlQuery = session.createQuery("from Pizarra");
			tx = session.beginTransaction();
			List<Pizarra> nombres = (List<Pizarra>) hqlQuery.list();
			tx.commit();

			System.out.println("\nA) Listar los nombres de todas las pizarras.\n");
			for (Pizarra pizarra : nombres){
				System.out.println("Pizarra: " + pizarra.getNombre());
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}
		
	
	/**
	 * Lista las tareas cuya descripcion contenga una secuencia especifica
	 * de caracteres enviada como parametro.
	 * @param cfg
	 * @param descripcion
	 */
	public static void consultaB(Configuration cfg, String descripcion) {
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			Query hqlQuery = session.createQuery("from Tarea t where t.descripcion like (:descripcion)");
			tx = session.beginTransaction();
			hqlQuery.setParameter("descripcion", descripcion);
			List<Tarea> list = (List<Tarea>) hqlQuery.list();
			tx.commit();

			System.out.println("\nB)  Listar las tareas cuyo descripcion contenga la secuencia de caracteres '" + descripcion + "'.\n");
			for (Tarea tarea : list) {
				System.out.println("Tarea: " + tarea.getDescripcion());
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	/**
	* Devuelve la pizarra que tiene mas tareas.
	* @param cfg
	**/
	public static void consultaC(Configuration cfg) throws IOException{
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			String hql = "select p from Pizarra p order by p.tareas.size desc";
			tx = session.beginTransaction();
			Query hqlQuery = session.createQuery(hql);
			hqlQuery.setMaxResults(1);
			Pizarra pizarra= (Pizarra) hqlQuery.uniqueResult();
			tx.commit();

			System.out.println("\nC) Obtener la Pizarra que tenga mas tareas.\n");
			System.out.println("Pizarra con mas tareas: "+ pizarra.getNombre() + " (" +pizarra.getTareas().size() +" tareas)");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * Devuelve los emails de los administradores de los proyecto que tengan
	 * al menos una pizarra archivada.
	 * @param cfg
	 */
	public static void consultaD(Configuration cfg) {
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			Query hqlQuery = session.createQuery("select pu.usuario from Proyecto p, PerfilDeAdministrador pu where pu in elements(p.perfiles ) and p.pizarrasArchivadas.size >0 ");
			tx = session.beginTransaction();
			List<Usuario> list = (List<Usuario>) hqlQuery.list();
			tx.commit();
			
			System.out.println("\nD) Obtener los emails de los administradores de los proyectos que tengan al menos una pizarra archivada.\n");
			for (Usuario usuario : list) {
				System.out.println("Administrador: "  + usuario.getEmail());
			}			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * Devuelve las tareas que hayan pasado por la pizarra cuyo
	 * nombre contenga una secuencia de caracteres enviada como parametro.
	 * @param cfg
	 * @param nombre
	 */
	public static void consultaE(Configuration cfg, String nombre) {
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			Query hqlQuery = session.createQuery("select t from Tarea t, Paso p where p in elements(t.pasos) and p.pizarra.nombre like (:nombre)");
			tx = session.beginTransaction();
			hqlQuery.setParameter("nombre", nombre);
			List<Tarea> list = (List<Tarea>)hqlQuery.list();
			tx.commit();

			System.out.println("\nE)  Obtener las tareas que hayan pasado por la pizarra cuyo nombre contenga la secuencia de caracteres '" + nombre + "'.\n");
			for (Tarea tarea : list) {
				System.out.println("Tarea: " + tarea.getDescripcion());
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	/**
	 * Devuelve las tareas que hayan sido cambiadas de pizarra mas de un numero de veces
	 * enviado como parametro.
	 * @param cfg
	 * @param cantidad
	 */
	public static void consultaF(Configuration cfg, int cantidad) {
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			Query hqlQuery = session.createQuery("select t from Tarea t where t.pasos.size> :cantidad");
			tx = session.beginTransaction();
			hqlQuery.setParameter("cantidad", cantidad);
			List<Tarea> list = (List<Tarea>) hqlQuery.list();
			tx.commit();

			System.out.println("\nF) Obtener la tareas que hayan sido cambiadas de pizarra mas de '" + cantidad + "' veces.\n");
			for (Tarea tarea : list) {
				System.out.println("Tarea: " + tarea.getDescripcion() + " ("+ tarea.getPasos().size() + " pasos)");
			}
			System.out.println();
				
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}	
	
	/**
	 * Devuelve las pizarras que tengan tareas tanto de investigacion como de desarrollo.
	 * @param cfg
	 */
	public static void consultaG(Configuration cfg) {
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			Query hqlQuery = session.createQuery("select distinct p from Pizarra p, TareaDeDesarrollo td, TareaDeInvestigacion ti "
					+ "where (td in elements(p.tareas) and ti in elements( p.tareas))");
			tx = session.beginTransaction();
			List<Pizarra> list = hqlQuery.list();
			tx.commit();

			System.out.println("\nG) Obtener las pizarras que tengan tareas tanto de investigación como de desarrollo.\n");
			for (Pizarra pizarra : list) {
				System.out.println("Pizarra: " + pizarra.getNombre());
			}
			System.out.println();
				
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}	
	
	
	/**
	 * Devuelve las pizarras que tengas tareas vencidas en Marzo, es decir que sus fecha limites
	 * esten dentro de Marzo 2015 y no esten completas. 
	 * @param cfg
	 */
	
	public static void consultaH(Configuration cfg) {
		SessionFactory sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		
		try {
			Query hqlQuery = session.createQuery("select distinct p from Pizarra as p, Tarea as t where t in elements(p.tareas) and t.completa='false'"
					+ "and (t.fechaLimite between :fechaMin and :fechaMax)");
			tx = session.beginTransaction();
			hqlQuery.setParameter("fechaMin", new Date("2015/03/01"));
			hqlQuery.setParameter("fechaMax", new Date("2015/03/31"));
			
			List<Pizarra> list = hqlQuery.list();
			tx.commit();

			System.out.println("\nH)Obtener las pizarras que tengas tareas vencidas en Marzo, es decir que sus fecha limites "
									+ "esten dentro de Marzo 2015 y no esten completas.\n");
			for (Pizarra pizarra : list) {
				System.out.println("Pizarra: " + pizarra.getNombre());
			}
			System.out.println();
				
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}	

}
