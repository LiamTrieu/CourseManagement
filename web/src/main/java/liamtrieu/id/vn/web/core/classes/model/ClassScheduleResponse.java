package liamtrieu.id.vn.web.core.classes.model;

import liamtrieu.id.vn.web.infrastructure.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface ClassScheduleResponse {
    String getId();

    @Value("#{target.time_study}")
    LocalDateTime getTimeStudy();

    default String getTime() {
        return DateUtil.dateToString(getTimeStudy());
    }

    Integer getStudy();

    @Value("#{target.day_of_week}")
    String getDayOfWeek();

    String getStatus();
}
