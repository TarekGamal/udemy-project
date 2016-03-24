package udemy.model;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/udemy";
    private static final String USER_NAME = "udemyUser";
    private static final String PASSWORD = "123";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Failed to connect todatabase");
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static User loginUser(String inputUserName, String inputPassword) {
        String query = "select * from users where user_name = ? and password = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, inputUserName);
            preparedStatement.setString(2, inputPassword);

            User user = null;
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                long id = result.getLong("id");
                String userName = result.getString("user_name");
                String password = result.getString("password");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int gender = result.getInt("gender");
                int type = result.getInt("type");

                user = new User(id, userName, password, firstName, lastName, gender, type);
            }

            return user;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean addUser(String userName, String password, String firstName, String lastName,
            int gender, int type) {
        boolean successFlag = false;
        String query = "insert into users(user_name, password, first_name, last_name, gender, type)"
                + "values(?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setInt(5, gender);
            preparedStatement.setInt(6, type);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                successFlag = false;
            } else {
                successFlag = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return successFlag;

    }

    public static long getUserId(String userName) {
        long id = -1;
        String query = "select id from users where user_name = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, userName);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                id = result.getLong("id");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

     public static long getUserCourseId(long userId, long courseId) {
        long id = -1;
        String query = "select id from users_courses where user_id = ? and course_id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, courseId);
            
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                id = result.getLong("id");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return id;
    }
    public static ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<Course>();

        String query = "select id, name, instructor_id from courses";
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Course course = new Course(result.getLong("id"), result.getString("name"),
                        result.getLong("instructor_id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return courses;
    }
    public static ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();

        String query = "select id, name from categories";
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Category category = new Category(result.getLong("id"), result.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return categories;
    }

    public static boolean addCourse(String courseName, long categoryId, long instructorId) {
        boolean successFlag = false;
        String query = "insert into courses(name, category_id, instructor_id)"
                + "values(?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, courseName);
            preparedStatement.setLong(2, categoryId);
            preparedStatement.setLong(3, instructorId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                successFlag = false;
            } else {
                successFlag = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return successFlag;
    }

    public static long getCourseId(String courseName, long categoryId) {
        long id = -1;
        String query = "select id from courses where name = ? and category_id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, courseName);
            preparedStatement.setLong(2, categoryId);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                id = result.getLong("id");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    public static boolean enrollNewCourse(long userId, long courseId) {
         boolean successFlag = false;
        String query = "insert into users_courses(user_id, course_id)"
                + "values(?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, courseId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                successFlag = false;
            } else {
                successFlag = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return successFlag;
    }

    public static ArrayList<Course> getEnrolledCoursesByUserId(Long userId) {
        ArrayList<Course> courses = new ArrayList<Course>();
        String query = "select c.id, c.name, c.instructor_id, u.user_name\n" +
                        "FROM users_courses uc, courses c, users u\n" +
                        "where uc.user_id = ?\n" +
                        "and uc.course_id = c.id\n" +
                        "and c.instructor_id = u.id";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setLong(1, userId);
            
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                //public Course(long id, String name, long instructorId, String instructorName
                Course course = new Course(result.getLong("id"), result.getString("name"),
                        result.getLong("instructor_id"), result.getString("user_name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return courses;
    }

}
