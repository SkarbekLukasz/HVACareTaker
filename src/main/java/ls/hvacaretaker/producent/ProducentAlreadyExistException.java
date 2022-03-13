package ls.hvacaretaker.producent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Producent tego typu już istnieje w bazie danych")
public class ProducentAlreadyExistException extends Throwable {
}
