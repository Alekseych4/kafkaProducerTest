/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.schemas;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class WriterResponseSchema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1157739255765306381L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WriterResponseSchema\",\"namespace\":\"com.example.schemas\",\"fields\":[{\"name\":\"writer\",\"type\":{\"type\":\"record\",\"name\":\"WriterSchema\",\"fields\":[{\"name\":\"nickname\",\"type\":\"string\"},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"surname\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"rating\",\"type\":[\"null\",\"double\"],\"default\":null}]}},{\"name\":\"nickname\",\"type\":\"string\"},{\"name\":\"greetMessage\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<WriterResponseSchema> ENCODER =
      new BinaryMessageEncoder<WriterResponseSchema>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<WriterResponseSchema> DECODER =
      new BinaryMessageDecoder<WriterResponseSchema>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<WriterResponseSchema> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<WriterResponseSchema> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<WriterResponseSchema> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<WriterResponseSchema>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this WriterResponseSchema to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a WriterResponseSchema from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a WriterResponseSchema instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static WriterResponseSchema fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private com.example.schemas.WriterSchema writer;
  private java.lang.CharSequence nickname;
  private java.lang.CharSequence greetMessage;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WriterResponseSchema() {}

  /**
   * All-args constructor.
   * @param writer The new value for writer
   * @param nickname The new value for nickname
   * @param greetMessage The new value for greetMessage
   */
  public WriterResponseSchema(com.example.schemas.WriterSchema writer, java.lang.CharSequence nickname, java.lang.CharSequence greetMessage) {
    this.writer = writer;
    this.nickname = nickname;
    this.greetMessage = greetMessage;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return writer;
    case 1: return nickname;
    case 2: return greetMessage;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: writer = (com.example.schemas.WriterSchema)value$; break;
    case 1: nickname = (java.lang.CharSequence)value$; break;
    case 2: greetMessage = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'writer' field.
   * @return The value of the 'writer' field.
   */
  public com.example.schemas.WriterSchema getWriter() {
    return writer;
  }


  /**
   * Sets the value of the 'writer' field.
   * @param value the value to set.
   */
  public void setWriter(com.example.schemas.WriterSchema value) {
    this.writer = value;
  }

  /**
   * Gets the value of the 'nickname' field.
   * @return The value of the 'nickname' field.
   */
  public java.lang.CharSequence getNickname() {
    return nickname;
  }


  /**
   * Sets the value of the 'nickname' field.
   * @param value the value to set.
   */
  public void setNickname(java.lang.CharSequence value) {
    this.nickname = value;
  }

  /**
   * Gets the value of the 'greetMessage' field.
   * @return The value of the 'greetMessage' field.
   */
  public java.lang.CharSequence getGreetMessage() {
    return greetMessage;
  }


  /**
   * Sets the value of the 'greetMessage' field.
   * @param value the value to set.
   */
  public void setGreetMessage(java.lang.CharSequence value) {
    this.greetMessage = value;
  }

  /**
   * Creates a new WriterResponseSchema RecordBuilder.
   * @return A new WriterResponseSchema RecordBuilder
   */
  public static com.example.schemas.WriterResponseSchema.Builder newBuilder() {
    return new com.example.schemas.WriterResponseSchema.Builder();
  }

  /**
   * Creates a new WriterResponseSchema RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WriterResponseSchema RecordBuilder
   */
  public static com.example.schemas.WriterResponseSchema.Builder newBuilder(com.example.schemas.WriterResponseSchema.Builder other) {
    if (other == null) {
      return new com.example.schemas.WriterResponseSchema.Builder();
    } else {
      return new com.example.schemas.WriterResponseSchema.Builder(other);
    }
  }

  /**
   * Creates a new WriterResponseSchema RecordBuilder by copying an existing WriterResponseSchema instance.
   * @param other The existing instance to copy.
   * @return A new WriterResponseSchema RecordBuilder
   */
  public static com.example.schemas.WriterResponseSchema.Builder newBuilder(com.example.schemas.WriterResponseSchema other) {
    if (other == null) {
      return new com.example.schemas.WriterResponseSchema.Builder();
    } else {
      return new com.example.schemas.WriterResponseSchema.Builder(other);
    }
  }

  /**
   * RecordBuilder for WriterResponseSchema instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WriterResponseSchema>
    implements org.apache.avro.data.RecordBuilder<WriterResponseSchema> {

    private com.example.schemas.WriterSchema writer;
    private com.example.schemas.WriterSchema.Builder writerBuilder;
    private java.lang.CharSequence nickname;
    private java.lang.CharSequence greetMessage;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.schemas.WriterResponseSchema.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.writer)) {
        this.writer = data().deepCopy(fields()[0].schema(), other.writer);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasWriterBuilder()) {
        this.writerBuilder = com.example.schemas.WriterSchema.newBuilder(other.getWriterBuilder());
      }
      if (isValidValue(fields()[1], other.nickname)) {
        this.nickname = data().deepCopy(fields()[1].schema(), other.nickname);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.greetMessage)) {
        this.greetMessage = data().deepCopy(fields()[2].schema(), other.greetMessage);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing WriterResponseSchema instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.schemas.WriterResponseSchema other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.writer)) {
        this.writer = data().deepCopy(fields()[0].schema(), other.writer);
        fieldSetFlags()[0] = true;
      }
      this.writerBuilder = null;
      if (isValidValue(fields()[1], other.nickname)) {
        this.nickname = data().deepCopy(fields()[1].schema(), other.nickname);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.greetMessage)) {
        this.greetMessage = data().deepCopy(fields()[2].schema(), other.greetMessage);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'writer' field.
      * @return The value.
      */
    public com.example.schemas.WriterSchema getWriter() {
      return writer;
    }


    /**
      * Sets the value of the 'writer' field.
      * @param value The value of 'writer'.
      * @return This builder.
      */
    public com.example.schemas.WriterResponseSchema.Builder setWriter(com.example.schemas.WriterSchema value) {
      validate(fields()[0], value);
      this.writerBuilder = null;
      this.writer = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'writer' field has been set.
      * @return True if the 'writer' field has been set, false otherwise.
      */
    public boolean hasWriter() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'writer' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.example.schemas.WriterSchema.Builder getWriterBuilder() {
      if (writerBuilder == null) {
        if (hasWriter()) {
          setWriterBuilder(com.example.schemas.WriterSchema.newBuilder(writer));
        } else {
          setWriterBuilder(com.example.schemas.WriterSchema.newBuilder());
        }
      }
      return writerBuilder;
    }

    /**
     * Sets the Builder instance for the 'writer' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.example.schemas.WriterResponseSchema.Builder setWriterBuilder(com.example.schemas.WriterSchema.Builder value) {
      clearWriter();
      writerBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'writer' field has an active Builder instance
     * @return True if the 'writer' field has an active Builder instance
     */
    public boolean hasWriterBuilder() {
      return writerBuilder != null;
    }

    /**
      * Clears the value of the 'writer' field.
      * @return This builder.
      */
    public com.example.schemas.WriterResponseSchema.Builder clearWriter() {
      writer = null;
      writerBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'nickname' field.
      * @return The value.
      */
    public java.lang.CharSequence getNickname() {
      return nickname;
    }


    /**
      * Sets the value of the 'nickname' field.
      * @param value The value of 'nickname'.
      * @return This builder.
      */
    public com.example.schemas.WriterResponseSchema.Builder setNickname(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.nickname = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'nickname' field has been set.
      * @return True if the 'nickname' field has been set, false otherwise.
      */
    public boolean hasNickname() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'nickname' field.
      * @return This builder.
      */
    public com.example.schemas.WriterResponseSchema.Builder clearNickname() {
      nickname = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'greetMessage' field.
      * @return The value.
      */
    public java.lang.CharSequence getGreetMessage() {
      return greetMessage;
    }


    /**
      * Sets the value of the 'greetMessage' field.
      * @param value The value of 'greetMessage'.
      * @return This builder.
      */
    public com.example.schemas.WriterResponseSchema.Builder setGreetMessage(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.greetMessage = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'greetMessage' field has been set.
      * @return True if the 'greetMessage' field has been set, false otherwise.
      */
    public boolean hasGreetMessage() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'greetMessage' field.
      * @return This builder.
      */
    public com.example.schemas.WriterResponseSchema.Builder clearGreetMessage() {
      greetMessage = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WriterResponseSchema build() {
      try {
        WriterResponseSchema record = new WriterResponseSchema();
        if (writerBuilder != null) {
          try {
            record.writer = this.writerBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("writer"));
            throw e;
          }
        } else {
          record.writer = fieldSetFlags()[0] ? this.writer : (com.example.schemas.WriterSchema) defaultValue(fields()[0]);
        }
        record.nickname = fieldSetFlags()[1] ? this.nickname : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.greetMessage = fieldSetFlags()[2] ? this.greetMessage : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<WriterResponseSchema>
    WRITER$ = (org.apache.avro.io.DatumWriter<WriterResponseSchema>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<WriterResponseSchema>
    READER$ = (org.apache.avro.io.DatumReader<WriterResponseSchema>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    this.writer.customEncode(out);

    out.writeString(this.nickname);

    out.writeString(this.greetMessage);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (this.writer == null) {
        this.writer = new com.example.schemas.WriterSchema();
      }
      this.writer.customDecode(in);

      this.nickname = in.readString(this.nickname instanceof Utf8 ? (Utf8)this.nickname : null);

      this.greetMessage = in.readString(this.greetMessage instanceof Utf8 ? (Utf8)this.greetMessage : null);

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (this.writer == null) {
            this.writer = new com.example.schemas.WriterSchema();
          }
          this.writer.customDecode(in);
          break;

        case 1:
          this.nickname = in.readString(this.nickname instanceof Utf8 ? (Utf8)this.nickname : null);
          break;

        case 2:
          this.greetMessage = in.readString(this.greetMessage instanceof Utf8 ? (Utf8)this.greetMessage : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









