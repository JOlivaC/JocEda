package Dades.Controladors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    	Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	ret.addAll(se.createCriteria(c).list());
    	tx.commit();
    	se.close();
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
		Object ret;
		SessionFactory s = HibernateUtil.getSessionFactory();
    	Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	ret = se.save(o);
    	tx.commit();
    	se.close();
	}
	
	public void Update(Object o){
		Object ret;
		SessionFactory s = HibernateUtil.getSessionFactory();
    	Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	se.update(o);
    	tx.commit();
    	se.close();
	}
	
	public void Delete(Object o){
		Object ret;
		SessionFactory s = HibernateUtil.getSessionFactory();
    	Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	se.delete(o);
    	tx.commit();
    	se.close();
	}
}
