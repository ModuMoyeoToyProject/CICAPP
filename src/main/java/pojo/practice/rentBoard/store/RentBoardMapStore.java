package pojo.practice.rentBoard.store;


import org.springframework.stereotype.Repository;
import pojo.practice.rentBoard.RentBoardVO;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RentBoardMapStore implements RentBoardStoreInterface {
    private Map<String, RentBoardVO> rentListMap;

    //SQL영역
    //DB를 Map으로 대체하기 때문에 sequence와 sysdate를 대신함
    int seq = 0; //렌트번호 물품 번호
    Date today = new Date();
    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd a HH:mm:ss");
    String now = date.format(today);    //등록일

    public RentBoardMapStore(){
        this.rentListMap = new LinkedHashMap<>();
    }

    @Override
    public String create(RentBoardVO rental) {
        seq++;
        String rentId = UUID.randomUUID().toString();
        rental.setRentId(rentId);
        rental.setRentSeq(this.seq);
        rental.setRentRequestDt(now);
        rental.setRentalYn("N");
        rental.setReturnYn("N");
        rentListMap.put(rentId, rental);
        return rentId;
    }

    @Override
    public RentBoardVO retrieveById(String rentalId) {
        return rentListMap.get(rentalId);
    }

    @Override
    public List<RentBoardVO> rentList() {
        return rentListMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(RentBoardVO rent) {
        rentListMap.put(rent.getRentId(),rent);
    }

    @Override
    public void delete(String rentId) {
        rentListMap.remove(rentId);
    }

}
