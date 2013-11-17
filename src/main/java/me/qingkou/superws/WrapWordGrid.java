package me.qingkou.superws;

public class WrapWordGrid extends WordGrid{
    public WrapWordGrid(Character[][] charArr) {
        super(charArr);
    }

    @Override
    public Character getCharByPosition(Position pos) {
        pos.wrapAdjust(this.getRowNum(), this.getColNum());
        return this.getCharArr()[pos.getRow()][pos.getCol()];
    }

}
