package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMovesCalc implements PieceMovesCalc{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {

        Collection<ChessMove> kingMoves = new ArrayList<>();
        int kingRow = position.getRow();
        int kingCol = position.getColumn();
        int[][] kingDirections = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        for (int[] dir : kingDirections) {
            int newRow = kingRow + dir[0];
            int newCol = kingCol + dir[1];

            ChessPosition newPosition = new ChessPosition(newRow, newCol);

            if (withinBounds(newPosition)) {
                if (board.getPiece(newPosition) == null || isOpponentTeam(board, position, newPosition)) {
                    kingMoves.add(new ChessMove(position, newPosition, null));
                }
            }
        }
        return kingMoves;
    }
}
