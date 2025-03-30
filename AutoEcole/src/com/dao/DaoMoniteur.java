package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Moniteur;

public class DaoMoniteur extends AbstractDao{
	private String idname = "numm";
	public DaoMoniteur() {
        super();
    }
    public void create(Moniteur moniteur) throws DataAccessLayerException {
        super.saveOrUpdate(moniteur);
    }
    
    public void delete(Moniteur moniteur) throws DataAccessLayerException {
        super.delete(moniteur);
    }

    public Moniteur find(Integer id) throws DataAccessLayerException {
        return (Moniteur) super.find(Moniteur.class, id);
    }

    public void update(Moniteur moniteur) throws DataAccessLayerException {
        super.saveOrUpdate(moniteur);
    }
    
    public Moniteur get(Integer id) throws DataAccessLayerException {
        return (Moniteur) super.get(Moniteur.class, id);
    }
    
    @SuppressWarnings("rawtypes")
	public List findAllId() throws DataAccessLayerException {
        return  super.findAllId(Moniteur.class, idname);
    }
    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Moniteur.class);
    }
   
   
}
