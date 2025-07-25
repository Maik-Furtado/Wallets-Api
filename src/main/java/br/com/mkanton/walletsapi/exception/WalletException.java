package br.com.mkanton.walletsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletException extends  RuntimeException {

    public ProblemDetail toProblemDetail(){
         var pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

         pd.setTitle("Wallet internal server error");

         return pd;
    }

}
