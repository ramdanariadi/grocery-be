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
    comments = "Source: product.proto")
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ProductService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ProductId,
          ProductResponse> METHOD_FIND_BY_ID =
      io.grpc.MethodDescriptor.<ProductId, ProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ProductId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ProductEmpty,
          MultipleProductResponse> METHOD_FIND_ALL =
      io.grpc.MethodDescriptor.<ProductEmpty, MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ProductEmpty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<CategoryId,
          MultipleProductResponse> METHOD_FIND_PRODUCTS_BY_CATEGORY =
      io.grpc.MethodDescriptor.<CategoryId, MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindProductsByCategory"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CategoryId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ProductEmpty,
          MultipleProductResponse> METHOD_FIND_RECOMMENDED_PRODUCT =
      io.grpc.MethodDescriptor.<ProductEmpty, MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindRecommendedProduct"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ProductEmpty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ProductEmpty,
          MultipleProductResponse> METHOD_FIND_TOP_PRODUCTS =
      io.grpc.MethodDescriptor.<ProductEmpty, MultipleProductResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "FindTopProducts"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ProductEmpty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MultipleProductResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Product,
          Response> METHOD_SAVE =
      io.grpc.MethodDescriptor.<Product, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "Save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Product.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Product,
          Response> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<Product, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "Update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Product.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ProductId,
          Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<ProductId, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.ProductService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ProductId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
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
    public void findById(ProductId request,
                         io.grpc.stub.StreamObserver<ProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_ID, responseObserver);
    }

    /**
     */
    public void findAll(ProductEmpty request,
                        io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_ALL, responseObserver);
    }

    /**
     */
    public void findProductsByCategory(CategoryId request,
                                       io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_PRODUCTS_BY_CATEGORY, responseObserver);
    }

    /**
     */
    public void findRecommendedProduct(ProductEmpty request,
                                       io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_RECOMMENDED_PRODUCT, responseObserver);
    }

    /**
     */
    public void findTopProducts(ProductEmpty request,
                                io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_TOP_PRODUCTS, responseObserver);
    }

    /**
     */
    public void save(Product request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void update(Product request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    /**
     */
    public void delete(ProductId request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_FIND_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                      ProductId,
                      ProductResponse>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            METHOD_FIND_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                      ProductEmpty,
                      MultipleProductResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            METHOD_FIND_PRODUCTS_BY_CATEGORY,
            asyncUnaryCall(
              new MethodHandlers<
                      CategoryId,
                      MultipleProductResponse>(
                  this, METHODID_FIND_PRODUCTS_BY_CATEGORY)))
          .addMethod(
            METHOD_FIND_RECOMMENDED_PRODUCT,
            asyncUnaryCall(
              new MethodHandlers<
                      ProductEmpty,
                      MultipleProductResponse>(
                  this, METHODID_FIND_RECOMMENDED_PRODUCT)))
          .addMethod(
            METHOD_FIND_TOP_PRODUCTS,
            asyncUnaryCall(
              new MethodHandlers<
                      ProductEmpty,
                      MultipleProductResponse>(
                  this, METHODID_FIND_TOP_PRODUCTS)))
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                      Product,
                      Response>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                      Product,
                      Response>(
                  this, METHODID_UPDATE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                      ProductId,
                      Response>(
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
    public void findById(ProductId request,
                         io.grpc.stub.StreamObserver<ProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(ProductEmpty request,
                        io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findProductsByCategory(CategoryId request,
                                       io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_PRODUCTS_BY_CATEGORY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findRecommendedProduct(ProductEmpty request,
                                       io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_RECOMMENDED_PRODUCT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findTopProducts(ProductEmpty request,
                                io.grpc.stub.StreamObserver<MultipleProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_TOP_PRODUCTS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(Product request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(Product request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(ProductId request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
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
    public ProductResponse findById(ProductId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public MultipleProductResponse findAll(ProductEmpty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_ALL, getCallOptions(), request);
    }

    /**
     */
    public MultipleProductResponse findProductsByCategory(CategoryId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_PRODUCTS_BY_CATEGORY, getCallOptions(), request);
    }

    /**
     */
    public MultipleProductResponse findRecommendedProduct(ProductEmpty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_RECOMMENDED_PRODUCT, getCallOptions(), request);
    }

    /**
     */
    public MultipleProductResponse findTopProducts(ProductEmpty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_TOP_PRODUCTS, getCallOptions(), request);
    }

    /**
     */
    public Response save(Product request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public Response update(Product request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }

    /**
     */
    public Response delete(ProductId request) {
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
    public com.google.common.util.concurrent.ListenableFuture<ProductResponse> findById(
        ProductId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MultipleProductResponse> findAll(
        ProductEmpty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MultipleProductResponse> findProductsByCategory(
        CategoryId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_PRODUCTS_BY_CATEGORY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MultipleProductResponse> findRecommendedProduct(
        ProductEmpty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_RECOMMENDED_PRODUCT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MultipleProductResponse> findTopProducts(
        ProductEmpty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_TOP_PRODUCTS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> save(
        Product request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> update(
        Product request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> delete(
        ProductId request) {
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
          serviceImpl.findById((ProductId) request,
              (io.grpc.stub.StreamObserver<ProductResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((ProductEmpty) request,
              (io.grpc.stub.StreamObserver<MultipleProductResponse>) responseObserver);
          break;
        case METHODID_FIND_PRODUCTS_BY_CATEGORY:
          serviceImpl.findProductsByCategory((CategoryId) request,
              (io.grpc.stub.StreamObserver<MultipleProductResponse>) responseObserver);
          break;
        case METHODID_FIND_RECOMMENDED_PRODUCT:
          serviceImpl.findRecommendedProduct((ProductEmpty) request,
              (io.grpc.stub.StreamObserver<MultipleProductResponse>) responseObserver);
          break;
        case METHODID_FIND_TOP_PRODUCTS:
          serviceImpl.findTopProducts((ProductEmpty) request,
              (io.grpc.stub.StreamObserver<MultipleProductResponse>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((Product) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((Product) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((ProductId) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
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
      return ProductOuterClass.getDescriptor();
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
