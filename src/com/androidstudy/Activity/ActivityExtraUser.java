package com.androidstudy.Activity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Ynb007
 *
 */
//public class ActivityExtraUser implements Serializable{
public class ActivityExtraUser implements Parcelable{
	public ActivityExtraUser() {
	}
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ActivityExtraUser(Parcel source) {
		Bundle bundle = source.readBundle();
		this.id = bundle.getString("id");
		this.name = bundle.getString("name");
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int arg1) {
		Bundle bundle = new Bundle();
		bundle.putString("id", getId());
		bundle.putString("name", getName());
		dest.writeBundle(bundle);
	}
	
	public static final Creator<ActivityExtraUser> CREATOR = new Creator<ActivityExtraUser>(){

		@Override
		public ActivityExtraUser createFromParcel(Parcel source) {
			return new ActivityExtraUser(source);
		}

		@Override
		public ActivityExtraUser[] newArray(int arg0) {
			return new ActivityExtraUser[arg0];
		}};
	
}
