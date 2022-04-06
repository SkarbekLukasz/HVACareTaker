package ls.hvacaretaker.user;

import ls.hvacaretaker.security.Role;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 45)
    @NotNull
    @Email(message = "Niewłaściwy format adresu email")
    private String email;
    @Column(nullable = false, length = 64)
    @NotNull @Size(max = 64, min = 8) @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
    private String password;
    @Column(name = "first_name", nullable = false, length = 20)
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 20)
    @NotBlank @Size(min = 2, max = 20)
    private String lastName;
    @Column(name = "account_expiration")
    private boolean accountExpiration;
    @Column(name = "account_lock")
    private boolean accountLock;
    @Column(name = "credential_expiration")
    private boolean credentialExpiration;
    @Column(name = "account_activation")
    private boolean accountActivation;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isAccountExpiration() {
        return accountExpiration;
    }

    public void setAccountExpiration(boolean accountExpiration) {
        this.accountExpiration = accountExpiration;
    }

    public boolean isAccountLock() {
        return accountLock;
    }

    public void setAccountLock(boolean accountLock) {
        this.accountLock = accountLock;
    }

    public boolean isCredentialExpiration() {
        return credentialExpiration;
    }

    public void setCredentialExpiration(boolean credentialExpiration) {
        this.credentialExpiration = credentialExpiration;
    }

    public boolean isAccountActivation() {
        return accountActivation;
    }

    public void setAccountActivation(boolean accountActivation) {
        this.accountActivation = accountActivation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void addRoles(Role role) {
        getRoles().add(role);
    }
}
