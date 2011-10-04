/**
 * NeumontWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public interface NeumontWS extends java.rmi.Remote {
    public edu.neumont.lms.User login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public boolean logout(java.lang.String sesskey) throws java.rmi.RemoteException;
    public long ping(java.lang.String sesskey, long pingdelay) throws java.rmi.RemoteException;
    public edu.neumont.lms.Course[] getMyCourses(java.lang.String sesskey) throws java.rmi.RemoteException;
    public edu.neumont.lms.Message[] getMessages(java.lang.String sesskey, long aftertime, long beforetime, boolean sent) throws java.rmi.RemoteException;
    public edu.neumont.lms.Event[] getEvents(java.lang.String sesskey, long timemodified) throws java.rmi.RemoteException;
    public edu.neumont.lms.Course[] getAssignments(java.lang.String sesskey, long timemodified) throws java.rmi.RemoteException;
    public int markMessage(java.lang.String sesskey, int messageid, boolean markread) throws java.rmi.RemoteException;
    public edu.neumont.lms.Message[] sendMessage(java.lang.String sesskey, int[] usersto, java.lang.String message) throws java.rmi.RemoteException;
    public edu.neumont.lms.User[] searchUsers(java.lang.String sesskey, java.lang.String query) throws java.rmi.RemoteException;
    public long deleteAssignmentFile(java.lang.String sesskey, int submission, java.lang.String filename) throws java.rmi.RemoteException;
    public edu.neumont.lms.FileTransfer downloadAssignmentFile(java.lang.String sesskey, int submission, java.lang.String filename) throws java.rmi.RemoteException;
    public edu.neumont.lms.Submission uploadAssignmentFile(java.lang.String sesskey, int assignment, edu.neumont.lms.FileTransfer file) throws java.rmi.RemoteException;
    public edu.neumont.lms.Submission submitAssignment(java.lang.String sesskey, int assignment, java.lang.String text) throws java.rmi.RemoteException;
    public long markSubmission(java.lang.String sesskey, int submission) throws java.rmi.RemoteException;
    public edu.neumont.lms.Quiz[] getActiveQuizzes(java.lang.String sesskey, int[] courseIDs) throws java.rmi.RemoteException;
    public edu.neumont.lms.Quiz getNextQuiz(java.lang.String sesskey, int[] courseIDs) throws java.rmi.RemoteException;
    public edu.neumont.lms.Question[] getQuizQuestions(java.lang.String sesskey, int[] questionIds) throws java.rmi.RemoteException;
    public edu.neumont.lms.AnswerResponse[] submitQuizAnswers(java.lang.String sesskey, int quizId, boolean finishattempt, edu.neumont.lms.Action[] actions) throws java.rmi.RemoteException;
    public edu.neumont.lms.Group[] getCourseGroups(java.lang.String sesskey, int[] courseIDs, int userid) throws java.rmi.RemoteException;
    public edu.neumont.lms.User[] getUsersByUsername(java.lang.String sesskey, java.lang.String[] userNames) throws java.rmi.RemoteException;
    public edu.neumont.lms.File[] getCourseFiles(java.lang.String sesskey, int courseID, java.lang.String wdir) throws java.rmi.RemoteException;
    public boolean deleteCourseFile(java.lang.String sesskey, int courseID, java.lang.String filepath) throws java.rmi.RemoteException;
    public boolean renameCourseFile(java.lang.String sesskey, int courseID, java.lang.String filepath, java.lang.String newfilepath) throws java.rmi.RemoteException;
    public boolean makeCourseDirectory(java.lang.String sesskey, int courseID, java.lang.String newdirpath) throws java.rmi.RemoteException;
    public edu.neumont.lms.User[] getUsersByID(java.lang.String sesskey, int[] userIds) throws java.rmi.RemoteException;
}
