package com.ps.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_profiles")
@AllArgsConstructor
@NoArgsConstructor
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long profileid;
    @NotNull(message = "Name should not be null")
    private String fullname;
    @Email(message = "Email should be in correct format.(abc@xyz.com)")
    private String email;
    private String password;
    private String profileImageUrl;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
    private Boolean isActive;
    private String activationToken;

    @PrePersist
    private void prePersist(){
        if(this.isActive == null){
            isActive = false;
        }
    }
}
