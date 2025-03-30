package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoEleve;
import com.dao.DaoMoniteur;
import com.dao.DaoVehicule;
import com.model.Eleve;
import com.model.Moniteur;
import com.model.Vehicule;

/**
 * Servlet implementation class recherchectrl
 */
public class recherchectrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String  vieweleve = "/viewEleve.jsp";
	private String  viewmoniteur = "/viewMoniteur.jsp";
	private String  viewvehicule = "/viewVehicule.jsp";
	private String  manage = "/Recherche.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
	 
	  
	Appfactory app = Appfactory.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recherchectrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  String table = request.getParameter("table");
		  Integer id = app.stringToint((String)request.getParameter("rechercheID"));
		  
		  if( table != null && id != null)
		  {
			  if( table.equals("eleve")){
				  DaoEleve dao = (DaoEleve)app.getModel("DaoEleve");
				  Eleve eleve=dao.get(id);
				  if(eleve != null ) {
					  request.setAttribute("p",eleve);
					  getServletContext().getRequestDispatcher(vieweleve).forward(request,response); 	
				  }  
				  else {
					  request.setAttribute("erreur","Numéro élève non trouvé.");
					  getServletContext().getRequestDispatcher(manage).forward(request,response); 
				  }
				  	   
				  
		    }
			  if( table.equals("moniteur")){
				  DaoMoniteur dao = (DaoMoniteur)app.getModel("DaoMoniteur");
				  Moniteur moniteur=dao.get(id);
				  if(moniteur != null ) {
					  request.setAttribute("p",moniteur);
					  getServletContext().getRequestDispatcher(viewmoniteur).forward(request,response); 
					  
				  }
				  else {
				  	   request.setAttribute("erreur","Numéro moniteur non trouvé.");
				  	  getServletContext().getRequestDispatcher(manage).forward(request,response); 
				  }
				      
				  
			  }
			  if( table.equals("vehicule")){
				  DaoVehicule dao = (DaoVehicule)app.getModel("DaoVehicule");
				  Vehicule vehicule=dao.get(id);
				  if(vehicule != null ){
					  request.setAttribute("p",vehicule);
				      getServletContext().getRequestDispatcher(viewvehicule).forward(request,response); 
			     }
				  else {
				  	   request.setAttribute("erreur","Numéro véhicule non trouvé.");
				  	   getServletContext().getRequestDispatcher(manage).forward(request,response); 
				  }
		        }
			  
		  }
		  else {
			  request.setAttribute("erreur",erreur);
			  getServletContext().getRequestDispatcher(manage).forward(request,response); 
		  }
	}

}
