/**
 * Message.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class Message  implements java.io.Serializable {
    private int id;

    private java.lang.String message;

    private long timecreated;

    private boolean unread;

    private edu.neumont.lms.Contact contactFrom;

    private edu.neumont.lms.Contact contactTo;

    public Message() {
    }

    public Message(
           int id,
           java.lang.String message,
           long timecreated,
           boolean unread,
           edu.neumont.lms.Contact contactFrom,
           edu.neumont.lms.Contact contactTo) {
           this.id = id;
           this.message = message;
           this.timecreated = timecreated;
           this.unread = unread;
           this.contactFrom = contactFrom;
           this.contactTo = contactTo;
    }


    /**
     * Gets the id value for this Message.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Message.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the message value for this Message.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this Message.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the timecreated value for this Message.
     * 
     * @return timecreated
     */
    public long getTimecreated() {
        return timecreated;
    }


    /**
     * Sets the timecreated value for this Message.
     * 
     * @param timecreated
     */
    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }


    /**
     * Gets the unread value for this Message.
     * 
     * @return unread
     */
    public boolean isUnread() {
        return unread;
    }


    /**
     * Sets the unread value for this Message.
     * 
     * @param unread
     */
    public void setUnread(boolean unread) {
        this.unread = unread;
    }


    /**
     * Gets the contactFrom value for this Message.
     * 
     * @return contactFrom
     */
    public edu.neumont.lms.Contact getContactFrom() {
        return contactFrom;
    }


    /**
     * Sets the contactFrom value for this Message.
     * 
     * @param contactFrom
     */
    public void setContactFrom(edu.neumont.lms.Contact contactFrom) {
        this.contactFrom = contactFrom;
    }


    /**
     * Gets the contactTo value for this Message.
     * 
     * @return contactTo
     */
    public edu.neumont.lms.Contact getContactTo() {
        return contactTo;
    }


    /**
     * Sets the contactTo value for this Message.
     * 
     * @param contactTo
     */
    public void setContactTo(edu.neumont.lms.Contact contactTo) {
        this.contactTo = contactTo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Message)) return false;
        Message other = (Message) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            this.timecreated == other.getTimecreated() &&
            this.unread == other.isUnread() &&
            ((this.contactFrom==null && other.getContactFrom()==null) || 
             (this.contactFrom!=null &&
              this.contactFrom.equals(other.getContactFrom()))) &&
            ((this.contactTo==null && other.getContactTo()==null) || 
             (this.contactTo!=null &&
              this.contactTo.equals(other.getContactTo())));
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
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        _hashCode += new Long(getTimecreated()).hashCode();
        _hashCode += (isUnread() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getContactFrom() != null) {
            _hashCode += getContactFrom().hashCode();
        }
        if (getContactTo() != null) {
            _hashCode += getContactTo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Message.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timecreated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "timecreated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unread");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "unread"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "contactFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Contact"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "contactTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Contact"));
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
