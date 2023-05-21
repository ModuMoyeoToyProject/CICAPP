package pojo.practice.board.store;


import pojo.practice.board.BoardVO;

import java.util.List;

public interface BoardStoreInterface {

    /**
     * 등록
     * @param board
     * @return 등록완성 여부 확인 String
     */
    String create(BoardVO board);

    /**
     * 세부항목 조회
     * @param boardId
     * @return 보드데이터
     */
    BoardVO retrieveById(String boardId);

    /**
     * List 관리자 전체 목록 조회
     * @return 전체 보드리스트
     */
    List<BoardVO> retrieveAllForAdmin();

    /**
     * List 전체리스트 + 조회 통합
     * @param boardVo
     * @param paramType
     * @return 전체 보드리스트
     */
    List<BoardVO> retrieveAllForParam(BoardVO boardVo, String paramType);

    /**
     * 보드 내용 수정, 수정시는 view 카운트 증가 없음
     * @param board
     */
    void update(BoardVO board);

    /**
     *
     * @param boardId
     */
    void delete(String boardId);

}
