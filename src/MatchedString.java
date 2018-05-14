import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A MatchedString is a String that has been matched by a regex pattern. It consists of SubSequences that are all either
 * matched or unmatched. Supplies an Iterator that can iterate through all of it's SubSequences.
 */
public class MatchedString implements Iterable<SubSequence> {

    // The SubSequences.
    private ArrayList<SubSequence> subSequences;

    /**
     * Create a new MatchedString.
     */
    public MatchedString() {
        this.subSequences = new ArrayList<>(0);
    }

    /**
     * Add a new SubSequence to this.
     * @param subSequence The SubSequence.
     */
    public void addSubSequence(SubSequence subSequence) {
        this.subSequences.add(subSequence);
    }

    @Override
    public Iterator<SubSequence> iterator() {
        return new MatchedStringIterator();
    }

    /**
     * An Iterator that iterates through the SubSequences of the MatchedString.
     */
    private class MatchedStringIterator implements Iterator<SubSequence> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return this.currentIndex < MatchedString.this.subSequences.size();
        }

        @Override
        public SubSequence next() {
            SubSequence next;
            try {
                next = MatchedString.this.subSequences.get(this.currentIndex);
                this.currentIndex++;
            } catch (IndexOutOfBoundsException e) {
                // Throw Exception.
                throw new NoSuchElementException();
            }
            return next;
        }
    }

    /**
     * Returns the number of SubSequences in this MatchedString.
     * @return The number of SubSequences.
     */
    public int getSize() {
        return this.subSequences.size();
    }

    /**
     * Returns the number of matches in this MatchedString.
     * @return THe number of matches.
     */
    public int getNumMatches() {
        int matches = 0;
        for (SubSequence subSequence : this) {
            if (subSequence.isMatch()) {
                matches ++;
            }
        }
        return matches;
    }

    /**
     * Returns String representation.
     * @return String representation.
     */
    public String toString() {
        String representation = "";
        for (SubSequence subSequence : this) {
            representation += subSequence.getValue() + ":";
        }
        return representation;
    }
}