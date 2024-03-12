package harshkumar.fakestoresstproject.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cart {
    private Long id;
    private String userId;
    private String date;
    private String[]  products;
}
