package pojo.practice.items.store;


import pojo.practice.items.ItemVO;

import java.util.List;

public interface ItemStoreInterface {

    /**
     * 등록
     * @param item
     * @return 등록완성 여부 확인 String
     */
    String create(ItemVO item);

    /**
     * 세부항목 조회
     * @param itemId
     * @return 아이템
     */
    ItemVO retrieveById(String itemId);

    /**
     * List 전체 목록 조회
     * @return 전체 아이템 리스트
     */
    List<ItemVO> retrieveAllForAdmin();

    /**
     * 물품 내용 수정
     * @param item
     */
    void update(ItemVO item);

    /**
     *
     * @param itemId
     */
    void delete(String itemId);

    String decrease(String itemId, int itemCnt);

    String increase(String itemId, int itemCnt);

}
