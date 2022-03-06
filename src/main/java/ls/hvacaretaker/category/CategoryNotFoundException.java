package ls.hvacaretaker.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak kategorii o wskazanym ID")
public class CategoryNotFoundException extends RuntimeException{
}
