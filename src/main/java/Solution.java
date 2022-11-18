import java.util.*;

public class Solution {

    public static List<Position> findShortestPathForKnight(
            int chessBoardSize,int initialRow, int initialCol,
            int finalRow, int finalCol
    ){
        // How the knight is moving on the board
        // For row and columns
        int[] dx ={-2,-1,1,2,-2,-1,1,2};
        int[] dy ={-1,-2,-2,-1,1,2,2,1};
        // To keep tracking of the visited positions so that we don't get infinite loop
        // the key is the position object witch conaints {row, column}
        Map<Position, Boolean> isVisited = new HashMap<>();
        Queue<Position> positionsToVisitNext = new ArrayDeque<>();
        Position targetPosition = new Position(finalRow, finalCol);

        isVisited.put(new Position(initialRow, initialCol), true);
        //numberOfMoves.put(new Position(initialRow, initialCol), 0);
        positionsToVisitNext.add(new Position(initialRow, initialCol));
        boolean isFound = false;

        while (!positionsToVisitNext.isEmpty()){
            Position currentPosition = positionsToVisitNext.poll();
            if(currentPosition.equals(targetPosition)){
                targetPosition.setParent(currentPosition.getParent());
                isFound = true;
                break;
            }
            // Debugging porpuses
            //System.out.println(currentPosition + " Number of moves"+ numberOfMoves.get(currentPosition));

            for(int i=0;i<8;i++){
                Position probablyNextPosition = currentPosition.adjustPosition(dx[i], dy[i]);
                //System.out.println(probablyNextPosition);
                if(!isVisited.getOrDefault(probablyNextPosition, false)
                        && isOnBoard(probablyNextPosition, chessBoardSize)){
                    probablyNextPosition.setParent(currentPosition);
                    positionsToVisitNext.add(probablyNextPosition);
                    isVisited.put(probablyNextPosition, true);
                    //numberOfMoves.put(probablyNextPosition, numberOfMoves.getOrDefault(currentPosition,0)+1);
                }
            }
        }

        if(isFound){
            return formPathToTarget(targetPosition);
        }
        return null;

    };

    public static boolean isOnBoard(Position p, int boardSize){
        if(p.getColumn() <=  boardSize && p.getRow() <= boardSize
                && p.getRow() >0 && p.getColumn() > 0){
            return true;
        }else{
            return false;
        }
    };

    public static List<Position> formPathToTarget(Position target){
        List<Position> positionsToTheTarget = new LinkedList<>();
        positionsToTheTarget.add(target);
        Position iterator = target;
        while (iterator.getParent() != null){
            positionsToTheTarget.add(iterator.getParent());
            iterator = iterator.getParent();
            //System.out.println(iterator.getParent());
        }
        Collections.reverse(positionsToTheTarget);
        return positionsToTheTarget;
    }
}
