package ls.hvacaretaker.refrigerant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Rzucany, gdy brak jest czynnika o wskazanym id w bazie danych.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak czynnika o wskazanym ID")
public class RefrigerantNotFoundException extends RuntimeException{
}
