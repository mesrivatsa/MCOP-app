/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.doubango.tinyWRAP;

import java.nio.ByteBuffer;

public class RegistrationSession extends SipSession {
  private long swigCPtr;

  protected RegistrationSession(long cPtr, boolean cMemoryOwn) {
    super(tinyWRAPJNI.RegistrationSession_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RegistrationSession obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        tinyWRAPJNI.delete_RegistrationSession(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public boolean registerWithMcpttInfo(byte[] buffer) {
	ByteBuffer payload = ByteBuffer.allocateDirect(buffer.length);
    payload.put(buffer);
    return this.registerWithMcpttInfo(payload, payload.capacity());
  }

  public RegistrationSession(SipStack pStack) {
    this(tinyWRAPJNI.new_RegistrationSession(SipStack.getCPtr(pStack), pStack), true);
  }

  public boolean register_(ActionConfig config) {
    return tinyWRAPJNI.RegistrationSession_register___SWIG_0(swigCPtr, this, ActionConfig.getCPtr(config), config);
  }

  public boolean register_() {
    return tinyWRAPJNI.RegistrationSession_register___SWIG_1(swigCPtr, this);
  }

  public boolean registerWithMcpttInfo(java.nio.ByteBuffer payload, long len, ActionConfig config) {
    return tinyWRAPJNI.RegistrationSession_registerWithMcpttInfo__SWIG_0(swigCPtr, this, payload, len, ActionConfig.getCPtr(config), config);
  }

  public boolean registerWithMcpttInfo(java.nio.ByteBuffer payload, long len) {
    return tinyWRAPJNI.RegistrationSession_registerWithMcpttInfo__SWIG_1(swigCPtr, this, payload, len);
  }

  public boolean unRegister(ActionConfig config) {
    return tinyWRAPJNI.RegistrationSession_unRegister__SWIG_0(swigCPtr, this, ActionConfig.getCPtr(config), config);
  }

  public boolean unRegister() {
    return tinyWRAPJNI.RegistrationSession_unRegister__SWIG_1(swigCPtr, this);
  }

  public boolean accept(ActionConfig config) {
    return tinyWRAPJNI.RegistrationSession_accept__SWIG_0(swigCPtr, this, ActionConfig.getCPtr(config), config);
  }

  public boolean accept() {
    return tinyWRAPJNI.RegistrationSession_accept__SWIG_1(swigCPtr, this);
  }

  public boolean reject(ActionConfig config) {
    return tinyWRAPJNI.RegistrationSession_reject__SWIG_0(swigCPtr, this, ActionConfig.getCPtr(config), config);
  }

  public boolean reject() {
    return tinyWRAPJNI.RegistrationSession_reject__SWIG_1(swigCPtr, this);
  }

}
