package br.com.leonardoz.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@ApplicationScoped
@WebListener
public class JPAFactory implements ServletContextListener  {

	private EntityManagerFactory factory;

	public JPAFactory() {
		this.factory = Persistence.createEntityManagerFactory("jpa-example");
	}

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	public void closeSession(@Disposes EntityManager manager) {
		try {
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (this.factory != null)
			this.factory.close();
	}
}
