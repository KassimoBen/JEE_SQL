package com.appfactory;
import java.lang.reflect.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.DaoEleve;
public class Appfactory {
	
	private static Appfactory instance = null;

	private Appfactory(){
		
	}
	
	/* Singleton*/
	public static Appfactory getInstance(){
		
		if(instance == null)
		{
			return new Appfactory();
		}
	return instance;
	}
	
	/* Factory*/
	  public Object getEntityModel(String nomModel){
		  Object model=null;
		  if(nomModel.equals("DaoEleve")){
			  return model = new DaoEleve();
		  }
		  return model;
		  
	  }
	
    public Object getModel(String nomModel){
    	nomModel="com.dao."+nomModel;
        Object monObject=null;
    	//Session maSession = HibernateUtil.getSessionFactory().openSession();
    	
		Class<?> maclass = null;
		Constructor<?> con = null;
			try {
				/*maclass = Class.forName(nomModel);
				con = maclass.getConstructor(Session.class);
				monObject = con.newInstance(maSession);*/
				
				maclass = Class.forName(nomModel);
				con = maclass.getConstructor();
				monObject = con.newInstance();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return monObject;
    }
    
 // vérifie le format de la date aaaa-mm-dd
 	public boolean VérificationDate(String ladate)
 	{
 		if(ladate == null)
 			return false;
 		String str[]=ladate.split("-");
 		if((str.length < 3) || (str.length >3))
 		    return false;
 		try {
 				if( Integer.parseInt(str[0]) <0 || Integer.parseInt(str[1]) <0 || Integer.parseInt(str[1]) > 12 || Integer.parseInt(str[2])<0 || Integer.parseInt(str[2]) > 31){
 					return false;
 				}
 		} catch (NumberFormatException e){
 			return false;
 		}
 		return true;
 			
 	}
 	
 	public Date getdate(String date)
 	{
 		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
 		  Date madate = null;
 		 try {
	     		madate = formatter.parse(date);
	     	     } catch (ParseException e) {
	     				// TODO Auto-generated catch block
	     				e.printStackTrace();
	         }
 		 return madate;
 	}
 	public Date changedateformat(Date date)
 	{
 		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
 		  String madate = null;
 		  Date dateformat=null;
 		 try {
	     		madate = formatter.format(date);
	     		dateformat = formatter.parse(madate);
	     	     } catch (ParseException e) {
	     				// TODO Auto-generated catch block
	     				e.printStackTrace();
	         }
 		 return dateformat;
 	}
 	
 // vérifie le format de la date aaaa-mm-dd
  	public boolean VérificationTemps(String temps)
  	{
  		if( temps == null)
  			return false;
  		String str[]=temps.split(":");
  		if((str.length < 3) || (str.length >3))
  		    return false;
  		try {
  				if( Integer.parseInt(str[0]) <0 || Integer.parseInt(str[0]) > 24 || Integer.parseInt(str[1]) < 0 || Integer.parseInt(str[1]) > 60 || Integer.parseInt(str[2]) < 0 || Integer.parseInt(str[2]) > 60 ){
  					return false;
  				}
  		} catch (NumberFormatException e){
  			return false;
  		}
  		return true;
  			
  	}
 	public Date getTime(String temps)
 	{
 		if( temps == null)
  			return null;
 		  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
 		  Date mytime = null;
 		 try {
	     		mytime = formatter.parse(temps);
	     	     } catch (ParseException e) {
	     				// TODO Auto-generated catch block
	     				e.printStackTrace();
	         }
 		 
 		 return mytime;
 	}
 	public Integer stringToint(String nombre)
 	{
 		if( nombre == null)
  			return null;
 		Integer id= null;
 	   if(nombre != null) {
 		try{
			  id = Integer.valueOf(nombre.trim());
			} catch (NumberFormatException e ){
				
			}
 	   }
 		return id;
 	}
}
