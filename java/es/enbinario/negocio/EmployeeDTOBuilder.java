package es.enbinario.negocio;

public class EmployeeDTOBuilder {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public EmployeeDTOBuilder() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTOBuilder id(long id) {
		this.id = id;
		return this;
	}

	public EmployeeDTOBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public EmployeeDTOBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public EmployeeDTOBuilder email(String email) {
		this.email = email;
		return this;
	}

	public EmployeeDTOBuilder phone(String phone) {
		this.phone = phone;
		return this;
	}
	
    public EmployeeDTO build() {
        return new EmployeeDTO(this);
    }

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
}