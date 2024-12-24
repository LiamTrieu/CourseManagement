package liamtrieu.id.vn.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import liamtrieu.id.vn.web.infrastructure.constant.EntityProperties;
import liamtrieu.id.vn.web.infrastructure.constant.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = EntityProperties.LENGTH_PASSWORD)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleUser role;

    @OneToOne(mappedBy = "account")
    private User user;
}
