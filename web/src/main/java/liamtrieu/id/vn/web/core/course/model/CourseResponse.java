package liamtrieu.id.vn.web.core.course.model;

import java.math.BigDecimal;

public interface CourseResponse {
    String getId();

    String getName();

    String getCode();

    BigDecimal getPrice();

    Integer getLessonQuantity();

    String getDescription();

    String getStatus();

    String getImageUrl();

    Integer getClassQuantity();

    String getTimeEnd();

    Integer getStudentQuantity();

}

