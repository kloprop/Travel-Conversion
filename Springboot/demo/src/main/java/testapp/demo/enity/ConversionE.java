package testapp.demo.enity;

import java.io.Serializable;
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
@Table(name = "words")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ConversionE implements Serializable {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long input_id;
  
  private String conversation;

  private String translation;

  @ManyToOne  
  @JoinColumn(name ="type_id")
  private TypeE typeId;

}


