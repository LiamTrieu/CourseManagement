package liamtrieu.id.vn.web.core.classes.model;

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
public class ClassesRequest {
    private Long id;

    private String code;

    private Long courseId;

    private Long teacherId;

    private String timeStart;

    private Short maxStudent;

    private String[] dayOfWeek;

    private Integer study;

    private String status;
}
