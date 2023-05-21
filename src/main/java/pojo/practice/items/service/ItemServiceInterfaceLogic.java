package pojo.practice.items.service;


import org.springframework.stereotype.Service;
import pojo.practice.items.ItemVO;
import pojo.practice.items.store.ItemStoreInterface;

import java.util.List;

@Service
public class ItemServiceInterfaceLogic implements ItemServiceInterface {

    private ItemStoreInterface itemMapStoreInterface;

    public ItemServiceInterfaceLogic(ItemStoreInterface boardStore){
        this.itemMapStoreInterface = boardStore;
    }
    @Override
    public String registItem(ItemVO board) {
        return itemMapStoreInterface.create(board);
    }

    @Override
    public ItemVO itemDetail(String boardId) {
        return itemMapStoreInterface.retrieveById(boardId);
    }

    @Override
    public List<ItemVO> itemListForAdmin() {
        return itemMapStoreInterface.retrieveAllForAdmin();
    }


    @Override
    public void modify(ItemVO itemVO) {
        itemMapStoreInterface.update(itemVO);
    }

    @Override
    public void remove(String userId) {
        itemMapStoreInterface.delete(userId);
    }

    @Override
    public String rent(String itemId, int itemCnt) {
        return itemMapStoreInterface.decrease(itemId,itemCnt);
    }

    @Override
    public String returnItem(String itemId, int itemCnt) {
        return itemMapStoreInterface.increase(itemId,itemCnt);
    }
}
