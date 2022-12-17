package id.grocery.tunas.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: transaction.proto")
public final class TransactionServiceGrpc {

  private TransactionServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.TransactionService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.TransactionId,
      id.grocery.tunas.grpc.TransactionResponse> METHOD_FIND_BY_TRANSACTION_ID =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.TransactionId, id.grocery.tunas.grpc.TransactionResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.TransactionService", "FindByTransactionId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.TransactionId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.TransactionResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.TransactionUserId,
      id.grocery.tunas.grpc.MultipleTransactionResponse> METHOD_FIND_BY_USER_ID =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.TransactionUserId, id.grocery.tunas.grpc.MultipleTransactionResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.TransactionService", "FindByUserId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.TransactionUserId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.MultipleTransactionResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.TransactionBody,
      id.grocery.tunas.grpc.Response> METHOD_SAVE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.TransactionBody, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.TransactionService", "Save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.TransactionBody.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.TransactionId,
      id.grocery.tunas.grpc.Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.TransactionId, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.TransactionService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.TransactionId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransactionServiceStub newStub(io.grpc.Channel channel) {
    return new TransactionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransactionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransactionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransactionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransactionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TransactionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findByTransactionId(id.grocery.tunas.grpc.TransactionId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.TransactionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_TRANSACTION_ID, responseObserver);
    }

    /**
     */
    public void findByUserId(id.grocery.tunas.grpc.TransactionUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleTransactionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_USER_ID, responseObserver);
    }

    /**
     */
    public void save(id.grocery.tunas.grpc.TransactionBody request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.TransactionId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_FIND_BY_TRANSACTION_ID,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.TransactionId,
                id.grocery.tunas.grpc.TransactionResponse>(
                  this, METHODID_FIND_BY_TRANSACTION_ID)))
          .addMethod(
            METHOD_FIND_BY_USER_ID,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.TransactionUserId,
                id.grocery.tunas.grpc.MultipleTransactionResponse>(
                  this, METHODID_FIND_BY_USER_ID)))
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.TransactionBody,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.TransactionId,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class TransactionServiceStub extends io.grpc.stub.AbstractStub<TransactionServiceStub> {
    private TransactionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceStub(channel, callOptions);
    }

    /**
     */
    public void findByTransactionId(id.grocery.tunas.grpc.TransactionId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.TransactionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_TRANSACTION_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByUserId(id.grocery.tunas.grpc.TransactionUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleTransactionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(id.grocery.tunas.grpc.TransactionBody request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.TransactionId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransactionServiceBlockingStub extends io.grpc.stub.AbstractStub<TransactionServiceBlockingStub> {
    private TransactionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public id.grocery.tunas.grpc.TransactionResponse findByTransactionId(id.grocery.tunas.grpc.TransactionId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_TRANSACTION_ID, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.MultipleTransactionResponse findByUserId(id.grocery.tunas.grpc.TransactionUserId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_USER_ID, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response save(id.grocery.tunas.grpc.TransactionBody request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response delete(id.grocery.tunas.grpc.TransactionId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransactionServiceFutureStub extends io.grpc.stub.AbstractStub<TransactionServiceFutureStub> {
    private TransactionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransactionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransactionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.TransactionResponse> findByTransactionId(
        id.grocery.tunas.grpc.TransactionId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_TRANSACTION_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.MultipleTransactionResponse> findByUserId(
        id.grocery.tunas.grpc.TransactionUserId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> save(
        id.grocery.tunas.grpc.TransactionBody request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> delete(
        id.grocery.tunas.grpc.TransactionId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_BY_TRANSACTION_ID = 0;
  private static final int METHODID_FIND_BY_USER_ID = 1;
  private static final int METHODID_SAVE = 2;
  private static final int METHODID_DELETE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransactionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransactionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_BY_TRANSACTION_ID:
          serviceImpl.findByTransactionId((id.grocery.tunas.grpc.TransactionId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.TransactionResponse>) responseObserver);
          break;
        case METHODID_FIND_BY_USER_ID:
          serviceImpl.findByUserId((id.grocery.tunas.grpc.TransactionUserId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleTransactionResponse>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((id.grocery.tunas.grpc.TransactionBody) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((id.grocery.tunas.grpc.TransactionId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class TransactionServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return id.grocery.tunas.grpc.TransactionOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TransactionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransactionServiceDescriptorSupplier())
              .addMethod(METHOD_FIND_BY_TRANSACTION_ID)
              .addMethod(METHOD_FIND_BY_USER_ID)
              .addMethod(METHOD_SAVE)
              .addMethod(METHOD_DELETE)
              .build();
        }
      }
    }
    return result;
  }
}
