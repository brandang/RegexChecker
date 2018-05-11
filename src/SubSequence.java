/**
 * A SubSequence is a substring that is generated when a regex is run on a String. It can either be one of the matches
 * of the regex, or it can be a substring that is not matched.
 */
public class SubSequence {

    // The value of this String sub-sequence.
    private String value;
    // Whether or not this sub-sequence is a part of match of the regex.
    private boolean isMatch;

    /**
     * Create a new SubSequence.
     * @param value The String value of the subsequence.
     * @param isMatch Whether or not it matches the regex.
     */
    public SubSequence(String value, boolean isMatch) {
        this.value = value;
        this.isMatch = isMatch;
    }

    /**
     * Returns the String value of the SubSequence.
     * @return The value of the SubSequence.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns whether or not this SubSequence matches.
     * @return True for yes, false for no.
     */
    public boolean isMatch() {
        return isMatch;
    }
}