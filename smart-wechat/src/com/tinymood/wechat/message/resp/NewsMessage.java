package org.taoran.course.message.resp;

import java.util.List;

/**
 * ��Ӧ��Ϣ -> ͼ����Ϣ
 * 
 * @author ����
 * @date 2015-4-7
 */
public class NewsMessage extends BaseMessage {
	// ͼ����Ϣ���� ����Ϊ1������
	private int ArticleCount;
	// ����ͼ����Ϣ Ĭ�ϵ�һ��itemΪ��ͼ
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

}
