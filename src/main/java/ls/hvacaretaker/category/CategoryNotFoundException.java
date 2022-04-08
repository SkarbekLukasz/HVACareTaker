package ls.hvacaretaker.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Wyjatek obsługujący sytuację, gdy poszukiwany obiekt Category nie zostanie odnaleziony w bazie danych.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak kategorii o wskazanym ID")
public class CategoryNotFoundException extends RuntimeException{
}
