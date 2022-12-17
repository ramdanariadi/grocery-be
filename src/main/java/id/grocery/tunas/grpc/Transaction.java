// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transaction.proto

package id.grocery.tunas.grpc;

/**
 * Protobuf type {@code proto.Transaction}
 */
public  final class Transaction extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.Transaction)
    TransactionOrBuilder {
  // Use Transaction.newBuilder() to construct.
  private Transaction(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Transaction() {
    id_ = "";
    totalPrice_ = 0L;
    transactionDate_ = 0L;
    products_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Transaction(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 16: {

            totalPrice_ = input.readUInt64();
            break;
          }
          case 24: {

            transactionDate_ = input.readInt64();
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              products_ = new java.util.ArrayList<id.grocery.tunas.grpc.TransactionProductDetail>();
              mutable_bitField0_ |= 0x00000008;
            }
            products_.add(
                input.readMessage(id.grocery.tunas.grpc.TransactionProductDetail.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        products_ = java.util.Collections.unmodifiableList(products_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return id.grocery.tunas.grpc.TransactionOuterClass.internal_static_proto_Transaction_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return id.grocery.tunas.grpc.TransactionOuterClass.internal_static_proto_Transaction_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            id.grocery.tunas.grpc.Transaction.class, id.grocery.tunas.grpc.Transaction.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object id_;
  /**
   * <code>string id = 1;</code>
   */
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOTAL_PRICE_FIELD_NUMBER = 2;
  private long totalPrice_;
  /**
   * <code>uint64 total_price = 2;</code>
   */
  public long getTotalPrice() {
    return totalPrice_;
  }

  public static final int TRANSACTION_DATE_FIELD_NUMBER = 3;
  private long transactionDate_;
  /**
   * <code>int64 transaction_date = 3;</code>
   */
  public long getTransactionDate() {
    return transactionDate_;
  }

  public static final int PRODUCTS_FIELD_NUMBER = 4;
  private java.util.List<id.grocery.tunas.grpc.TransactionProductDetail> products_;
  /**
   * <code>repeated .proto.TransactionProductDetail products = 4;</code>
   */
  public java.util.List<id.grocery.tunas.grpc.TransactionProductDetail> getProductsList() {
    return products_;
  }
  /**
   * <code>repeated .proto.TransactionProductDetail products = 4;</code>
   */
  public java.util.List<? extends id.grocery.tunas.grpc.TransactionProductDetailOrBuilder> 
      getProductsOrBuilderList() {
    return products_;
  }
  /**
   * <code>repeated .proto.TransactionProductDetail products = 4;</code>
   */
  public int getProductsCount() {
    return products_.size();
  }
  /**
   * <code>repeated .proto.TransactionProductDetail products = 4;</code>
   */
  public id.grocery.tunas.grpc.TransactionProductDetail getProducts(int index) {
    return products_.get(index);
  }
  /**
   * <code>repeated .proto.TransactionProductDetail products = 4;</code>
   */
  public id.grocery.tunas.grpc.TransactionProductDetailOrBuilder getProductsOrBuilder(
      int index) {
    return products_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
    }
    if (totalPrice_ != 0L) {
      output.writeUInt64(2, totalPrice_);
    }
    if (transactionDate_ != 0L) {
      output.writeInt64(3, transactionDate_);
    }
    for (int i = 0; i < products_.size(); i++) {
      output.writeMessage(4, products_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
    }
    if (totalPrice_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, totalPrice_);
    }
    if (transactionDate_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, transactionDate_);
    }
    for (int i = 0; i < products_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, products_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof id.grocery.tunas.grpc.Transaction)) {
      return super.equals(obj);
    }
    id.grocery.tunas.grpc.Transaction other = (id.grocery.tunas.grpc.Transaction) obj;

    boolean result = true;
    result = result && getId()
        .equals(other.getId());
    result = result && (getTotalPrice()
        == other.getTotalPrice());
    result = result && (getTransactionDate()
        == other.getTransactionDate());
    result = result && getProductsList()
        .equals(other.getProductsList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + TOTAL_PRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTotalPrice());
    hash = (37 * hash) + TRANSACTION_DATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTransactionDate());
    if (getProductsCount() > 0) {
      hash = (37 * hash) + PRODUCTS_FIELD_NUMBER;
      hash = (53 * hash) + getProductsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static id.grocery.tunas.grpc.Transaction parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static id.grocery.tunas.grpc.Transaction parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static id.grocery.tunas.grpc.Transaction parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static id.grocery.tunas.grpc.Transaction parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(id.grocery.tunas.grpc.Transaction prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code proto.Transaction}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.Transaction)
      id.grocery.tunas.grpc.TransactionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return id.grocery.tunas.grpc.TransactionOuterClass.internal_static_proto_Transaction_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return id.grocery.tunas.grpc.TransactionOuterClass.internal_static_proto_Transaction_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              id.grocery.tunas.grpc.Transaction.class, id.grocery.tunas.grpc.Transaction.Builder.class);
    }

    // Construct using id.grocery.tunas.grpc.Transaction.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getProductsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      id_ = "";

      totalPrice_ = 0L;

      transactionDate_ = 0L;

      if (productsBuilder_ == null) {
        products_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        productsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return id.grocery.tunas.grpc.TransactionOuterClass.internal_static_proto_Transaction_descriptor;
    }

    public id.grocery.tunas.grpc.Transaction getDefaultInstanceForType() {
      return id.grocery.tunas.grpc.Transaction.getDefaultInstance();
    }

    public id.grocery.tunas.grpc.Transaction build() {
      id.grocery.tunas.grpc.Transaction result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public id.grocery.tunas.grpc.Transaction buildPartial() {
      id.grocery.tunas.grpc.Transaction result = new id.grocery.tunas.grpc.Transaction(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.id_ = id_;
      result.totalPrice_ = totalPrice_;
      result.transactionDate_ = transactionDate_;
      if (productsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          products_ = java.util.Collections.unmodifiableList(products_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.products_ = products_;
      } else {
        result.products_ = productsBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof id.grocery.tunas.grpc.Transaction) {
        return mergeFrom((id.grocery.tunas.grpc.Transaction)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(id.grocery.tunas.grpc.Transaction other) {
      if (other == id.grocery.tunas.grpc.Transaction.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (other.getTotalPrice() != 0L) {
        setTotalPrice(other.getTotalPrice());
      }
      if (other.getTransactionDate() != 0L) {
        setTransactionDate(other.getTransactionDate());
      }
      if (productsBuilder_ == null) {
        if (!other.products_.isEmpty()) {
          if (products_.isEmpty()) {
            products_ = other.products_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureProductsIsMutable();
            products_.addAll(other.products_);
          }
          onChanged();
        }
      } else {
        if (!other.products_.isEmpty()) {
          if (productsBuilder_.isEmpty()) {
            productsBuilder_.dispose();
            productsBuilder_ = null;
            products_ = other.products_;
            bitField0_ = (bitField0_ & ~0x00000008);
            productsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getProductsFieldBuilder() : null;
          } else {
            productsBuilder_.addAllMessages(other.products_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      id.grocery.tunas.grpc.Transaction parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (id.grocery.tunas.grpc.Transaction) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 1;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private long totalPrice_ ;
    /**
     * <code>uint64 total_price = 2;</code>
     */
    public long getTotalPrice() {
      return totalPrice_;
    }
    /**
     * <code>uint64 total_price = 2;</code>
     */
    public Builder setTotalPrice(long value) {
      
      totalPrice_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 total_price = 2;</code>
     */
    public Builder clearTotalPrice() {
      
      totalPrice_ = 0L;
      onChanged();
      return this;
    }

    private long transactionDate_ ;
    /**
     * <code>int64 transaction_date = 3;</code>
     */
    public long getTransactionDate() {
      return transactionDate_;
    }
    /**
     * <code>int64 transaction_date = 3;</code>
     */
    public Builder setTransactionDate(long value) {
      
      transactionDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 transaction_date = 3;</code>
     */
    public Builder clearTransactionDate() {
      
      transactionDate_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<id.grocery.tunas.grpc.TransactionProductDetail> products_ =
      java.util.Collections.emptyList();
    private void ensureProductsIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        products_ = new java.util.ArrayList<id.grocery.tunas.grpc.TransactionProductDetail>(products_);
        bitField0_ |= 0x00000008;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        id.grocery.tunas.grpc.TransactionProductDetail, id.grocery.tunas.grpc.TransactionProductDetail.Builder, id.grocery.tunas.grpc.TransactionProductDetailOrBuilder> productsBuilder_;

    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public java.util.List<id.grocery.tunas.grpc.TransactionProductDetail> getProductsList() {
      if (productsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(products_);
      } else {
        return productsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public int getProductsCount() {
      if (productsBuilder_ == null) {
        return products_.size();
      } else {
        return productsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public id.grocery.tunas.grpc.TransactionProductDetail getProducts(int index) {
      if (productsBuilder_ == null) {
        return products_.get(index);
      } else {
        return productsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder setProducts(
        int index, id.grocery.tunas.grpc.TransactionProductDetail value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.set(index, value);
        onChanged();
      } else {
        productsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder setProducts(
        int index, id.grocery.tunas.grpc.TransactionProductDetail.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.set(index, builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder addProducts(id.grocery.tunas.grpc.TransactionProductDetail value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.add(value);
        onChanged();
      } else {
        productsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder addProducts(
        int index, id.grocery.tunas.grpc.TransactionProductDetail value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.add(index, value);
        onChanged();
      } else {
        productsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder addProducts(
        id.grocery.tunas.grpc.TransactionProductDetail.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.add(builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder addProducts(
        int index, id.grocery.tunas.grpc.TransactionProductDetail.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.add(index, builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder addAllProducts(
        java.lang.Iterable<? extends id.grocery.tunas.grpc.TransactionProductDetail> values) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, products_);
        onChanged();
      } else {
        productsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder clearProducts() {
      if (productsBuilder_ == null) {
        products_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        productsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public Builder removeProducts(int index) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.remove(index);
        onChanged();
      } else {
        productsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public id.grocery.tunas.grpc.TransactionProductDetail.Builder getProductsBuilder(
        int index) {
      return getProductsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public id.grocery.tunas.grpc.TransactionProductDetailOrBuilder getProductsOrBuilder(
        int index) {
      if (productsBuilder_ == null) {
        return products_.get(index);  } else {
        return productsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public java.util.List<? extends id.grocery.tunas.grpc.TransactionProductDetailOrBuilder> 
         getProductsOrBuilderList() {
      if (productsBuilder_ != null) {
        return productsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(products_);
      }
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public id.grocery.tunas.grpc.TransactionProductDetail.Builder addProductsBuilder() {
      return getProductsFieldBuilder().addBuilder(
          id.grocery.tunas.grpc.TransactionProductDetail.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public id.grocery.tunas.grpc.TransactionProductDetail.Builder addProductsBuilder(
        int index) {
      return getProductsFieldBuilder().addBuilder(
          index, id.grocery.tunas.grpc.TransactionProductDetail.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.TransactionProductDetail products = 4;</code>
     */
    public java.util.List<id.grocery.tunas.grpc.TransactionProductDetail.Builder> 
         getProductsBuilderList() {
      return getProductsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        id.grocery.tunas.grpc.TransactionProductDetail, id.grocery.tunas.grpc.TransactionProductDetail.Builder, id.grocery.tunas.grpc.TransactionProductDetailOrBuilder> 
        getProductsFieldBuilder() {
      if (productsBuilder_ == null) {
        productsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            id.grocery.tunas.grpc.TransactionProductDetail, id.grocery.tunas.grpc.TransactionProductDetail.Builder, id.grocery.tunas.grpc.TransactionProductDetailOrBuilder>(
                products_,
                ((bitField0_ & 0x00000008) == 0x00000008),
                getParentForChildren(),
                isClean());
        products_ = null;
      }
      return productsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:proto.Transaction)
  }

  // @@protoc_insertion_point(class_scope:proto.Transaction)
  private static final id.grocery.tunas.grpc.Transaction DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new id.grocery.tunas.grpc.Transaction();
  }

  public static id.grocery.tunas.grpc.Transaction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Transaction>
      PARSER = new com.google.protobuf.AbstractParser<Transaction>() {
    public Transaction parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Transaction(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Transaction> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Transaction> getParserForType() {
    return PARSER;
  }

  public id.grocery.tunas.grpc.Transaction getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

