package Dades.Controladors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Actors.Alarmes.AlarmaJugar;
import Dades.Factories.HibernateUtil;
import Domini.Model.Partida;
import Domini.Model.Usuari;

public class Controlador  {

	public Set<Object> getAll(Class c){
		Set<Object> ret = new HashSet<>();
		SessionFactory s = HibernateUtil.getSessionFactory();
    	Session se = s.getCurrentSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	ret.addAll(se.createCriteria(c).list());
    	tx.commit();
    	return ret;
	}
	
	public Object get(Class c,Serializable ser){
		Object ret;
		SessionFactory s = HibernateUtil.getSessionFactory();
		Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	ret = se.get(c,ser);
    	tx.commit();
    	se.close();
    	return ret;
	}
	
	public void Insert(Object o){
		SessionFactory s = HibernateUtil.getSessionFactory();
		Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	se.save(o);
    
    	tx.commit();
    	se.close();
	}
	
	public void Update(Object o){
		SessionFactory s = HibernateUtil.getSessionFactory();
		Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	se.update(o);
    	tx.commit();
    	se.close();
	}
	
	public boolean Exists(Class c,Serializable ser){
		boolean ret;
		Transaction tx;
		SessionFactory s = HibernateUtil.getSessionFactory();
		Session se = s.openSession();
		tx = se.beginTransaction();
	    Object t = se.get(c,ser);
	    tx.commit();
		se.close();
		return t != null;
	}
	
	public void Delete(Object o){
		SessionFactory s = HibernateUtil.getSessionFactory();
		Session se = s.getCurrentSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	
    	se.delete(o);
    	tx.commit();
	}
}
