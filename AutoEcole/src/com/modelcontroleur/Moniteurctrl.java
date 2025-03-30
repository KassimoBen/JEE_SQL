package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoMoniteur;
import com.model.Moniteur;

/**
 * Servlet implementation class Moniteurctrl
 */
public class Moniteurctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Appfactory app = Appfactory.getInstance();
	DaoMoniteur dao = (DaoMoniteur)app.getModel("DaoMoniteur");
	private String  manage = "/manageMoniteur.jsp";
	private String  add = "/AddMoniteur.jsp";
	private String  edit = "/EditMoniteur.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Moniteurctrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String numm = (String)request.getParameter("numm");
	        
	   if(action != null && !"".equals(action) && numm != null && !"".equals(numm))
	   {
			  Integer id = Integer.valueOf(numm.trim());
			  
			  if(action.equals("supprimer"))
			  {  
				  dao.delete(dao.find(id));
				  getServletContext().getRequestDispatcher(manage).forward(request,response);
			  }
			  if(action.equals("modifier"))
			  {
				 
				  Moniteur moniteur= dao.get(id);
				  request.setAttribute("p",moniteur);
				  getServletContext().getRequestDispatcher(edit).forward(request,response);
			  }
			  
	   }
	   else{
	   request.setAttribute("erreur",erreur);
	   getServletContext().getRequestDispatcher(add).forward(request,response);
	   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub7
		//
	
		Moniteur moniteur = new Moniteur();
		String nom = (String)request.getParameter("nom");
        String prenom = (String)request.getParameter("prenom");
       
    String action = request.getParameter("action");
    
    if( action != null && !"".equals(action))
    {
        
	      if( nom!= null && prenom != null )
	      {
		        if (nom.equals("") || prenom.equals("") ){
		        	
		        	// si eereur provient de la modification
                      if( action.equals("edit")){
		        		
		        		String numm = (String)request.getParameter("numm");
			        	Integer id = null;
						if(numm!=null ||! "".equals(numm))
						{
							
							try{
								id = Integer.parseInt(numm);
							} catch (NumberFormatException e ){
								
							}
							  moniteur = dao.get(id);
							  request.setAttribute("p",moniteur);
							  request.setAttribute("erreur",erreur);
					          getServletContext().getRequestDispatcher(edit).forward(request,response);
						}
		        	}
		        	else{
		        		request.setAttribute("erreur",erreur);
			        	getServletContext().getRequestDispatcher(add).forward(request,response);
		        	}
        } else {
						        
						        moniteur.setNom(nom);
						        moniteur.setPrenom(prenom);
						       System.out.println(moniteur);
						        if(action.equals("ajouter"))
						        {
						        	dao.create(moniteur); 
									request.setAttribute("succes","Moniteur ajouté avec succès.");
						        }
						        if( action.equals("edit"))
						        {
						        	String numm = (String)request.getParameter("numm");
						        	Integer id = null;
									if(numm!=null ||! "".equals(numm))
									{
										
										try{
											id = Integer.parseInt(numm);
										} catch (NumberFormatException e ){
											// retour à l'affichage
											//getServletContext().getRequestDispatcher(manage).forward(request,response); 
											
										}
									}
									
									moniteur.setNumm(id); 
									dao.update(moniteur);
									request.setAttribute("succes","Moniteur modifié avec succès.");
									
						        }
						        getServletContext().getRequestDispatcher(manage).forward(request,response);
						      }  
	      }
        
    }
    else
    {
       request.setAttribute("erreur",erreur);
  	   getServletContext().getRequestDispatcher(add).forward(request,response);
  	  
    }
		
		
		
}
}
