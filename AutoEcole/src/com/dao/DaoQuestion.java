package com.dao;

import java.util.List;

import com.core.AbstractDao;
import com.core.DataAccessLayerException;
import com.model.Question;

public class DaoQuestion extends AbstractDao{
	private String idname = "numq";
	public DaoQuestion() {
        super();
    }
    public void create(Question question) throws DataAccessLayerException {
        super.saveOrUpdate(question);
    }
    
    public void delete(Question question) throws DataAccessLayerException {
        super.delete(question);
    }

    public Question find(Integer id) throws DataAccessLayerException {
        return (Question) super.find(Question.class, id);
    }

    public void update(Question question) throws DataAccessLayerException {
        super.saveOrUpdate(question);
    }
    
    public Question get(Integer id) throws DataAccessLayerException {
        return (Question) super.get(Question.class, id);
    }
    
    @SuppressWarnings("rawtypes")
	public List findAllId() throws DataAccessLayerException {
        return  super.findAllId(Question.class, idname);
    }
    @SuppressWarnings("rawtypes")
	public List findAll() throws DataAccessLayerException{
        return super.findAll(Question.class);
    }
}
