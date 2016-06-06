package demo.thymeleaf.cgr.controller;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.thymeleaf.TemplateEngine;

import demo.thymeleaf.cgr.dto.PersonComponentDTO;
import demo.thymeleaf.cgr.dto.PersonDTO;

@Controller
@Scope("session")
@RequestMapping("/personas")
@SessionAttributes({ "formComponent" })
public class PeopleController implements Serializable {

	/**
   * 
   */
	private static final long serialVersionUID = -4498483830059653623L;

	private PersonComponentDTO formComponent;

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private TemplateEngine templateEngine;

	public PeopleController() {
		loadObjects();
	}

	private void loadObjects() {
		setFormComponent(new PersonComponentDTO());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("formComponent", getFormComponent());
		return "/manage/person";
	}

	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public	String consultar(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("formComponent") PersonComponentDTO formComponent,
			BindingResult result) {
		
		setFormComponent(formComponent);
		getFormComponent().getPeople().add(formComponent.getPerson());
		getFormComponent().setPerson(new PersonDTO());
		
		model.addAttribute("formComponent", getFormComponent());
		
		return "redirect:/personas";
	}
	
	@RequestMapping(value = "/eliminar/{index}", method = RequestMethod.GET)
	public	String eliminar(
			Model model,
			HttpServletRequest request,
			@PathVariable("index") Integer index) {
		
		if(index != null){
			PersonDTO p = getFormComponent().getPeople().get(index);
			getFormComponent().getPeople().remove(p);
		}
		
		model.addAttribute("formComponent", getFormComponent());
		
		return "redirect:/personas";
	}

	/**
	 * @return the formComponent
	 */
	public PersonComponentDTO getFormComponent() {
		return formComponent;
	}

	/**
	 * @param formComponent the formComponent to set
	 */
	public void setFormComponent(PersonComponentDTO formComponent) {
		this.formComponent = formComponent;
	}

	

}
