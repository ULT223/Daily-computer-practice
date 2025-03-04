package com.saki.company.util;

import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.InboundConnectionFailure;
import org.freeswitch.esl.client.transport.message.EslMessage;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.freeswitch.esl.client.IEslEventListener;

import java.util.Map;

public class FreeSwitchJavaESL {
    public static void main(String[] args) {
        String fsHost = "127.0.0.1"; // FreeSWITCH 服务器 IP
        int fsPort = 8021;          // ESL 监听端口
        String password = "ClueCon"; // ESL 连接密码

        // 创建 ESL 客户端
        Client client = new Client();

        try {
            // 连接 FreeSWITCH
            client.connect(fsHost, fsPort, password, 10);
            System.out.println("✅ 成功连接到 FreeSWITCH!");

            // 发送 API 命令获取系统状态
            EslMessage response = client.sendSyncApiCommand("status", "");
            System.out.println("📋 FreeSWITCH 状态:\n" + String.join("\n", response.getBodyLines()));

            // 添加事件监听器
            client.addEventListener(new FreeSwitchEventListener());

            // 订阅所有事件
            client.setEventSubscriptions("plain", "all");

            // 让程序保持运行，以便监听事件
            Thread.sleep(Long.MAX_VALUE);

        } catch (InboundConnectionFailure | InterruptedException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}

/**
 * ESL 事件监听器，适配 IEslEventListener 接口
 */
class FreeSwitchEventListener implements IEslEventListener {

    @Override
    public void eventReceived(EslEvent event) {
        String eventName = event.getEventName();
        System.out.println("📢 接收到事件：" + eventName);

        // 打印所有事件头信息
        for (Map.Entry<String, String> entry : event.getEventHeaders().entrySet()) {
            System.out.println("🔹 " + entry.getKey() + ": " + entry.getValue());
        }

        switch (eventName) {
            case "CHANNEL_CREATE":
                System.out.println("📞 呼叫创建");
                break;
            case "CHANNEL_ANSWER":
                System.out.println("✅ 呼叫已接听");
                break;
            case "CHANNEL_HANGUP":
                System.out.println("❌ 呼叫已挂断");
                break;
            default:
                System.out.println("📌 其他事件：" + eventName);
        }
    }

    @Override
    public void backgroundJobResultReceived(EslEvent event) {
        System.out.println("🎯 后台任务完成：" + event.getEventName());

        // 打印任务返回的所有参数
        for (Map.Entry<String, String> entry : event.getEventHeaders().entrySet()) {
            System.out.println("🛠️ 任务结果：" + entry.getKey() + ": " + entry.getValue());
        }
    }
}




