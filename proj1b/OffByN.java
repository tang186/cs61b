public class OffByN implements CharacterComparator {
    int N;
    OffByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int dif = x - y;
        return dif == N || dif == -N;
    }
}
