package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Cd;

public class DaoCd extends AbstractDao{
	private String idname = "numcd";
	public DaoCd() {
        super();
    }
    public void create(Cd cd) throws DataAccessLayerException {
        super.saveOrUpdate(cd);
    }
    
    public void delete(Cd cd) throws DataAccessLayerException {
        super.delete(cd);
    }

    public Cd find(Integer id) throws DataAccessLayerException {
        return (Cd) super.find(Cd.class, id);
    }

    public void update(Cd cd) throws DataAccessLayerException {
        super.saveOrUpdate(cd);
    }
    
    public Cd get(Integer id) throws DataAccessLayerException {
        return (Cd) super.get(Cd.class, id);
    }
    
    @SuppressWarnings("rawtypes")
	public List findAllId() throws DataAccessLayerException {
	    return  super.findAllId(Cd.class, idname);
    }
    
    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Cd.class);
    }
}
   
