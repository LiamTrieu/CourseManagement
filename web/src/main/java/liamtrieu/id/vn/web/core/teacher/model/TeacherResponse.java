package liamtrieu.id.vn.web.core.teacher.model;

import liamtrieu.id.vn.web.infrastructure.constant.GenderUser;
import liamtrieu.id.vn.web.infrastructure.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface TeacherResponse {
    String getId();

    String getCode();

    String getName();

    @Value("#{target.birth_date}")
    LocalDateTime getDateBirth();

    default String getBirthDate() {
        return DateUtil.dateToString(getDateBirth());
    }

    String getEmail();

    String getPhone();

    Integer getTotalClass();

    String getAddress();

    String getStatus();

    GenderUser getGender();
}
