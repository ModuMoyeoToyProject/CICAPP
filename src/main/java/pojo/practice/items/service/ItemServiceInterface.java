package pojo.practice.items.service;


import pojo.practice.items.ItemVO;

import java.util.List;

public interface ItemServiceInterface {
    String registItem(ItemVO board);
    ItemVO itemDetail(String id);
    List<ItemVO> itemListForAdmin();

    void modify(ItemVO itemVO);

    void remove(String itemId);

    String rent(String itemId, int itemCnt);
    String returnItem(String itemId, int itemCnt);

}
