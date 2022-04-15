package ls.hvacaretaker.producent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Wyjątek rzucany, przy próbie zapisu nowego producenta, gdy w bazie danych istnieje producent o podanej nazwie.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Producent tego typu już istnieje w bazie danych")
public class ProducentAlreadyExistException extends Throwable {
}
