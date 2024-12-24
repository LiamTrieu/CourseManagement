package liamtrieu.id.vn.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import liamtrieu.id.vn.web.entity.base.BaseEntity;
import liamtrieu.id.vn.web.infrastructure.constant.EntityProperties;
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
@Table(name = "classes")
public class Classes extends BaseEntity {

    @Column(length = EntityProperties.LENGTH_CODE)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime timeStart;

    private String background = "https://www.gstatic.com/classroom/themes/img_code.jpg";

    private Short maxStudent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacher;

//    private String days;

//    private Integer study;

    @ManyToMany
    @JoinTable(
            name = "class_student",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<User> students = new HashSet<>();
}
