/**
 * Question.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class Question  implements java.io.Serializable {
    private int id;

    private int category;

    private int parent;

    private java.lang.String name;

    private java.lang.String questiontext;

    private java.lang.String generalfeedback;

    private int defaultgrade;

    private float penalty;

    private java.lang.String qtype;

    private int length;

    private boolean hidden;

    private edu.neumont.lms.QuestionOptions options;

    public Question() {
    }

    public Question(
           int id,
           int category,
           int parent,
           java.lang.String name,
           java.lang.String questiontext,
           java.lang.String generalfeedback,
           int defaultgrade,
           float penalty,
           java.lang.String qtype,
           int length,
           boolean hidden,
           edu.neumont.lms.QuestionOptions options) {
           this.id = id;
           this.category = category;
           this.parent = parent;
           this.name = name;
           this.questiontext = questiontext;
           this.generalfeedback = generalfeedback;
           this.defaultgrade = defaultgrade;
           this.penalty = penalty;
           this.qtype = qtype;
           this.length = length;
           this.hidden = hidden;
           this.options = options;
    }


    /**
     * Gets the id value for this Question.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Question.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the category value for this Question.
     * 
     * @return category
     */
    public int getCategory() {
        return category;
    }


    /**
     * Sets the category value for this Question.
     * 
     * @param category
     */
    public void setCategory(int category) {
        this.category = category;
    }


    /**
     * Gets the parent value for this Question.
     * 
     * @return parent
     */
    public int getParent() {
        return parent;
    }


    /**
     * Sets the parent value for this Question.
     * 
     * @param parent
     */
    public void setParent(int parent) {
        this.parent = parent;
    }


    /**
     * Gets the name value for this Question.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Question.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the questiontext value for this Question.
     * 
     * @return questiontext
     */
    public java.lang.String getQuestiontext() {
        return questiontext;
    }


    /**
     * Sets the questiontext value for this Question.
     * 
     * @param questiontext
     */
    public void setQuestiontext(java.lang.String questiontext) {
        this.questiontext = questiontext;
    }


    /**
     * Gets the generalfeedback value for this Question.
     * 
     * @return generalfeedback
     */
    public java.lang.String getGeneralfeedback() {
        return generalfeedback;
    }


    /**
     * Sets the generalfeedback value for this Question.
     * 
     * @param generalfeedback
     */
    public void setGeneralfeedback(java.lang.String generalfeedback) {
        this.generalfeedback = generalfeedback;
    }


    /**
     * Gets the defaultgrade value for this Question.
     * 
     * @return defaultgrade
     */
    public int getDefaultgrade() {
        return defaultgrade;
    }


    /**
     * Sets the defaultgrade value for this Question.
     * 
     * @param defaultgrade
     */
    public void setDefaultgrade(int defaultgrade) {
        this.defaultgrade = defaultgrade;
    }


    /**
     * Gets the penalty value for this Question.
     * 
     * @return penalty
     */
    public float getPenalty() {
        return penalty;
    }


    /**
     * Sets the penalty value for this Question.
     * 
     * @param penalty
     */
    public void setPenalty(float penalty) {
        this.penalty = penalty;
    }


    /**
     * Gets the qtype value for this Question.
     * 
     * @return qtype
     */
    public java.lang.String getQtype() {
        return qtype;
    }


    /**
     * Sets the qtype value for this Question.
     * 
     * @param qtype
     */
    public void setQtype(java.lang.String qtype) {
        this.qtype = qtype;
    }


    /**
     * Gets the length value for this Question.
     * 
     * @return length
     */
    public int getLength() {
        return length;
    }


    /**
     * Sets the length value for this Question.
     * 
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }


    /**
     * Gets the hidden value for this Question.
     * 
     * @return hidden
     */
    public boolean isHidden() {
        return hidden;
    }


    /**
     * Sets the hidden value for this Question.
     * 
     * @param hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }


    /**
     * Gets the options value for this Question.
     * 
     * @return options
     */
    public edu.neumont.lms.QuestionOptions getOptions() {
        return options;
    }


    /**
     * Sets the options value for this Question.
     * 
     * @param options
     */
    public void setOptions(edu.neumont.lms.QuestionOptions options) {
        this.options = options;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Question)) return false;
        Question other = (Question) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            this.category == other.getCategory() &&
            this.parent == other.getParent() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.questiontext==null && other.getQuestiontext()==null) || 
             (this.questiontext!=null &&
              this.questiontext.equals(other.getQuestiontext()))) &&
            ((this.generalfeedback==null && other.getGeneralfeedback()==null) || 
             (this.generalfeedback!=null &&
              this.generalfeedback.equals(other.getGeneralfeedback()))) &&
            this.defaultgrade == other.getDefaultgrade() &&
            this.penalty == other.getPenalty() &&
            ((this.qtype==null && other.getQtype()==null) || 
             (this.qtype!=null &&
              this.qtype.equals(other.getQtype()))) &&
            this.length == other.getLength() &&
            this.hidden == other.isHidden() &&
            ((this.options==null && other.getOptions()==null) || 
             (this.options!=null &&
              this.options.equals(other.getOptions())));
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
        _hashCode += getCategory();
        _hashCode += getParent();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getQuestiontext() != null) {
            _hashCode += getQuestiontext().hashCode();
        }
        if (getGeneralfeedback() != null) {
            _hashCode += getGeneralfeedback().hashCode();
        }
        _hashCode += getDefaultgrade();
        _hashCode += new Float(getPenalty()).hashCode();
        if (getQtype() != null) {
            _hashCode += getQtype().hashCode();
        }
        _hashCode += getLength();
        _hashCode += (isHidden() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getOptions() != null) {
            _hashCode += getOptions().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Question.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "Question"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "parent"));
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
        elemField.setFieldName("questiontext");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "questiontext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generalfeedback");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "generalfeedback"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultgrade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "defaultgrade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("penalty");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "penalty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtype");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "qtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hidden");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "hidden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "QuestionOptions"));
        elemField.setMinOccurs(0);
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
