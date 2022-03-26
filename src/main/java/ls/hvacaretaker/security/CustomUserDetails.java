package ls.hvacaretaker.security;

import ls.hvacaretaker.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
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
