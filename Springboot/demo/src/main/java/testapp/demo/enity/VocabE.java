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
@Table(name = "vocabs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class VocabE implements Serializable {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long input_id;
  
  private String chinese;

  private String english;

}
