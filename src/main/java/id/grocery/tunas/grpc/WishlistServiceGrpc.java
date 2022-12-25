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
    comments = "Source: wishlist.proto")
public final class WishlistServiceGrpc {

  private WishlistServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.WishlistService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.Wishlist,
      id.grocery.tunas.grpc.Response> METHOD_SAVE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.Wishlist, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "Save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Wishlist.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.UserAndWishlistId,
      id.grocery.tunas.grpc.Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.UserAndWishlistId, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.UserAndWishlistId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.WishlistUserId,
      id.grocery.tunas.grpc.MultipleWishlistResponse> METHOD_FIND_BY_USER_ID =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.WishlistUserId, id.grocery.tunas.grpc.MultipleWishlistResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "FindByUserId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.WishlistUserId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.MultipleWishlistResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.UserAndProductId,
      id.grocery.tunas.grpc.WishlistResponse> METHOD_FIND_WISHLIST_BY_PRODUCT_ID =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.UserAndProductId, id.grocery.tunas.grpc.WishlistResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "FindWishlistByProductId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.UserAndProductId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.WishlistResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WishlistServiceStub newStub(io.grpc.Channel channel) {
    return new WishlistServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WishlistServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WishlistServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WishlistServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WishlistServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class WishlistServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void save(id.grocery.tunas.grpc.Wishlist request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.UserAndWishlistId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    /**
     */
    public void findByUserId(id.grocery.tunas.grpc.WishlistUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleWishlistResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_USER_ID, responseObserver);
    }

    /**
     */
    public void findWishlistByProductId(id.grocery.tunas.grpc.UserAndProductId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.WishlistResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_WISHLIST_BY_PRODUCT_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.Wishlist,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.UserAndWishlistId,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_DELETE)))
          .addMethod(
            METHOD_FIND_BY_USER_ID,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.WishlistUserId,
                id.grocery.tunas.grpc.MultipleWishlistResponse>(
                  this, METHODID_FIND_BY_USER_ID)))
          .addMethod(
            METHOD_FIND_WISHLIST_BY_PRODUCT_ID,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.UserAndProductId,
                id.grocery.tunas.grpc.WishlistResponse>(
                  this, METHODID_FIND_WISHLIST_BY_PRODUCT_ID)))
          .build();
    }
  }

  /**
   */
  public static final class WishlistServiceStub extends io.grpc.stub.AbstractStub<WishlistServiceStub> {
    private WishlistServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WishlistServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WishlistServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WishlistServiceStub(channel, callOptions);
    }

    /**
     */
    public void save(id.grocery.tunas.grpc.Wishlist request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.UserAndWishlistId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByUserId(id.grocery.tunas.grpc.WishlistUserId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleWishlistResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findWishlistByProductId(id.grocery.tunas.grpc.UserAndProductId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.WishlistResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_WISHLIST_BY_PRODUCT_ID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WishlistServiceBlockingStub extends io.grpc.stub.AbstractStub<WishlistServiceBlockingStub> {
    private WishlistServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WishlistServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WishlistServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WishlistServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response save(id.grocery.tunas.grpc.Wishlist request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response delete(id.grocery.tunas.grpc.UserAndWishlistId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.MultipleWishlistResponse findByUserId(id.grocery.tunas.grpc.WishlistUserId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_USER_ID, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.WishlistResponse findWishlistByProductId(id.grocery.tunas.grpc.UserAndProductId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_WISHLIST_BY_PRODUCT_ID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WishlistServiceFutureStub extends io.grpc.stub.AbstractStub<WishlistServiceFutureStub> {
    private WishlistServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WishlistServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WishlistServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WishlistServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> save(
        id.grocery.tunas.grpc.Wishlist request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> delete(
        id.grocery.tunas.grpc.UserAndWishlistId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.MultipleWishlistResponse> findByUserId(
        id.grocery.tunas.grpc.WishlistUserId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.WishlistResponse> findWishlistByProductId(
        id.grocery.tunas.grpc.UserAndProductId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_WISHLIST_BY_PRODUCT_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE = 0;
  private static final int METHODID_DELETE = 1;
  private static final int METHODID_FIND_BY_USER_ID = 2;
  private static final int METHODID_FIND_WISHLIST_BY_PRODUCT_ID = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WishlistServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WishlistServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE:
          serviceImpl.save((id.grocery.tunas.grpc.Wishlist) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((id.grocery.tunas.grpc.UserAndWishlistId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        case METHODID_FIND_BY_USER_ID:
          serviceImpl.findByUserId((id.grocery.tunas.grpc.WishlistUserId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleWishlistResponse>) responseObserver);
          break;
        case METHODID_FIND_WISHLIST_BY_PRODUCT_ID:
          serviceImpl.findWishlistByProductId((id.grocery.tunas.grpc.UserAndProductId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.WishlistResponse>) responseObserver);
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

  private static final class WishlistServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return id.grocery.tunas.grpc.WishlistOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WishlistServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WishlistServiceDescriptorSupplier())
              .addMethod(METHOD_SAVE)
              .addMethod(METHOD_DELETE)
              .addMethod(METHOD_FIND_BY_USER_ID)
              .addMethod(METHOD_FIND_WISHLIST_BY_PRODUCT_ID)
              .build();
        }
      }
    }
    return result;
  }
}
