package org.taoran.course.message.resp;

/**
 * ��Ϣ����(���ں� -> �û�)
 * 
 * @author ����
 * @date 2015-4-6
 */
public class BaseMessage {
	// ���շ����û���openId
	private String ToUserName;
	// ���ͷ� ������΢�ź�
	private String FromUserName;
	// ��Ϣ����ʱ��
	private long CreateTime;
	// ��Ϣ����
	private String MsgType;
	// λ0x0001�����ʱ���Ǳ���յ�����Ϣ
	private int FuncFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}

}
