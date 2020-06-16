package com.meowmeow.dhateapp.Adapter;

import java.util.List;

class TinderUser {
    private String _id;
    private Integer age_filter_max;
    private Integer age_filter_min;
    private String birth_date;
    private String create_date;

    private String crm_id;
    private boolean discoverable;
    private List<Object> interests;
    private Integer distance_filter;
    private Integer gender;

    private Integer gender_filter;
    private boolean show_gender_on_profile;
    private String name;
    private List<Object> photos;
    private boolean photos_processing;

    private boolean photo_optimizer_enabled;
    private String ping_time;
    private List<Object> schools;
    private List<Object> badges;
    private String phone_id;

    private List<Object> interested_in;
    private Object pos;
    private String autoplay_video;
    private boolean top_picks_discoverable;
    private boolean photo_tagging_enabled;

    private Object user_interests;
    private boolean recommended_sort_discoverable;
    private String selfie_verification;
    private boolean noonlight_protected;
    private boolean sync_swipe_enabled;

    public TinderUser(){}
    public TinderUser(String _id, Integer age_filter_max, Integer age_filter_min, String birth_date, String create_date, String crm_id, boolean discoverable, List<Object> interests, Integer distance_filter, Integer gender, Integer gender_filter, boolean show_gender_on_profile, String name, List<Object> photos, boolean photos_processing, boolean photo_optimizer_enabled, String ping_time, List<Object> schools, List<Object> badges, String phone_id, List<Object> interested_in, Object pos, String autoplay_video, boolean top_picks_discoverable, boolean photo_tagging_enabled, Object user_interests, boolean recommended_sort_discoverable, String selfie_verification, boolean noonlight_protected, boolean sync_swipe_enabled) {
        this._id = _id;
        this.age_filter_max = age_filter_max;
        this.age_filter_min = age_filter_min;
        this.birth_date = birth_date;
        this.create_date = create_date;
        this.crm_id = crm_id;
        this.discoverable = discoverable;
        this.interests = interests;
        this.distance_filter = distance_filter;
        this.gender = gender;
        this.gender_filter = gender_filter;
        this.show_gender_on_profile = show_gender_on_profile;
        this.name = name;
        this.photos = photos;
        this.photos_processing = photos_processing;
        this.photo_optimizer_enabled = photo_optimizer_enabled;
        this.ping_time = ping_time;
        this.schools = schools;
        this.badges = badges;
        this.phone_id = phone_id;
        this.interested_in = interested_in;
        this.pos = pos;
        this.autoplay_video = autoplay_video;
        this.top_picks_discoverable = top_picks_discoverable;
        this.photo_tagging_enabled = photo_tagging_enabled;
        this.user_interests = user_interests;
        this.recommended_sort_discoverable = recommended_sort_discoverable;
        this.selfie_verification = selfie_verification;
        this.noonlight_protected = noonlight_protected;
        this.sync_swipe_enabled = sync_swipe_enabled;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setAge_filter_max(Integer age_filter_max) {
        this.age_filter_max = age_filter_max;
    }

    public void setAge_filter_min(Integer age_filter_min) {
        this.age_filter_min = age_filter_min;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public void setCrm_id(String crm_id) {
        this.crm_id = crm_id;
    }

    public void setDiscoverable(boolean discoverable) {
        this.discoverable = discoverable;
    }

    public void setInterests(List<Object> interests) {
        this.interests = interests;
    }

    public void setDistance_filter(Integer distance_filter) {
        this.distance_filter = distance_filter;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setGender_filter(Integer gender_filter) {
        this.gender_filter = gender_filter;
    }

    public void setShow_gender_on_profile(boolean show_gender_on_profile) {
        this.show_gender_on_profile = show_gender_on_profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotos(List<Object> photos) {
        this.photos = photos;
    }

    public void setPhotos_processing(boolean photos_processing) {
        this.photos_processing = photos_processing;
    }

    public void setPhoto_optimizer_enabled(boolean photo_optimizer_enabled) {
        this.photo_optimizer_enabled = photo_optimizer_enabled;
    }

    public void setPing_time(String ping_time) {
        this.ping_time = ping_time;
    }

    public void setSchools(List<Object> schools) {
        this.schools = schools;
    }

    public void setBadges(List<Object> badges) {
        this.badges = badges;
    }

    public void setPhone_id(String phone_id) {
        this.phone_id = phone_id;
    }

    public void setInterested_in(List<Object> interested_in) {
        this.interested_in = interested_in;
    }

    public void setPos(Object pos) {
        this.pos = pos;
    }

    public void setAutoplay_video(String autoplay_video) {
        this.autoplay_video = autoplay_video;
    }

    public void setTop_picks_discoverable(boolean top_picks_discoverable) {
        this.top_picks_discoverable = top_picks_discoverable;
    }

    public void setPhoto_tagging_enabled(boolean photo_tagging_enabled) {
        this.photo_tagging_enabled = photo_tagging_enabled;
    }

    public void setUser_interests(Object user_interests) {
        this.user_interests = user_interests;
    }

    public void setRecommended_sort_discoverable(boolean recommended_sort_discoverable) {
        this.recommended_sort_discoverable = recommended_sort_discoverable;
    }

    public void setSelfie_verification(String selfie_verification) {
        this.selfie_verification = selfie_verification;
    }

    public void setNoonlight_protected(boolean noonlight_protected) {
        this.noonlight_protected = noonlight_protected;
    }

    public void setSync_swipe_enabled(boolean sync_swipe_enabled) {
        this.sync_swipe_enabled = sync_swipe_enabled;
    }

    public String get_id() {
        return _id;
    }

    public Integer getAge_filter_max() {
        return age_filter_max;
    }

    public Integer getAge_filter_min() {
        return age_filter_min;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getCrm_id() {
        return crm_id;
    }

    public boolean isDiscoverable() {
        return discoverable;
    }

    public List<Object> getInterests() {
        return interests;
    }

    public Integer getDistance_filter() {
        return distance_filter;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getGender_filter() {
        return gender_filter;
    }

    public boolean isShow_gender_on_profile() {
        return show_gender_on_profile;
    }

    public String getName() {
        return name;
    }

    public List<Object> getPhotos() {
        return photos;
    }

    public boolean isPhotos_processing() {
        return photos_processing;
    }

    public boolean isPhoto_optimizer_enabled() {
        return photo_optimizer_enabled;
    }

    public String getPing_time() {
        return ping_time;
    }

    public List<Object> getSchools() {
        return schools;
    }

    public List<Object> getBadges() {
        return badges;
    }

    public String getPhone_id() {
        return phone_id;
    }

    public List<Object> getInterested_in() {
        return interested_in;
    }

    public Object getPos() {
        return pos;
    }

    public String getAutoplay_video() {
        return autoplay_video;
    }

    public boolean isTop_picks_discoverable() {
        return top_picks_discoverable;
    }

    public boolean isPhoto_tagging_enabled() {
        return photo_tagging_enabled;
    }

    public Object getUser_interests() {
        return user_interests;
    }

    public boolean isRecommended_sort_discoverable() {
        return recommended_sort_discoverable;
    }

    public String getSelfie_verification() {
        return selfie_verification;
    }

    public boolean isNoonlight_protected() {
        return noonlight_protected;
    }

    public boolean isSync_swipe_enabled() {
        return sync_swipe_enabled;
    }
}
