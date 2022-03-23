package ls.hvacaretaker.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Nie ma takiej roli w bazie danych")
public class RoleNotFoundException extends Exception{
}
