package liamtrieu.id.vn.web.core.course.model;

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
public class CourseRequest {
    private Long id;
    private String code;
    private String name;
    private String imageUrl;
    private String description;
    private String price;
    private String status;
    private String timeEnd;
}
