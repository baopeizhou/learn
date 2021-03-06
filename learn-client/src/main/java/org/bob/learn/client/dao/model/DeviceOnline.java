package org.bob.learn.client.dao.model;

import java.io.Serializable;
import java.util.Date;

public class DeviceOnline implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DEVICE_ONLINE.MAC
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    private String mac;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DEVICE_ONLINE.DMAC
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    private String dmac;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DEVICE_ONLINE.TIME
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DEVICE_ONLINE
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DEVICE_ONLINE.MAC
     *
     * @return the value of DEVICE_ONLINE.MAC
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    public String getMac() {
        return mac;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DEVICE_ONLINE.MAC
     *
     * @param mac the value for DEVICE_ONLINE.MAC
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DEVICE_ONLINE.DMAC
     *
     * @return the value of DEVICE_ONLINE.DMAC
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    public String getDmac() {
        return dmac;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DEVICE_ONLINE.DMAC
     *
     * @param dmac the value for DEVICE_ONLINE.DMAC
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    public void setDmac(String dmac) {
        this.dmac = dmac == null ? null : dmac.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DEVICE_ONLINE.TIME
     *
     * @return the value of DEVICE_ONLINE.TIME
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DEVICE_ONLINE.TIME
     *
     * @param time the value for DEVICE_ONLINE.TIME
     *
     * @mbg.generated Mon Jun 10 17:07:19 CST 2019
     */
    public void setTime(Date time) {
        this.time = time;
    }
}