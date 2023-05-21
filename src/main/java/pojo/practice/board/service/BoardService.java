package pojo.practice.board.service;


import pojo.practice.board.BoardVO;

import java.util.List;

public interface BoardService {
    String registBoard(BoardVO board);
    BoardVO boardDetail(String id);
    List<BoardVO> boardListForAdmin();

    List<BoardVO> boardList(BoardVO board, String paramType);
    void modify(BoardVO boardVO);
    void remove(String userId);

}
