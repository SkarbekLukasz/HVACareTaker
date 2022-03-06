package ls.hvacaretaker.device;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Urządzenie tego typu już istnieje w bazie danych")
public class DeviceAlreadyExistException extends RuntimeException{
}
