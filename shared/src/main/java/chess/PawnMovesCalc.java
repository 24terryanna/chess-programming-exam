package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMovesCalc implements PieceMovesCalc {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> pawnMoves = new ArrayList<>();

        int pawnRow = position.getRow();
        int pawnCol = position.getColumn();
        ChessPosition pawnPosition = new ChessPosition(pawnRow, pawnCol);

        ChessPiece currentPawn = board.getPiece(position);
        boolean isWhite = currentPawn.getTeamColor() == ChessGame.TeamColor.WHITE;

        if (isWhite) {
            whitePawnMoves(board, pawnPosition, pawnMoves);
        } else {
            blackPawnMoves(board, pawnPosition, pawnMoves);
        }

        return pawnMoves;
    }

    //white helper
    private Collection<ChessMove> whitePawnMoves(ChessBoard board, ChessPosition position, Collection<ChessMove> pawnMoves) {
        int pawnRow = position.getRow();
        int pawnCol = position.getColumn();

        ChessPosition pawnForwardOne = new ChessPosition(pawnRow + 1, pawnCol);
        if (withinBounds(pawnForwardOne) && board.getPiece(pawnForwardOne) == null) {
            if (pawnRow + 1 == 8) {
                promotionPiece(pawnMoves, position, pawnForwardOne);
            } else {
                pawnMoves.add(new ChessMove(position, pawnForwardOne, null));
            }
        }

        //captureLeft
        ChessPosition captureLeft = new ChessPosition(pawnRow + 1, pawnCol - 1);
        if (withinBounds(captureLeft) && board.getPiece(captureLeft) != null && isOpponentTeam(board, position, captureLeft)) {
            if (pawnRow + 1 == 8) {
                promotionPiece(pawnMoves, position, captureLeft);
            } else {
                pawnMoves.add(new ChessMove(position, captureLeft, null));
            }
        }

        //captureRight
        ChessPosition captureRight = new ChessPosition(pawnRow + 1, pawnCol + 1);
        if (withinBounds(captureRight) && board.getPiece(captureRight) != null && isOpponentTeam(board, position, captureRight)) {
            if (pawnRow + 1 == 8) {
                promotionPiece(pawnMoves, position, captureRight);
            } else {
                pawnMoves.add(new ChessMove(position, captureRight, null));
            }
        }

        //pawnForwardTwo
        ChessPosition pawnForwardTwo = new ChessPosition(pawnRow + 2, pawnCol);
        if(pawnRow == 2) {
            if (withinBounds(pawnForwardTwo) && board.getPiece(pawnForwardOne) == null && board.getPiece(pawnForwardTwo) == null){
                pawnMoves.add(new ChessMove(position, pawnForwardTwo, null));
            }
        }

        return pawnMoves;
    }

    //black helper
    private Collection<ChessMove> blackPawnMoves(ChessBoard board, ChessPosition position, Collection<ChessMove> pawnMoves) {
        int pawnRow = position.getRow();
        int pawnCol = position.getColumn();

        ChessPosition pawnForwardOne = new ChessPosition(pawnRow - 1, pawnCol);
        if (withinBounds(pawnForwardOne) && board.getPiece(pawnForwardOne) == null) {
            if (pawnRow - 1 == 1) {
                promotionPiece(pawnMoves, position, pawnForwardOne);
            } else {
                pawnMoves.add(new ChessMove(position, pawnForwardOne, null));
            }
        }

        //captureLeft
        ChessPosition captureLeft = new ChessPosition(pawnRow - 1, pawnCol - 1);
        if (withinBounds(captureLeft) && board.getPiece(captureLeft) != null && isOpponentTeam(board, position, captureLeft)) {
            if (pawnRow - 1 == 1) {
                promotionPiece(pawnMoves, position, captureLeft);
            } else {
                pawnMoves.add(new ChessMove(position, captureLeft, null));
            }
        }

        //captureRight
        ChessPosition captureRight = new ChessPosition(pawnRow - 1, pawnCol + 1);
        if (withinBounds(captureRight) && board.getPiece(captureRight) != null && isOpponentTeam(board, position, captureRight)) {
            if (pawnRow - 1 == 1) {
                promotionPiece(pawnMoves, position, captureRight);
            } else {
                pawnMoves.add(new ChessMove(position, captureRight, null));
            }
        }

        //pawnForwardTwo
        ChessPosition pawnForwardTwo = new ChessPosition(pawnRow - 2, pawnCol);
        if(pawnRow == 7) {
            if (withinBounds(pawnForwardTwo) && board.getPiece(pawnForwardOne) == null && board.getPiece(pawnForwardTwo) == null){
                pawnMoves.add(new ChessMove(position, pawnForwardTwo, null));
            }
        }

        return pawnMoves;
    }
    //promotionPiece
    private void promotionPiece(Collection<ChessMove> pawnMoves, ChessPosition pawnFrom, ChessPosition pawnTo){
        pawnMoves.add(new ChessMove(pawnFrom, pawnTo, ChessPiece.PieceType.BISHOP));
        pawnMoves.add(new ChessMove(pawnFrom, pawnTo, ChessPiece.PieceType.QUEEN));
        pawnMoves.add(new ChessMove(pawnFrom, pawnTo, ChessPiece.PieceType.ROOK));
        pawnMoves.add(new ChessMove(pawnFrom, pawnTo, ChessPiece.PieceType.KNIGHT));

    }
}
