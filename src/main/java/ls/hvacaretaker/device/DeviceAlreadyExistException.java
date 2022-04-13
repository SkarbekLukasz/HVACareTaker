package ls.hvacaretaker.device;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Wyjątek w przpypadku wykrycia urządzenia o danym id w istniejącej bazie danych.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Urządzenie tego typu już istnieje w bazie danych")
public class DeviceAlreadyExistException extends RuntimeException{
}
