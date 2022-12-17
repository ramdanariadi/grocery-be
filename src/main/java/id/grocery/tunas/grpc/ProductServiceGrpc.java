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
    comments = "Source: product.proto")
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ProductService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.ProductId,
      id.grocery.tunas.grpc.ProductResponse> METHOD_FIND_BY_ID =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.ProductId, id.grocery.tunas.grpc.ProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.ProductId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.ProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.ProductEmpty,
      id.grocery.tunas.grpc.MultipleProductResponse> METHOD_FIND_ALL =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.ProductEmpty, id.grocery.tunas.grpc.MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.ProductEmpty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.CategoryId,
      id.grocery.tunas.grpc.MultipleProductResponse> METHOD_FIND_PRODUCTS_BY_CATEGORY =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.CategoryId, id.grocery.tunas.grpc.MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindProductsByCategory"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.CategoryId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.ProductEmpty,
      id.grocery.tunas.grpc.MultipleProductResponse> METHOD_FIND_RECOMMENDED_PRODUCT =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.ProductEmpty, id.grocery.tunas.grpc.MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindRecommendedProduct"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.ProductEmpty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.ProductEmpty,
      id.grocery.tunas.grpc.MultipleProductResponse> METHOD_FIND_TOP_PRODUCTS =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.ProductEmpty, id.grocery.tunas.grpc.MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindTopProducts"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.ProductEmpty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.Product,
      id.grocery.tunas.grpc.Response> METHOD_SAVE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.Product, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "Save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Product.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.Product,
      id.grocery.tunas.grpc.Response> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.Product, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "Update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Product.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<id.grocery.tunas.grpc.ProductId,
      id.grocery.tunas.grpc.Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<id.grocery.tunas.grpc.ProductId, id.grocery.tunas.grpc.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.ProductId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              id.grocery.tunas.grpc.Response.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    return new ProductServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProductServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProductServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProductServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findById(id.grocery.tunas.grpc.ProductId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.ProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_ID, responseObserver);
    }

    /**
     */
    public void findAll(id.grocery.tunas.grpc.ProductEmpty request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_ALL, responseObserver);
    }

    /**
     */
    public void findProductsByCategory(id.grocery.tunas.grpc.CategoryId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_PRODUCTS_BY_CATEGORY, responseObserver);
    }

    /**
     */
    public void findRecommendedProduct(id.grocery.tunas.grpc.ProductEmpty request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_RECOMMENDED_PRODUCT, responseObserver);
    }

    /**
     */
    public void findTopProducts(id.grocery.tunas.grpc.ProductEmpty request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_TOP_PRODUCTS, responseObserver);
    }

    /**
     */
    public void save(id.grocery.tunas.grpc.Product request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void update(id.grocery.tunas.grpc.Product request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.ProductId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_FIND_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.ProductId,
                id.grocery.tunas.grpc.ProductResponse>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            METHOD_FIND_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.ProductEmpty,
                id.grocery.tunas.grpc.MultipleProductResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            METHOD_FIND_PRODUCTS_BY_CATEGORY,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.CategoryId,
                id.grocery.tunas.grpc.MultipleProductResponse>(
                  this, METHODID_FIND_PRODUCTS_BY_CATEGORY)))
          .addMethod(
            METHOD_FIND_RECOMMENDED_PRODUCT,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.ProductEmpty,
                id.grocery.tunas.grpc.MultipleProductResponse>(
                  this, METHODID_FIND_RECOMMENDED_PRODUCT)))
          .addMethod(
            METHOD_FIND_TOP_PRODUCTS,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.ProductEmpty,
                id.grocery.tunas.grpc.MultipleProductResponse>(
                  this, METHODID_FIND_TOP_PRODUCTS)))
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.Product,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.Product,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_UPDATE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                id.grocery.tunas.grpc.ProductId,
                id.grocery.tunas.grpc.Response>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class ProductServiceStub extends io.grpc.stub.AbstractStub<ProductServiceStub> {
    private ProductServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void findById(id.grocery.tunas.grpc.ProductId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.ProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(id.grocery.tunas.grpc.ProductEmpty request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findProductsByCategory(id.grocery.tunas.grpc.CategoryId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_PRODUCTS_BY_CATEGORY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findRecommendedProduct(id.grocery.tunas.grpc.ProductEmpty request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_RECOMMENDED_PRODUCT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findTopProducts(id.grocery.tunas.grpc.ProductEmpty request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_TOP_PRODUCTS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(id.grocery.tunas.grpc.Product request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(id.grocery.tunas.grpc.Product request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(id.grocery.tunas.grpc.ProductId request,
        io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductServiceBlockingStub extends io.grpc.stub.AbstractStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public id.grocery.tunas.grpc.ProductResponse findById(id.grocery.tunas.grpc.ProductId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.MultipleProductResponse findAll(id.grocery.tunas.grpc.ProductEmpty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_ALL, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.MultipleProductResponse findProductsByCategory(id.grocery.tunas.grpc.CategoryId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_PRODUCTS_BY_CATEGORY, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.MultipleProductResponse findRecommendedProduct(id.grocery.tunas.grpc.ProductEmpty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_RECOMMENDED_PRODUCT, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.MultipleProductResponse findTopProducts(id.grocery.tunas.grpc.ProductEmpty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_TOP_PRODUCTS, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response save(id.grocery.tunas.grpc.Product request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response update(id.grocery.tunas.grpc.Product request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }

    /**
     */
    public id.grocery.tunas.grpc.Response delete(id.grocery.tunas.grpc.ProductId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductServiceFutureStub extends io.grpc.stub.AbstractStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.ProductResponse> findById(
        id.grocery.tunas.grpc.ProductId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.MultipleProductResponse> findAll(
        id.grocery.tunas.grpc.ProductEmpty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.MultipleProductResponse> findProductsByCategory(
        id.grocery.tunas.grpc.CategoryId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_PRODUCTS_BY_CATEGORY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.MultipleProductResponse> findRecommendedProduct(
        id.grocery.tunas.grpc.ProductEmpty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_RECOMMENDED_PRODUCT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.MultipleProductResponse> findTopProducts(
        id.grocery.tunas.grpc.ProductEmpty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_TOP_PRODUCTS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> save(
        id.grocery.tunas.grpc.Product request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> update(
        id.grocery.tunas.grpc.Product request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<id.grocery.tunas.grpc.Response> delete(
        id.grocery.tunas.grpc.ProductId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_BY_ID = 0;
  private static final int METHODID_FIND_ALL = 1;
  private static final int METHODID_FIND_PRODUCTS_BY_CATEGORY = 2;
  private static final int METHODID_FIND_RECOMMENDED_PRODUCT = 3;
  private static final int METHODID_FIND_TOP_PRODUCTS = 4;
  private static final int METHODID_SAVE = 5;
  private static final int METHODID_UPDATE = 6;
  private static final int METHODID_DELETE = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((id.grocery.tunas.grpc.ProductId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.ProductResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((id.grocery.tunas.grpc.ProductEmpty) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse>) responseObserver);
          break;
        case METHODID_FIND_PRODUCTS_BY_CATEGORY:
          serviceImpl.findProductsByCategory((id.grocery.tunas.grpc.CategoryId) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse>) responseObserver);
          break;
        case METHODID_FIND_RECOMMENDED_PRODUCT:
          serviceImpl.findRecommendedProduct((id.grocery.tunas.grpc.ProductEmpty) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse>) responseObserver);
          break;
        case METHODID_FIND_TOP_PRODUCTS:
          serviceImpl.findTopProducts((id.grocery.tunas.grpc.ProductEmpty) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.MultipleProductResponse>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((id.grocery.tunas.grpc.Product) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((id.grocery.tunas.grpc.Product) request,
              (io.grpc.stub.StreamObserver<id.grocery.tunas.grpc.Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((id.grocery.tunas.grpc.ProductId) request,
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

  private static final class ProductServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return id.grocery.tunas.grpc.ProductOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServiceDescriptorSupplier())
              .addMethod(METHOD_FIND_BY_ID)
              .addMethod(METHOD_FIND_ALL)
              .addMethod(METHOD_FIND_PRODUCTS_BY_CATEGORY)
              .addMethod(METHOD_FIND_RECOMMENDED_PRODUCT)
              .addMethod(METHOD_FIND_TOP_PRODUCTS)
              .addMethod(METHOD_SAVE)
              .addMethod(METHOD_UPDATE)
              .addMethod(METHOD_DELETE)
              .build();
        }
      }
    }
    return result;
  }
}
