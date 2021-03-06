package com.ruoyi.entity;

public class Tea {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tea.tea_id
     *
     * @mbggenerated
     */
    private Integer teaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tea.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tea.sex
     *
     * @mbggenerated
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tea.phonenumber
     *
     * @mbggenerated
     */
    private String phonenumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tea
     *
     * @mbggenerated
     */
    public Tea(Integer teaId, String name, String sex, String phonenumber) {
        this.teaId = teaId;
        this.name = name;
        this.sex = sex;
        this.phonenumber = phonenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tea
     *
     * @mbggenerated
     */
    public Tea() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tea.tea_id
     *
     * @return the value of t_tea.tea_id
     *
     * @mbggenerated
     */
    public Integer getTeaId() {
        return teaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tea.tea_id
     *
     * @param teaId the value for t_tea.tea_id
     *
     * @mbggenerated
     */
    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tea.name
     *
     * @return the value of t_tea.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tea.name
     *
     * @param name the value for t_tea.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tea.sex
     *
     * @return the value of t_tea.sex
     *
     * @mbggenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tea.sex
     *
     * @param sex the value for t_tea.sex
     *
     * @mbggenerated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tea.phonenumber
     *
     * @return the value of t_tea.phonenumber
     *
     * @mbggenerated
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tea.phonenumber
     *
     * @param phonenumber the value for t_tea.phonenumber
     *
     * @mbggenerated
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
}