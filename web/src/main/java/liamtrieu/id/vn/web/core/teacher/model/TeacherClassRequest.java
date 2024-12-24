package liamtrieu.id.vn.web.core.teacher.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherClassRequest {
    private Long id;
    private String dayOfWeek;
    private Integer study;
}
