package chengfeng.learn.admindemo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Enumerated(EnumType.STRING)
	private RoleType type;
	
	private String descrption;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleType getType() {
		return type;
	}

	public void setType(RoleType type) {
		this.type = type;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	
}
