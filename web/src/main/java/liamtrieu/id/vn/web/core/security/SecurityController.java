package liamtrieu.id.vn.web.core.security;

import liamtrieu.id.vn.web.core.teacher.model.TeacherRequest;
import liamtrieu.id.vn.web.entity.User;
import liamtrieu.id.vn.web.infrastructure.config.security.CustomUserDetails;
import liamtrieu.id.vn.web.infrastructure.config.security.JwtTokenProvider;
import liamtrieu.id.vn.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SecurityController {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody AccountLogin accountLogin) {
        User user = userRepository.findByCode(accountLogin.getUserName().toLowerCase()).orElse(null);
        if (user != null && passwordEncoder.matches(accountLogin.getPassword(), user.getAccount().getPassword())) {
            return jwtTokenProvider.generateToken(new CustomUserDetails(user.getAccount(), user));
        }
        return null;
    }

    @PostMapping("/register")
    public Map<String, String> registerTeacher(@RequestBody TeacherRequest request) {
        Map<String, String> map = new HashMap<>();
        TeacherRequest res = userService.addAdmin(request);
        map.put("user", res.getCode());
        map.put("password", res.getPassword());
        return map;
    }

    @GetMapping("/get-user-login")
    public UserLoginResponse getUserLogin() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getUserLogin(principal.toString().toLowerCase()).orElse(null);
    }

}
