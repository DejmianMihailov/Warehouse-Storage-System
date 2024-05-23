package org.warehouse.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class UserResponse {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
}
