package manop.mytutor.com.mytutor.tablayout;

public class Data_RecentFragment {

    private String coursename, teachername, chapter;
    private int VDOphoto;

    public Data_RecentFragment(String coursename, String teachername, String chapter, int VDOphoto) {
        this.coursename = coursename;
        this.teachername = teachername;
        this.chapter = chapter;
        this.VDOphoto = VDOphoto;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getVDOphoto() {
        return VDOphoto;
    }

    public void setVDOphoto(int VDOphoto) {
        this.VDOphoto = VDOphoto;
    }
}




