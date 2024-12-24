package liamtrieu.id.vn.web.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import liamtrieu.id.vn.web.infrastructure.constant.StatusEntity;
import liamtrieu.id.vn.web.infrastructure.listener.BaseEntityListener;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Setter
@Getter
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private String createdBy;

    @Column
    private String updatedBy;

    @Enumerated(EnumType.STRING)
    private StatusEntity status = StatusEntity.HOAT_DONG;
}
