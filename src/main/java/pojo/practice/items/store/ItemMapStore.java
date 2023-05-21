package pojo.practice.items.store;


import org.springframework.stereotype.Repository;
import pojo.practice.items.ItemVO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Repository
public class ItemMapStore implements ItemStoreInterface {

    private Map<String, ItemVO> itemMap;

    //SQL영역
    //DB를 Map으로 대체하기 때문에 sequence와 sysdate를 대신함
    int seq = 0; //아이템 물품 번호
    Date today = new Date();
    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd a HH:mm:ss");
    String regDate = date.format(today);    //등록일


    public ItemMapStore(){
        this.itemMap = new LinkedHashMap<>();
        this.seq++;
        //더미 데이터
        String itemId = "item_"+this.seq;
        ItemVO firstData = new ItemVO();
        firstData.setItemId(itemId);
        firstData.setItemType("IT자재");
        firstData.setItemNo(this.seq);
        firstData.setItemName("노트북");
        firstData.setDescribe("테스트용 첫 물품");
        firstData.setItemCnt(5);
        firstData.setItemMaxCnt(5);
        firstData.setRentalYn("Y");
        firstData.setRegistUserId("admin");
        firstData.setRegDt(regDate);
        this.itemMap.put(itemId, firstData);

        this.seq++;
        String itemId2 = "item_"+this.seq;
        ItemVO secondData = new ItemVO();
        secondData.setItemId(itemId2);
        secondData.setItemType("IT자재");
        secondData.setItemNo(this.seq);
        secondData.setItemName("카메라");
        secondData.setDescribe("테스트용 두번째 물품");
        secondData.setItemCnt(3);
        secondData.setItemMaxCnt(3);
        secondData.setRentalYn("Y");
        secondData.setRegistUserId("admin");
        secondData.setRegDt(regDate);
        this.itemMap.put(itemId2, secondData);
    }

    @Override
    public String create(ItemVO itemVO) {
        seq++;
        String itemId = "item_"+this.seq;
        //고유값
        itemVO.setItemId(itemId);
        itemVO.setItemType(itemVO.itemType);
        itemVO.setItemNo(this.seq++);
        itemVO.setItemName(itemVO.getItemName());
        itemVO.setDescribe(itemVO.getDescribe());
        itemVO.setItemMaxCnt(itemVO.getItemCnt());
        itemVO.setItemCnt(itemVO.getItemMaxCnt());
        itemVO.setRentalYn("Y");
        itemVO.setRegistUserId("admin");
        itemVO.setRegDt(this.regDate);
        itemMap.put(itemVO.getItemId(), itemVO);
        return itemVO.getItemId();
    }

    //세부조회
    @Override
    public ItemVO retrieveById(String itemId) {
        ItemVO itemVO = itemMap.get(itemId);
        return itemVO;
    }

    @Override
    public List<ItemVO> retrieveAllForAdmin() {
        return itemMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(ItemVO item) {
        itemMap.put(item.getItemId(), item);
    }

    @Override
    public void delete(String itemId) {
        itemMap.remove(itemId);
    }

    @Override
    public String decrease(String itemId,int itemCntParam) {
        ItemVO itemVO = itemMap.get(itemId);
        int itemCnt = itemVO.getItemCnt();
        String msg = "decreased";
        if(itemCnt-itemCntParam >= 0){
            itemVO.setItemCnt(itemCnt-itemCntParam);
        }else{
            msg = "can not decrease";
        }
        update(itemVO);
        return msg;
    }

    @Override
    public String increase(String itemId,int itemCntParam) {
        ItemVO itemVO = itemMap.get(itemId);
        int itemCnt = itemVO.getItemCnt();
        String msg = "increased";
        if(itemCnt+itemCntParam <= itemVO.getItemMaxCnt()){
            itemVO.setItemCnt(itemCnt+itemCntParam);
        }else{
            msg = "can not increase";
        }
        update(itemVO);
        return msg;
    }

}
