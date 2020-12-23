/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.flight.status.api;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** A record for flight status information */
@org.apache.avro.specific.AvroGenerated
public class Flights extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3690999079841199050L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Flights\",\"namespace\":\"io.flight.status.api\",\"doc\":\"A record for flight status information\",\"fields\":[{\"name\":\"Flights\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Flight\",\"doc\":\"A flight object\",\"fields\":[{\"name\":\"lastUpdatedAt\",\"type\":[\"null\",\"string\"],\"doc\":\"The last updated date of the flight information\"},{\"name\":\"actualLandingTime\",\"type\":[\"null\",\"string\"],\"doc\":\"The actual landing time of the flight\"},{\"name\":\"aircraftRegistration\",\"type\":[\"null\",\"string\"],\"doc\":\"The aircraft registration number\"},{\"name\":\"AircraftType\",\"type\":{\"type\":\"record\",\"name\":\"AircraftType\",\"doc\":\"A record for aircraft type\",\"fields\":[{\"name\":\"iataMain\",\"type\":[\"null\",\"string\"],\"doc\":\"iata code\"},{\"name\":\"iataSub\",\"type\":[\"null\",\"string\"],\"doc\":\"iata code\"}]},\"doc\":\"The aircraft type\"},{\"name\":\"estimatedLandingTime\",\"type\":[\"null\",\"string\"],\"doc\":\"The estimated landing time\"},{\"name\":\"flightDirection\",\"type\":[\"null\",\"string\"],\"doc\":\"The direction of flight\"},{\"name\":\"flightName\",\"type\":[\"null\",\"string\"],\"doc\":\"The name of the flight\"},{\"name\":\"gate\",\"type\":[\"null\",\"string\"],\"doc\":\"The gate information\"},{\"name\":\"pier\",\"type\":[\"null\",\"string\"],\"doc\":\"The pier information\"},{\"name\":\"id\",\"type\":[\"null\",\"string\"],\"doc\":\"The id of the flight status record\"},{\"name\":\"isOperationalFlight\",\"type\":[\"null\",\"string\"],\"doc\":\"The indicator for the flight type\"},{\"name\":\"mainFlight\",\"type\":[\"null\",\"string\"],\"doc\":\"The main flight information\"},{\"name\":\"prefixIATA\",\"type\":[\"null\",\"string\"],\"doc\":\"The iata number\"},{\"name\":\"airlineCode\",\"type\":\"int\",\"doc\":\"The airline code\"},{\"name\":\"route\",\"type\":{\"type\":\"record\",\"name\":\"Route\",\"doc\":\"A record for route type\",\"fields\":[{\"name\":\"destinations\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"The destination information\"},{\"name\":\"eu\",\"type\":[\"null\",\"string\"],\"doc\":\"An indicator for whether the route is within EU or not\"},{\"name\":\"visa\",\"type\":[\"null\",\"string\"],\"doc\":\"An indicator to check whether the route is required to have a visa or not\"}]},\"doc\":\"The route information\"},{\"name\":\"scheduleDateTime\",\"type\":[\"null\",\"string\"],\"doc\":\"The scheduled date time information\"},{\"name\":\"scheduleDate\",\"type\":[\"null\",\"string\"],\"doc\":\"The scheduled date information\"},{\"name\":\"scheduleTime\",\"type\":[\"null\",\"string\"],\"doc\":\"The scheduled time information\"}]}},\"doc\":\"The flight list\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Flights> ENCODER =
      new BinaryMessageEncoder<Flights>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Flights> DECODER =
      new BinaryMessageDecoder<Flights>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Flights> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Flights> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Flights> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Flights>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Flights to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Flights from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Flights instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Flights fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The flight list */
   private java.util.List<io.flight.status.api.Flight> Flights;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Flights() {}

  /**
   * All-args constructor.
   * @param Flights The flight list
   */
  public Flights(java.util.List<io.flight.status.api.Flight> Flights) {
    this.Flights = Flights;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Flights;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Flights = (java.util.List<io.flight.status.api.Flight>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'Flights' field.
   * @return The flight list
   */
  public java.util.List<io.flight.status.api.Flight> getFlights() {
    return Flights;
  }


  /**
   * Sets the value of the 'Flights' field.
   * The flight list
   * @param value the value to set.
   */
  public void setFlights(java.util.List<io.flight.status.api.Flight> value) {
    this.Flights = value;
  }

  /**
   * Creates a new Flights RecordBuilder.
   * @return A new Flights RecordBuilder
   */
  public static io.flight.status.api.Flights.Builder newBuilder() {
    return new io.flight.status.api.Flights.Builder();
  }

  /**
   * Creates a new Flights RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Flights RecordBuilder
   */
  public static io.flight.status.api.Flights.Builder newBuilder(io.flight.status.api.Flights.Builder other) {
    if (other == null) {
      return new io.flight.status.api.Flights.Builder();
    } else {
      return new io.flight.status.api.Flights.Builder(other);
    }
  }

  /**
   * Creates a new Flights RecordBuilder by copying an existing Flights instance.
   * @param other The existing instance to copy.
   * @return A new Flights RecordBuilder
   */
  public static io.flight.status.api.Flights.Builder newBuilder(io.flight.status.api.Flights other) {
    if (other == null) {
      return new io.flight.status.api.Flights.Builder();
    } else {
      return new io.flight.status.api.Flights.Builder(other);
    }
  }

  /**
   * RecordBuilder for Flights instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Flights>
    implements org.apache.avro.data.RecordBuilder<Flights> {

    /** The flight list */
    private java.util.List<io.flight.status.api.Flight> Flights;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.flight.status.api.Flights.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Flights)) {
        this.Flights = data().deepCopy(fields()[0].schema(), other.Flights);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing Flights instance
     * @param other The existing instance to copy.
     */
    private Builder(io.flight.status.api.Flights other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.Flights)) {
        this.Flights = data().deepCopy(fields()[0].schema(), other.Flights);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'Flights' field.
      * The flight list
      * @return The value.
      */
    public java.util.List<io.flight.status.api.Flight> getFlights() {
      return Flights;
    }


    /**
      * Sets the value of the 'Flights' field.
      * The flight list
      * @param value The value of 'Flights'.
      * @return This builder.
      */
    public io.flight.status.api.Flights.Builder setFlights(java.util.List<io.flight.status.api.Flight> value) {
      validate(fields()[0], value);
      this.Flights = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'Flights' field has been set.
      * The flight list
      * @return True if the 'Flights' field has been set, false otherwise.
      */
    public boolean hasFlights() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'Flights' field.
      * The flight list
      * @return This builder.
      */
    public io.flight.status.api.Flights.Builder clearFlights() {
      Flights = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Flights build() {
      try {
        Flights record = new Flights();
        record.Flights = fieldSetFlags()[0] ? this.Flights : (java.util.List<io.flight.status.api.Flight>) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Flights>
    WRITER$ = (org.apache.avro.io.DatumWriter<Flights>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Flights>
    READER$ = (org.apache.avro.io.DatumReader<Flights>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    long size0 = this.Flights.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (io.flight.status.api.Flight e0: this.Flights) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      long size0 = in.readArrayStart();
      java.util.List<io.flight.status.api.Flight> a0 = this.Flights;
      if (a0 == null) {
        a0 = new SpecificData.Array<io.flight.status.api.Flight>((int)size0, SCHEMA$.getField("Flights").schema());
        this.Flights = a0;
      } else a0.clear();
      SpecificData.Array<io.flight.status.api.Flight> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<io.flight.status.api.Flight>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          io.flight.status.api.Flight e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new io.flight.status.api.Flight();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          long size0 = in.readArrayStart();
          java.util.List<io.flight.status.api.Flight> a0 = this.Flights;
          if (a0 == null) {
            a0 = new SpecificData.Array<io.flight.status.api.Flight>((int)size0, SCHEMA$.getField("Flights").schema());
            this.Flights = a0;
          } else a0.clear();
          SpecificData.Array<io.flight.status.api.Flight> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<io.flight.status.api.Flight>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              io.flight.status.api.Flight e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new io.flight.status.api.Flight();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









