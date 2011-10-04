/**
 * Course.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class Course  implements java.io.Serializable {
    private int id;

    private edu.neumont.lms.Assignment[] assignments;

    private java.lang.String fullname;

    private java.lang.String shortname;

    private java.lang.String summary;

    public Course() {
    }

    public Course(
           int id,
           edu.neumont.lms.Assignment[] assignments,
           java.lang.String fullname,
           java.lang.String shortname,
           java.lang.String summary) {
           this.id = id;
           this.assignments = assignments;
           this.fullname = fullname;
           this.shortname = shortname;
           this.summary = summary;
    }


    /**
     * Gets the id value for this Course.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Course.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the assignments value for this Course.
     * 
     * @return assignments
     */
    public edu.neumont.lms.Assignment[] getAssignments() {
        return assignments;
    }


    /**
     * Sets the assignments value for this Course.
     * 
     * @param assignments
     */
    public void setAssignments(edu.neumont.lms.Assignment[] assignments) {
        this.assignments = assignments;
    }


    /**
     * Gets the fullname value for this Course.
     * 
     * @return fullname
     */
    public java.lang.String getFullname() {
        return fullname;
    }


    /**
     * Sets the fullname value for this Course.
     * 
     * @param fullname
     */
    public void setFullname(java.lang.String fullname) {
        this.fullname = fullname;
    }


    /**
     * Gets the shortname value for this Course.
     * 
     * @return shortname
     */
    public java.lang.String getShortname() {
        return shortname;
    }


    /**
     * Sets the shortname value for this Course.
     * 
     * @param shortname
     */
    public void setShortname(java.lang.String shortname) {
        this.shortname = shortname;
    }


    /**
     * Gets the summary value for this Course.
     * 
     * @return summary
     */
    public java.lang.String getSummary() {
        return summary;
    }


    /**
     * Sets the summary value for this Course.
     * 
     * @param summary
     */
    public void setSummary(java.lang.String summary) {
        this.summary = summary;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.assignments==null && other.getAssignments()==null) || 
             (this.assignments!=null &&
              java.util.Arrays.equals(this.assignments, other.getAssignments()))) &&
            ((this.fullname==null && other.getFullname()==null) || 
             (this.fullname!=null &&
              this.fullname.equals(other.getFullname()))) &&
            ((this.shortname==null && other.getShortname()==null) || 
             (this.shortname!=null &&
              this.shortname.equals(other.getShortname()))) &&
            ((this.summary==null && other.getSummary()==null) || 
             (this.summary!=null &&
              this.summary.equals(other.getSummary())));
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
        if (getAssignments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAssignments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAssignments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFullname() != null) {
            _hashCode += getFullname().hashCode();
        }
        if (getShortname() != null) {
            _hashCode += getShortname().hashCode();
        }
        if (getSummary() != null) {
            _hashCode += getSummary().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Course.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Course"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assignments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "assignments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Assignment"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://lms.neumont.edu", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "fullname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "shortname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "summary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
