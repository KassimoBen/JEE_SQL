package com.modelcontroleur;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoSeance;
import com.model.Seance;
import com.model.SeanceId;

/**
 * Servlet implementation class Seancectrl
 */
public class Seancectrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoSeance dao = (DaoSeance)app.getModel("DaoSeance");
	private String  manage = "/manageSeance.jsp";
	private String  add = "/AddSeance.jsp";
	private String  edit = "/EditSeance.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  Seancectrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private String get(String txt,int val)
    {
    	String str[]=txt.split("_");
  		if((str.length < 0) || (str.length >2))
  		    return null;
  		return str[val];
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String date = (String)request.getParameter("dates");
		   String heure = (String)request.getParameter("heures");
		   
		   Integer id2 = app.stringToint(heure);
		   
		   
	   if(action != null && !"".equals(action) && app.VérificationDate(date) && id2 != null)
	   {
		   Date id1 = app.getdate(date);
		   
			 if(id1 != null && id2 !=null) 
			 {
			          SeanceId seanceid = new SeanceId(id1,id2);
					  if(action.equals("supprimer"))
					  {  
						  dao.delete(dao.find(seanceid));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Seance seance = dao.get(seanceid);
						  request.setAttribute("p",seance);
						  request.setAttribute("ladate", date);
						  getServletContext().getRequestDispatcher(edit).forward(request,response);
					  }
			 }else {
					request.setAttribute("erreur","Id incorrecte");
					getServletContext().getRequestDispatcher(manage).forward(request,response); 
			 }
			  
	   }
	   else{
	   request.setAttribute("erreur","Paramètres incorrectes");
	   getServletContext().getRequestDispatcher(manage).forward(request,response);
	   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub7
		//
	
		 Seance seance = new Seance();
		 String date = (String)request.getParameter("dates");
		 String heure = (String)request.getParameter("heures");
		 String numsnumcd = (String)request.getParameter("numsnumcd");
		  
		 Integer id2 = app.stringToint(heure);
		 Integer nums = app.stringToint(get(numsnumcd,0));
		 Integer numcd = app.stringToint(get(numsnumcd,1));
		 
         String action = request.getParameter("action");
    
    if( action != null && !"".equals(action) && nums != null && numcd != null && app.VérificationDate(date) && id2 !=null )	
    {          
    	       SeanceId seanceid = new SeanceId(app.getdate(date),id2);
    	       seance.setId(seanceid);
			   seance.setNums(nums);
			   seance.setNumcd(numcd);
    			
    			if( action.equals("ajouter")){
    				dao.create(seance);
    				request.setAttribute("succes","Séance ajoutée avec succès.");
    			}
    			if( action.equals("edit")){

       				    	dao.create(seance);
       				    	request.setAttribute("succes","Série modifiée avec succès.");
       		
    			}
    			
    			getServletContext().getRequestDispatcher(manage).forward(request,response);        
		
    }
    else
    {
    	if( action != null && !"".equals(action))
    	{
    		 // alors l'erreur provient de la modification
    		if(action.equals("edit"))
    		{
    			   // on vérifie la date et l'heure
    			 if( app.VérificationDate(date) && id2 != null)
				  {
					  seance = dao.get(new SeanceId(app.getdate(date),id2));
					  request.setAttribute("p",seance);
				  }
    			  request.setAttribute("erreur",erreur);
		          getServletContext().getRequestDispatcher(edit).forward(request,response);
			 
    			
    		}
    		else{
        		request.setAttribute("erreur",erreur);
	        	getServletContext().getRequestDispatcher(add).forward(request,response);
        	}
    	} else {
    		
    		// on le rédirige vers la page de manage avec un message d'erreur
    		request.setAttribute("erreur","Action inconnue");
    		getServletContext().getRequestDispatcher(manage).forward(request,response);        
    		
    	}
    	
    }

}

}
