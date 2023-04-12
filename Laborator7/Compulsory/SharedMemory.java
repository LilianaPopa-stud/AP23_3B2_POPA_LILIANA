import java.util.*;

public class SharedMemory {
    private final Queue<Token> tokens = new LinkedList<>();

    /**
     * Creates a new shared memory.
     * @param n the number of tokens to create
     */
    public SharedMemory(int n) {
        for (int i = 0; i < n * n * n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle((List<?>) tokens);
    }

    /**
     * Extracts a number of tokens from the shared memory.
     * @param howMany the number of tokens to extract
     * @return the extracted tokens
     */
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.poll());
        }
        return extracted;
    }


    /**
     * Returns the number of tokens in the shared memory.
     * @return the number of tokens in the shared memory
     */
    public Queue<Token> getTokens() {
        return tokens;
    }
}
