package design.builder3;

public class Course {

    private String courseName;
    private String courseVideo;
    private String coursePpt;
    private String courseBook;

    public Course(CourseBuilder builder) {
        this.courseName = builder.courseName;
        this.courseVideo = builder.courseVideo;
        this.coursePpt = builder.coursePpt;
        this.courseBook = builder.courseBook;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                ", coursePpt='" + coursePpt + '\'' +
                ", courseBook='" + courseBook + '\'' +
                '}';
    }

    public static class CourseBuilder{
        private String courseName;
        private String courseVideo;
        private String coursePpt;
        private String courseBook;

        public CourseBuilder buildCourseName(String courseName){
            System.out.println(courseName);
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder buildCourseVideo(String courseVideo){
            System.out.println(courseVideo);
            this.courseVideo = courseVideo;
            return this;
        }

        public CourseBuilder buildCoursePpt(String coursePptPpt){
            System.out.println(coursePptPpt);
            this.coursePpt = coursePptPpt;
            return this;
        }

        public CourseBuilder buildCourseBook(String courseBook){
            System.out.println(courseBook);
            this.courseBook = courseBook;
            return this;
        }

        public Course build(){
            return new Course(this);
        }

    }
}
