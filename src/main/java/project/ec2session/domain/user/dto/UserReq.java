package project.ec2session.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import project.ec2session.domain.user.entity.User;

public class UserReq {

    public record SignUpDto(
            @Schema(description = "로그인에 사용할 사용자 아이디", example = "user01")
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            String username,
            @Schema(description = "로그인에 사용할 비밀번호", example = "password1234")
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password,
            @Schema(description = "서비스에서 표시할 사용자 닉네임", example = "홍길동")
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            String nickname
    ) {
        public User toEntity(String encodedPassword) {
            return User.builder()
                    .username(username)
                    .password(encodedPassword)
                    .nickname(nickname)
                    .build();
        }
    }

    public record SignInDto(
            @Schema(description = "로그인할 사용자 아이디", example = "user01")
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            String username,
            @Schema(description = "로그인할 사용자 비밀번호", example = "password1234")
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password
    ) { }

    public record UpdateInfo(
            @Schema(description = "변경할 사용자 닉네임", example = "새닉네임")
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            String nickname
    ) { }
}
