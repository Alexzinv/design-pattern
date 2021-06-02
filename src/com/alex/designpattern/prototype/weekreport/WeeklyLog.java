package com.alex.designpattern.prototype.weekreport;

import java.io.*;

/**
 * @author Alex
 */
public class WeeklyLog implements Cloneable, Serializable{
	private Attachment attachment;
	private String name;
	private String date;
	private String content;

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "WeeklyLog{" +
				"attachment=" + attachment +
				", name='" + name + '\'' +
				", date='" + date + '\'' +
				", content='" + content + '\'' +
				'}';
	}

	@Override
	protected Object clone() {
		try {
			Object o = super.clone();
			return o;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 深拷贝 方式二：对象序列化实现  <推荐>
	 * @return 深拷贝对象
	 */
	public WeeklyLog deepClone(){
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			// 序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			// 把当前对象一对象流方式输出,实现serializable接口
			oos.writeObject(this);

			// 反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			WeeklyLog copyObj = (WeeklyLog) ois.readObject();
			return copyObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(null != ois){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != bis){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != oos){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != bos){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
