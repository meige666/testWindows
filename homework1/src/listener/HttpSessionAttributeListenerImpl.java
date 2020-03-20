package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class HttpSessionAttributeListenerImpl
 *
 */
@WebListener
public class HttpSessionAttributeListenerImpl implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public HttpSessionAttributeListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         String name = se.getName();
         if(name.equals("user")) {
        	 ServletContext application = se.getSession().getServletContext();
        	 if(application.getAttribute("vipNum")==null) {
        		 application.setAttribute("vipNum", 1);
        	 }else {
        		 int vipNum = (Integer)application.getAttribute("vipNum");
        		 vipNum++;
        		 application.setAttribute("vipNum", vipNum);
        	 }
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         String name = se.getName();
         if(name.equals("user")) {
        	 ServletContext application = se.getSession().getServletContext();
        	 int vipNum = (Integer)application.getAttribute("vipNum");
        	 if(vipNum > 0) {
        		 vipNum--;
        	 }else {
        		 vipNum = 0;
        	 }
        	 application.setAttribute("vipNum", vipNum);
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
