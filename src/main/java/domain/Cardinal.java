package domain;

public enum Cardinal {
    N("W", "E"),
    W("S", "N"),
    S("E", "W"),
    E("N", "S");

    private final String left;
    private final String right;

    Cardinal(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public Cardinal left() {
        return Cardinal.valueOf(this.left);
    }

    public Cardinal right() {
        return Cardinal.valueOf(this.right);
    }
}
