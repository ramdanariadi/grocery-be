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
    comments = "Source: category.proto")
public final class CategoryServiceGrpc {

  private CategoryServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CategoryService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<CategoryId,
          CategoryResponse> METHOD_FIND_BY_ID =
      io.grpc.MethodDescriptor.<CategoryId, CategoryResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CategoryService", "FindById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CategoryId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CategoryResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EmptyCategory,
          MultipleCategoryResponse> METHOD_FIND_ALL =
      io.grpc.MethodDescriptor.<EmptyCategory, MultipleCategoryResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CategoryService", "FindAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EmptyCategory.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              MultipleCategoryResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Category,
          Response> METHOD_SAVE =
      io.grpc.MethodDescriptor.<Category, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CategoryService", "Save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Category.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Category,
          Response> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<Category, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CategoryService", "Update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Category.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<CategoryId,
          Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<CategoryId, Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.CategoryService", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              CategoryId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Response.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CategoryServiceStub newStub(io.grpc.Channel channel) {
    return new CategoryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CategoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CategoryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CategoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CategoryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CategoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findById(CategoryId request,
                         io.grpc.stub.StreamObserver<CategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_BY_ID, responseObserver);
    }

    /**
     */
    public void findAll(EmptyCategory request,
                        io.grpc.stub.StreamObserver<MultipleCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FIND_ALL, responseObserver);
    }

    /**
     */
    public void save(Category request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void update(Category request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    /**
     */
    public void delete(CategoryId request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_FIND_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                      CategoryId,
                      CategoryResponse>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            METHOD_FIND_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                      EmptyCategory,
                      MultipleCategoryResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                      Category,
                      Response>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                      Category,
                      Response>(
                  this, METHODID_UPDATE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                      CategoryId,
                      Response>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class CategoryServiceStub extends io.grpc.stub.AbstractStub<CategoryServiceStub> {
    private CategoryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void findById(CategoryId request,
                         io.grpc.stub.StreamObserver<CategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(EmptyCategory request,
                        io.grpc.stub.StreamObserver<MultipleCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(Category request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(Category request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(CategoryId request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CategoryServiceBlockingStub extends io.grpc.stub.AbstractStub<CategoryServiceBlockingStub> {
    private CategoryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public CategoryResponse findById(CategoryId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public MultipleCategoryResponse findAll(EmptyCategory request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FIND_ALL, getCallOptions(), request);
    }

    /**
     */
    public Response save(Category request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public Response update(Category request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }

    /**
     */
    public Response delete(CategoryId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CategoryServiceFutureStub extends io.grpc.stub.AbstractStub<CategoryServiceFutureStub> {
    private CategoryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CategoryResponse> findById(
        CategoryId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MultipleCategoryResponse> findAll(
        EmptyCategory request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FIND_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> save(
        Category request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> update(
        Category request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> delete(
        CategoryId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_BY_ID = 0;
  private static final int METHODID_FIND_ALL = 1;
  private static final int METHODID_SAVE = 2;
  private static final int METHODID_UPDATE = 3;
  private static final int METHODID_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CategoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CategoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((CategoryId) request,
              (io.grpc.stub.StreamObserver<CategoryResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((EmptyCategory) request,
              (io.grpc.stub.StreamObserver<MultipleCategoryResponse>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((Category) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((Category) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((CategoryId) request,
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

  private static final class CategoryServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CategoryOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CategoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CategoryServiceDescriptorSupplier())
              .addMethod(METHOD_FIND_BY_ID)
              .addMethod(METHOD_FIND_ALL)
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
