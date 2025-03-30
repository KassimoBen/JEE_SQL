package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoInscrit;
import com.model.Inscrit;
import com.model.InscritId;

/**
 * Servlet implementation class Inscritctrl
 */
public class Inscritctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoInscrit dao = (DaoInscrit)app.getModel("DaoInscrit");
	private String  manage = "/manageInscrit.jsp";
	private String  add = "/AddInscrit.jsp";
	private String  edit = "/EditInscrit.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  Inscritctrl() {
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
		   String datee = (String)request.getParameter("datee");
		   Integer heuree =  app.stringToint((String)request.getParameter("heuree"));
		   Integer nume = app.stringToint((String)request.getParameter("nume"));
		  
		
		   
	   if(action != null && !"".equals(action) && app.VérificationDate(datee) && nume!= null && heuree != null)
	   { 
		   
			 
			          InscritId inscritid = new InscritId(nume,app.getdate(datee), heuree);
					  if(action.equals("supprimer"))
					  {  
						  dao.delete(dao.find(inscritid));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Inscrit inscrit = dao.get(inscritid);
						  request.setAttribute("p",inscrit);
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
	
		 Inscrit inscrit = new Inscrit();
		 String action = request.getParameter("action");
		 String datee = get(request.getParameter("dateeheuree"),0);
		 Integer heuree = app.stringToint(get(request.getParameter("dateeheuree"),1));
		 Integer nume = app.stringToint((String)request.getParameter("nume"));
		 Integer nbfautes =  app.stringToint((String)request.getParameter("nbfautes"));
		 
    
    if( action != null && !"".equals(action) && app.VérificationDate(datee) && nume != null && heuree != null && nbfautes != null )	
    {          
    	       InscritId inscritid = new  InscritId(nume,app.getdate(datee),heuree);
    	       inscrit.setNbfautes(nbfautes);
    	       inscrit.setId(inscritid);
    			
    			if( action.equals("ajouter")){
    				dao.create(inscrit);
    				request.setAttribute("succes","Inscrit ajoutée avec succès.");
    			}
    			if( action.equals("edit")){
       				    	dao.create(inscrit);
       				    	request.setAttribute("succes","Inscrit modifiée avec succès.");
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
    			 if( nume != null && heuree != null && nbfautes != null && app.VérificationDate(datee))
				  {
					  inscrit = dao.get(new InscritId(nume,app.getdate(datee),heuree));
					  request.setAttribute("p",inscrit);
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
