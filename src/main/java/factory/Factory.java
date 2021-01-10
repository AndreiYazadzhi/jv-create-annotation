package factory;

import dao.BetDao;
import dao.PlayerDao;
import dao.impl.BetDaoImpl;
import dao.impl.PlayerDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static PlayerDao playerDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static PlayerDao getPlayerDao() {
        if (playerDao == null) {
            playerDao = new PlayerDaoImpl();
        }
        return playerDao;
    }

    public static Object getDao(Class clazz) {
        if (clazz == BetDao.class) {
            return getBetDao();
        }
        if (clazz == PlayerDao.class) {
            return getPlayerDao();
        }
        throw new RuntimeException("Dao for object " + clazz.getName() + " is not exist!");
    }
}
