package liamtrieu.id.vn.web.core.security;

import liamtrieu.id.vn.web.core.teacher.model.TeacherRequest;

public interface UserService {
    String genCodeStudent(String name);

    String checkCode(String code, Integer index);

    TeacherRequest addAdmin(TeacherRequest teacher);
}
