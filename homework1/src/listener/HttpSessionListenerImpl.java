package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSessionListenerImpl
 *
 */
@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public HttpSessionListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         ServletContext application = se.getSession().getServletContext();
         if(application.getAttribute("onlineNum") == null) {
        	 application.setAttribute("onlineNum", 1);
         }else {
        	 int onlineNum = (Integer)application.getAttribute("onlineNum");
        	 onlineNum++;
        	 application.setAttribute("onlineNum", onlineNum);
         }
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         ServletContext application = se.getSession().getServletContext();
         int onlineNum = (Integer)application.getAttribute("onlineNum");
         if(onlineNum > 0) {
        	 onlineNum--;
         }else {
        	 onlineNum = 0;
         }
         application.setAttribute("onlineNum", onlineNum);
    }
	
}
