package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Eleve;

public class DaoEleve extends AbstractDao{
	private String idname = "nume";
	public DaoEleve() {
		
        super();
    }
    public void create(Eleve eleve) throws DataAccessLayerException {
        super.saveOrUpdate(eleve);
    }
    
    public void delete(Eleve eleve) throws DataAccessLayerException {
        super.delete(eleve);
    }

    public Eleve find(Integer id) throws DataAccessLayerException {
        return (Eleve) super.find(Eleve.class, id);
    }

    public void update(Eleve eleve) throws DataAccessLayerException {
        super.saveOrUpdate(eleve);
    }
    
    public Eleve get(Integer id) throws DataAccessLayerException {
        return (Eleve) super.get(Eleve.class, id);
    }

    @SuppressWarnings("rawtypes")
	public List findAllId() throws DataAccessLayerException {
        return  super.findAllId(Eleve.class, idname);
    }
    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Eleve.class);
    }
   
    /*@SuppressWarnings("unchecked")
	public List<Eleve> getAllEleves() {
		List<Eleve> Eleves = new ArrayList<Eleve>();
		 HibernateFactory.buildIfNeeded();
		Transaction trns = null;
		Session session = HibernateFactory.openSession();
		try {
			trns = session.beginTransaction();
			Eleves = session.createQuery("from Eleve").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			//session.flush();
			 HibernateFactory.close(session);
			//session.close();
		}
		return Eleves;
	}*/
}
