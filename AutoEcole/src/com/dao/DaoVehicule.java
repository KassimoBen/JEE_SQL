package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Vehicule;

public class DaoVehicule extends AbstractDao{
	private String idname = "numv";
	public DaoVehicule() {
        super();
    }
    public void create(Vehicule vehicule) throws DataAccessLayerException {
        super.saveOrUpdate(vehicule);
    }
    
    public void delete(Vehicule vehicule) throws DataAccessLayerException {
        super.delete(vehicule);
    }

    public Vehicule find(Integer id) throws DataAccessLayerException {
        return (Vehicule) super.find(Vehicule.class, id);
    }

    public void update(Vehicule vehicule) throws DataAccessLayerException {
        super.saveOrUpdate(vehicule);
    }
    
    public Vehicule get(Integer id) throws DataAccessLayerException {
        return (Vehicule) super.get(Vehicule.class, id);
    }
    
    @SuppressWarnings("rawtypes")
	public List findAllId() throws DataAccessLayerException {
        return  super.findAllId(Vehicule.class, idname);
    }
    
    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Vehicule.class);
    }
}
   
