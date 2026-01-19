package com.regent.rpush.common.protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.google.protobuf.InvalidProtocolBufferException;

public class ProtocolUtil {
private static final Logger log = LoggerFactory.getLogger(ProtocolUtil.class);

    public static void main(String[] args) throws InvalidProtocolBufferException {
        MessageProto.MessageProtocol protocol = MessageProto.MessageProtocol.newBuilder()
                .setSendTo(12)
                .setContent("测试")
                .setFromTo(22)
                .setType(3)
                .build();

        byte[] encode = encode(protocol);

        MessageProto.MessageProtocol parseFrom = decode(encode);

        log.info("Parsed content: {}", parseFrom.getContent());
        log.info("Protocol: {}", protocol);
        log.info("Protocol equals parsedFrom: {}", protocol.equals(parseFrom));

    }

    /**
     * 编码
     */
    public static byte[] encode(MessageProto.MessageProtocol protocol) {
        return protocol.toByteArray();
    }

    /**
     * 解码
     */
    public static MessageProto.MessageProtocol decode(byte[] bytes) throws InvalidProtocolBufferException {
        return MessageProto.MessageProtocol.parseFrom(bytes);
    }
}