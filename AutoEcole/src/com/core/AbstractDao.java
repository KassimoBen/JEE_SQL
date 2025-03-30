package com.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public abstract class AbstractDao {
	private Session session;
    private Transaction tx;
    
    public AbstractDao() {
        HibernateFactory.buildIfNeeded();
    }

    protected void saveOrUpdate(Object obj) {
        try {
            startOperation();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected void delete(Object obj) {
        try {
            startOperation();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected Object find(Class<?> clazz, Integer id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.load(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }
    
    protected Object find(Class<?> clazz, Object id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.load(clazz, (Serializable) id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }
    protected Object get(Class<?> clazz, Object id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.get(clazz, (Serializable) id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }
    protected Object get(Class<?> clazz,Integer id)
    {
    	Object obj = null;
        try {
            startOperation();
            obj = session.get(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
          HibernateFactory.close(session);
        }
        return obj;
    	
    }
    protected List<?> findAllId(Class<?> clazz, String idname) {
        List<?> objects = null;
        try {
            startOperation();
            Query query = session.createQuery(" select " + idname + " from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }
    protected List<?> findAllId(Class<?> clazz, String idname, String idnames) {
        List<?> objects = null;
        String id = idname+","+ idnames;
        try {
            startOperation();
            Query query = session.createQuery(" select "+ id +" from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }
    @SuppressWarnings("rawtypes")
	protected List findAll(Class<?> clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }
    protected void handleException(HibernateException e) throws DataAccessLayerException {
        HibernateFactory.rollback(tx);
        throw new DataAccessLayerException(e);
    }

    protected void startOperation() throws HibernateException {
        session = HibernateFactory.openSession();
        tx = session.beginTransaction();
    }
}
