/**
 * Quiz.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class Quiz  implements java.io.Serializable {
    private int id;

    private int course;

    private java.lang.String name;

    private java.lang.String intro;

    private long timeopen;

    private long timeclose;

    private long timelimit;

    private int grade;

    private int attempts;

    private int previousAttempts;

    private boolean shufflequestions;

    private boolean shuffleanswers;

    private int[] questionIds;

    public Quiz() {
    }

    public Quiz(
           int id,
           int course,
           java.lang.String name,
           java.lang.String intro,
           long timeopen,
           long timeclose,
           long timelimit,
           int grade,
           int attempts,
           int previousAttempts,
           boolean shufflequestions,
           boolean shuffleanswers,
           int[] questionIds) {
           this.id = id;
           this.course = course;
           this.name = name;
           this.intro = intro;
           this.timeopen = timeopen;
           this.timeclose = timeclose;
           this.timelimit = timelimit;
           this.grade = grade;
           this.attempts = attempts;
           this.previousAttempts = previousAttempts;
           this.shufflequestions = shufflequestions;
           this.shuffleanswers = shuffleanswers;
           this.questionIds = questionIds;
    }


    /**
     * Gets the id value for this Quiz.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Quiz.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the course value for this Quiz.
     * 
     * @return course
     */
    public int getCourse() {
        return course;
    }


    /**
     * Sets the course value for this Quiz.
     * 
     * @param course
     */
    public void setCourse(int course) {
        this.course = course;
    }


    /**
     * Gets the name value for this Quiz.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Quiz.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the intro value for this Quiz.
     * 
     * @return intro
     */
    public java.lang.String getIntro() {
        return intro;
    }


    /**
     * Sets the intro value for this Quiz.
     * 
     * @param intro
     */
    public void setIntro(java.lang.String intro) {
        this.intro = intro;
    }


    /**
     * Gets the timeopen value for this Quiz.
     * 
     * @return timeopen
     */
    public long getTimeopen() {
        return timeopen;
    }


    /**
     * Sets the timeopen value for this Quiz.
     * 
     * @param timeopen
     */
    public void setTimeopen(long timeopen) {
        this.timeopen = timeopen;
    }


    /**
     * Gets the timeclose value for this Quiz.
     * 
     * @return timeclose
     */
    public long getTimeclose() {
        return timeclose;
    }


    /**
     * Sets the timeclose value for this Quiz.
     * 
     * @param timeclose
     */
    public void setTimeclose(long timeclose) {
        this.timeclose = timeclose;
    }


    /**
     * Gets the timelimit value for this Quiz.
     * 
     * @return timelimit
     */
    public long getTimelimit() {
        return timelimit;
    }


    /**
     * Sets the timelimit value for this Quiz.
     * 
     * @param timelimit
     */
    public void setTimelimit(long timelimit) {
        this.timelimit = timelimit;
    }


    /**
     * Gets the grade value for this Quiz.
     * 
     * @return grade
     */
    public int getGrade() {
        return grade;
    }


    /**
     * Sets the grade value for this Quiz.
     * 
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }


    /**
     * Gets the attempts value for this Quiz.
     * 
     * @return attempts
     */
    public int getAttempts() {
        return attempts;
    }


    /**
     * Sets the attempts value for this Quiz.
     * 
     * @param attempts
     */
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }


    /**
     * Gets the previousAttempts value for this Quiz.
     * 
     * @return previousAttempts
     */
    public int getPreviousAttempts() {
        return previousAttempts;
    }


    /**
     * Sets the previousAttempts value for this Quiz.
     * 
     * @param previousAttempts
     */
    public void setPreviousAttempts(int previousAttempts) {
        this.previousAttempts = previousAttempts;
    }


    /**
     * Gets the shufflequestions value for this Quiz.
     * 
     * @return shufflequestions
     */
    public boolean isShufflequestions() {
        return shufflequestions;
    }


    /**
     * Sets the shufflequestions value for this Quiz.
     * 
     * @param shufflequestions
     */
    public void setShufflequestions(boolean shufflequestions) {
        this.shufflequestions = shufflequestions;
    }


    /**
     * Gets the shuffleanswers value for this Quiz.
     * 
     * @return shuffleanswers
     */
    public boolean isShuffleanswers() {
        return shuffleanswers;
    }


    /**
     * Sets the shuffleanswers value for this Quiz.
     * 
     * @param shuffleanswers
     */
    public void setShuffleanswers(boolean shuffleanswers) {
        this.shuffleanswers = shuffleanswers;
    }


    /**
     * Gets the questionIds value for this Quiz.
     * 
     * @return questionIds
     */
    public int[] getQuestionIds() {
        return questionIds;
    }


    /**
     * Sets the questionIds value for this Quiz.
     * 
     * @param questionIds
     */
    public void setQuestionIds(int[] questionIds) {
        this.questionIds = questionIds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Quiz)) return false;
        Quiz other = (Quiz) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            this.course == other.getCourse() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.intro==null && other.getIntro()==null) || 
             (this.intro!=null &&
              this.intro.equals(other.getIntro()))) &&
            this.timeopen == other.getTimeopen() &&
            this.timeclose == other.getTimeclose() &&
            this.timelimit == other.getTimelimit() &&
            this.grade == other.getGrade() &&
            this.attempts == other.getAttempts() &&
            this.previousAttempts == other.getPreviousAttempts() &&
            this.shufflequestions == other.isShufflequestions() &&
            this.shuffleanswers == other.isShuffleanswers() &&
            ((this.questionIds==null && other.getQuestionIds()==null) || 
             (this.questionIds!=null &&
              java.util.Arrays.equals(this.questionIds, other.getQuestionIds())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getId();
        _hashCode += getCourse();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getIntro() != null) {
            _hashCode += getIntro().hashCode();
        }
        _hashCode += new Long(getTimeopen()).hashCode();
        _hashCode += new Long(getTimeclose()).hashCode();
        _hashCode += new Long(getTimelimit()).hashCode();
        _hashCode += getGrade();
        _hashCode += getAttempts();
        _hashCode += getPreviousAttempts();
        _hashCode += (isShufflequestions() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShuffleanswers() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getQuestionIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQuestionIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQuestionIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Quiz.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Quiz"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("course");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "course"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "intro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeopen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timeopen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeclose");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timeclose"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timelimit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timelimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "grade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attempts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "attempts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previousAttempts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "previousAttempts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shufflequestions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "shufflequestions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shuffleanswers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "shuffleanswers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("questionIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "questionIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
