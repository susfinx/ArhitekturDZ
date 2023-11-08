package DZ5;
public class ProjectFile {
    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public int getSetting1() {
        return this.setting1;
    }

    public String getSetting2() {
        return this.setting2;
    }

    public boolean getSetting3() {
        return this.setting3;
    }

    public String getFileName() {
        return this.fileName;
    }

    public ProjectFile(String fileName) {
        this.fileName = fileName;
        this.setting1 = 1;
        this.setting2 = "..";
        this.setting3 = false;
    }
}
