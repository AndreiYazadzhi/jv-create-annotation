package factory;

import dao.BetDao;
import dao.PlayerDao;
import dao.impl.BetDaoImpl;
import dao.impl.PlayerDaoImpl;
import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Map<Class, Object> DaoMap = new HashMap<>();

    static {
        DaoMap.put(BetDao.class, getBetDao());
        DaoMap.put(PlayerDao.class, getPlayerDao());
    }

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
        if (!DaoMap.containsKey(clazz)) {
            throw new RuntimeException("Dao for object "
                    + clazz.getName() + " is not exist!");
        }
        return DaoMap.get(clazz);
    }
}
