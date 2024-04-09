package com.themoin.overseasremittance.infrastructure.user;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "USERS")  //user라는 키워드는 이미 예약어여서 테이블명으로 사용할수 없음.
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userId;

	private String password;

	private String name;

	private String idType;

	private String idValue;

	private String token;

	private LocalDateTime created;

	private LocalDateTime updated;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("user"));
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public String getPassword(){
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Builder
	public User(String userId, String password, String name, String idType, String idValue, String token){
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.idType = idType;
		this.idValue = idValue;
		this.token = token;
		this.created = LocalDateTime.now();
		this.updated = LocalDateTime.now();
	}
}
