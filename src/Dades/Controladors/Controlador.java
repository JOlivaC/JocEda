package Dades.Controladors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Dades.Factories.HibernateUtil;

public class Controlador  {

	@SuppressWarnings("rawtypes")
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
		Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction();
    	
    	se.delete(o);
    	
    	tx.commit();
    	se.close();
	}
	
	public void Delete(Class c,Serializable ser){
		SessionFactory s = HibernateUtil.getSessionFactory();
		Session se = s.openSession();
    	Transaction tx;
    	tx = se.beginTransaction(); 	
    	Object o = se.get(c, ser);
    	se.delete(o);
    	tx.commit();
    	se.close();
	}
	
	public void DeleteAll(String tableName){
		 String hql = String.format("delete from %s",tableName);
		 SessionFactory s = HibernateUtil.getSessionFactory();
		 Session se = s.openSession();
		 Query query = se.createQuery(hql);
		 query.executeUpdate();
	}

}
