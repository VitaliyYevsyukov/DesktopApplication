package utility;

public class Person {

	private String firstName;
	private String lastName;
	private Integer age;
	private String city;
	private String email;
	private String thumbnailPhoto;
	private String mediumPhoto;
	private String gender;
	private String userName;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, Integer age, String city, String email, String thumbnailPhoto,
			String mediumPhoto, String gender, String userName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.email = email;
		this.thumbnailPhoto = thumbnailPhoto;
		this.mediumPhoto = mediumPhoto;
		this.gender = gender;
		this.userName = userName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return thumbnailPhoto;
	}

	public void setPhoto(String photo) {
		this.thumbnailPhoto = photo;
	}
	
	public String getMediumPhoto() {
		return mediumPhoto;
	}

	public void setMediumPhoto(String mediumPhoto) {
		this.mediumPhoto = mediumPhoto;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
