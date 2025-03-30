package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Lecon;

public class DaoLecon extends AbstractDao{
	private String idname = "numl";

		public DaoLecon() {
		    super();
		}
		public void create(Lecon lecon) throws DataAccessLayerException {
		    super.saveOrUpdate(lecon);
		}
		
		public void delete(Lecon lecon) throws DataAccessLayerException {
		    super.delete(lecon);
		}
		
		public Lecon find(Integer id) throws DataAccessLayerException {
		    return (Lecon) super.find(Lecon.class, id);
		}
		
		public void update(Lecon lecon) throws DataAccessLayerException {
		    super.saveOrUpdate(lecon);
		}
		
		public Lecon get(Integer id) throws DataAccessLayerException {
		    return (Lecon) super.get(Lecon.class, id);
		}
		
		@SuppressWarnings("rawtypes")
		public List findAllId() throws DataAccessLayerException {
		    return  super.findAllId(Lecon.class, idname);
		}
		@SuppressWarnings("rawtypes")
		public List findAll() throws DataAccessLayerException{
		    return super.findAll(Lecon.class);
		}
}
