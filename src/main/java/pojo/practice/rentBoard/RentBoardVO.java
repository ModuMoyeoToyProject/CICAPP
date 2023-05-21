package pojo.practice.rentBoard;

import lombok.Data;

@Data
public class RentBoardVO {

    public String rentId; //렌트 ID
    public int rentSeq; //대여번호
    public String rentTitle; //렌트 요청제목  (userInput)

    public String itemId; //물품 고유id  (userInput)
    public String itemName; //물품명  (sysInput)
    public int itemCnt; //물품량 (가변)(userInput)
    public String rentReason; //빌린사유  (userInput)
    public String rentRequestDt; //대여요청 작성일
    public String rentPeriod; //대여일시 -> later 기간
    public String returnSchedule; //반납예정일
    public int rentCnt; // 빌린 수량 (input)
    public String rentalUserId; //빌린사람
    public String rentalYn; // 대여완료 여부 (admin)
    public String rentDt; //실제 빌린일시 (admin)
    public String returnYn; //반납완료여부 (admin)
    public String returnDt; //반납확인일시 (userInput)

}
