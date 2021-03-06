package com.plivo.api.models.phlo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PhloGetter extends Getter<Phlo> {

  public PhloGetter(final String phloId) {
    super(phloId);
  }

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  @Override
  protected Call<Phlo> obtainCall() {
    return client().getApiService().phloGet(this.id);
  }

}
