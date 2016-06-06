package demo.thymeleaf.cgr.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("session")
public class HomeController implements Serializable {

	private static final long serialVersionUID = 3901390503767512990L;

	public HomeController() {
		loadObjects();
	}

	private void loadObjects() {
		
	}

	/**
	 * Configure Layout.
	 */
	@RequestMapping(value = "/layout", method = RequestMethod.GET)
	public String layout(Model model) {
		return "/layouts/layout";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model, HttpServletRequest request,
			HttpServletResponse response) {		
		return "home";
	}
	
}
