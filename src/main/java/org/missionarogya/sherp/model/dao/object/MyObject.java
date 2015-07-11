package org.missionarogya.sherp.model.dao.object;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 


@Entity
@Table(name="sherpdemo")
public class MyObject {
  @Id
  @Column(name = "sherpdemo_id", nullable = false)
  private int id;
  @Column(name = "sherpdemo_string", nullable = false)
  private String name;
  
  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
     this.name = name;
  }
    
  
}
