package me.qingkou.superws;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void wrapAdjust(int rowNum, int colNum) {
        while(row < 0) row += rowNum;
        while(col < 0) col += colNum;
        row = row % rowNum;
        col = col % colNum;
    }

    public Position offset(Direction dr, int len) {
        Position newPos = null;
        switch (dr) {
            case WEST:      newPos = new Position(row,       col - len); break;
            case NORTH:     newPos = new Position(row - len, col      ); break;
            case EAST:      newPos = new Position(row,       col + len); break;
            case SOUTH:     newPos = new Position(row + len, col      ); break;
            case NORTHWEST: newPos = new Position(row - len, col - len); break;
            case NORTHEAST: newPos = new Position(row - len, col + len); break;
            case SOUTHWEST: newPos = new Position(row + len, col - len); break;
            case SOUTHEAST: newPos = new Position(row + len, col + len); break;
        }
        return newPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (col != position.col) return false;
        if (row != position.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }
}
