package liamtrieu.id.vn.web.core.lesson.model;

import liamtrieu.id.vn.web.entity.Lesson;
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
public class LessonRequest {
    private Long id;

    private String name;

    private String description;

    private Integer ordinal;
    private Integer quantity;

    public Lesson tranferLesson(LessonRequest req, Lesson lesson) {
        lesson.setId(req.getId());
        lesson.setName(req.getName());
        lesson.setDescription(req.getDescription());
        lesson.setQuantity(req.getQuantity());
        return lesson;
    }

    public LessonRequest lessTranfer(Lesson lesson) {
        return LessonRequest.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .description(lesson.getDescription())
                .quantity(lesson.getQuantity())
                .build();
    }
}
