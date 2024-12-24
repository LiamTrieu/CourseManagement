package liamtrieu.id.vn.web.core.teacher.model;

import liamtrieu.id.vn.web.entity.User;
import liamtrieu.id.vn.web.infrastructure.constant.GenderUser;
import liamtrieu.id.vn.web.infrastructure.constant.StatusEntity;
import liamtrieu.id.vn.web.infrastructure.util.DateUtil;
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
public class TeacherRequest {
    private Long id;

    private String code;

    private String name;

    private String birthDate;

    private String email;

    private String phone;

    private String address;

    private String gender;

    private String roleUser;

    private String password;

    private String status;

    public User tranferUser(TeacherRequest req, User teacher) {
        teacher.setName(req.getName());
        teacher.setCode(req.getCode());
        teacher.setBirthDate(DateUtil.stringToDate(req.getBirthDate()));
        teacher.setPhone(req.getPhone());
        teacher.setAddress(req.getAddress());
        teacher.setGender(GenderUser.valueOf(req.getGender()));
        if (req.getStatus() != null && !req.getStatus().isBlank()) {
            teacher.setStatus(StatusEntity.valueOf(req.getStatus()));
        }
        return teacher;
    }

    public TeacherRequest userTranfer(User teacher) {
        return TeacherRequest.builder()
                .id(teacher.getId())
                .code(teacher.getCode())
                .name(teacher.getName())
                .birthDate(DateUtil.dateToString(teacher.getBirthDate()))
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .address(teacher.getAddress())
                .gender(teacher.getGender().toString())
                .status(teacher.getStatus().toString())
                .build();
    }
}
