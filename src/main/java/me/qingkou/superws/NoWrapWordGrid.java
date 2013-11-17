package me.qingkou.superws;

public class NoWrapWordGrid extends WordGrid {
    public NoWrapWordGrid(Character[][] charArr) {
        super(charArr);
    }

    @Override
    public Character getCharByPosition(Position pos) {
        if (pos.getRow() >= 0 && pos.getRow() < this.getRowNum() && pos.getCol() >= 0 && pos.getCol() < this.getColNum()) {
            return this.getCharArr()[pos.getRow()][pos.getCol()];
        } else {
            return null;
        }
    }
}
