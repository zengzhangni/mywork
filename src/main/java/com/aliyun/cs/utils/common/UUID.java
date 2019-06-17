package com.aliyun.cs.utils.common;

import com.aliyun.cs.config.redis.RedisService;
import com.aliyun.cs.utils.baen.BeanFactoryUtil;

/**
 * @author zengzhangni
 * @date 2019/6/17
 */
public class UUID {

    private RedisService redisService = BeanFactoryUtil.getBeanByClass(RedisService.class);

    private StringBuilder id = new StringBuilder("000000000");

    public String getUuid() {
        String idUnifyPrefix = redisService.getStr("idUnifyPrefix");
        idUnifyPrefix = id.append(idUnifyPrefix).toString();
        Integer i = Integer.valueOf(idUnifyPrefix) + 1;
        redisService.setStr("idUnifyPrefix", i.toString());
        if (idUnifyPrefix.length() > 10) {
            idUnifyPrefix.substring(idUnifyPrefix.length() - 1);
        }
        return idUnifyPrefix;
    }


}
