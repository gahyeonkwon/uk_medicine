package medicine.exception.code;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum DetailErrorCode implements ErrorCode {

    SUCCESS(HttpStatus.OK, "정상 호출 되었습니다."),
    INVALID_REGIST_DATA(HttpStatus.BAD_REQUEST, "이미 등록된 레시피 입니다."),
    INVALID_PARAM(HttpStatus.BAD_REQUEST, "파라미터가 유효하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
