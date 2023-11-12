package pro.sky.EmployeeBookmaps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeDataRecordedIncorrectly extends RuntimeException {
    public EmployeeDataRecordedIncorrectly() {
    }

    public EmployeeDataRecordedIncorrectly(String message) {
        super(message);
    }
}
