package br.com.leonardoz.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.leonardoz.entities.User;
import br.com.leonardoz.repositories.UserRepository;

@Named
@FacesConverter(forClass = User.class)
public class UserConverter implements Converter {

	@Inject
	private UserRepository userRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return userRepository.getById(Long.valueOf(value)).get();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value == null ? null : String.valueOf(((User) value).getId());
	}

}
