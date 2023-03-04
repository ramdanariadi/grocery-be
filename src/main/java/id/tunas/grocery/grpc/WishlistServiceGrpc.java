package id.tunas.grocery.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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
  public static final io.grpc.MethodDescriptor<Wishlist,
          Response> METHOD_SAVE =
      io.grpc.MethodDescriptor.<Wishlist, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "Save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Wishlist.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserAndProductId,
          Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<UserAndProductId, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserAndProductId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<WishlistUserId,
          MultipleWishlistResponse> METHOD_FIND_BY_USER_ID =
      io.grpc.MethodDescriptor.<WishlistUserId, MultipleWishlistResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "FindByUserId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              WishlistUserId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MultipleWishlistResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<UserAndProductId,
          WishlistResponse> METHOD_FIND_WISHLIST_BY_PRODUCT_ID =
      io.grpc.MethodDescriptor.<UserAndProductId, WishlistResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.WishlistService", "FindWishlistByProductId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              UserAndProductId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              WishlistResponse.getDefaultInstance()))
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
    public void save(Wishlist request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void delete(UserAndProductId request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    /**
     */
    public void findByUserId(WishlistUserId request,
                             io.grpc.stub.StreamObserver<MultipleWishlistResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_USER_ID, responseObserver);
    }

    /**
     */
    public void findWishlistByProductId(UserAndProductId request,
                                        io.grpc.stub.StreamObserver<WishlistResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_WISHLIST_BY_PRODUCT_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                      Wishlist,
                      Response>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                      UserAndProductId,
                      Response>(
                  this, METHODID_DELETE)))
          .addMethod(
            METHOD_FIND_BY_USER_ID,
            asyncUnaryCall(
              new MethodHandlers<
                      WishlistUserId,
                      MultipleWishlistResponse>(
                  this, METHODID_FIND_BY_USER_ID)))
          .addMethod(
            METHOD_FIND_WISHLIST_BY_PRODUCT_ID,
            asyncUnaryCall(
              new MethodHandlers<
                      UserAndProductId,
                      WishlistResponse>(
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
    public void save(Wishlist request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(UserAndProductId request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByUserId(WishlistUserId request,
                             io.grpc.stub.StreamObserver<MultipleWishlistResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findWishlistByProductId(UserAndProductId request,
                                        io.grpc.stub.StreamObserver<WishlistResponse> responseObserver) {
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
    public Response save(Wishlist request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public Response delete(UserAndProductId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }

    /**
     */
    public MultipleWishlistResponse findByUserId(WishlistUserId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_USER_ID, getCallOptions(), request);
    }

    /**
     */
    public WishlistResponse findWishlistByProductId(UserAndProductId request) {
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
    public com.google.common.util.concurrent.ListenableFuture<Response> save(
        Wishlist request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> delete(
        UserAndProductId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MultipleWishlistResponse> findByUserId(
        WishlistUserId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_USER_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<WishlistResponse> findWishlistByProductId(
        UserAndProductId request) {
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
          serviceImpl.save((Wishlist) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((UserAndProductId) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_FIND_BY_USER_ID:
          serviceImpl.findByUserId((WishlistUserId) request,
              (io.grpc.stub.StreamObserver<MultipleWishlistResponse>) responseObserver);
          break;
        case METHODID_FIND_WISHLIST_BY_PRODUCT_ID:
          serviceImpl.findWishlistByProductId((UserAndProductId) request,
              (io.grpc.stub.StreamObserver<WishlistResponse>) responseObserver);
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
      return WishlistOuterClass.getDescriptor();
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
