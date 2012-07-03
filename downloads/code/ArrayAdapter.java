package com.samarth.cricscore.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.samarth.cricscore.yahoo.json.Result;

public class ArrayAdapter<T> extends TypeAdapter<List<T>> {
	private Class<T> adapterclass;

	public ArrayAdapter(Class<T> adapterclass) {
		this.adapterclass = adapterclass;
	}

	public List<T> read(JsonReader reader) throws IOException {

		List<T> list = new ArrayList<T>();

		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(new ArrayAdapterFactory())
				.registerTypeAdapter(Result.class, new ResultAdapter())
				.create();

		if (reader.peek() == JsonToken.BEGIN_OBJECT) {
			T inning = gson.fromJson(reader, adapterclass);
			list.add(inning);

		} else if (reader.peek() == JsonToken.BEGIN_ARRAY) {

			reader.beginArray();
			while (reader.hasNext()) {
				T inning = gson.fromJson(reader, adapterclass);
				list.add(inning);
			}
			reader.endArray();

		}

		return list;
	}

	public void write(JsonWriter writer, List<T> value) throws IOException {

	}

}