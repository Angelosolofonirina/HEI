package hei.concours.hei.connection;
public class DatabaseParams {
    static final String url = System.getenv("DATABASE_URL");
    static final String username = System.getenv("DATABASE_USERNAME");
    static final String password = System.getenv("DATABASE_PASSWORD");
}
