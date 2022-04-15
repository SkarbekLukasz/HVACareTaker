package ls.hvacaretaker.user;

import ls.hvacaretaker.security.Role;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasa reprezentująca obiekt użytkownika aplikacji w bazie danych.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
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

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Is account expiration boolean.
     *
     * @return the boolean
     */
    public boolean isAccountExpiration() {
        return accountExpiration;
    }

    /**
     * Sets account expiration.
     *
     * @param accountExpiration the account expiration
     */
    public void setAccountExpiration(boolean accountExpiration) {
        this.accountExpiration = accountExpiration;
    }

    /**
     * Is account lock boolean.
     *
     * @return the boolean
     */
    public boolean isAccountLock() {
        return accountLock;
    }

    /**
     * Sets account lock.
     *
     * @param accountLock the account lock
     */
    public void setAccountLock(boolean accountLock) {
        this.accountLock = accountLock;
    }

    /**
     * Is credential expiration boolean.
     *
     * @return the boolean
     */
    public boolean isCredentialExpiration() {
        return credentialExpiration;
    }

    /**
     * Sets credential expiration.
     *
     * @param credentialExpiration the credential expiration
     */
    public void setCredentialExpiration(boolean credentialExpiration) {
        this.credentialExpiration = credentialExpiration;
    }

    /**
     * Is account activation boolean.
     *
     * @return the boolean
     */
    public boolean isAccountActivation() {
        return accountActivation;
    }

    /**
     * Sets account activation.
     *
     * @param accountActivation the account activation
     */
    public void setAccountActivation(boolean accountActivation) {
        this.accountActivation = accountActivation;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Add roles.
     *
     * @param role the role
     */
    public void addRoles(Role role) {
        getRoles().add(role);
    }
}
