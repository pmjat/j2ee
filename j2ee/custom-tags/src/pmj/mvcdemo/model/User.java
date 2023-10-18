package pmj.mvcdemo.model;

public class User {

    public User() {
	}

    public String getUserId() {
		return user_id;
	}

    public void setUserId(String user_id) {
		this.user_id = user_id;
	}

    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}

    public String getEmail() {
		return email;
	}

    public void setEmail(String email) {
		this.email = email;
	}

    public String getPhone() {
		return phone;
	}

    public void setPhone(String phone) {
		this.phone = phone;
	}

    private String user_id = "";
    private String name = "";
    private String email = "";
    private String phone = "";
}
