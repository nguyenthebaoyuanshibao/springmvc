package springmvc_example.form;

public class UserForm {
	
	//ユーザーID
	private String userId;
	
	//パスワード
	private String password;
	
	//確認 の パスワード
	private String confirmPassword;
	
	public String getUserId() {
		
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
