package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoSerie;
import com.model.Serie;
import com.model.SerieId;

/**
 * Servlet implementation class Seriectrl
 */
public class Seriectrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoSerie dao = (DaoSerie)app.getModel("DaoSerie");
	private String  manage = "/manageSerie.jsp";
	private String  add = "/AddSerie.jsp";
	private String  edit = "/EditSerie.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  Seriectrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String nums = (String)request.getParameter("nums");
		   String numcd = (String)request.getParameter("numcd");
		   
	   if(action != null && !"".equals(action) && nums != null && !"".equals(nums) && numcd != null && !"".equals(numcd))
	   {
		   Integer id1 = app.stringToint(nums.trim());
		   Integer id2 = app.stringToint(numcd.trim());
			 if(id1 != null && id2 !=null) 
			 {
			          SerieId serieid = new SerieId(id1,id2);
					  if(action.equals("supprimer"))
					  {  
						  dao.delete(dao.find(serieid));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Serie serie = dao.get(serieid);
						  request.setAttribute("p",serie);
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
	
		 Serie serie = new Serie();
		 SerieId serieid = new SerieId();
		 String numcd = (String)request.getParameter("numcd");
	
		 Integer id2 = app.stringToint(numcd);
		 
         String action = request.getParameter("action");
    
    if( action != null && !"".equals(action) && id2 != null)	
    {
    		   serieid.setNumcd(id2);
    			
    			if( action.equals("ajouter")){
    				serie.setId(serieid);
    				dao.create(serie);
    				request.setAttribute("succes","Question ajoutée avec succès.");
    			}
    			if( action.equals("edit")){
    				 String nums = (String)request.getParameter("nums");
    				 Integer id1 = app.stringToint(nums);
    				if( id1 != null){
    					serieid.setNums(id1);
       				    serie.setId(serieid);
       				    // on vérifie que cette série existe pas 
       				    Serie tmp = dao.get(serieid);
       				    
       				    if(!serie.equals(tmp))
       				    {
       				    	dao.create(serie);
       				    	request.setAttribute("succes","Série modifiée avec succès.");
       				    }
       				    else
       				    {
       				    	// on informe l'utilisateur
       				    	request.setAttribute("erreur","Cette série existe dèjà.");
       				    }
        					
    				} else {
    					request.setAttribute("erreur","ID Série incorrecte.");
    				}
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
    			Integer id1 = app.stringToint(request.getParameter("nums"));
    			 id2 = app.stringToint(request.getParameter("numcd"));
    			 if( id1 != null && id2 != null)
				  {
					  serie = dao.get(new SerieId(id1,id2));
					  request.setAttribute("p",serie);
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
