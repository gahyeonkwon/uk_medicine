package medicine.exception;


import lombok.extern.slf4j.Slf4j;
import medicine.exception.code.ErrorCode;
import medicine.exception.dto.CustomErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ExceptionAdviceHandler {


    // RuntimException 처리
    @ExceptionHandler
    public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(CustomException ex) {
        log.warn("SQLIntegrityConstraintViolationException ", ex);
        ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus())
                    .body(makeErrorResponse(errorCode));

    }

    private CustomErrorResponse makeErrorResponse(ErrorCode errorCode) {
        return CustomErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }
}
