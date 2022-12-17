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
    comments = "Source: cart.proto")
public final class CartServiceGrpc {

  private CartServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CartService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.Cart,
      id.grocery.tunas.grpc.Response> METHOD_SAVE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.Cart, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CartService", "Save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Cart.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.CartAndUserId,
      id.grocery.tunas.grpc.Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.CartAndUserId, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CartService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.CartAndUserId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.CartUserId,
      id.grocery.tunas.grpc.MultipleCartResponse> METHOD_FIND_BY_USER_ID =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.CartUserId, id.grocery.tunas.grpc.MultipleCartResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CartService", "FindByUserId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.CartUserId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.MultipleCartResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CartServiceStub newStub(io.grpc.Channel channel) {
    return new CartServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CartServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CartServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CartServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CartServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CartServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void save(id.grocery.tunas.grpc.Cart request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.CartAndUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    /**
     */
    public void findByUserId(id.grocery.tunas.grpc.CartUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleCartResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_USER_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.Cart,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.CartAndUserId,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_DELETE)))
          .addMethod(
            METHOD_FIND_BY_USER_ID,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.CartUserId,
                id.grocery.tunas.grpc.MultipleCartResponse>(
                  this, METHODID_FIND_BY_USER_ID)))
          .build();
    }
  }

  /**
   */
  public static final class CartServiceStub extends io.grpc.stub.AbstractStub<CartServiceStub> {
    private CartServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CartServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CartServiceStub(channel, callOptions);
    }

    /**
     */
    public void save(id.grocery.tunas.grpc.Cart request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.CartAndUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByUserId(id.grocery.tunas.grpc.CartUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleCartResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CartServiceBlockingStub extends io.grpc.stub.AbstractStub<CartServiceBlockingStub> {
    private CartServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CartServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CartServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response save(id.grocery.tunas.grpc.Cart request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response delete(id.grocery.tunas.grpc.CartAndUserId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.MultipleCartResponse findByUserId(id.grocery.tunas.grpc.CartUserId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_USER_ID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CartServiceFutureStub extends io.grpc.stub.AbstractStub<CartServiceFutureStub> {
    private CartServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CartServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CartServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> save(
        id.grocery.tunas.grpc.Cart request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> delete(
        id.grocery.tunas.grpc.CartAndUserId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.MultipleCartResponse> findByUserId(
        id.grocery.tunas.grpc.CartUserId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE = 0;
  private static final int METHODID_DELETE = 1;
  private static final int METHODID_FIND_BY_USER_ID = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CartServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CartServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE:
          serviceImpl.save((id.grocery.tunas.grpc.Cart) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((id.grocery.tunas.grpc.CartAndUserId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        case METHODID_FIND_BY_USER_ID:
          serviceImpl.findByUserId((id.grocery.tunas.grpc.CartUserId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleCartResponse>) responseObserver);
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

  private static final class CartServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return id.grocery.tunas.grpc.CartOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CartServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CartServiceDescriptorSupplier())
              .addMethod(METHOD_SAVE)
              .addMethod(METHOD_DELETE)
              .addMethod(METHOD_FIND_BY_USER_ID)
              .build();
        }
      }
    }
    return result;
  }
}
