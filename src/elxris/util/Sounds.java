package elxris.util;

public enum Sounds {
    LOOP("/res/Loop.wav"),
    FALLO("/res/Fallo.wav"),
    ACERTA("/res/Acertado.wav");
    private final String fileName;
    Sounds(String fileName){
        this.fileName = fileName;
    }
    public String fileName(){
        return fileName;
    }
}
