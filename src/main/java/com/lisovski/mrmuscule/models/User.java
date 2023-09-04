package com.lisovski.mrmuscule.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp=".{0,16}")
    @Column(name="phone_number")
    private String phoneNumber;

    @Email
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @Pattern(regexp=".{0,64}")
    @Column(name="name")
    private String name;

    @Column(name="avatar_path")
    private String avatarPath;

    @Min(0)
    @Max(2147483647)
    @Column(name="bonuses")
    private int bonuses;

    @OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id",referencedColumnName = "id")
    private List<Order> ordersList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
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
}
