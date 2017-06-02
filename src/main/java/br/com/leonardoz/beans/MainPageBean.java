package br.com.leonardoz.beans;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.leonardoz.config.TransactionalOperation;
import br.com.leonardoz.entities.User;
import br.com.leonardoz.repositories.UserRepository;

@Named
@ApplicationScoped
public class MainPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String defaultMessage;

	@Inject
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		this.defaultMessage = "Hello!";
	}
	
	@TransactionalOperation
	public void saveUser(ActionEvent actionEvent) {
		User user = new User();
		user.setLogin(UUID.randomUUID().toString());
		user.setPassword(UUID.randomUUID().toString());
		userRepository.saveUser(user);
	}
	
	public List<User> listUsers() {
		return userRepository.retrieveUsers();
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}


}
