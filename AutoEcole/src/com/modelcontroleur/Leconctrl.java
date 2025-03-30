package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoLecon;
import com.model.Lecon;

/**
 * Servlet implementation class Leconctrl
 */
public class Leconctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoLecon dao = (DaoLecon)app.getModel("DaoLecon");
	private String  manage = "/manageLecon.jsp";
	private String  add = "/AddLecon.jsp";
	private String  edit = "/EditLecon.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Leconctrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String numl = (String)request.getParameter("numl");
	        
	   if(action != null && !"".equals(action) && numl != null && !"".equals(numl))
	   {
		   Integer id= app.stringToint(numl.trim());
			 if(id != null) 
			 {
			  
					  if(action.equals("supprimer"))
					  {  
						  dao.delete(dao.find(id));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Lecon lecon = dao.get(id);
						  request.setAttribute("p",lecon);
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
	
		Lecon lecon = new Lecon();
		String dateCours = (String)request.getParameter("dateCours");
		String heurDebut = (String)request.getParameter("heurDebut");
		String duree = (String)request.getParameter("duree");
		String nume = (String)request.getParameter("nume");
		String numv = (String)request.getParameter("numv");
		String numm = (String)request.getParameter("numm");
		
		// les id
		Integer tmp = app.stringToint(duree);
		Integer tmp1 = app.stringToint(nume);
		Integer tmp2 = app.stringToint(numv);
		Integer tmp3 = app.stringToint(numm);
		
		/*System.out.println(" cours : " +dateCours);
		System.out.println(" heure : " +heurDebut);
		System.out.println(" durée : " +duree);
		System.out.println(" nume : " +nume);
		System.out.println(" numv : " +numv);
		System.out.println(" numm : " +numm);*/
		
		
    String action = request.getParameter("action");
    
    if( action != null && !"".equals(action) && dateCours != null && !"".equals(dateCours) && 
    	heurDebut != null && !"".equals(heurDebut) && duree != null && !"".equals(duree) && 
    	nume != null && !"".equals(nume) && 	numv != null && !"".equals(numv)  && 	numm != null && !"".equals(numm)
    	&& app.VérificationDate(dateCours) && app.VérificationTemps(heurDebut) && tmp!= null && tmp1 != null && tmp2 != null &&
    	tmp3 != null)	
    {
    		   System.out.println( " date lecon : "+ app.getdate(dateCours));
    			lecon.setDateCours(app.getdate(dateCours));
    			lecon.setDuree(tmp);
    			lecon.setHeureDebut(app.getTime(heurDebut));
    			lecon.setNume(tmp1);
    			lecon.setNumv(tmp2);
    			lecon.setNumm(tmp3);
    			
    			if( action.equals("ajouter")){
    				dao.create(lecon);
    				request.setAttribute("succes","Lecon ajoutée avec succès.");
    			}
    			if( action.equals("edit")){
    				Integer id = app.stringToint(request.getParameter("numl"));
    				if( id != null){
    					lecon.setNuml(id);
    					dao.update(lecon);
        				request.setAttribute("succes","Lecon modifiée avec succès.");	
    				} else {
    					request.setAttribute("erreur","ID lecon incorrecte.");
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
    			Integer id = app.stringToint(request.getParameter("numl"));
    			 if( id != null)
				  {
					  lecon = dao.get(id);
					  request.setAttribute("p",lecon);
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
