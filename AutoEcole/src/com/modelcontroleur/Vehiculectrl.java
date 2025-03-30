package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoVehicule;
import com.model.Vehicule;

/**
 * Servlet implementation class Vehiculectrl
 */
public class Vehiculectrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoVehicule dao = (DaoVehicule)app.getModel("DaoVehicule");
	private String  manage = "/manageVehicule.jsp";
	private String  add = "/AddVehicule.jsp";
	private String  edit = "/EditVehicule.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehiculectrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("action");
		   String numv = (String)request.getParameter("numv");
		   
	   if(action != null && !"".equals(action) && numv != null && !"".equals(numv))
	   {
			  Integer id = Integer.valueOf(numv.trim());
			  
			  if(action.equals("supprimer"))
			  {  
				  dao.delete(dao.find(id));
				  getServletContext().getRequestDispatcher(manage).forward(request,response);
			  }
			  if(action.equals("modifier"))
			  {
				 
				  Vehicule vehicule= dao.get(id);
				  request.setAttribute("p",vehicule);
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
		// TODO Auto-generated method stub
		Vehicule vehicule = new Vehicule();
		String model = (String)request.getParameter("model");
        String imma = (String)request.getParameter("imma");

    String action = request.getParameter("action");
    if( action != null && !"".equals(action))
    {
        
	      if( model!= null && imma != null )
	      {
		        if (model.equals("") || imma.equals("") ){
		        	request.setAttribute("erreur",erreur);
		        	getServletContext().getRequestDispatcher(add).forward(request,response);
		        } else {
		        	      
						        vehicule.setModele(model);
						        vehicule.setImmatriculation(imma);
						      
						        if(action.equals("ajouter"))
						        {
						        	dao.create(vehicule); 
									request.setAttribute("succes","Véhicule ajouté avec succès.");
						        }
						        if( action.equals("edit"))
						        {
						        	String numv = (String)request.getParameter("numv");
						        	Integer id = null;
									if(numv!=null ||! "".equals(numv))
									{
										
										try{
											id = Integer.parseInt(numv);
										} catch (NumberFormatException e ){
											
										}
									}
									
									
									vehicule.setNumv(id); 
									dao.update(vehicule);
									request.setAttribute("succes","Véhicule modifié avec succès.");
									
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
