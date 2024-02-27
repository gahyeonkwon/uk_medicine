package medicine.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import medicine.exception.code.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {
        private final ErrorCode errorCode;
}
