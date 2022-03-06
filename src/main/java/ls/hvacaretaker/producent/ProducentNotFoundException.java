package ls.hvacaretaker.producent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak producenta o wskazanym ID")
public class ProducentNotFoundException extends RuntimeException{

}
