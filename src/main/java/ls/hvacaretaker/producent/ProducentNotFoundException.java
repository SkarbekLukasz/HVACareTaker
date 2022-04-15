package ls.hvacaretaker.producent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Rzucany, gdy nie zostaje odnaleziony producent o podanym id.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak producenta o wskazanym ID")
public class ProducentNotFoundException extends RuntimeException{

}
