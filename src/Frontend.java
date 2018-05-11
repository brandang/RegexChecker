/**
 * Interface that represents the frontend of the program. Allows the backend to tell the frontend what to display.
 */
public interface Frontend {
    /**
     * Set the Backend that this Frontend must communicate with.
     * @param backend The Backend.
     */
    void setBackend(RegexBackend backend);
} 