// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transaction.proto

package id.grocery.tunas.grpc;

public interface TransactionResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.TransactionResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string status = 1;</code>
   */
  java.lang.String getStatus();
  /**
   * <code>string status = 1;</code>
   */
  com.google.protobuf.ByteString
      getStatusBytes();

  /**
   * <code>string message = 2;</code>
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.proto.Transaction data = 3;</code>
   */
  boolean hasData();
  /**
   * <code>.proto.Transaction data = 3;</code>
   */
  id.grocery.tunas.grpc.Transaction getData();
  /**
   * <code>.proto.Transaction data = 3;</code>
   */
  id.grocery.tunas.grpc.TransactionOrBuilder getDataOrBuilder();
}
