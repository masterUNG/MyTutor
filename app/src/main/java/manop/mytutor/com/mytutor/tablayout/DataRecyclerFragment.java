package manop.mytutor.com.mytutor.tablayout;

public class DataRecyclerFragment {

    private String coursename, teachername, detail;
    private int teacherphoto;


    public DataRecyclerFragment(String coursename, String teachername, String detail, int teacherphoto) {
        this.coursename = coursename;
        this.teachername = teachername;
        this.detail = detail;
        this.teacherphoto = teacherphoto;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTeacherphoto() {
        return teacherphoto;
    }

    public void setTeacherphoto(int teacherphoto) {
        this.teacherphoto = teacherphoto;
    }
}
