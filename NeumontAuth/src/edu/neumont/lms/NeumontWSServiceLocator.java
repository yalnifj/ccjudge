/**
 * NeumontWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.neumont.lms;

public class NeumontWSServiceLocator extends org.apache.axis.client.Service implements edu.neumont.lms.NeumontWSService {

    public NeumontWSServiceLocator() {
    }


    public NeumontWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NeumontWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NeumontWS
    private java.lang.String NeumontWS_address = "https://lms.neumont.edu/nuws/service.php";

    public java.lang.String getNeumontWSAddress() {
        return NeumontWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NeumontWSWSDDServiceName = "NeumontWS";

    public java.lang.String getNeumontWSWSDDServiceName() {
        return NeumontWSWSDDServiceName;
    }

    public void setNeumontWSWSDDServiceName(java.lang.String name) {
        NeumontWSWSDDServiceName = name;
    }

    public edu.neumont.lms.NeumontWS getNeumontWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NeumontWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNeumontWS(endpoint);
    }

    public edu.neumont.lms.NeumontWS getNeumontWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.neumont.lms.NeumontWSSoapBindingStub _stub = new edu.neumont.lms.NeumontWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getNeumontWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNeumontWSEndpointAddress(java.lang.String address) {
        NeumontWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.neumont.lms.NeumontWS.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.neumont.lms.NeumontWSSoapBindingStub _stub = new edu.neumont.lms.NeumontWSSoapBindingStub(new java.net.URL(NeumontWS_address), this);
                _stub.setPortName(getNeumontWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("NeumontWS".equals(inputPortName)) {
            return getNeumontWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://lms.neumont.edu", "NeumontWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://lms.neumont.edu", "NeumontWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NeumontWS".equals(portName)) {
            setNeumontWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
