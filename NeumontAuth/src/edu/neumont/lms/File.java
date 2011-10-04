/**
 * File.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class File  implements java.io.Serializable {
    private java.lang.String filename;

    private long modifiedtime;

    private long filesize;

    private boolean directory;

    public File() {
    }

    public File(
           java.lang.String filename,
           long modifiedtime,
           long filesize,
           boolean directory) {
           this.filename = filename;
           this.modifiedtime = modifiedtime;
           this.filesize = filesize;
           this.directory = directory;
    }


    /**
     * Gets the filename value for this File.
     * 
     * @return filename
     */
    public java.lang.String getFilename() {
        return filename;
    }


    /**
     * Sets the filename value for this File.
     * 
     * @param filename
     */
    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }


    /**
     * Gets the modifiedtime value for this File.
     * 
     * @return modifiedtime
     */
    public long getModifiedtime() {
        return modifiedtime;
    }


    /**
     * Sets the modifiedtime value for this File.
     * 
     * @param modifiedtime
     */
    public void setModifiedtime(long modifiedtime) {
        this.modifiedtime = modifiedtime;
    }


    /**
     * Gets the filesize value for this File.
     * 
     * @return filesize
     */
    public long getFilesize() {
        return filesize;
    }


    /**
     * Sets the filesize value for this File.
     * 
     * @param filesize
     */
    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }


    /**
     * Gets the directory value for this File.
     * 
     * @return directory
     */
    public boolean isDirectory() {
        return directory;
    }


    /**
     * Sets the directory value for this File.
     * 
     * @param directory
     */
    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof File)) return false;
        File other = (File) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filename==null && other.getFilename()==null) || 
             (this.filename!=null &&
              this.filename.equals(other.getFilename()))) &&
            this.modifiedtime == other.getModifiedtime() &&
            this.filesize == other.getFilesize() &&
            this.directory == other.isDirectory();
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
        if (getFilename() != null) {
            _hashCode += getFilename().hashCode();
        }
        _hashCode += new Long(getModifiedtime()).hashCode();
        _hashCode += new Long(getFilesize()).hashCode();
        _hashCode += (isDirectory() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(File.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://lms.neumont.edu", "File"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filename");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "filename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifiedtime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "modifiedtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filesize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "filesize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://lms.neumont.edu", "directory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
