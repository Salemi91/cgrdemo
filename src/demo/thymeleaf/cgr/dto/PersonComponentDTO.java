package demo.thymeleaf.cgr.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonComponentDTO {

	private PersonDTO person;
	private List<PersonDTO> people;
	
	/**
	 * 
	 */
	public PersonComponentDTO() {
		super();
		person = new PersonDTO();
		people = new ArrayList<PersonDTO>();
	}
	/**
	 * @return the person
	 */
	public PersonDTO getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	/**
	 * @return the people
	 */
	public List<PersonDTO> getPeople() {
		return people;
	}
	/**
	 * @param people the people to set
	 */
	public void setPeople(List<PersonDTO> people) {
		this.people = people;
	}
	
	
	
	
}
