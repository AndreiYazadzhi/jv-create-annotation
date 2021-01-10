package dao.impl;

import static db.Storage.bets;

import dao.BetDao;
import java.util.List;
import lib.Dao;
import model.Bet;

@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return bets;
    }
}
