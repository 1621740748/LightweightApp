package org.taoran.course.message.req;

/**
 * ������Ϣ
 * 
 * @author ����
 * @date 2015-4-6
 */
public class LinkMessage extends BaseMessage {
	// ��Ϣ����
	private String Title;
	// ��Ϣ����
	private String Description;
	// ��Ϣ����
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
