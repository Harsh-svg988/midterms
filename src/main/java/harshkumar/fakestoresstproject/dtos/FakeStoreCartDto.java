package harshkumar.fakestoresstproject.dtos;

import harshkumar.fakestoresstproject.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreCartDto {
    private Long id;
    private String userId;
    private String date;
    private String[] product;
}
