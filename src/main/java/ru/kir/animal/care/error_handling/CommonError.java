package ru.kir.animal.care.error_handling;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class CommonError {
    private int status;
    private List<String> messages;
    private Date timestamp;

    public CommonError(int status, String ... messages) {
        this.status = status;
        this.messages = new ArrayList<>(Arrays.asList(messages));
        this.timestamp = new Date();
    }

    public CommonError(int status, List<String> messages) {
        this.status = status;
        this.messages = new ArrayList<>(messages);
        this.timestamp = new Date();
    }

}