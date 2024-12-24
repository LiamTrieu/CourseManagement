package liamtrieu.id.vn.web.core.student.model;

import liamtrieu.id.vn.web.infrastructure.constant.GenderUser;
import liamtrieu.id.vn.web.infrastructure.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface StudentResponse {
    Long getId();

    String getCode();

    String getName();

    @Value("#{target.birth_date}")
    LocalDateTime getDateBirth();

    default String getBirthDate() {
        if (getDateBirth() != null) {
            return DateUtil.dateToString(getDateBirth());
        }
        return null;
    }

    String getEmail();

    String getPhone();

    String getAddress();

    String getStatus();

    GenderUser getGender();
}
