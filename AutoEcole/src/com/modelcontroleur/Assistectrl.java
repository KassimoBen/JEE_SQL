package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoAssiste;
import com.model.Assiste;
import com.model.AssisteId;

/**
 * Servlet implementation class Assistectrl
 */
public class Assistectrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoAssiste dao = (DaoAssiste)app.getModel("DaoAssiste");
	private String  manage = "/manageAssiste.jsp";
	private String  add = "/AddAssiste.jsp";
	private String  edit = "/EditAssiste.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  Assistectrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private String get(String txt,int val)
    {
    	if (txt == null)
    		return null;
    	String str[]=txt.split("_");
  		if((str.length < 0) || (str.length >2))
  		    return null;
  		return str[val];
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String datea = (String)request.getParameter("datea");
		   Integer heurea =  app.stringToint((String)request.getParameter("heurea"));
		   Integer nume = app.stringToint((String)request.getParameter("nume"));
		  
		
		   
	   if(action != null && !"".equals(action) && app.VérificationDate(datea) && nume!= null && heurea != null)
	   { 
		   
			 
			          AssisteId assisteid = new AssisteId(nume,app.getdate(datea), heurea);
					  if(action.equals("supprimer"))
					  {  
						  dao.delete(dao.find(assisteid));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Assiste assiste = dao.get(assisteid);
						  request.setAttribute("p",assiste);
						  getServletContext().getRequestDispatcher(edit).forward(request,response);
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
	
		 Assiste assiste = new Assiste();
		 String action = request.getParameter("action");
		 String datea= get(request.getParameter("dateaheurea"),0);
		 Integer heurea = app.stringToint(get(request.getParameter("dateaheurea"),1));
		 Integer nume = app.stringToint((String)request.getParameter("nume"));
		 Integer nbfautes =  app.stringToint((String)request.getParameter("nbfautes"));
		 
    
    if( action != null && !"".equals(action) && app.VérificationDate(datea) && nume != null && heurea != null && nbfautes != null )	
    {          
    	       AssisteId assisteid = new  AssisteId(nume,app.getdate(datea),heurea);
    	       assiste.setNbfautes(nbfautes);
    	       assiste.setId(assisteid);
    			
    			if( action.equals("ajouter")){
    				dao.create(assiste);
    				request.setAttribute("succes","Assiste ajoutée avec succès.");
    			}
    			if( action.equals("edit")){
       				    	dao.create(assiste);
       				    	request.setAttribute("succes","Assiste modifiée avec succès.");
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
    			   // on vérifie les clef primaires
    			 if( nume != null && heurea != null && nbfautes != null && app.VérificationDate(datea))
				  {
					  assiste = dao.get(new AssisteId(nume,app.getdate(datea),heurea));
					  request.setAttribute("p",assiste);
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
