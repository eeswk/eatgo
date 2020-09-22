package kr.co.fastcampus.eatgo.applicaiton;

public class EmailNotExistedException extends RuntimeException {
    public EmailNotExistedException(String email) {
        super("Email is not registed: " + email);
    }
}
