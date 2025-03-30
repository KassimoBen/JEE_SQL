package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Serie;
import com.model.SerieId;

public class DaoSerie extends AbstractDao{
	
	public DaoSerie() {
        super();
    }
    public void create(Serie serie) throws DataAccessLayerException {
        super.saveOrUpdate(serie);
    }
    
    public void delete(Serie serie) throws DataAccessLayerException {
        super.delete(serie);
    }

    public Serie find(SerieId id) throws DataAccessLayerException {
        return (Serie) super.find(Serie.class,id);
    }

    public void update(Serie serie) throws DataAccessLayerException {
        super.saveOrUpdate(serie);
    }
    
    public Serie get(SerieId id) throws DataAccessLayerException {
    	  return (Serie) super.get(Serie.class,id);
    }
    

    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Serie.class);
    }
}
