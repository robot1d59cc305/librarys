package com.lixiangxuan.www.eventbus.event;

/**
 * <p>Description: EventBus的事件实体类</p>
 * <p>Company: www.lixiangxuan.com</p>
 *
 *  相当于来说这里的代码实际上就是一个数据结构,如果说后期有更多的数据需要存放的话,那么我们就可以在这个类当中去修改这个类的数据结构.而不用去考虑其它的东西,甚至我们还可以建立一个包来专门对这些类进行管理.不同的业务可以有不同的Event类.
 *  这里主要编写一个demo,处理信息,那么就叫做MessageEvent类,入股有文件下载的业务需要去处理那么就可以叫做FileDownloadEvent类.
 *
 * @author 李湘旋
 * @version 1.0
 * @className MessageEvent
 * @date 2018/7/23 10:17
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {

        this.message = message;
        
    }

    public void setMessage(String message) {

        this.message = message;

    }

    public String getMessage() {

        return message;

    }

}