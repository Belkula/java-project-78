package hexlet.code.schemas;

public class StringSchema {
    private String input;
    private boolean required = false;
    private Integer minLength = null;
    private String containsSubstring = null;

    public StringSchema() {}

    public StringSchema(String input) {
        this.input = input;
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.containsSubstring = substring;
        return this;
    }

    public boolean isValid(String input) {
        // Apply constraints
        if (required && (input == null || input.isEmpty())) {
            return false;
        }

        if (minLength != null && (input == null || input.length() < minLength)) {
            return false;
        }

        if (containsSubstring != null && (input == null || !input.contains(containsSubstring))) {
            return false;
        }

        return true;
    }
}