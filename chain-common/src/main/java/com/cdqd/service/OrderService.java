package com.cdqd.service;

import com.cdqd.core.Block;

import java.util.List;
import java.util.Map;

/**
 * Description: 调用其他Order节点提供的服务
 * Created At 2020/2/8
 */
public interface OrderService {

    /**
     * 拉取其他Order节点网络地址
     *
     * @param address
     * @return
     */
    Map<String, String> fetchAddress(String address);

    /**
     * 接受其他节点的注册
     *
     * @param targetAddress
     * @param orderId
     * @param orderAddress
     */
    void register(String targetAddress, Integer orderId, String orderAddress);

    /**
     * 查询Leader节点的区块高度
     *
     * @param leaderAddress
     * @return
     */
    int getBlockIndex(String leaderAddress);

    /**
     * 从其他节点拉取区块
     *
     * @param targetAddress
     * @param blockIndex
     * @param size
     * @return
     */
    List<Block> pullBlock(String targetAddress, Integer blockIndex, Integer size);

    /**
     * 向其他节点广播区块
     *
     * @param address 目标地址
     * @param block   要广播的区块
     */
    void broadcastBlock(String address, Block block);

    /**
     * 向其他节点广播写入区块消息
     *
     * @param address 目标地址
     */
    void broadcastAckBlock(String address);

    /**
     * 向Order节点提交数据
     *
     * @param address 目标地址
     * @param peerId  peerId
     * @param data    提交的数据
     * @param sign    数据的签名
     */
    void commitData(String address, Integer peerId, String data, String sign);
}
