package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        this.initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        ChessPosition chessPosition = new ChessPosition(column, row);
        board.placePiece(piece, chessPosition.toPosition());
    }

    private void initialSetup() {
        this.placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        this.placeNewPiece('e', 8, new King(board, Color.BLACK));
        this.placeNewPiece('e', 1, new King(board, Color.WHITE));
    }
}
