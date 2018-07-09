package com.crud.tasks.test;

public class LiczbyPierwsze {

    private boolean czyLiczbaPierwsza(int liczba) {

        for(int i = 2; liczba > i; i++){
            if(liczba % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LiczbyPierwsze liczbyPierwsze = new LiczbyPierwsze();

        System.out.println(liczbyPierwsze.czyLiczbaPierwsza(345321));
    }
}
