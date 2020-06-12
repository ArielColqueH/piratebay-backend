package bo.edu.ucb.sis.piratebay.model;

public class UserModel {
    private Integer userId;
    private String username;
    private String email;
    private String phoneNumber;
    private String carUserStatus;

    public UserModel() {
    }

    public UserModel(Integer userId, String username, String email, String phoneNumber, String carUserStatus) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.carUserStatus = carUserStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCarUserStatus() {
        return carUserStatus;
    }

    public void setCarUserStatus(String carUserStatus) {
        this.carUserStatus = carUserStatus;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", carUserStatus='" + carUserStatus + '\'' +
                '}';
    }
}
