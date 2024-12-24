package liamtrieu.id.vn.web.infrastructure.config.security;

import liamtrieu.id.vn.web.entity.Account;
import liamtrieu.id.vn.web.entity.User;
import liamtrieu.id.vn.web.infrastructure.constant.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    Account account;
    User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(account.getRole().name()));
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getCode();
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
        return user.getStatus().equals(StatusEntity.HOAT_DONG);
    }
}
