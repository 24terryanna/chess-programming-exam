package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMovesCalc implements PieceMovesCalc{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> queenMoves = new ArrayList<>();

        BishopMovesCalc bishopMoves = new BishopMovesCalc();
        RookMovesCalc rookMoves = new RookMovesCalc();

        queenMoves.addAll(bishopMoves.pieceMoves(board, position));
        queenMoves.addAll(rookMoves.pieceMoves(board, position));

        return queenMoves;
    }
}
