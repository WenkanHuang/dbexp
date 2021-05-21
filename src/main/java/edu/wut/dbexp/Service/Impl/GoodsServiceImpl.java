package edu.wut.dbexp.Service.Impl;


import com.alibaba.druid.sql.visitor.functions.If;
import edu.wut.dbexp.Dao.DruidUtil;
import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxx
 */
@Service("UserService")
public class GoodsServiceImpl implements GoodsService {

    GoodsDao goodsDao;

    @Autowired
    public GoodsServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public boolean addGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean deleteGoods(Goods goods) {
        return false;
    }

    @Override
    public Goods searchGoods(String id) {
        return goodsDao.searchGoods(id);
    }

    @Override
    public List<Goods> getAllGoods() {
        return null;
    }

    @Override
    public List<Goods> selectedByStock(int num) {
        return null;
    }
}
