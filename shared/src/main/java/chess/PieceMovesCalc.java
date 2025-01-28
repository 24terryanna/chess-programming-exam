package chess;

import java.util.Collection;

public interface PieceMovesCalc {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position);

    default boolean withinBounds(ChessPosition position) {
        return (position.getRow() >= 1 && position.getRow() <= 8
        && position.getColumn() >= 1 && position.getColumn() <=8);
    }

    default boolean isOpponentTeam(ChessBoard board, ChessPosition position, ChessPosition newPosition) {
        ChessPiece currentPiece = board.getPiece(position);
        ChessPiece unknownPiece = board.getPiece(newPosition);

        return currentPiece.getTeamColor() != unknownPiece.getTeamColor();

    }
}
