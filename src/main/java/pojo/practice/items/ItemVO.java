package pojo.practice.items;

import lombok.Data;

@Data
public class ItemVO {

    public String itemId; //물품 고유id
    public String itemType; //물품 종류 (input)
    public int itemNo; //물품 넘버링
    public String itemName; //물품명 (input)
    public String describe; //물품설명 (input)
    public int itemMaxCnt; //최초 물품량(최초 이후 불변)
    public int itemCnt; //물품량 (가변)
    public String rentalYn; // 대여 가능여부
    public String registUserId; //등록한사람
    public String regDt; //등록일시

}
