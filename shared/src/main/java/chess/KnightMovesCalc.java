package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMovesCalc implements PieceMovesCalc{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {

        Collection<ChessMove> knightMoves = new ArrayList<>();
        int knightRow = position.getRow();
        int knightCol = position.getColumn();
        int[][] kingDirections = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        for (int[] dir : kingDirections) {
            int newRow = knightRow + dir[0];
            int newCol = knightCol + dir[1];

            ChessPosition newPosition = new ChessPosition(newRow, newCol);

            if (withinBounds(newPosition)) {
                if (board.getPiece(newPosition) == null || isOpponentTeam(board, position, newPosition)) {
                    knightMoves.add(new ChessMove(position, newPosition, null));
                }
            }
        }
        return knightMoves;
    }
}
