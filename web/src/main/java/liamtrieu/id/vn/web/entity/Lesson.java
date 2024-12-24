package liamtrieu.id.vn.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import liamtrieu.id.vn.web.entity.base.BaseEntity;
import liamtrieu.id.vn.web.infrastructure.constant.EntityProperties;
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
@Table(name = "lesson")
public class Lesson extends BaseEntity {

    @Column(columnDefinition = EntityProperties.DEFINITION_NAME)
    private String name;

    @Column(columnDefinition = EntityProperties.DEFINITION_DESCRIPTION)
    private String description;

    private Integer quantity;
}
