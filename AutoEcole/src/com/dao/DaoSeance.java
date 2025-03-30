package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Seance;
import com.model.SeanceId;

public class DaoSeance extends AbstractDao{
	
	public DaoSeance() {
        super();
    }
    public void create(Seance seance) throws DataAccessLayerException {
        super.saveOrUpdate(seance);
    }
    
    public void delete(Seance seance) throws DataAccessLayerException {
        super.delete(seance);
    }

    public Seance find(SeanceId id) throws DataAccessLayerException {
        return (Seance) super.find(Seance.class,id);
    }

    public void update(Seance seance) throws DataAccessLayerException {
        super.saveOrUpdate(seance);
    }
    
    public Seance get(SeanceId id) throws DataAccessLayerException {
    	  return (Seance) super.get(Seance.class,id);
    }
    

    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Seance.class);
    }
}
