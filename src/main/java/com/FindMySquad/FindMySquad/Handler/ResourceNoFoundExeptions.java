package com.FindMySquad.FindMySquad.Handler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNoFoundExeptions extends RuntimeException {

    public ResourceNoFoundExeptions(String msg) {
        super(msg);
    }


}
