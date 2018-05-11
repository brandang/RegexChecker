/**
 * Interface that represent the backend code for the RegexChecker. Used to allow the GUI to communicate
 * with the backend.
 */
public interface Backend {
    /**
     * Set the Frontend that this Backend must communicate with.
     * @param frontend The Frontend.
     */
    void setFrontend(RegexFrontend frontend);
}