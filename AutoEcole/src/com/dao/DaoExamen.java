package com.dao;

import java.util.List;
import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Examen;
import com.model.ExamenId;

public class DaoExamen extends AbstractDao{
	private String idname="datee";
	private String idnames="heuree";
	
	public DaoExamen() {
        super();
    }
    public void create(Examen examen) throws DataAccessLayerException {
        super.saveOrUpdate(examen);
    }
    
    public void delete(Examen examen) throws DataAccessLayerException {
        super.delete(examen);
    }

    public Examen find(ExamenId id) throws DataAccessLayerException {
        return (Examen) super.find(Examen.class,id);
    }

    public void update(Examen examen) throws DataAccessLayerException {
        super.saveOrUpdate(examen);
    }
    
    public Examen get(ExamenId id) throws DataAccessLayerException {
    	  return (Examen) super.get(Examen.class,id);
    }
    
    @SuppressWarnings("rawtypes")
	public List findAllId() throws DataAccessLayerException {
	    return  super.findAllId(Examen.class, idname,idnames);
    }

    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Examen.class);
    }
}
