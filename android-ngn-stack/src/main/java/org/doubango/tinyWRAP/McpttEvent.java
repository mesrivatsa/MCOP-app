/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.doubango.tinyWRAP;

public class McpttEvent {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected McpttEvent(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(McpttEvent obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        tinyWRAPJNI.delete_McpttEvent(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public tmcptt_event_type_t getType() {
    return tmcptt_event_type_t.swigToEnum(tinyWRAPJNI.McpttEvent_getType(swigCPtr, this));
  }

  public CallSession getSipSession() {
    long cPtr = tinyWRAPJNI.McpttEvent_getSipSession(swigCPtr, this);
    return (cPtr == 0) ? null : new CallSession(cPtr, false);
  }

  public McpttMessage getMessage() {
    long cPtr = tinyWRAPJNI.McpttEvent_getMessage(swigCPtr, this);
    return (cPtr == 0) ? null : new McpttMessage(cPtr, false);
  }

}