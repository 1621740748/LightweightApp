package org.taoran.course.message.event;

/**
 * �Զ���˵��¼�
 * 
 * @author ����
 * @date 2015-4-9
 */
public class MenuEvent extends BaseEvent {
	// �¼�keyֵ,���Զ���˵��ӿ���keyֵ��Ӧ
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
