package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Inscrit;
import com.model.InscritId;

public class DaoInscrit extends AbstractDao{
	
	public DaoInscrit() {
        super();
    }
    public void create(Inscrit inscrit) throws DataAccessLayerException {
        super.saveOrUpdate(inscrit);
    }
    
    public void delete(Inscrit inscrit) throws DataAccessLayerException {
        super.delete(inscrit);
    }

    public Inscrit find(InscritId id) throws DataAccessLayerException {
        return (Inscrit) super.find(Inscrit.class,id);
    }

    public void update(Inscrit inscrit) throws DataAccessLayerException {
        super.saveOrUpdate(inscrit);
    }
    
    public Inscrit get(InscritId id) throws DataAccessLayerException {
    	  return (Inscrit) super.get(Inscrit.class,id);
    }
    

    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Inscrit.class);
    }
}
