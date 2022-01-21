
  package com.example.demo.auth;
  
  import java.util.ArrayList; import java.util.Collection; import
  java.util.List; import java.util.Set;
  
  import org.jboss.logging.Logger; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.core.GrantedAuthority; import
  org.springframework.security.core.authority.SimpleGrantedAuthority; import
  org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.stereotype.Component;
  
  import com.example.demo.entity.Authorities; import
  com.example.demo.entity.User;
import com.example.demo.entity.ValidationClass;
import
  com.example.demo.repository.UserRoleRepository;
  
  @Component public class ApplicationUser implements UserDetails{
  
 /**
	* 
	*/
		  private static final long serialVersionUID = 1L; 
		  private static final Logger logger = Logger.getLogger(ApplicationUser.class);
		  
		  private ValidationClass validationClass = new ValidationClass();
		  
		  public ApplicationUser(ValidationClass validationClass) { super(); this.validationClass = validationClass; }
		  
		  public ApplicationUser() {}
		  
		  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
		  
				  logger.info(validationClass.getPhonenumber()); 
				  List<SimpleGrantedAuthority> authorities = new ArrayList<>();
				  
				  authorities.add(new SimpleGrantedAuthority(validationClass.getRole())); 
				  
				  return authorities; 
				  
		  }
		  
		  @Override public String getPassword() { return validationClass.getPassword(); }
		  
		  @Override public String getUsername() { return validationClass.getPhonenumber(); }
		  
		  @Override public boolean isAccountNonExpired() { return true; }
		  
		  @Override public boolean isAccountNonLocked() { return true; }
		  
		  @Override public boolean isCredentialsNonExpired() { return true; }
		  
		  @Override public boolean isEnabled() { return validationClass.isEnabled(); }
		  
		  }
		 