// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ethermint/types/v1/dynamic_fee.proto

package ethermint.types.v1;

public final class DynamicFee {
  private DynamicFee() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ExtensionOptionDynamicFeeTxOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ethermint.types.v1.ExtensionOptionDynamicFeeTx)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * the same as `max_priority_fee_per_gas` in eip-1559 spec
     * </pre>
     *
     * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
     * @return The maxPriorityPrice.
     */
    java.lang.String getMaxPriorityPrice();
    /**
     * <pre>
     * the same as `max_priority_fee_per_gas` in eip-1559 spec
     * </pre>
     *
     * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
     * @return The bytes for maxPriorityPrice.
     */
    com.google.protobuf.ByteString
        getMaxPriorityPriceBytes();
  }
  /**
   * <pre>
   * ExtensionOptionDynamicFeeTx is an extension option that specify the maxPrioPrice for cosmos tx
   * </pre>
   *
   * Protobuf type {@code ethermint.types.v1.ExtensionOptionDynamicFeeTx}
   */
  public static final class ExtensionOptionDynamicFeeTx extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ethermint.types.v1.ExtensionOptionDynamicFeeTx)
      ExtensionOptionDynamicFeeTxOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ExtensionOptionDynamicFeeTx.newBuilder() to construct.
    private ExtensionOptionDynamicFeeTx(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ExtensionOptionDynamicFeeTx() {
      maxPriorityPrice_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ExtensionOptionDynamicFeeTx();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ExtensionOptionDynamicFeeTx(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              maxPriorityPrice_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ethermint.types.v1.DynamicFee.internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ethermint.types.v1.DynamicFee.internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx.class, ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx.Builder.class);
    }

    public static final int MAX_PRIORITY_PRICE_FIELD_NUMBER = 1;
    private volatile java.lang.Object maxPriorityPrice_;
    /**
     * <pre>
     * the same as `max_priority_fee_per_gas` in eip-1559 spec
     * </pre>
     *
     * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
     * @return The maxPriorityPrice.
     */
    @java.lang.Override
    public java.lang.String getMaxPriorityPrice() {
      java.lang.Object ref = maxPriorityPrice_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        maxPriorityPrice_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * the same as `max_priority_fee_per_gas` in eip-1559 spec
     * </pre>
     *
     * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
     * @return The bytes for maxPriorityPrice.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMaxPriorityPriceBytes() {
      java.lang.Object ref = maxPriorityPrice_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        maxPriorityPrice_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getMaxPriorityPriceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, maxPriorityPrice_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMaxPriorityPriceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, maxPriorityPrice_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx)) {
        return super.equals(obj);
      }
      ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx other = (ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx) obj;

      if (!getMaxPriorityPrice()
          .equals(other.getMaxPriorityPrice())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MAX_PRIORITY_PRICE_FIELD_NUMBER;
      hash = (53 * hash) + getMaxPriorityPrice().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * <pre>
     * ExtensionOptionDynamicFeeTx is an extension option that specify the maxPrioPrice for cosmos tx
     * </pre>
     *
     * Protobuf type {@code ethermint.types.v1.ExtensionOptionDynamicFeeTx}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ethermint.types.v1.ExtensionOptionDynamicFeeTx)
        ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTxOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ethermint.types.v1.DynamicFee.internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ethermint.types.v1.DynamicFee.internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx.class, ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx.Builder.class);
      }

      // Construct using ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx.newBuilder()
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
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        maxPriorityPrice_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ethermint.types.v1.DynamicFee.internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_descriptor;
      }

      @java.lang.Override
      public ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx getDefaultInstanceForType() {
        return ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx.getDefaultInstance();
      }

      @java.lang.Override
      public ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx build() {
        ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx buildPartial() {
        ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx result = new ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx(this);
        result.maxPriorityPrice_ = maxPriorityPrice_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx) {
          return mergeFrom((ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx other) {
        if (other == ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx.getDefaultInstance()) return this;
        if (!other.getMaxPriorityPrice().isEmpty()) {
          maxPriorityPrice_ = other.maxPriorityPrice_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object maxPriorityPrice_ = "";
      /**
       * <pre>
       * the same as `max_priority_fee_per_gas` in eip-1559 spec
       * </pre>
       *
       * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
       * @return The maxPriorityPrice.
       */
      public java.lang.String getMaxPriorityPrice() {
        java.lang.Object ref = maxPriorityPrice_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          maxPriorityPrice_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * the same as `max_priority_fee_per_gas` in eip-1559 spec
       * </pre>
       *
       * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
       * @return The bytes for maxPriorityPrice.
       */
      public com.google.protobuf.ByteString
          getMaxPriorityPriceBytes() {
        java.lang.Object ref = maxPriorityPrice_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          maxPriorityPrice_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * the same as `max_priority_fee_per_gas` in eip-1559 spec
       * </pre>
       *
       * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
       * @param value The maxPriorityPrice to set.
       * @return This builder for chaining.
       */
      public Builder setMaxPriorityPrice(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        maxPriorityPrice_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * the same as `max_priority_fee_per_gas` in eip-1559 spec
       * </pre>
       *
       * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
       * @return This builder for chaining.
       */
      public Builder clearMaxPriorityPrice() {
        
        maxPriorityPrice_ = getDefaultInstance().getMaxPriorityPrice();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * the same as `max_priority_fee_per_gas` in eip-1559 spec
       * </pre>
       *
       * <code>string max_priority_price = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Int"];</code>
       * @param value The bytes for maxPriorityPrice to set.
       * @return This builder for chaining.
       */
      public Builder setMaxPriorityPriceBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        maxPriorityPrice_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:ethermint.types.v1.ExtensionOptionDynamicFeeTx)
    }

    // @@protoc_insertion_point(class_scope:ethermint.types.v1.ExtensionOptionDynamicFeeTx)
    private static final ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx();
    }

    public static ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ExtensionOptionDynamicFeeTx>
        PARSER = new com.google.protobuf.AbstractParser<ExtensionOptionDynamicFeeTx>() {
      @java.lang.Override
      public ExtensionOptionDynamicFeeTx parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ExtensionOptionDynamicFeeTx(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ExtensionOptionDynamicFeeTx> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ExtensionOptionDynamicFeeTx> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public ethermint.types.v1.DynamicFee.ExtensionOptionDynamicFeeTx getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n$ethermint/types/v1/dynamic_fee.proto\022\022" +
      "ethermint.types.v1\032\024gogoproto/gogo.proto" +
      "\"i\n\033ExtensionOptionDynamicFeeTx\022J\n\022max_p" +
      "riority_price\030\001 \001(\tB.\332\336\037&github.com/cosm" +
      "os/cosmos-sdk/types.Int\310\336\037\000B\"Z github.co" +
      "m/evmos/ethermint/typesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf2.GoGoProtos.getDescriptor(),
        });
    internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ethermint_types_v1_ExtensionOptionDynamicFeeTx_descriptor,
        new java.lang.String[] { "MaxPriorityPrice", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.protobuf2.GoGoProtos.customtype);
    registry.add(com.google.protobuf2.GoGoProtos.nullable);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf2.GoGoProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}