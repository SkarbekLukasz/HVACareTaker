package ls.hvacaretaker.common;

/**
 * Klasa typu Message reprezentuje obiekt zapisywany jako atrybut modelu.
 * Służy do przekazania wiadomości do użytkownika w widoku message.html.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
public class Message {

    private String title;
    private String message;

    /**
     * Konstruktor klasy Message.
     *
     * @param title   pole z tytułem wiadomości.
     * @param message pole z treścią wiadomości.
     */
    public Message(String title, String message) {
        this.title = title;
        this.message = message;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
