package com.forezp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * copyright(c) 2019
 * FileName:RedisUtil
 * Author:  ynFrineds
 * Description:缓存设置工具类
 * create :2019/3/27
 */
@Service
public class RedisUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(RedisUtil.class);

    /*缓存*/
    @Resource
    private RedisTemplate redisTemplate;

    /**
      *
      * <功能>：设置缓存
      * @param key :key ,
      * @param object :value ,
      * @param time:可用时间（毫秒）
      * @param TimeUnit-seconds:时间类型
      * @return boolean
      */
    public Boolean setValue(String key, Object object, Integer time, TimeUnit timeUnit){
        //从缓存中取数据
        Date date=new Date();
        String d=date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"\t"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
        try {
            ValueOperations<String,Object> operations=redisTemplate.opsForValue();
            Boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey){
                LOGGER.info("time:"+d+" key:"+key+",在缓存中已存在！");
            }else {
                operations.set(key,object,time,timeUnit );
                LOGGER.info("time:"+d+" key:"+key+",设置缓存成功，有效期："+time+""+timeUnit);
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            LOGGER.info("time:"+d+" key:"+key+",设置缓存失败！，原因："+e.getMessage());
            return false;
        }
    }

    /**
     * <功能>：获取缓存
     * @param key
     * @return Object
     */
     public Object getValue(String key){
         Date date=new Date();
         String d=date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"\t"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();

         ValueOperations<String, Object> operations=redisTemplate.opsForValue();
         Boolean hasKey = redisTemplate.hasKey(key);
         //判断是否存在 key
         if (hasKey) {
             Object o = operations.get(key);
             LOGGER.info("time:"+d+" key:"+key+"，从缓存中获取成功！");
             return o;
         }
         LOGGER.info("time:"+d+" key:"+key+",不存在（已过期），请先加入缓存！");
         return null;
     }

     /**
      * <删除>：删除缓存
      * @param key
      * @return Boolean
      */
      public Boolean deleteValue(String key){
          Date date=new Date();
          String d=date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"\t"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
          ValueOperations<String,Object> operations=redisTemplate.opsForValue();
          Boolean hasKey = redisTemplate.hasKey(key);
          if (hasKey){
              redisTemplate.delete(key);
              LOGGER.info("time:"+d+" key:"+key+",的缓存删除成功！");
              return true;
          }
          LOGGER.info("time:"+d+" key:"+key+",的缓存不存在！，删除失败");
          return false;
      }
}
