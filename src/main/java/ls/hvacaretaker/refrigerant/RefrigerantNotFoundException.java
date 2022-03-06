package ls.hvacaretaker.refrigerant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak czynnika o wskazanym ID")
public class RefrigerantNotFoundException extends RuntimeException{
}
