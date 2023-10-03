package ListaPrioridade;

class Entry {
    private int key;
    private String value;

    public Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + key + "]: " + value;
    }
}
