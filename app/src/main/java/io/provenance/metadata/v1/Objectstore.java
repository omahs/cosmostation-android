// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: provenance/metadata/v1/objectstore.proto

package io.provenance.metadata.v1;

public final class Objectstore {
  private Objectstore() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_provenance_metadata_v1_ObjectStoreLocator_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_provenance_metadata_v1_ObjectStoreLocator_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_provenance_metadata_v1_OSLocatorParams_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_provenance_metadata_v1_OSLocatorParams_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(provenance/metadata/v1/objectstore.pro" +
      "to\022\026provenance.metadata.v1\032\024gogoproto/go" +
      "go.proto\"P\n\022ObjectStoreLocator\022\r\n\005owner\030" +
      "\001 \001(\t\022\023\n\013locator_uri\030\002 \001(\t\022\026\n\016encryption" +
      "_key\030\003 \001(\t\"R\n\017OSLocatorParams\022?\n\016max_uri" +
      "_length\030\001 \001(\rB\'\332\336\037\006uint32\310\336\037\000\362\336\037\025yaml:\"m" +
      "ax_uri_length\"BS\n\031io.provenance.metadata" +
      ".v1P\001Z4github.com/provenance-io/provenan" +
      "ce/x/metadata/typesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf2.GoGoProtos.getDescriptor(),
        });
    internal_static_provenance_metadata_v1_ObjectStoreLocator_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_provenance_metadata_v1_ObjectStoreLocator_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_provenance_metadata_v1_ObjectStoreLocator_descriptor,
        new java.lang.String[] { "Owner", "LocatorUri", "EncryptionKey", });
    internal_static_provenance_metadata_v1_OSLocatorParams_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_provenance_metadata_v1_OSLocatorParams_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_provenance_metadata_v1_OSLocatorParams_descriptor,
        new java.lang.String[] { "MaxUriLength", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.protobuf2.GoGoProtos.customtype);
    registry.add(com.google.protobuf2.GoGoProtos.moretags);
    registry.add(com.google.protobuf2.GoGoProtos.nullable);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf2.GoGoProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}