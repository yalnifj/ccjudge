/**
 * QuestionOptions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class QuestionOptions  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.Integer question;

    private java.lang.Integer layout;

    private java.lang.Integer single;

    private java.lang.Integer shuffleanswers;

    private edu.neumont.lms.Answer[] answers;

    public QuestionOptions() {
    }

    public QuestionOptions(
           java.lang.Integer id,
           java.lang.Integer question,
           java.lang.Integer layout,
           java.lang.Integer single,
           java.lang.Integer shuffleanswers,
           edu.neumont.lms.Answer[] answers) {
           this.id = id;
           this.question = question;
           this.layout = layout;
           this.single = single;
           this.shuffleanswers = shuffleanswers;
           this.answers = answers;
    }


    /**
     * Gets the id value for this QuestionOptions.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this QuestionOptions.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the question value for this QuestionOptions.
     * 
     * @return question
     */
    public java.lang.Integer getQuestion() {
        return question;
    }


    /**
     * Sets the question value for this QuestionOptions.
     * 
     * @param question
     */
    public void setQuestion(java.lang.Integer question) {
        this.question = question;
    }


    /**
     * Gets the layout value for this QuestionOptions.
     * 
     * @return layout
     */
    public java.lang.Integer getLayout() {
        return layout;
    }


    /**
     * Sets the layout value for this QuestionOptions.
     * 
     * @param layout
     */
    public void setLayout(java.lang.Integer layout) {
        this.layout = layout;
    }


    /**
     * Gets the single value for this QuestionOptions.
     * 
     * @return single
     */
    public java.lang.Integer getSingle() {
        return single;
    }


    /**
     * Sets the single value for this QuestionOptions.
     * 
     * @param single
     */
    public void setSingle(java.lang.Integer single) {
        this.single = single;
    }


    /**
     * Gets the shuffleanswers value for this QuestionOptions.
     * 
     * @return shuffleanswers
     */
    public java.lang.Integer getShuffleanswers() {
        return shuffleanswers;
    }


    /**
     * Sets the shuffleanswers value for this QuestionOptions.
     * 
     * @param shuffleanswers
     */
    public void setShuffleanswers(java.lang.Integer shuffleanswers) {
        this.shuffleanswers = shuffleanswers;
    }


    /**
     * Gets the answers value for this QuestionOptions.
     * 
     * @return answers
     */
    public edu.neumont.lms.Answer[] getAnswers() {
        return answers;
    }


    /**
     * Sets the answers value for this QuestionOptions.
     * 
     * @param answers
     */
    public void setAnswers(edu.neumont.lms.Answer[] answers) {
        this.answers = answers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QuestionOptions)) return false;
        QuestionOptions other = (QuestionOptions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.question==null && other.getQuestion()==null) || 
             (this.question!=null &&
              this.question.equals(other.getQuestion()))) &&
            ((this.layout==null && other.getLayout()==null) || 
             (this.layout!=null &&
              this.layout.equals(other.getLayout()))) &&
            ((this.single==null && other.getSingle()==null) || 
             (this.single!=null &&
              this.single.equals(other.getSingle()))) &&
            ((this.shuffleanswers==null && other.getShuffleanswers()==null) || 
             (this.shuffleanswers!=null &&
              this.shuffleanswers.equals(other.getShuffleanswers()))) &&
            ((this.answers==null && other.getAnswers()==null) || 
             (this.answers!=null &&
              java.util.Arrays.equals(this.answers, other.getAnswers())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getQuestion() != null) {
            _hashCode += getQuestion().hashCode();
        }
        if (getLayout() != null) {
            _hashCode += getLayout().hashCode();
        }
        if (getSingle() != null) {
            _hashCode += getSingle().hashCode();
        }
        if (getShuffleanswers() != null) {
            _hashCode += getShuffleanswers().hashCode();
        }
        if (getAnswers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnswers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnswers(), i);
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
        new org.apache.axis.description.TypeDesc(QuestionOptions.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "QuestionOptions"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("question");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "question"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("layout");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "layout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("single");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "single"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shuffleanswers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "shuffleanswers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("answers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "answers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Answer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://lms.neumont.edu", "answer"));
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
