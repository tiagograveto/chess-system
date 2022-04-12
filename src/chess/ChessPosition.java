package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8)
            throw new ChessException("Error instantianing ChessPosition. Valid values are from a1 to h8.");

        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition() {
        int row = 8 - this.row;
        int column = this.column - 'a';
        return new Position(row, column);
    }

    protected static ChessPosition fromPosition(Position position) {
        char column = (char) ('a' + position.getColumn());
        int row = 8 - position.getRow();
        return new ChessPosition(column, row);
    }

    @Override
    public String toString() {
        return "" + this.column + this.row;
    }
}
