/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.doubango.tinyWRAP;

public class PublicationAuthenticationEvent extends SipEvent {
  private long swigCPtr;

  protected PublicationAuthenticationEvent(long cPtr, boolean cMemoryOwn) {
    super(tinyWRAPJNI.PublicationAuthenticationEvent_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PublicationAuthenticationEvent obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        tinyWRAPJNI.delete_PublicationAuthenticationEvent(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public tsip_publish_event_type_t getType() {
    return tsip_publish_event_type_t.swigToEnum(tinyWRAPJNI.PublicationAuthenticationEvent_getType(swigCPtr, this));
  }

  public PublicationAuthenticationSession getSession() {
    long cPtr = tinyWRAPJNI.PublicationAuthenticationEvent_getSession(swigCPtr, this);
    return (cPtr == 0) ? null : new PublicationAuthenticationSession(cPtr, false);
  }

  public PublicationAuthenticationSession takeSessionOwnership() {
    long cPtr = tinyWRAPJNI.PublicationAuthenticationEvent_takeSessionOwnership(swigCPtr, this);
    return (cPtr == 0) ? null : new PublicationAuthenticationSession(cPtr, true);
  }

}
