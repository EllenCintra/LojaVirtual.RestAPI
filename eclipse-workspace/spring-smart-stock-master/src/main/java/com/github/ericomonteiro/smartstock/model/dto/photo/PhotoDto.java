package com.github.ericomonteiro.smartstock.model.dto.photo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhotoDto {
    private String id;
    private Boolean main;
    private String fileType;
    private byte[] data;

    public String getFileName() {
        return this.id + "." + this.fileType;
    }
}
