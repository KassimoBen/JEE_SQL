package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Appartient;
import com.model.AppartientId;

public class DaoAppartient extends AbstractDao{
	
	public DaoAppartient() {
        super();
    }
    public void create(Appartient appartient) throws DataAccessLayerException {
        super.saveOrUpdate(appartient);
    }
    
    public void delete(Appartient appartient) throws DataAccessLayerException {
        super.delete(appartient);
    }

    public Appartient find(AppartientId id) throws DataAccessLayerException {
        return (Appartient) super.find(Appartient.class,id);
    }

    public void update(Appartient appartient) throws DataAccessLayerException {
        super.saveOrUpdate(appartient);
    }
    
    public Appartient get(AppartientId id) throws DataAccessLayerException {
    	  return (Appartient) super.get(Appartient.class,id);
    }
    

    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Appartient.class);
    }
}

