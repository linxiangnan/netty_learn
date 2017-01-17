// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ResponseUserProto.proto

package com.lxn.netty.model.protoModel;

public final class ResponseUserProto {
  private ResponseUserProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ResponseUserOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.lxn.netty.model.protoModel.ResponseUser)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int64 userId = 1;</code>
     */
    boolean hasUserId();
    /**
     * <code>required int64 userId = 1;</code>
     */
    long getUserId();

    /**
     * <code>optional string helloText = 2;</code>
     */
    boolean hasHelloText();
    /**
     * <code>optional string helloText = 2;</code>
     */
    java.lang.String getHelloText();
    /**
     * <code>optional string helloText = 2;</code>
     */
    com.google.protobuf.ByteString
        getHelloTextBytes();
  }
  /**
   * Protobuf type {@code com.lxn.netty.model.protoModel.ResponseUser}
   */
  public  static final class ResponseUser extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.lxn.netty.model.protoModel.ResponseUser)
      ResponseUserOrBuilder {
    // Use ResponseUser.newBuilder() to construct.
    private ResponseUser(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ResponseUser() {
      userId_ = 0L;
      helloText_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ResponseUser(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              userId_ = input.readInt64();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              helloText_ = bs;
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
      return com.lxn.netty.model.protoModel.ResponseUserProto.internal_static_com_lxn_netty_model_protoModel_ResponseUser_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lxn.netty.model.protoModel.ResponseUserProto.internal_static_com_lxn_netty_model_protoModel_ResponseUser_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser.class, com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser.Builder.class);
    }

    private int bitField0_;
    public static final int USERID_FIELD_NUMBER = 1;
    private long userId_;
    /**
     * <code>required int64 userId = 1;</code>
     */
    public boolean hasUserId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int64 userId = 1;</code>
     */
    public long getUserId() {
      return userId_;
    }

    public static final int HELLOTEXT_FIELD_NUMBER = 2;
    private volatile java.lang.Object helloText_;
    /**
     * <code>optional string helloText = 2;</code>
     */
    public boolean hasHelloText() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string helloText = 2;</code>
     */
    public java.lang.String getHelloText() {
      java.lang.Object ref = helloText_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          helloText_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string helloText = 2;</code>
     */
    public com.google.protobuf.ByteString
        getHelloTextBytes() {
      java.lang.Object ref = helloText_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        helloText_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasUserId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, userId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, helloText_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, userId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, helloText_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser)) {
        return super.equals(obj);
      }
      com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser other = (com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser) obj;

      boolean result = true;
      result = result && (hasUserId() == other.hasUserId());
      if (hasUserId()) {
        result = result && (getUserId()
            == other.getUserId());
      }
      result = result && (hasHelloText() == other.hasHelloText());
      if (hasHelloText()) {
        result = result && getHelloText()
            .equals(other.getHelloText());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasUserId()) {
        hash = (37 * hash) + USERID_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
            getUserId());
      }
      if (hasHelloText()) {
        hash = (37 * hash) + HELLOTEXT_FIELD_NUMBER;
        hash = (53 * hash) + getHelloText().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parseFrom(
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
    public static Builder newBuilder(com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser prototype) {
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
     * Protobuf type {@code com.lxn.netty.model.protoModel.ResponseUser}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.lxn.netty.model.protoModel.ResponseUser)
        com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUserOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.lxn.netty.model.protoModel.ResponseUserProto.internal_static_com_lxn_netty_model_protoModel_ResponseUser_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.lxn.netty.model.protoModel.ResponseUserProto.internal_static_com_lxn_netty_model_protoModel_ResponseUser_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser.class, com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser.Builder.class);
      }

      // Construct using com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser.newBuilder()
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
      public Builder clear() {
        super.clear();
        userId_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        helloText_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.lxn.netty.model.protoModel.ResponseUserProto.internal_static_com_lxn_netty_model_protoModel_ResponseUser_descriptor;
      }

      public com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser getDefaultInstanceForType() {
        return com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser.getDefaultInstance();
      }

      public com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser build() {
        com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser buildPartial() {
        com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser result = new com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.userId_ = userId_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.helloText_ = helloText_;
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
        if (other instanceof com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser) {
          return mergeFrom((com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser other) {
        if (other == com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser.getDefaultInstance()) return this;
        if (other.hasUserId()) {
          setUserId(other.getUserId());
        }
        if (other.hasHelloText()) {
          bitField0_ |= 0x00000002;
          helloText_ = other.helloText_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasUserId()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long userId_ ;
      /**
       * <code>required int64 userId = 1;</code>
       */
      public boolean hasUserId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int64 userId = 1;</code>
       */
      public long getUserId() {
        return userId_;
      }
      /**
       * <code>required int64 userId = 1;</code>
       */
      public Builder setUserId(long value) {
        bitField0_ |= 0x00000001;
        userId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 userId = 1;</code>
       */
      public Builder clearUserId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        userId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object helloText_ = "";
      /**
       * <code>optional string helloText = 2;</code>
       */
      public boolean hasHelloText() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string helloText = 2;</code>
       */
      public java.lang.String getHelloText() {
        java.lang.Object ref = helloText_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            helloText_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string helloText = 2;</code>
       */
      public com.google.protobuf.ByteString
          getHelloTextBytes() {
        java.lang.Object ref = helloText_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          helloText_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string helloText = 2;</code>
       */
      public Builder setHelloText(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        helloText_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string helloText = 2;</code>
       */
      public Builder clearHelloText() {
        bitField0_ = (bitField0_ & ~0x00000002);
        helloText_ = getDefaultInstance().getHelloText();
        onChanged();
        return this;
      }
      /**
       * <code>optional string helloText = 2;</code>
       */
      public Builder setHelloTextBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        helloText_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.lxn.netty.model.protoModel.ResponseUser)
    }

    // @@protoc_insertion_point(class_scope:com.lxn.netty.model.protoModel.ResponseUser)
    private static final com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser();
    }

    public static com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<ResponseUser>
        PARSER = new com.google.protobuf.AbstractParser<ResponseUser>() {
      public ResponseUser parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ResponseUser(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ResponseUser> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ResponseUser> getParserForType() {
      return PARSER;
    }

    public com.lxn.netty.model.protoModel.ResponseUserProto.ResponseUser getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lxn_netty_model_protoModel_ResponseUser_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lxn_netty_model_protoModel_ResponseUser_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027ResponseUserProto.proto\022\036com.lxn.netty" +
      ".model.protoModel\"1\n\014ResponseUser\022\016\n\006use" +
      "rId\030\001 \002(\003\022\021\n\thelloText\030\002 \001(\tB\023B\021Response" +
      "UserProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_lxn_netty_model_protoModel_ResponseUser_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_lxn_netty_model_protoModel_ResponseUser_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lxn_netty_model_protoModel_ResponseUser_descriptor,
        new java.lang.String[] { "UserId", "HelloText", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
