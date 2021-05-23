package edu.wut.dbexp.Controller;

import com.alibaba.fastjson.JSON;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Error.EmBusinessError;
import edu.wut.dbexp.Reponse.CommonReturnType;
import edu.wut.dbexp.Service.GoodsService;
import edu.wut.dbexp.Utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenka
 * @use 商品操作逻辑
 * @date 2021/5/219:07
 */
@RestController
@RequestMapping(value = "dbexp/goods")
@CrossOrigin
public class GoodsController {

    private GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 查询某个商品
     *
     * @return 返回某个商品信息
     */
    @PostMapping("/query/one")
    public CommonReturnType queryForOneGood(@RequestParam("goodsId") String goodsId) {
        Goods goods = goodsService.searchGoods(goodsId);
        return CommonReturnType.create(JSON.toJSONString(goods), "success");
    }

    @GetMapping("/query/all")
    public CommonReturnType queryForAllGoods() {
        if (goodsService.getAllGoods() != null) {
            return CommonReturnType.create(JSON.toJSONString(goodsService.getAllGoods()), "success");
        } else {
            return CommonReturnType.create(EmBusinessError.UNKNOWN_ERROR, "unKnownError");
        }
    }

    @PostMapping("/query/stock")
    public CommonReturnType queryByStock(@RequestParam("numbers") int num) {
        if (goodsService.selectedByStock(num) != null) {
            return CommonReturnType.create(JSON.toJSONString(goodsService.selectedByStock(num)), "success");
        } else {
            return CommonReturnType.create(EmBusinessError.UNKNOWN_ERROR, "unKnownError");
        }
    }

    @PostMapping("/add/goods")
    public CommonReturnType addGood(@RequestParam("goodAttributes") Integer goodAttributes,
                                    @RequestParam("stock") Integer stock,
                                    @RequestParam("description") String description) {
        Goods goods = new Goods();
        goods.setGoodAttributes(goodAttributes);
        goods.setDescription(description);
        goods.setStock(stock);
        goods.setGoodsId(IdUtils.getPrimaryKey());
        if (goodsService.addGoods(goods)) {
            return CommonReturnType.create(goods.getGoodsId(), "success");
        } else {
            return CommonReturnType.create(EmBusinessError.LACK_INFO, "check your data");
        }

    }

    /*@PostMapping("/update/stock")
    public CommonReturnType updateStock(@RequestParam("goodAttributes") String goodAtteibutes,
                                        @RequestParam("stock") int stock){
        Goods goods=goodsService.searchGoods();
        goods.setStock(stock);
        if (goodsService.updateGoods(goods)){
            return CommonReturnType.create(null,"update stock success");
        }

    }*/
}

