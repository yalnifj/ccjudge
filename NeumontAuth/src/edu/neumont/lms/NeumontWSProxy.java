package edu.neumont.lms;

public class NeumontWSProxy implements edu.neumont.lms.NeumontWS {
  private String _endpoint = null;
  private edu.neumont.lms.NeumontWS neumontWS = null;
  
  public NeumontWSProxy() {
    _initNeumontWSProxy();
  }
  
  public NeumontWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initNeumontWSProxy();
  }
  
  private void _initNeumontWSProxy() {
    try {
      neumontWS = (new edu.neumont.lms.NeumontWSServiceLocator()).getNeumontWS();
      if (neumontWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)neumontWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)neumontWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (neumontWS != null)
      ((javax.xml.rpc.Stub)neumontWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.neumont.lms.NeumontWS getNeumontWS() {
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS;
  }
  
  public edu.neumont.lms.User login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.login(username, password);
  }
  
  public boolean logout(java.lang.String sesskey) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.logout(sesskey);
  }
  
  public long ping(java.lang.String sesskey, long pingdelay) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.ping(sesskey, pingdelay);
  }
  
  public edu.neumont.lms.Course[] getMyCourses(java.lang.String sesskey) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getMyCourses(sesskey);
  }
  
  public edu.neumont.lms.Message[] getMessages(java.lang.String sesskey, long aftertime, long beforetime, boolean sent) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getMessages(sesskey, aftertime, beforetime, sent);
  }
  
  public edu.neumont.lms.Event[] getEvents(java.lang.String sesskey, long timemodified) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getEvents(sesskey, timemodified);
  }
  
  public edu.neumont.lms.Course[] getAssignments(java.lang.String sesskey, long timemodified) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getAssignments(sesskey, timemodified);
  }
  
  public int markMessage(java.lang.String sesskey, int messageid, boolean markread) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.markMessage(sesskey, messageid, markread);
  }
  
  public edu.neumont.lms.Message[] sendMessage(java.lang.String sesskey, int[] usersto, java.lang.String message) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.sendMessage(sesskey, usersto, message);
  }
  
  public edu.neumont.lms.User[] searchUsers(java.lang.String sesskey, java.lang.String query) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.searchUsers(sesskey, query);
  }
  
  public long deleteAssignmentFile(java.lang.String sesskey, int submission, java.lang.String filename) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.deleteAssignmentFile(sesskey, submission, filename);
  }
  
  public edu.neumont.lms.FileTransfer downloadAssignmentFile(java.lang.String sesskey, int submission, java.lang.String filename) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.downloadAssignmentFile(sesskey, submission, filename);
  }
  
  public edu.neumont.lms.Submission uploadAssignmentFile(java.lang.String sesskey, int assignment, edu.neumont.lms.FileTransfer file) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.uploadAssignmentFile(sesskey, assignment, file);
  }
  
  public edu.neumont.lms.Submission submitAssignment(java.lang.String sesskey, int assignment, java.lang.String text) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.submitAssignment(sesskey, assignment, text);
  }
  
  public long markSubmission(java.lang.String sesskey, int submission) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.markSubmission(sesskey, submission);
  }
  
  public edu.neumont.lms.Quiz[] getActiveQuizzes(java.lang.String sesskey, int[] courseIDs) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getActiveQuizzes(sesskey, courseIDs);
  }
  
  public edu.neumont.lms.Quiz getNextQuiz(java.lang.String sesskey, int[] courseIDs) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getNextQuiz(sesskey, courseIDs);
  }
  
  public edu.neumont.lms.Question[] getQuizQuestions(java.lang.String sesskey, int[] questionIds) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getQuizQuestions(sesskey, questionIds);
  }
  
  public edu.neumont.lms.AnswerResponse[] submitQuizAnswers(java.lang.String sesskey, int quizId, boolean finishattempt, edu.neumont.lms.Action[] actions) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.submitQuizAnswers(sesskey, quizId, finishattempt, actions);
  }
  
  public edu.neumont.lms.Group[] getCourseGroups(java.lang.String sesskey, int[] courseIDs, int userid) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getCourseGroups(sesskey, courseIDs, userid);
  }
  
  public edu.neumont.lms.User[] getUsersByUsername(java.lang.String sesskey, java.lang.String[] userNames) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getUsersByUsername(sesskey, userNames);
  }
  
  public edu.neumont.lms.File[] getCourseFiles(java.lang.String sesskey, int courseID, java.lang.String wdir) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getCourseFiles(sesskey, courseID, wdir);
  }
  
  public boolean deleteCourseFile(java.lang.String sesskey, int courseID, java.lang.String filepath) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.deleteCourseFile(sesskey, courseID, filepath);
  }
  
  public boolean renameCourseFile(java.lang.String sesskey, int courseID, java.lang.String filepath, java.lang.String newfilepath) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.renameCourseFile(sesskey, courseID, filepath, newfilepath);
  }
  
  public boolean makeCourseDirectory(java.lang.String sesskey, int courseID, java.lang.String newdirpath) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.makeCourseDirectory(sesskey, courseID, newdirpath);
  }
  
  public edu.neumont.lms.User[] getUsersByID(java.lang.String sesskey, int[] userIds) throws java.rmi.RemoteException{
    if (neumontWS == null)
      _initNeumontWSProxy();
    return neumontWS.getUsersByID(sesskey, userIds);
  }
  
  
}