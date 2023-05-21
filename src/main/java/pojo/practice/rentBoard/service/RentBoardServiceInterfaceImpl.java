package pojo.practice.rentBoard.service;


import org.springframework.stereotype.Service;
import pojo.practice.rentBoard.RentBoardVO;
import pojo.practice.rentBoard.store.RentBoardStoreInterface;

import java.util.List;

@Service
public class RentBoardServiceInterfaceImpl implements RentBoardServiceInterface {

    private RentBoardStoreInterface rentBoardStoreInterface;

    public RentBoardServiceInterfaceImpl(RentBoardStoreInterface rent){
        this.rentBoardStoreInterface = rent;
    }
    @Override
    public String registRentBoard(RentBoardVO rentBoardVO) {
        return rentBoardStoreInterface.create(rentBoardVO);
    }

    @Override
    public RentBoardVO rentBoardDetail(String rentBoardId) {
        return rentBoardStoreInterface.retrieveById(rentBoardId);
    }

    @Override
    public List<RentBoardVO> rentBoardList() {
        return rentBoardStoreInterface.rentList();
    }

    @Override
    public void modifyRentBoard(RentBoardVO rentBoardVO) {
        rentBoardStoreInterface.update(rentBoardVO);
    }

    @Override
    public void removeRentBoard(String rentBoardId) {
        rentBoardStoreInterface.delete(rentBoardId);
    }
}
