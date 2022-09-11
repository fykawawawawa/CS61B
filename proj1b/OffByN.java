public class OffByN implements CharacterComparator{
    private int N;
    public OffByN(int inN){
        N=inN;
    }
    @Override
    public boolean equalChars(char x,char y){
        return x == y+N;
    }
}
