package enums;

public enum Archivos {
    IMAGENES(new String[]{"jpg", "png", "gif"},"Visor de Fotos de Windows"),
    DOCUMENTOS(new String[]{"pdf", "doc", "txt"},"Adobe Acrobat Reader"),
    AUDIO(new String[]{"mp3", "wav"},"Windows Media Player"),
    VIDEO(new String[]{"mp4", "avi"},"VLC Media Player");

    private final String[] extension;
    private final String programa;

    Archivos(String[] extensionP, String programaP){
        this.extension = extensionP;
        this.programa = programaP;
    }
    public String[] getExtension(){
        return extension;
    }
    public String getPrograma(){
        return programa;
    }

    public static Archivos getPorExtension(String ext) {
        for (Archivos tipo : Archivos.values()) {
            for (String e : tipo.getExtension()) {
                if (e.equalsIgnoreCase(ext)) {
                    return tipo;
                }
            }
        }
        return null;
    }
}

