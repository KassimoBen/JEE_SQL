package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoCd;
import com.model.Cd;

/**
 * Servlet implementation class Cdctrl
 */
public class Cdctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoCd dao = (DaoCd)app.getModel("DaoCd");
	private String  manage = "/manageCd.jsp";
	private String  add = "/AddCd.jsp";
	private String  edit = "/EditCd.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cdctrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String numcd = (String)request.getParameter("numcd");
	        
	   if(action != null && !"".equals(action) && numcd != null && !"".equals(numcd))
	   {
			  Integer id = Integer.valueOf(numcd.trim());
			  
			  if(action.equals("supprimer"))
			  {  
				  dao.delete(dao.find(id));
				  getServletContext().getRequestDispatcher(manage).forward(request,response);
			  }
			  if(action.equals("modifier"))
			  {
				 
				  Cd cd = dao.get(id);
				  request.setAttribute("p",cd);
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
	
		Cd cd = new Cd();
		String editeur = (String)request.getParameter("editeur");
        
       
    String action = request.getParameter("action");
    
    if( action != null && !"".equals(action))
    {
        
	      if( editeur!= null  )
	      {
		        if (editeur.equals("") ){
		        	
		        	// si eereur provient de la modification
                      if( action.equals("edit")){
		        		
		        		String numcd= (String)request.getParameter("numcd");
			        	Integer id = null;
						if(numcd!=null ||! "".equals(numcd))
						{
							
							try{
								id = Integer.parseInt(numcd);
							} catch (NumberFormatException e ){
								
							}
							  cd = dao.get(id);
							  request.setAttribute("p",cd);
							  request.setAttribute("erreur",erreur);
					          getServletContext().getRequestDispatcher(edit).forward(request,response);
						}
		        	}
		        	else{
		        		request.setAttribute("erreur",erreur);
			        	getServletContext().getRequestDispatcher(add).forward(request,response);
		        	}
        } else {
						        
						        cd.setEditeur(editeur);
						        if(action.equals("ajouter"))
						        {
						        	dao.create(cd); 
									request.setAttribute("succes","CD ajouté avec succès.");
						        }
						        if( action.equals("edit"))
						        {
						        	String numcd = (String)request.getParameter("numcd");
						        	Integer id = null;
									if(numcd!=null ||! "".equals(numcd))
									{
										
										try{
											id = Integer.parseInt(numcd);
										} catch (NumberFormatException e ){
											// retour à l'affichage
											//getServletContext().getRequestDispatcher(manage).forward(request,response); 
											
										}
									}
									
									cd.setNumcd(id); 
									dao.update(cd);
									request.setAttribute("succes","CD modifié avec succès.");
									
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
