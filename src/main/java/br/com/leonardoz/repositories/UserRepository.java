package br.com.leonardoz.repositories;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.leonardoz.config.TransactionalOperation;
import br.com.leonardoz.entities.User;

@RequestScoped
public class UserRepository {

	@Inject
	private EntityManager manager;

	public Optional<User> getById(long id) {
		return Optional.ofNullable(manager.find(User.class, id));
	}

	@TransactionalOperation
	public void saveUser(User user) {
		this.manager.persist(user);
		this.manager.flush();
	} 

	public List<User> retrieveUsers() {
		return this.manager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

}
