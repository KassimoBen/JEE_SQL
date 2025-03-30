package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Assiste;
import com.model.AssisteId;

public class DaoAssiste extends AbstractDao{
	
	public DaoAssiste() {
        super();
    }
    public void create(Assiste assiste) throws DataAccessLayerException {
        super.saveOrUpdate(assiste);
    }
    
    public void delete(Assiste assiste) throws DataAccessLayerException {
        super.delete(assiste);
    }

    public Assiste find(AssisteId id) throws DataAccessLayerException {
        return (Assiste) super.find(Assiste.class,id);
    }

    public void update(Assiste assiste) throws DataAccessLayerException {
        super.saveOrUpdate(assiste);
    }
    
    public Assiste get(AssisteId id) throws DataAccessLayerException {
    	  return (Assiste) super.get(Assiste.class,id);
    }
    

    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Assiste.class);
    }
}
