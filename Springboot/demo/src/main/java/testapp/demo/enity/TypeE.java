package testapp.demo.enity;

import java.io.Serializable;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TypeE implements Serializable {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;


  @Column(name = "Type")
  private String type;

}


