package liamtrieu.id.vn.web.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import liamtrieu.id.vn.web.entity.base.BaseEntity;
import liamtrieu.id.vn.web.infrastructure.constant.EntityProperties;
import liamtrieu.id.vn.web.infrastructure.constant.GenderUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(columnDefinition = EntityProperties.DEFINITION_NAME)
    private String name;

    @Column(length = EntityProperties.LENGTH_CODE)
    private String code;

    private LocalDateTime birthDate;

    @Column(length = EntityProperties.LENGTH_PHONE)
    private String phone;

    @Column(length = EntityProperties.LENGTH_ADDRESS)
    private String address;

    @Enumerated(EnumType.STRING)
    private GenderUser gender;

    @ManyToMany(mappedBy = "students")
    private Set<Classes> classes = new HashSet<>();

    @ManyToMany(mappedBy = "courseStudents")
    private Set<Course> courses = new HashSet<>();

    @Column(length = EntityProperties.LENGTH_EMAIL)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
}
