package fr.ldevapps.hello;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener {
	
	// Création du logger
	private static final Logger LOG = Logger.getLogger(MySessionListener.class.getName());
	
	// Compteur du nombre de session en cours
	private int sessionCounter = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		synchronized (this) {
			sessionCounter++;
		}
		
		LOG.log(Level.INFO, "********* Session created - {0} Session in memory *********", sessionCounter);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		synchronized (this) {
			sessionCounter--;
		}
		
		LOG.log(Level.INFO, "********* Session destroyed - {0} Session in memory *********", sessionCounter);
	}

}
