package com.example.apporder.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String message;
    private boolean status;
    private Object object;

    public Response(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
