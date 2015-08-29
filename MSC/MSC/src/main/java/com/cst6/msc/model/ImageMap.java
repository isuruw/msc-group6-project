/**
 * 
 */
package com.cst6.msc.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="image_map")
public class ImageMap {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="table_name", nullable=false)
	private String tableName;
	
	@Column(name="table_field", nullable=false)
	private String tableField;
	
	@ManyToOne
	@JoinColumn(name="image_id", nullable=false)
	private Image image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableField() {
		return tableField;
	}

	public void setTableField(String tableField) {
		this.tableField = tableField;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("ImageMap[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("tableName=").append(getTableName()).append(",");
		newSB.append("tableField=").append(getTableField()).append(",");
		newSB.append("image=").append(getImage());
		newSB.append("]"); 
		
		return newSB.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if(obj==this)
			return true;
		
		if(obj instanceof ImageMap){
			ImageMap other = (ImageMap) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
