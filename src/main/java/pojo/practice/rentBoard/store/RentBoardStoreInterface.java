package pojo.practice.rentBoard.store;


import pojo.practice.rentBoard.RentBoardVO;

import java.util.List;

public interface RentBoardStoreInterface {

    /**
     * 등록
     * @param rentalItem
     * @return 등록완성 여부 확인 String
     */
    String create(RentBoardVO rentalItem);

    /**
     * 세부항목 조회
     * @param rentalId
     * @return 렌탈항목
     */
    RentBoardVO retrieveById(String rentalId);

    /**
     * List 관리자 전체 목록 조회
     * @return 전체 보드리스트
     */
    List<RentBoardVO> rentList();

    /**
     * 보드 내용 수정, 수정시는 view 카운트 증가 없음
     * @param rent
     */
    void update(RentBoardVO rent);

    /**
     *
     * @param rentId
     */
    void delete(String rentId);

}
