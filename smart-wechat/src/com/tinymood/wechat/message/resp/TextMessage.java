package org.taoran.course.message.resp;

/**
 * ��Ӧ��Ϣ -> �ı���Ϣ
 * 
 * @author ����
 * @date 2015-4-6
 */
public class TextMessage extends BaseMessage {
	// �ظ�����Ϣ����
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
