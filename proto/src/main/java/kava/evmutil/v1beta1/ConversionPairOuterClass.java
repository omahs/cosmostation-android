// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kava/evmutil/v1beta1/conversion_pair.proto

package kava.evmutil.v1beta1;

public final class ConversionPairOuterClass {
  private ConversionPairOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ConversionPairOrBuilder extends
      // @@protoc_insertion_point(interface_extends:kava.evmutil.v1beta1.ConversionPair)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * ERC20 address of the token on the Kava EVM
     * </pre>
     *
     * <code>bytes kava_erc20_address = 1 [(.gogoproto.customname) = "KavaERC20Address", (.gogoproto.casttype) = "HexBytes"];</code>
     * @return The kavaErc20Address.
     */
    com.google.protobuf.ByteString getKavaErc20Address();

    /**
     * <pre>
     * Denom of the corresponding sdk.Coin
     * </pre>
     *
     * <code>string denom = 2;</code>
     * @return The denom.
     */
    java.lang.String getDenom();
    /**
     * <pre>
     * Denom of the corresponding sdk.Coin
     * </pre>
     *
     * <code>string denom = 2;</code>
     * @return The bytes for denom.
     */
    com.google.protobuf.ByteString
        getDenomBytes();
  }
  /**
   * <pre>
   * ConversionPair defines a Kava ERC20 address and corresponding denom that is
   * allowed to be converted between ERC20 and sdk.Coin
   * </pre>
   *
   * Protobuf type {@code kava.evmutil.v1beta1.ConversionPair}
   */
  public static final class ConversionPair extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:kava.evmutil.v1beta1.ConversionPair)
      ConversionPairOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ConversionPair.newBuilder() to construct.
    private ConversionPair(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ConversionPair() {
      kavaErc20Address_ = com.google.protobuf.ByteString.EMPTY;
      denom_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ConversionPair();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ConversionPair(
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

              kavaErc20Address_ = input.readBytes();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              denom_ = s;
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
      return kava.evmutil.v1beta1.ConversionPairOuterClass.internal_static_kava_evmutil_v1beta1_ConversionPair_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return kava.evmutil.v1beta1.ConversionPairOuterClass.internal_static_kava_evmutil_v1beta1_ConversionPair_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair.class, kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair.Builder.class);
    }

    public static final int KAVA_ERC20_ADDRESS_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString kavaErc20Address_;
    /**
     * <pre>
     * ERC20 address of the token on the Kava EVM
     * </pre>
     *
     * <code>bytes kava_erc20_address = 1 [(.gogoproto.customname) = "KavaERC20Address", (.gogoproto.casttype) = "HexBytes"];</code>
     * @return The kavaErc20Address.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getKavaErc20Address() {
      return kavaErc20Address_;
    }

    public static final int DENOM_FIELD_NUMBER = 2;
    private volatile java.lang.Object denom_;
    /**
     * <pre>
     * Denom of the corresponding sdk.Coin
     * </pre>
     *
     * <code>string denom = 2;</code>
     * @return The denom.
     */
    @java.lang.Override
    public java.lang.String getDenom() {
      java.lang.Object ref = denom_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        denom_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * Denom of the corresponding sdk.Coin
     * </pre>
     *
     * <code>string denom = 2;</code>
     * @return The bytes for denom.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDenomBytes() {
      java.lang.Object ref = denom_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        denom_ = b;
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
      if (!kavaErc20Address_.isEmpty()) {
        output.writeBytes(1, kavaErc20Address_);
      }
      if (!getDenomBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, denom_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!kavaErc20Address_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, kavaErc20Address_);
      }
      if (!getDenomBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, denom_);
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
      if (!(obj instanceof kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair)) {
        return super.equals(obj);
      }
      kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair other = (kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair) obj;

      if (!getKavaErc20Address()
          .equals(other.getKavaErc20Address())) return false;
      if (!getDenom()
          .equals(other.getDenom())) return false;
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
      hash = (37 * hash) + KAVA_ERC20_ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getKavaErc20Address().hashCode();
      hash = (37 * hash) + DENOM_FIELD_NUMBER;
      hash = (53 * hash) + getDenom().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parseFrom(
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
    public static Builder newBuilder(kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair prototype) {
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
     * ConversionPair defines a Kava ERC20 address and corresponding denom that is
     * allowed to be converted between ERC20 and sdk.Coin
     * </pre>
     *
     * Protobuf type {@code kava.evmutil.v1beta1.ConversionPair}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:kava.evmutil.v1beta1.ConversionPair)
        kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPairOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return kava.evmutil.v1beta1.ConversionPairOuterClass.internal_static_kava_evmutil_v1beta1_ConversionPair_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return kava.evmutil.v1beta1.ConversionPairOuterClass.internal_static_kava_evmutil_v1beta1_ConversionPair_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair.class, kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair.Builder.class);
      }

      // Construct using kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair.newBuilder()
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
        kavaErc20Address_ = com.google.protobuf.ByteString.EMPTY;

        denom_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return kava.evmutil.v1beta1.ConversionPairOuterClass.internal_static_kava_evmutil_v1beta1_ConversionPair_descriptor;
      }

      @java.lang.Override
      public kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair getDefaultInstanceForType() {
        return kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair.getDefaultInstance();
      }

      @java.lang.Override
      public kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair build() {
        kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair buildPartial() {
        kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair result = new kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair(this);
        result.kavaErc20Address_ = kavaErc20Address_;
        result.denom_ = denom_;
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
        if (other instanceof kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair) {
          return mergeFrom((kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair other) {
        if (other == kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair.getDefaultInstance()) return this;
        if (other.getKavaErc20Address() != com.google.protobuf.ByteString.EMPTY) {
          setKavaErc20Address(other.getKavaErc20Address());
        }
        if (!other.getDenom().isEmpty()) {
          denom_ = other.denom_;
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
        kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.google.protobuf.ByteString kavaErc20Address_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <pre>
       * ERC20 address of the token on the Kava EVM
       * </pre>
       *
       * <code>bytes kava_erc20_address = 1 [(.gogoproto.customname) = "KavaERC20Address", (.gogoproto.casttype) = "HexBytes"];</code>
       * @return The kavaErc20Address.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getKavaErc20Address() {
        return kavaErc20Address_;
      }
      /**
       * <pre>
       * ERC20 address of the token on the Kava EVM
       * </pre>
       *
       * <code>bytes kava_erc20_address = 1 [(.gogoproto.customname) = "KavaERC20Address", (.gogoproto.casttype) = "HexBytes"];</code>
       * @param value The kavaErc20Address to set.
       * @return This builder for chaining.
       */
      public Builder setKavaErc20Address(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        kavaErc20Address_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * ERC20 address of the token on the Kava EVM
       * </pre>
       *
       * <code>bytes kava_erc20_address = 1 [(.gogoproto.customname) = "KavaERC20Address", (.gogoproto.casttype) = "HexBytes"];</code>
       * @return This builder for chaining.
       */
      public Builder clearKavaErc20Address() {
        
        kavaErc20Address_ = getDefaultInstance().getKavaErc20Address();
        onChanged();
        return this;
      }

      private java.lang.Object denom_ = "";
      /**
       * <pre>
       * Denom of the corresponding sdk.Coin
       * </pre>
       *
       * <code>string denom = 2;</code>
       * @return The denom.
       */
      public java.lang.String getDenom() {
        java.lang.Object ref = denom_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          denom_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * Denom of the corresponding sdk.Coin
       * </pre>
       *
       * <code>string denom = 2;</code>
       * @return The bytes for denom.
       */
      public com.google.protobuf.ByteString
          getDenomBytes() {
        java.lang.Object ref = denom_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          denom_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * Denom of the corresponding sdk.Coin
       * </pre>
       *
       * <code>string denom = 2;</code>
       * @param value The denom to set.
       * @return This builder for chaining.
       */
      public Builder setDenom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        denom_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Denom of the corresponding sdk.Coin
       * </pre>
       *
       * <code>string denom = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearDenom() {
        
        denom_ = getDefaultInstance().getDenom();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Denom of the corresponding sdk.Coin
       * </pre>
       *
       * <code>string denom = 2;</code>
       * @param value The bytes for denom to set.
       * @return This builder for chaining.
       */
      public Builder setDenomBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        denom_ = value;
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


      // @@protoc_insertion_point(builder_scope:kava.evmutil.v1beta1.ConversionPair)
    }

    // @@protoc_insertion_point(class_scope:kava.evmutil.v1beta1.ConversionPair)
    private static final kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair();
    }

    public static kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ConversionPair>
        PARSER = new com.google.protobuf.AbstractParser<ConversionPair>() {
      @java.lang.Override
      public ConversionPair parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ConversionPair(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ConversionPair> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ConversionPair> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public kava.evmutil.v1beta1.ConversionPairOuterClass.ConversionPair getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_kava_evmutil_v1beta1_ConversionPair_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_kava_evmutil_v1beta1_ConversionPair_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n*kava/evmutil/v1beta1/conversion_pair.p" +
      "roto\022\024kava.evmutil.v1beta1\032\024gogoproto/go" +
      "go.proto\"c\n\016ConversionPair\022<\n\022kava_erc20" +
      "_address\030\001 \001(\014B \342\336\037\020KavaERC20Address\372\336\037\010" +
      "HexBytes\022\r\n\005denom\030\002 \001(\t:\004\210\240\037\000B3Z)github." +
      "com/kava-labs/kava/x/evmutil/types\250\342\036\001\340\341" +
      "\036\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf2.GoGoProtos.getDescriptor(),
        });
    internal_static_kava_evmutil_v1beta1_ConversionPair_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_kava_evmutil_v1beta1_ConversionPair_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_kava_evmutil_v1beta1_ConversionPair_descriptor,
        new java.lang.String[] { "KavaErc20Address", "Denom", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.protobuf2.GoGoProtos.casttype);
    registry.add(com.google.protobuf2.GoGoProtos.customname);
    registry.add(com.google.protobuf2.GoGoProtos.equalAll);
    registry.add(com.google.protobuf2.GoGoProtos.goprotoGetters);
    registry.add(com.google.protobuf2.GoGoProtos.verboseEqualAll);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf2.GoGoProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}