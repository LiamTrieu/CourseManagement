package liamtrieu.id.vn.web.infrastructure.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import liamtrieu.id.vn.web.entity.base.BaseEntity;

import java.time.LocalDateTime;


public class BaseEntityListener {
    @PrePersist
    private void onCreate(BaseEntity entity) {
        entity.setCreatedAt(getLongDate());
        entity.setUpdatedAt(getLongDate());
        entity.setUpdatedBy("Admin");
        entity.setCreatedBy("Admin");
    }

    @PreUpdate
    private void onUpdate(BaseEntity entity) {
        entity.setUpdatedAt(getLongDate());
        String updatedBy = "Admin";
        entity.setUpdatedBy(updatedBy);
    }

    private LocalDateTime getLongDate() {
        return LocalDateTime.now();
    }
}
