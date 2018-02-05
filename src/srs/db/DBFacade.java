package srs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import srs.model.Student;
import srs.model.Car;
import srs.model.User;

public class DBFacade {
	
	private DBConnection dbConnection;
	
	public DBFacade() {
		this.dbConnection = DBConnection.getInstance();
	}
	
	public void registerNewStudent(Student student) {
		Connection conn = dbConnection.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into app.tbl_students (STUDENTNUMBER, FIRSTNAME) values (?, ?)");
			pstmt.setString(1, student.getStudentNumber());
			pstmt.setString(2, student.getFirstName());
			pstmt.executeUpdate();
		} catch(SQLException sqlEx) {
			printSQLException(sqlEx);
		} finally {
            // release resources
            try {
                if (pstmt != null) {
                	pstmt.close();
                	pstmt = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
	}	
	public void registerNewCar(Car car) {
		Connection conn = dbConnection.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into app.CAR (CARBRAND, VIN, TYPE, CATEGORY,RENTPRICE) values (?,?,?,?,?,?)");
			pstmt.setString(1, car.getBarnd());
			pstmt.setString(2, car.getVIN());
			pstmt.setString(3, car.getType());
			pstmt.setString(4, car.getCatagory());
			pstmt.setDouble(5, car.getPrice());
			pstmt.executeUpdate();
		} catch(SQLException sqlEx) {
			printSQLException(sqlEx);
		} finally {
            // release resources
            try {
                if (pstmt != null) {
                	pstmt.close();
                	pstmt = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
	}	
	public List<Student> getStudents() {
		Connection conn = dbConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT STUDENTID, STUDENTNUMBER, FIRSTNAME from app.tbl_STUDENTS order by studentid");
			
			while(rs.next()) {
				Student student = new Student();
				int studentId = rs.getInt("STUDENTID");
				String studentNumber = rs.getString("STUDENTNUMBER");
				String firstName = rs.getString("FIRSTNAME");
				student.setStudentId(studentId);
				student.setStudentNumber(studentNumber);
				student.setFirstName(firstName);
				students.add(student);
			}
			closeResultSet(rs);
		} catch(SQLException sqlEx) {
			printSQLException(sqlEx);
		} finally {
            // release resources
            try {
                if (stmt != null) {
                	stmt.close();
                	stmt = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
		return students;
	}	
	
	public List<User> getUsers() {
		Connection conn = dbConnection.getConnection();
		//PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<>();
		
		try {
			//pstmt = conn.prepareStatement("SELECT * from app.tbl_users");
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * from app.tbl_users");
			while(rs.next()) {
				User user = new User();
				int userId = rs.getInt("USEID");
				String username = rs.getString("USERNAME");
				user.setUserid(userId);
				user.setUsername(username);
				users.add(user);
			}
			closeResultSet(rs);
		} catch(SQLException sqlEx) {
			printSQLException(sqlEx);
		} finally {
            // release resources
            try {
                if (stmt != null) {
                	stmt.close();
                	stmt = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
		return users;
	}
	
	public void registerNewUser(User user) {
		Connection conn = dbConnection.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into app.tbl_users (USERNAME, PASSWORD) values (?, ?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
		} catch(SQLException sqlEx) {
			printSQLException(sqlEx);
		} finally {
            // release resources
            try {
                if (pstmt != null) {
                	pstmt.close();
                	pstmt = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
	}
	
    /**
     * Prints details of an SQLException chain to <code>System.err</code>.
     * Details included are SQL State, Error code, Exception message.
     *
     * @param e the SQLException from which to print details.
     */
    public static void printSQLException(SQLException e)
    {
        // Unwraps the entire exception chain to unveil the real cause of the
        // Exception.
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            // for stack traces, refer to derby.log or uncomment this:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    }	
    
    private void closeResultSet(ResultSet rs) {
        // ResultSet
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException sqle) {
            printSQLException(sqle);
        }
    }

}
