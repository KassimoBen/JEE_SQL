package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoEleve;
import com.model.Eleve;

/**
 * Servlet implementation class Elevectrl
 */
public class Elevectrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoEleve dao = (DaoEleve)app.getModel("DaoEleve");
	private String  manage = "/manageEleve.jsp";
	private String  add = "/AddEleve.jsp";
	private String  edit = "/EditEleve.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Elevectrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String action = request.getParameter("action");
		   String nume = (String)request.getParameter("nume");
	        
		  if(action != null && !"".equals(action) && nume != null && !"".equals(nume) )
		  {
			  Integer id=null;
			  try{
				  id = Integer.valueOf(nume.trim());
				} catch (NumberFormatException e ){
					request.setAttribute("erreur","Id incorrecte");
					getServletContext().getRequestDispatcher(manage).forward(request,response); 
					
				}
			  
			 if(id != null) 
			 {
				  if(action.equals("supprimer"))
				  {  
					  dao.delete(dao.find(id));
					  getServletContext().getRequestDispatcher(manage).forward(request,response);
				  }
				  if(action.equals("modifier"))
				  {
					 
					  Eleve eleve = dao.get(id);
					  request.setAttribute("p",eleve);
					  getServletContext().getRequestDispatcher(edit).forward(request,response);
				  }
			 }
			  
		  }
		  else
		  {
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
		
		Eleve eleve = new Eleve();
		String nom = (String)request.getParameter("nom");
        String prenom = (String)request.getParameter("prenom");
        String adresse = (String)request.getParameter("adresse");
        String datenaiss = (String)request.getParameter("datenaiss");
        

    String action = request.getParameter("action");
    
    if( action != null && !"".equals(action))
    {
        
	      if( nom!= null || prenom != null || adresse != null || datenaiss != null)
	      {
		        if (nom.equals("") || prenom.equals("") || adresse.equals("") || datenaiss.equals("") || !app.VérificationDate(datenaiss)){
                    // si erreur provient de edit    
		        	if( action.equals("edit")){
		        		
		        		String nume = (String)request.getParameter("nume");
			        	Integer id = null;
						if(nume!=null ||! "".equals(nume))
						{
							
							try{
								id = Integer.parseInt(nume);
							} catch (NumberFormatException e ){
								request.setAttribute("erreur","Id incorrecte");
								getServletContext().getRequestDispatcher(manage).forward(request,response); 
								
							}
							
						  if( id != null)
						  {
							  eleve = dao.get(id);
							  request.setAttribute("p",eleve);
							  request.setAttribute("erreur",erreur);
					          getServletContext().getRequestDispatcher(edit).forward(request,response);
						  }
						}
		        	}
		        	else{
		        		request.setAttribute("erreur",erreur);
			        	getServletContext().getRequestDispatcher(add).forward(request,response);
		        	}
		        	
		        } else {
						       
						        
						        eleve.setNom(nom);
						        eleve.setPrenom(prenom);
						        eleve.setAdresse(adresse);
						        eleve.setDatenaiss(app.getdate(datenaiss));
						        
						        if(action.equals("ajouter"))
						        {
						        	dao.create(eleve); 
									request.setAttribute("succes","Elève ajouté avec succès.");
						        }
						        if( action.equals("edit"))
						        {
						        	String nume = (String)request.getParameter("nume");
						        	Integer id = null;
									if(nume!=null ||! "".equals(nume))
									{
										
										try{
											id = Integer.parseInt(nume);
										} catch (NumberFormatException e ){
											request.setAttribute("erreur","Id incorrecte");
											getServletContext().getRequestDispatcher(manage).forward(request,response); 
											
										}
									}
									
									eleve.setNume(id);
									dao.update(eleve);
									request.setAttribute("succes","Elève modifié avec succès.");
									
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
