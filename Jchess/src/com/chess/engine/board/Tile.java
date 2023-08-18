//package com.chess.engine.board;
//
//import com.chess.engine.pieces.Piece;
//import com.google.common.collect.ImmutableMap;
//
//import javax.swing.text.Utilities;
//import java.util.HashMap;
//import java.util.Map;
//
//public abstract class Tile {
//    protected final int tileCoordinate;
//
//    //Declearing and initializing the Map Called (EMPTY_TILES)
//    private static final Map<Integer,EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
//
//    // this will generate and return a map of empty tiles.
//    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
//        final Map<Integer,EmptyTile> emptyTileMap = new HashMap<>();
//
//        for (int i = 0; i< BoardUtils.NUM_TILES; i++){
//            //it creates a new instance of the EmptyTile class and adds it to the emptyTileMap using the integer i as the key.
//            emptyTileMap.put(i,new EmptyTile(i));
//        }
//        //ImmutableMap.copyOf(emptyTileMap): This is a method call that creates an immutable copy of the emptyTileMap using some library or utility that provides immutable map functionality.
//        // In your code, it seems like you're using ImmutableMap from a library like Google Guava.
//        return ImmutableMap.copyOf(emptyTileMap);
//    }
//    //This is a public static method named createTile() that creates a Tile instance based on the given tile coordinate and piece.
//    //
//    //It takes two parameters: tileCoordinate, which is an integer representing the position on the chessboard, and piece, which is either a chess piece or null.
//    //
//    //If piece is not null, the method creates and returns a new OccupiedTile instance, representing a tile with a chess piece on it.
//    //
//    //If piece is null, the method retrieves the corresponding tile from the EMPTY_TILES map (which contains all possible empty tiles) using the provided tileCoordinate.
//    // It returns that tile, representing an empty tile on the chessboard.
//    public static Tile createTile(final int tileCoordinate,final Piece piece){
//        return piece!= null ? new OccupiedTile(tileCoordinate,piece): EMPTY_TILES_CACHE.get(tileCoordinate);
//    }
//    private Tile(final int tilecoordinate) {
//        this.tileCoordinate = tilecoordinate;
//    }
//    // Wether the tile is Occupied or not
//    public abstract boolean isTileOccupied();
//
//    public abstract Piece getPiece();
//    public int getTileCoordinate(){
//        return this.tileCoordinate;
//    }
//
//    // Show which tile is empty
//    public static final class EmptyTile extends Tile{
//
//        private EmptyTile(final int tilecoordinate) {
//            super(tilecoordinate);
//        }
//        @Override
//        public String toString(){
//            return "-";
//        }
//        @Override
//        public boolean isTileOccupied(){
//            return false;
//        }
//
//        @Override
//        public Piece getPiece() {
//            return null;
//        }
//
//
//    }
//    // Show which tile is occupied
//    public static final class OccupiedTile extends Tile{
//       private final Piece pieceOnTile;
//
//        private OccupiedTile(int tilecoordinate,final Piece pieceOnTile) {
//            super(tilecoordinate);
//            this.pieceOnTile = pieceOnTile;
//        }
//        @Override
//        public String toString(){
//            return getPiece().getPieceAlliance().isBlack() ? getPiece().toString().toLowerCase():
//                    getPiece().toString();
//        }
//        @Override
//        public boolean isTileOccupied() {
//            return true;
//        }
//
//        @Override
//        public Piece getPiece() {
//            return this.pieceOnTile;
//        }
//    }
//}
