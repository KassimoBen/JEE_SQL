package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoExamen;
import com.model.Examen;
import com.model.ExamenId;

/**
 * Servlet implementation class Examenctrl
 */
public class Examenctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoExamen dao = (DaoExamen)app.getModel("DaoExamen");
	private String  manage = "/manageExamen.jsp";
	private String  add = "/AddExamen.jsp";
	private String  edit = "/EditExamen.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Examenctrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String datee = (String)request.getParameter("datee");
		   String heuree = (String)request.getParameter("heuree");
		   Integer id =  app.stringToint(heuree);
	   if(action != null && !"".equals(action) && datee != null && !"".equals(datee) && heuree != null && !"".equals(heuree)
			   && app.VérificationDate(datee) && id != null)
	   {
		            ExamenId examenId = new ExamenId(app.getdate(datee),id);
			
					  if(action.equals("supprimer"))
					  {  
						  
						  dao.delete(dao.find(examenId));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Examen examen = dao.get(examenId);
						  request.setAttribute("p",examen);
						  request.setAttribute("ladate",datee);
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
	
		Examen examen = new Examen();
		String datee= (String)request.getParameter("datee");
		String heuree = (String)request.getParameter("heuree");
		String typee = (String)request.getParameter("typee");
		String resultate = (String)request.getParameter("resultate");
		
		
    String action = request.getParameter("action");
    
    if( action != null && !"".equals(action) && datee!= null && !"".equals(datee) && 
    	heuree != null && !"".equals(heuree) && typee != null && !"".equals(typee) && 
    	resultate != null && !"".equals(resultate))	
    {
    	        ExamenId id = new ExamenId(app.getdate(datee),app.stringToint(heuree));
    		    examen.setId(id);
    		    examen.setResultate(resultate);
    		    examen.setTypee(typee);
    		    
    			if( action.equals("ajouter")){
    				dao.create(examen);
    				request.setAttribute("succes","Examen ajoutée avec succès.");
    			}
    			if( action.equals("edit")){
    				
    					examen.setId(id);
    					dao.update(examen);
        				request.setAttribute("succes","Lecon modifiée avec succès.");	
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
    			 if( app.getdate(datee) != null && app.stringToint(heuree) != null )
				  {
					  examen = dao.get(new ExamenId(app.getdate(datee),app.stringToint(heuree)));
					  request.setAttribute("p",examen);
					  request.setAttribute("ladate",datee);
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
