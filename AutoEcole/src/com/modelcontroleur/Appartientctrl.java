package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoAppartient;
import com.model.Appartient;
import com.model.AppartientId;

/**
 * Servlet implementation class Appartientctrl
 */
public class Appartientctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoAppartient dao = (DaoAppartient)app.getModel("DaoAppartient");
	private String  manage = "/manageAppartient.jsp";
	private String  add = "/AddAppartient.jsp";
	private String  edit = "/EditAppartient.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  Appartientctrl() {
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
		  // String rangg = (String)request.getParameter("rang");
		   String numqq = (String)request.getParameter("numq");
		      
		   Integer nums = app.stringToint((String)request.getParameter("nums"));
		   Integer numcd = app.stringToint((String)request.getParameter("numcd"));
		  // Integer rang = app.stringToint(rangg);
		   Integer numq = app.stringToint(numqq);
		   
	   if(action != null && !"".equals(action) && numq != null && nums != null && numcd != null)
	   {
		   
			 
			          AppartientId appartientid = new AppartientId(numq,numcd,nums);
					  if(action.equals("supprimer"))
					  {  
						  dao.delete(dao.find(appartientid));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Appartient appartient = dao.get(appartientid);
						  request.setAttribute("p",appartient);
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
	
		 Appartient appartient = new Appartient();
		 String action = request.getParameter("action");
		 String rangg = (String)request.getParameter("rang");
		 String numqq = (String)request.getParameter("numq");
		 String numsnumcd = (String)request.getParameter("numsnumcd");
			  
		 Integer nums = app.stringToint(get(numsnumcd,0));
		 Integer numcd = app.stringToint(get(numsnumcd,1));
		 Integer rang = app.stringToint(rangg);
		 Integer numq = app.stringToint(numqq);
		 
    
    if( action != null && !"".equals(action) && nums != null && numcd != null && numq != null && rang != null )	
    {          
    	       AppartientId appartientid = new  AppartientId(numq,numcd,nums);
    	       appartient.setRang(rang);
    	       appartient.setId(appartientid);
    			
    			if( action.equals("ajouter")){
    				dao.create(appartient);
    				request.setAttribute("succes","Appartient ajoutée avec succès.");
    			}
    			if( action.equals("edit")){

       				    	dao.create(appartient);
       				    	request.setAttribute("succes","Appartient modifiée avec succès.");
       		
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
    			 if( numq != null && numcd != null && nums != null)
				  {
					  appartient = dao.get(new  AppartientId(numq,numcd,nums));
					  request.setAttribute("p",appartient);
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
