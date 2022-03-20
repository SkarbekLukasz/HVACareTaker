package ls.hvacaretaker.security;

import ls.hvacaretaker.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountExpiration();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialExpiration();
    }

    @Override
    public boolean isEnabled() {
        return user.isAccountActivation();
    }

    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }
}
