package net.codejava;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired

	private RoleRepository roleRepo;
	
	@Autowired
	private JavaMailSender mailSender;

	public User getById(long id){
		return repo.findById(id).get();
	}
	public List<User> listAll() {
		return repo.findAll();
	}
	
	public void register(User user, String siteURL) 
			throws UnsupportedEncodingException, MessagingException {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		String randomCode = RandomString.make(64);
		user.setVerificationCode(randomCode);
		user.setEnabled(false);


			Role roleUser = roleRepo.findByName("Role_User");
			user.addRole(roleUser);


		
		repo.save(user);
		
		sendVerificationEmail(user, siteURL);
	}

	public List<Role> listRoles() {
		return roleRepo.findAll();
	}


	private void sendVerificationEmail(User user, String siteURL) 
			throws MessagingException, UnsupportedEncodingException {
		String toAddress = user.getEmail();
		String fromAddress = "pcdtest8@gmail.com";
		String senderName = "pcd";
		String subject = "Please verify your registration";
		String content = "Dear [[name]],<br>"
				+ "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
				+ "Thank you,<br>"
				+ "Your company name.";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		
		content = content.replace("[[name]]", user.getFullName());
		String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
		
		content = content.replace("[[URL]]", verifyURL);
		
		helper.setText(content, true);
		
		mailSender.send(message);
		
		System.out.println("Email has been sent");
	}
	
	public boolean verify(String verificationCode) {
		User user = repo.findByVerificationCode(verificationCode);
		
		if (user == null || user.isEnabled()) {
			return false;
		} else {
			user.setVerificationCode(null);
			user.setEnabled(true);
			repo.save(user);
			
			return true;
		}
		
	}

	public void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException {
		User customer = repo.findByEmail(email);
		if (customer != null) {
			customer.setResetPasswordToken(token);
			repo.save(customer);
		} else {
			throw new CustomerNotFoundException("Could not find any customer with the email " + email);
		}
	}

	public User getByResetPasswordToken(String token) {
		return repo.findByResetPasswordToken(token);
	}

	public void updatePassword(User user, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);
		user.setPassword(encodedPassword);

		user.setResetPasswordToken(null);
		repo.save(user);
	}


	public User getByName(String user) {
		return repo.findByName(user) ;
	}

	public User getByEmail(String userEmail) {return repo.findByEmail(userEmail);
	}
}
