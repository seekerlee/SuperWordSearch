package me.qingkou.superws;

public abstract class WordGrid {
    private final int rowNum;
    private final int colNum;
    private final Character[][] charArr;

    public WordGrid(Character[][] charArr) {
        if(charArr == null || charArr.length == 0 || charArr[0].length == 0) {
            throw new IllegalArgumentException("input char[][] can not be null nor zero length.");
        }
        this.charArr = charArr;
        this.colNum = charArr[0].length;
        this.rowNum = charArr.length;
    }

    public abstract Character getCharByPosition(Position pos);

    public int getColNum() {
        return colNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public Character[][] getCharArr() {
        return charArr;
    }
}
