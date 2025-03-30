package com.modelcontroleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appfactory.Appfactory;
import com.dao.DaoQuestion;
import com.model.Question;

/**
 * Servlet implementation class Questionctrl
 */
public class Questionctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Appfactory app = Appfactory.getInstance();
	DaoQuestion dao = (DaoQuestion)app.getModel("DaoQuestion");
	private String  manage = "/manageQuestion.jsp";
	private String  add = "/AddQuestion.jsp";
	private String  edit = "/EditQuestion.jsp";
	private String erreur = "Vous devez remplir les champs ou entrer des valeurs correctes.";
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questionctrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String action = request.getParameter("action");
		   String numq = (String)request.getParameter("numq");
	        
	   if(action != null && !"".equals(action) && numq != null && !"".equals(numq))
	   {
		   Integer id= app.stringToint(numq.trim());
			 if(id != null) 
			 {
			  
					  if(action.equals("supprimer"))
					  {  
						  dao.delete(dao.find(id));
						  getServletContext().getRequestDispatcher(manage).forward(request,response);
					  }
					  if(action.equals("modifier"))
					  {
						 
						  Question question = dao.get(id);
						  request.setAttribute("p",question);
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
	
		Question question = new Question();
		String intitule = (String)request.getParameter("intitule");
		String reponse = (String)request.getParameter("reponse");
		String diffic = (String)request.getParameter("diffic");
		String theme = (String)request.getParameter("theme");
		
		Integer tmp = app.stringToint(diffic);
		
		
		
    String action = request.getParameter("action");
    
    if( action != null && !"".equals(action) && intitule != null && !"".equals(intitule) && 
    	reponse != null && !"".equals(reponse) && diffic != null && !"".equals(diffic) && 
    	theme != null && !"".equals(theme) && tmp != null)	
    {
    		   question.setIntitule(intitule);
    		   question.setReponse(reponse);
    		   question.setTheme(theme);
    		   question.setDiffic(tmp);
    			
    			if( action.equals("ajouter")){
    				dao.create(question);
    				request.setAttribute("succes","Question ajoutée avec succès.");
    			}
    			if( action.equals("edit")){
    				Integer id = app.stringToint(request.getParameter("numq"));
    				if( id != null){
    					question.setNumq(id);
    					dao.update(question);
        				request.setAttribute("succes","Question modifiée avec succès.");	
    				} else {
    					request.setAttribute("erreur","ID question incorrecte.");
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
    			Integer id = app.stringToint(request.getParameter("numq"));
    			 if( id != null)
				  {
					  question = dao.get(id);
					  request.setAttribute("p",question);
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