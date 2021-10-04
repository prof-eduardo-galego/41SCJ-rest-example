package fiap.scj41.parkmgm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class RecursoNaoEncontradoException extends RuntimeException {
}
