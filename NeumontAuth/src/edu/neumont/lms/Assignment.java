/**
 * Assignment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class Assignment  implements java.io.Serializable {
    private int id;

    private java.lang.String name;

    private java.lang.String description;

    private long timedue;

    private long timemodified;

    private java.lang.String assignmenttype;

    private boolean preventlate;

    private boolean resubmit;

    private boolean allownotes;

    private boolean enablesendmark;

    private int maxfiles;

    private long maxbytes;

    private int grade;

    private edu.neumont.lms.Submission[] submissions;

    public Assignment() {
    }

    public Assignment(
           int id,
           java.lang.String name,
           java.lang.String description,
           long timedue,
           long timemodified,
           java.lang.String assignmenttype,
           boolean preventlate,
           boolean resubmit,
           boolean allownotes,
           boolean enablesendmark,
           int maxfiles,
           long maxbytes,
           int grade,
           edu.neumont.lms.Submission[] submissions) {
           this.id = id;
           this.name = name;
           this.description = description;
           this.timedue = timedue;
           this.timemodified = timemodified;
           this.assignmenttype = assignmenttype;
           this.preventlate = preventlate;
           this.resubmit = resubmit;
           this.allownotes = allownotes;
           this.enablesendmark = enablesendmark;
           this.maxfiles = maxfiles;
           this.maxbytes = maxbytes;
           this.grade = grade;
           this.submissions = submissions;
    }


    /**
     * Gets the id value for this Assignment.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Assignment.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this Assignment.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Assignment.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the description value for this Assignment.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Assignment.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the timedue value for this Assignment.
     * 
     * @return timedue
     */
    public long getTimedue() {
        return timedue;
    }


    /**
     * Sets the timedue value for this Assignment.
     * 
     * @param timedue
     */
    public void setTimedue(long timedue) {
        this.timedue = timedue;
    }


    /**
     * Gets the timemodified value for this Assignment.
     * 
     * @return timemodified
     */
    public long getTimemodified() {
        return timemodified;
    }


    /**
     * Sets the timemodified value for this Assignment.
     * 
     * @param timemodified
     */
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }


    /**
     * Gets the assignmenttype value for this Assignment.
     * 
     * @return assignmenttype
     */
    public java.lang.String getAssignmenttype() {
        return assignmenttype;
    }


    /**
     * Sets the assignmenttype value for this Assignment.
     * 
     * @param assignmenttype
     */
    public void setAssignmenttype(java.lang.String assignmenttype) {
        this.assignmenttype = assignmenttype;
    }


    /**
     * Gets the preventlate value for this Assignment.
     * 
     * @return preventlate
     */
    public boolean isPreventlate() {
        return preventlate;
    }


    /**
     * Sets the preventlate value for this Assignment.
     * 
     * @param preventlate
     */
    public void setPreventlate(boolean preventlate) {
        this.preventlate = preventlate;
    }


    /**
     * Gets the resubmit value for this Assignment.
     * 
     * @return resubmit
     */
    public boolean isResubmit() {
        return resubmit;
    }


    /**
     * Sets the resubmit value for this Assignment.
     * 
     * @param resubmit
     */
    public void setResubmit(boolean resubmit) {
        this.resubmit = resubmit;
    }


    /**
     * Gets the allownotes value for this Assignment.
     * 
     * @return allownotes
     */
    public boolean isAllownotes() {
        return allownotes;
    }


    /**
     * Sets the allownotes value for this Assignment.
     * 
     * @param allownotes
     */
    public void setAllownotes(boolean allownotes) {
        this.allownotes = allownotes;
    }


    /**
     * Gets the enablesendmark value for this Assignment.
     * 
     * @return enablesendmark
     */
    public boolean isEnablesendmark() {
        return enablesendmark;
    }


    /**
     * Sets the enablesendmark value for this Assignment.
     * 
     * @param enablesendmark
     */
    public void setEnablesendmark(boolean enablesendmark) {
        this.enablesendmark = enablesendmark;
    }


    /**
     * Gets the maxfiles value for this Assignment.
     * 
     * @return maxfiles
     */
    public int getMaxfiles() {
        return maxfiles;
    }


    /**
     * Sets the maxfiles value for this Assignment.
     * 
     * @param maxfiles
     */
    public void setMaxfiles(int maxfiles) {
        this.maxfiles = maxfiles;
    }


    /**
     * Gets the maxbytes value for this Assignment.
     * 
     * @return maxbytes
     */
    public long getMaxbytes() {
        return maxbytes;
    }


    /**
     * Sets the maxbytes value for this Assignment.
     * 
     * @param maxbytes
     */
    public void setMaxbytes(long maxbytes) {
        this.maxbytes = maxbytes;
    }


    /**
     * Gets the grade value for this Assignment.
     * 
     * @return grade
     */
    public int getGrade() {
        return grade;
    }


    /**
     * Sets the grade value for this Assignment.
     * 
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }


    /**
     * Gets the submissions value for this Assignment.
     * 
     * @return submissions
     */
    public edu.neumont.lms.Submission[] getSubmissions() {
        return submissions;
    }


    /**
     * Sets the submissions value for this Assignment.
     * 
     * @param submissions
     */
    public void setSubmissions(edu.neumont.lms.Submission[] submissions) {
        this.submissions = submissions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Assignment)) return false;
        Assignment other = (Assignment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.timedue == other.getTimedue() &&
            this.timemodified == other.getTimemodified() &&
            ((this.assignmenttype==null && other.getAssignmenttype()==null) || 
             (this.assignmenttype!=null &&
              this.assignmenttype.equals(other.getAssignmenttype()))) &&
            this.preventlate == other.isPreventlate() &&
            this.resubmit == other.isResubmit() &&
            this.allownotes == other.isAllownotes() &&
            this.enablesendmark == other.isEnablesendmark() &&
            this.maxfiles == other.getMaxfiles() &&
            this.maxbytes == other.getMaxbytes() &&
            this.grade == other.getGrade() &&
            ((this.submissions==null && other.getSubmissions()==null) || 
             (this.submissions!=null &&
              java.util.Arrays.equals(this.submissions, other.getSubmissions())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += new Long(getTimedue()).hashCode();
        _hashCode += new Long(getTimemodified()).hashCode();
        if (getAssignmenttype() != null) {
            _hashCode += getAssignmenttype().hashCode();
        }
        _hashCode += (isPreventlate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isResubmit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAllownotes() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isEnablesendmark() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getMaxfiles();
        _hashCode += new Long(getMaxbytes()).hashCode();
        _hashCode += getGrade();
        if (getSubmissions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubmissions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubmissions(), i);
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
        new org.apache.axis.description.TypeDesc(Assignment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Assignment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
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
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timedue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timedue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timemodified");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timemodified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assignmenttype");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "assignmenttype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preventlate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "preventlate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resubmit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "resubmit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allownotes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "allownotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enablesendmark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "enablesendmark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxfiles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "maxfiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxbytes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "maxbytes"));
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
        elemField.setFieldName("submissions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "submissions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Submission"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://lms.neumont.edu", "item"));
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
