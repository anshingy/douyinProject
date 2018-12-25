package com.space.register.configurer;

import com.mysql.cj.x.protobuf.MysqlxExpr;
import com.space.register.dao.DYUserRepository;
import com.space.register.dao.DeviceRepository;
import com.space.register.dao.OrderRepository;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import com.space.register.entity.OrderEntity;
import com.space.register.service.DeviceService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @program: protool
 * @description: 订单点赞操作数据库操作实现类
 * @author: Mr.gao
 * @create: 2018-09-27 15:39
 **/
@Component
public class OrderThreadDatabaseImpl {

    @Resource
    protected DeviceService deviceService;
    @Resource
    protected DYUserRepository DYUserRepository;
    @Resource
    protected DeviceRepository deviceRepository;
    @Resource
    protected OrderRepository orderRepository;

    private static OrderThreadDatabaseImpl orderThreadDatabase;

    @PostConstruct
    public void init() {
        if(orderThreadDatabase == null){
            orderThreadDatabase = this;
            orderThreadDatabase.orderRepository = this.orderRepository;
            orderThreadDatabase.DYUserRepository = this.DYUserRepository;
        }
    }

    public ArrayList<OrderEntity> getAllOrder(String status){
        ArrayList<OrderEntity> orderEntities = orderThreadDatabase.orderRepository.findAllByStatus(status);
        for(OrderEntity orderEntity:orderEntities){
            orderEntity.setStatus("3");
            updataOrderInfo(orderEntity);
        }
        return orderEntities;
    }

    public DYUserEntity saveDyUser(DYUserEntity dyUserEntity){
        return orderThreadDatabase.DYUserRepository.save(dyUserEntity);
    }

    public OrderEntity updataOrderInfo(OrderEntity orderEntity){
        return orderThreadDatabase.orderRepository.save(orderEntity);
    }

    public ArrayList<DYUserEntity> getNumsUser(long lessId,long number){
        ArrayList<DYUserEntity> dyUserEntities = orderThreadDatabase.DYUserRepository.getUserByIdAndNum(lessId,number);
        return dyUserEntities;
    }

    public DeviceEntity getDeviceByID(int id){
        return orderThreadDatabase.deviceRepository.getDeviceMsgById(id);
    }

    public int getUserNum(){
        return orderThreadDatabase.DYUserRepository.getDyUserNum();
    }

    public DYUserEntity getOneUser(int id){
        return  orderThreadDatabase.DYUserRepository.findById(id);
    }
    public OrderEntity getOneOrder(int id){
        return orderThreadDatabase.orderRepository.findById(id);
    }
    public void getOrderListNew(){
        //orderThreadDatabase.orderRepository.setAllOrderNowType();
    }
}
