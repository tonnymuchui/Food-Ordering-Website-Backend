package org.foodOrdering.response;

import lombok.Data;
import org.foodOrdering.domain.USER_ROLE;

@Data
public class AuthResponse {

    private String message;
    private String jwt;
    private USER_ROLE role;

}
