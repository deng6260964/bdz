package com.bdz.core.util;

/**
 * 摘取网上的SnowFlake算法
 * @author bdz
 * @date 2018/5/15 15:25
 */
public class IdWorker{

  /** 工作机器ID(0~31) */
  private long workerId;
  /** 数据中心ID(0~31) */
  private long datacenterId;
  /** 毫秒内序列(0~4095) */
  private long sequence;

  public IdWorker(long workerId, long datacenterId, long sequence){
    // sanity check for workerId
    if (workerId > maxWorkerId || workerId < 0) {
      throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",maxWorkerId));
    }
    if (datacenterId > maxDatacenterId || datacenterId < 0) {
      throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",maxDatacenterId));
    }
    System.out.printf("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
                      timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

    this.workerId = workerId;
    this.datacenterId = datacenterId;
    this.sequence = sequence;
  }

  private long twepoch = 1288834974657L;

  private long workerIdBits = 5L;
  private long datacenterIdBits = 5L;
  private long maxWorkerId = -1L ^ (-1L << workerIdBits);
  private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
  private long sequenceBits = 12L;

  private long workerIdShift = sequenceBits;
  private long datacenterIdShift = sequenceBits + workerIdBits;
  private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
  private long sequenceMask = -1L ^ (-1L << sequenceBits);

  private long lastTimestamp = -1L;

  public long getWorkerId(){
    return workerId;
  }

  public long getDatacenterId(){
    return datacenterId;
  }

  public long getTimestamp(){
    return System.currentTimeMillis();
  }

  /**
   * 获取ID
   * @return
   */
  public synchronized long nextId() {
    long timestamp = timeGen();

    if (timestamp < lastTimestamp) {
      System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
      throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                                               lastTimestamp - timestamp));
    }

    //如果是同一时间生成的，则进行毫秒内序列
    if (lastTimestamp == timestamp) {
      sequence = (sequence + 1) & sequenceMask;
      //毫秒内序列溢出
      if (sequence == 0) {
        //阻塞到下一个毫秒,获得新的时间戳
        timestamp = tilNextMillis(lastTimestamp);
      }
      //时间戳改变，毫秒内序列重置
    } else {
      sequence = 0;
    }
    //记录上次生成ID的时间截
    lastTimestamp = timestamp;
    return ((timestamp - twepoch) << timestampLeftShift) |
        (datacenterId << datacenterIdShift) |
        (workerId << workerIdShift) |
        sequence;
  }

  /**
   * 阻塞到下一个毫秒，直到获取新的时间戳
   * @param lastTimestamp
   * @return
   */
  private long tilNextMillis(long lastTimestamp) {
    long timestamp = timeGen();
    while (timestamp <= lastTimestamp) {
      timestamp = timeGen();
    }
    return timestamp;
  }

  /**
   * 获取时间戳
   * @return
   */
  private long timeGen(){
    return System.currentTimeMillis();
  }



}