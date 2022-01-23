package com.example.myapplication;

import java.io.Serializable;

public class PerfilMascotasDto implements Serializable {

    public PerfilMascotasDto(int petImgPerfil, String petName){
        this.petImgPerfil=petImgPerfil;
      // this.boneImg=boneImg;
        this.petName=petName;

    }
    private   int petImgPerfil;

    private String petName;

    public int getPetImgPerfil() {
        return petImgPerfil;
    }

    public void setPetImgPerfil(int petImgPerfil) {
        this.petImgPerfil = petImgPerfil;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
