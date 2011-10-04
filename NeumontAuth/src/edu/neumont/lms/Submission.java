/**
 * Submission.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class Submission  implements java.io.Serializable {
    private int id;

    private long timemodified;

    private java.lang.String notes;

    private java.lang.String markedstatus;

    private java.lang.Integer grade;

    private edu.neumont.lms.Contact grader;

    private java.lang.String submissioncomment;

    private java.lang.Long timemarked;

    private edu.neumont.lms.Contact submitter;

    private edu.neumont.lms.File[] files;

    public Submission() {
    }

    public Submission(
           int id,
           long timemodified,
           java.lang.String notes,
           java.lang.String markedstatus,
           java.lang.Integer grade,
           edu.neumont.lms.Contact grader,
           java.lang.String submissioncomment,
           java.lang.Long timemarked,
           edu.neumont.lms.Contact submitter,
           edu.neumont.lms.File[] files) {
           this.id = id;
           this.timemodified = timemodified;
           this.notes = notes;
           this.markedstatus = markedstatus;
           this.grade = grade;
           this.grader = grader;
           this.submissioncomment = submissioncomment;
           this.timemarked = timemarked;
           this.submitter = submitter;
           this.files = files;
    }


    /**
     * Gets the id value for this Submission.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Submission.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the timemodified value for this Submission.
     * 
     * @return timemodified
     */
    public long getTimemodified() {
        return timemodified;
    }


    /**
     * Sets the timemodified value for this Submission.
     * 
     * @param timemodified
     */
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }


    /**
     * Gets the notes value for this Submission.
     * 
     * @return notes
     */
    public java.lang.String getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this Submission.
     * 
     * @param notes
     */
    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }


    /**
     * Gets the markedstatus value for this Submission.
     * 
     * @return markedstatus
     */
    public java.lang.String getMarkedstatus() {
        return markedstatus;
    }


    /**
     * Sets the markedstatus value for this Submission.
     * 
     * @param markedstatus
     */
    public void setMarkedstatus(java.lang.String markedstatus) {
        this.markedstatus = markedstatus;
    }


    /**
     * Gets the grade value for this Submission.
     * 
     * @return grade
     */
    public java.lang.Integer getGrade() {
        return grade;
    }


    /**
     * Sets the grade value for this Submission.
     * 
     * @param grade
     */
    public void setGrade(java.lang.Integer grade) {
        this.grade = grade;
    }


    /**
     * Gets the grader value for this Submission.
     * 
     * @return grader
     */
    public edu.neumont.lms.Contact getGrader() {
        return grader;
    }


    /**
     * Sets the grader value for this Submission.
     * 
     * @param grader
     */
    public void setGrader(edu.neumont.lms.Contact grader) {
        this.grader = grader;
    }


    /**
     * Gets the submissioncomment value for this Submission.
     * 
     * @return submissioncomment
     */
    public java.lang.String getSubmissioncomment() {
        return submissioncomment;
    }


    /**
     * Sets the submissioncomment value for this Submission.
     * 
     * @param submissioncomment
     */
    public void setSubmissioncomment(java.lang.String submissioncomment) {
        this.submissioncomment = submissioncomment;
    }


    /**
     * Gets the timemarked value for this Submission.
     * 
     * @return timemarked
     */
    public java.lang.Long getTimemarked() {
        return timemarked;
    }


    /**
     * Sets the timemarked value for this Submission.
     * 
     * @param timemarked
     */
    public void setTimemarked(java.lang.Long timemarked) {
        this.timemarked = timemarked;
    }


    /**
     * Gets the submitter value for this Submission.
     * 
     * @return submitter
     */
    public edu.neumont.lms.Contact getSubmitter() {
        return submitter;
    }


    /**
     * Sets the submitter value for this Submission.
     * 
     * @param submitter
     */
    public void setSubmitter(edu.neumont.lms.Contact submitter) {
        this.submitter = submitter;
    }


    /**
     * Gets the files value for this Submission.
     * 
     * @return files
     */
    public edu.neumont.lms.File[] getFiles() {
        return files;
    }


    /**
     * Sets the files value for this Submission.
     * 
     * @param files
     */
    public void setFiles(edu.neumont.lms.File[] files) {
        this.files = files;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Submission)) return false;
        Submission other = (Submission) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            this.timemodified == other.getTimemodified() &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            ((this.markedstatus==null && other.getMarkedstatus()==null) || 
             (this.markedstatus!=null &&
              this.markedstatus.equals(other.getMarkedstatus()))) &&
            ((this.grade==null && other.getGrade()==null) || 
             (this.grade!=null &&
              this.grade.equals(other.getGrade()))) &&
            ((this.grader==null && other.getGrader()==null) || 
             (this.grader!=null &&
              this.grader.equals(other.getGrader()))) &&
            ((this.submissioncomment==null && other.getSubmissioncomment()==null) || 
             (this.submissioncomment!=null &&
              this.submissioncomment.equals(other.getSubmissioncomment()))) &&
            ((this.timemarked==null && other.getTimemarked()==null) || 
             (this.timemarked!=null &&
              this.timemarked.equals(other.getTimemarked()))) &&
            ((this.submitter==null && other.getSubmitter()==null) || 
             (this.submitter!=null &&
              this.submitter.equals(other.getSubmitter()))) &&
            ((this.files==null && other.getFiles()==null) || 
             (this.files!=null &&
              java.util.Arrays.equals(this.files, other.getFiles())));
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
        _hashCode += new Long(getTimemodified()).hashCode();
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        if (getMarkedstatus() != null) {
            _hashCode += getMarkedstatus().hashCode();
        }
        if (getGrade() != null) {
            _hashCode += getGrade().hashCode();
        }
        if (getGrader() != null) {
            _hashCode += getGrader().hashCode();
        }
        if (getSubmissioncomment() != null) {
            _hashCode += getSubmissioncomment().hashCode();
        }
        if (getTimemarked() != null) {
            _hashCode += getTimemarked().hashCode();
        }
        if (getSubmitter() != null) {
            _hashCode += getSubmitter().hashCode();
        }
        if (getFiles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFiles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFiles(), i);
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
        new org.apache.axis.description.TypeDesc(Submission.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Submission"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timemodified");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timemodified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("markedstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "markedstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "grade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grader");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "grader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Contact"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("submissioncomment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "submissioncomment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timemarked");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timemarked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("submitter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "submitter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Contact"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("files");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "files"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "File"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://lms.neumont.edu", "file"));
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
