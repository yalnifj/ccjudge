/**
 * Action.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class Action  implements java.io.Serializable {
    private int questionId;

    private int event;

    private java.lang.String[] responses;

    public Action() {
    }

    public Action(
           int questionId,
           int event,
           java.lang.String[] responses) {
           this.questionId = questionId;
           this.event = event;
           this.responses = responses;
    }


    /**
     * Gets the questionId value for this Action.
     * 
     * @return questionId
     */
    public int getQuestionId() {
        return questionId;
    }


    /**
     * Sets the questionId value for this Action.
     * 
     * @param questionId
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }


    /**
     * Gets the event value for this Action.
     * 
     * @return event
     */
    public int getEvent() {
        return event;
    }


    /**
     * Sets the event value for this Action.
     * 
     * @param event
     */
    public void setEvent(int event) {
        this.event = event;
    }


    /**
     * Gets the responses value for this Action.
     * 
     * @return responses
     */
    public java.lang.String[] getResponses() {
        return responses;
    }


    /**
     * Sets the responses value for this Action.
     * 
     * @param responses
     */
    public void setResponses(java.lang.String[] responses) {
        this.responses = responses;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Action)) return false;
        Action other = (Action) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.questionId == other.getQuestionId() &&
            this.event == other.getEvent() &&
            ((this.responses==null && other.getResponses()==null) || 
             (this.responses!=null &&
              java.util.Arrays.equals(this.responses, other.getResponses())));
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
        _hashCode += getQuestionId();
        _hashCode += getEvent();
        if (getResponses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResponses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResponses(), i);
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
        new org.apache.axis.description.TypeDesc(Action.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Action"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("questionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "questionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("event");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "event"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "responses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://lms.neumont.edu", "response"));
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
