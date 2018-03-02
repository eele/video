package edu.zhku.jsj144.lzc.video.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UploadPreparedVideoListener
 *
 */
@WebListener
public class UploadPreparedVideoListener implements ServletContextListener {
	
	private static List<String> vidList;

    /**
     * Default constructor. 
     */
    public UploadPreparedVideoListener() {
    	vidList = new ArrayList<String>();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
    
    public static void addVID(String id) {
    	vidList.add(id);
    }
    
    public static void removeVID(String id) {
    	vidList.remove(id);
    }
    
    public static boolean containsVID(String id) {
    	return vidList.contains(id);
    }
	
}
