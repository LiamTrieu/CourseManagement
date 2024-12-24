package liamtrieu.id.vn.web.core.student.model;

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
public class StudentRequest {
    private Long id;

    private String code;

    private String name;

    private String birthDate;

    private String email;

    private String phone;

    private String address;

    private String gender;

    private String roleUser;

    private String status;

    private String password;

    private Long courseId;

    public User tranferUser(StudentRequest req, User student) {
        student.setName(req.getName());
        if (req.getBirthDate() != null && !req.getBirthDate().isBlank()) {
            student.setBirthDate(DateUtil.stringToDate(req.getBirthDate()));
        }
        student.setPhone(req.getPhone());
        if (req.getAddress() != null && !req.getAddress().isBlank()) {
            student.setAddress(req.getAddress());
        }
        if (req.getGender() != null && !req.getGender().isBlank()) {
            student.setGender(GenderUser.valueOf(req.getGender()));
        }
        if (req.getStatus() != null && !req.getStatus().isBlank()) {
            student.setStatus(StatusEntity.valueOf(req.getStatus()));
        }
        return student;
    }

    public StudentRequest userTranfer(User student) {
        return StudentRequest.builder()
                .id(student.getId())
                .code(student.getCode())
                .password(student.getAccount().getPassword())
                .email(student.getEmail())
                .name(student.getName())
                .birthDate(DateUtil.dateToString(student.getBirthDate()))
                .phone(student.getPhone())
                .address(student.getAddress())
                .gender(student.getGender().toString())
                .status(student.getStatus().toString())
                .build();
    }
}
