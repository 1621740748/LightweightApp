package org.taoran.course.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.taoran.course.pojo.Face;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ����������
 * 
 * @author ����
 * @date 2015-4-15
 */
public class FaceService {
	/**
	 * ����http����
	 * 
	 * @param requestUrl
	 *            �����ַ
	 * @return String
	 */
	private static String httpRequest(String requestUrl) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();
			// �����ص�������ת�����ַ���
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// �ͷ���Դ
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * ����Face++ APIʵ���������
	 * 
	 * @param picUrl
	 *            �����ͼƬ�ķ��ʵ�ַ
	 * @return List<Face> �����б�
	 */
	private static List<Face> faceDetect(String picUrl) {
		List<Face> faceList = new ArrayList<Face>();
		try {
			// ƴ��Face++�������������ַ
			String queryUrl = "http://apicn.faceplusplus.com/v2/detection/detect?url=URL&api_secret=API_SECRET&api_key=API_KEY";
			// ��URL���б���
			queryUrl = queryUrl.replace("URL",
					java.net.URLEncoder.encode(picUrl, "UTF-8"));
			queryUrl = queryUrl.replace("API_KEY",
					"0bcb1a3096ae11c9d69d3fa6dcc80f7a");
			queryUrl = queryUrl.replace("API_SECRET",
					"HAHLEIlYu-F4vCzotuvV3nVuMwJCT7-5");
			// �����������ӿ�
			String json = httpRequest(queryUrl);
			// ��������json�е�Face�б�
			JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray(
					"face");
			// ������⵽������
			for (int i = 0; i < jsonArray.size(); i++) {
				// face
				JSONObject faceObject = (JSONObject) jsonArray.get(i);
				// attribute
				JSONObject attrObject = faceObject.getJSONObject("attribute");
				// position
				JSONObject posObject = faceObject.getJSONObject("position");
				Face face = new Face();
				face.setFaceId(faceObject.getString("face_id"));
				face.setAgeValue(attrObject.getJSONObject("age")
						.getInt("value"));
				face.setAgeRange(attrObject.getJSONObject("age")
						.getInt("range"));
				face.setGenderValue(genderConvert(attrObject.getJSONObject(
						"gender").getString("value")));
				face.setGenderConfidence(attrObject.getJSONObject("gender")
						.getDouble("confidence"));
				face.setRaceValue(raceConvert(attrObject.getJSONObject("race")
						.getString("value")));
				face.setRaceConfidence(attrObject.getJSONObject("race")
						.getDouble("confidence"));
				face.setSmilingValue(attrObject.getJSONObject("smiling")
						.getDouble("value"));
				face.setCenterX(posObject.getJSONObject("center")
						.getDouble("x"));
				face.setCenterY(posObject.getJSONObject("center")
						.getDouble("y"));
				faceList.add(face);
			}
			// ��������Face���������ҵ�˳������
			Collections.sort(faceList);
		} catch (Exception e) {
			faceList = null;
			e.printStackTrace();
		}
		return faceList;
	}

	/**
	 * �Ա�ת����Ӣ��->���ģ�
	 * 
	 * @param gender
	 * @return
	 */
	private static String genderConvert(String gender) {
		String result = "����";
		if ("Male".equals(gender))
			result = "Male(����)";
		else if ("Female".equals(gender))
			result = "Female(Ů��)";

		return result;
	}

	/**
	 * ����ת����Ӣ��->���ģ�
	 * 
	 * @param race
	 * @return
	 */
	private static String raceConvert(String race) {
		String result = "��ɫ";
		if ("Asian".equals(race))
			result = "Yellow����ɫ��";
		else if ("White".equals(race))
			result = "White����ɫ��";
		else if ("Black".equals(race))
			result = "Black����ɫ��";
		return result;
	}

	/**
	 * ��������ʶ������װ��Ϣ
	 * 
	 * @param faceList
	 *            �����б�
	 * @return
	 */
	private static String makeMessage(List<Face> faceList) {
		DecimalFormat df = new DecimalFormat("0.00");
		StringBuffer buffer = new StringBuffer();
		buffer.append("***************************\nResult:\n");
		// ��⵽1����
		if (1 == faceList.size()) {
//			buffer.append("����⵽").append(faceList.size()).append("������")
//					.append("\n");
			buffer.append("total of ").append(faceList.size()).append(" face detected.")
			.append("\n");
			for (Face face : faceList) {
				buffer.append("\ue307");
				buffer.append(face.getRaceValue()).append(" race(����), ");
				buffer.append(face.getGenderValue()).append(", ");
				buffer.append(face.getAgeValue()).append(" years old.\n");
				buffer.append("Race Confidence:").append(df.format(face.getRaceConfidence())).append("%\n");
				buffer.append("Smiling Value:").append(df.format(face.getSmilingValue()));
//				if (face.getAgeValue() <= 15)
//					buffer.append("\ue307����������Ľ�㣬С�ƺ����ú���ˣ��\ue40d\n");
//				else if (face.getAgeValue() > 15 && face.getAgeValue() <= 22 && face.getGenderValue() == "Ů��") {
//					buffer.append("\ue307����������Ǻ������ŵĻ��٣������������԰�\ue40d\n").append(
//							"����������̴ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											90.0 + Math.random() * 10)
//									+ "���ƶȣ�̫�����˰ѣ�\n");
//				} else if (face.getAgeValue() > 15 && face.getAgeValue() <= 22
//						&& face.getGenderValue() == "����") {
//					buffer.append("\ue307����������Ǻ������ŵĻ��٣������������԰�\ue40d\n").append(
//							"�������������ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											90.0 + Math.random() * 10)
//									+ "���ƶȣ���ֱĤ�ݣ�\n");
//				} else if (face.getAgeValue() > 22 && face.getAgeValue() <= 28
//						&& face.getGenderValue() == "Ů��") {
//					buffer.append("\ue307�����������ഺ����ʱ���ഺ���Σ�������裬��������ϧ��").append(
//							"���Ů�����ϣ�ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											80.0 + Math.random() * 10)
//									+ "�����ˣ�\n");
//				} else if (face.getAgeValue() > 22 && face.getAgeValue() <= 28
//						&& face.getGenderValue() == "����") {
//					buffer.append("\ue307�����������ഺ����ʱ���ഺ���Σ�������裬��������ϧ��").append(
//							"�������л����ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											80.0 + Math.random() * 10)
//									+ "\n�����ƶȣ���������");
//				} else if (face.getGenderValue() == "����")
//					buffer.append("\ue307��������ѽ,����������Щ���ɣ������Ҳ��һ�ֳ����������\n").append(
//							"����������»��ﵽ��"
//									+ String.format("%.2f",
//											70.0 + Math.random() * 10)
//									+ "�����ƶȣ���������\n");
//				else {
//					buffer.append("\ue307��������ѽ,����������Ȼ�Ѳ������ᣬ��������ʻ�����Ȼɢ����\n").append(
//							"�͹����µ�����ﵽ��"
//									+ String.format("%.2f",
//											70.0 + Math.random() * 10)
//									+ "�����ƶȣ�������Ŷ��\n");
//				}

				buffer.append("\n***************************\n");
			}
		}
		// ��⵽2-10����
		else if (faceList.size() > 1 && faceList.size() <= 10) {
//			buffer.append("����⵽ ").append(faceList.size())
//					.append(" �ˣ����������Ĵ�������Ϊ��").append("\n");
			buffer.append("total of ").append(faceList.size())
			.append(" faces detected.\nAccording to the center of the face from left to right:").append("\n");
			for (Face face : faceList) {
				buffer.append("\ue307");
				buffer.append(face.getRaceValue()).append("race(����), ");
				buffer.append(face.getGenderValue()).append(", ");
				buffer.append(face.getAgeValue()).append(" years old.\n");
				buffer.append("Race Confidence:").append(df.format(face.getRaceConfidence())).append("%\n");
				buffer.append("Smiling Value:").append(df.format(face.getSmilingValue()));
//				if (face.getAgeValue() <= 15)
//					buffer.append("\ue307����������Ľ�㣬С�ƺ����ú���ˣ��\ue40d\n");
//				else if (face.getAgeValue() > 15 && face.getAgeValue() <= 22 && face.getGenderValue() == "Ů��") {
//					buffer.append("\ue307����������Ǻ������ŵĻ��٣������������԰�\ue40d\n").append(
//							"����������̴ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											90.0 + Math.random() * 10)
//									+ "���ƶȣ�̫�����˰ѣ�\n");
//				} else if (face.getAgeValue() > 15 && face.getAgeValue() <= 22
//						&& face.getGenderValue() == "����") {
//					buffer.append("\ue307����������Ǻ������ŵĻ��٣������������԰�\ue40d\n").append(
//							"�������������ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											90.0 + Math.random() * 10)
//									+ "���ƶȣ���ֱĤ�ݣ�\n");
//				} else if (face.getAgeValue() > 22 && face.getAgeValue() <= 28
//						&& face.getGenderValue() == "Ů��") {
//					buffer.append("\ue307�����������ഺ����ʱ���ഺ���Σ�������裬��������ϧ��").append(
//							"���Ů�����ϣ�ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											80.0 + Math.random() * 10)
//									+ "�����ˣ�\n");
//				} else if (face.getAgeValue() > 22 && face.getAgeValue() <= 28
//						&& face.getGenderValue() == "����") {
//					buffer.append("\ue307�����������ഺ����ʱ���ഺ���Σ�������裬��������ϧ��").append(
//							"�������л����ﵽ�˾��˵�"
//									+ String.format("%.2f",
//											80.0 + Math.random() * 10)
//									+ "\n�����ƶȣ���������");
//				} else if (face.getGenderValue() == "����")
//					buffer.append("\ue307��������ѽ,����������Щ���ɣ������Ҳ��һ�ֳ����������\n").append(
//							"����������»��ﵽ��"
//									+ String.format("%.2f",
//											70.0 + Math.random() * 10)
//									+ "�����ƶȣ���������\n");
//				else {
//					buffer.append("\ue307��������ѽ,����������Ȼ�Ѳ������ᣬ��������ʻ�����Ȼɢ����\n").append(
//							"�͹����µ�����ﵽ��"
//									+ String.format("%.2f",
//											70.0 + Math.random() * 10)
//									+ "�����ƶȣ�������Ŷ��\n");
//				}

				buffer.append("\n**************************\n");
			}
		}
		// ��⵽10��������
		else if (faceList.size() > 10) {
			buffer.append("����⵽ ").append(faceList.size()).append(" ������")
					.append("\n");
			// ͳ�Ƹ����֡��Ա������
			int asiaMale = 0;
			int asiaFemale = 0;
			int whiteMale = 0;
			int whiteFemale = 0;
			int blackMale = 0;
			int blackFemale = 0;
			for (Face face : faceList) {
				if ("��ɫ".equals(face.getRaceValue()))
					if ("����".equals(face.getGenderValue()))
						asiaMale++;
					else
						asiaFemale++;
				else if ("��ɫ".equals(face.getRaceValue()))
					if ("����".equals(face.getGenderValue()))
						whiteMale++;
					else
						whiteFemale++;
				else if ("��ɫ".equals(face.getRaceValue()))
					if ("����".equals(face.getGenderValue()))
						blackMale++;
					else
						blackFemale++;
			}
			if (0 != asiaMale || 0 != asiaFemale)
				buffer.append("��ɫ���֣�").append(asiaMale).append("��")
						.append(asiaFemale).append("Ů").append("\n");
			if (0 != whiteMale || 0 != whiteFemale)
				buffer.append("��ɫ���֣�").append(whiteMale).append("��")
						.append(whiteFemale).append("Ů").append("\n");
			if (0 != blackMale || 0 != blackFemale)
				buffer.append("��ɫ���֣�").append(blackMale).append("��")
						.append(blackFemale).append("Ů").append("\n");

		}

		// �Ƴ�ĩβ�ո�
		buffer = new StringBuffer(buffer.substring(0, buffer.lastIndexOf("\n")));
		return buffer.toString();
	}

	/**
	 * �ṩ���ⲿ���õ�������ⷽ��
	 * 
	 * @param picUrl
	 *            �����ͼƬ�ķ��ʵ�ַ
	 * @return String
	 */
	public static String detect(String picUrl) {
		// Ĭ�ϻظ���Ϣ
		String result = "�ҵ��㷨��û���{������δ֪��ͼƬŶ���ϴ��������������԰�\ue059";
		List<Face> faceList = faceDetect(picUrl);
		if (!faceList.isEmpty()) {
			result = makeMessage(faceList);
		}
		
		return result;
	
	}

	public static void main(String[] args) {
		String picUrl = "http://a4.att.hudong.com/32/13/300000895028127824138388216_950.jpg";
		System.out.println(detect(picUrl));
	}
}
