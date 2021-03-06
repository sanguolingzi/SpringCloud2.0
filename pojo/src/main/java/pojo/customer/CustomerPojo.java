package pojo.customer;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "busi_customer")
public class CustomerPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 0 女 1男
     */
    private Short sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 头像
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 账号状态 0 未冻结 1已冻结 
     */
    @Column(name = "account_status")
    private Short accountStatus;

    /**
     * 身份证号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 登录密码   
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 支付密码  
     */
    @Column(name = "pay_password")
    private String payPassword;

    /**
     * 注销状态 0 未注销 1 已注销
     */
    @Column(name = "cancel_status")
    private Short cancelStatus;

    /**
     * 推荐二维码密钥
     */
    @Column(name = "qrcode_secret")
    private String qrcodeSecret;

    /**
     * 个人二维码图片地址
     */
    @Column(name = "person_qrcode")
    private String personQrcode;

    @Column(name = "del_flag")
    private Short delFlag;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 是否会员 0 是 1 不是 
     */
    @Column(name = "is_member")
    private Short isMember;

    /**
     * 已关联游戏用户的游戏账号Id
     */
    @Column(name = "game_id")
    private Integer gameId;

    /**
     * 是否合作商 0是  1不是
     */
    @Column(name = "is_partner")
    private Short isPartner;

    /**
     * 合伙人比例
     */
    private BigDecimal proportion;

    /**
     * 会员推荐码
     */
    @Column(name = "recommend_code")
    private String recommendCode;

    /**
     * 推荐奖励是否赠送 0 为赠送 1已赠送
     */
    @Column(name = "recommend_reward")
    private Short recommendReward;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取0 女 1男
     *
     * @return sex - 0 女 1男
     */
    public Short getSex() {
        return sex;
    }

    /**
     * 设置0 女 1男
     *
     * @param sex 0 女 1男
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取头像
     *
     * @return photo_url - 头像
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 设置头像
     *
     * @param photoUrl 头像
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    /**
     * 获取账号状态 0 未冻结 1已冻结 
     *
     * @return account_status - 账号状态 0 未冻结 1已冻结 
     */
    public Short getAccountStatus() {
        return accountStatus;
    }

    /**
     * 设置账号状态 0 未冻结 1已冻结 
     *
     * @param accountStatus 账号状态 0 未冻结 1已冻结 
     */
    public void setAccountStatus(Short accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 获取身份证号
     *
     * @return id_card - 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取登录密码   
     *
     * @return login_password - 登录密码   
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置登录密码   
     *
     * @param loginPassword 登录密码   
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 获取支付密码  
     *
     * @return pay_password - 支付密码  
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 设置支付密码  
     *
     * @param payPassword 支付密码  
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    /**
     * 获取注销状态 0 未注销 1 已注销
     *
     * @return cancel_status - 注销状态 0 未注销 1 已注销
     */
    public Short getCancelStatus() {
        return cancelStatus;
    }

    /**
     * 设置注销状态 0 未注销 1 已注销
     *
     * @param cancelStatus 注销状态 0 未注销 1 已注销
     */
    public void setCancelStatus(Short cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    /**
     * 获取推荐二维码密钥
     *
     * @return qrcode_secret - 推荐二维码密钥
     */
    public String getQrcodeSecret() {
        return qrcodeSecret;
    }

    /**
     * 设置推荐二维码密钥
     *
     * @param qrcodeSecret 推荐二维码密钥
     */
    public void setQrcodeSecret(String qrcodeSecret) {
        this.qrcodeSecret = qrcodeSecret;
    }

    /**
     * 获取个人二维码图片地址
     *
     * @return person_qrcode - 个人二维码图片地址
     */
    public String getPersonQrcode() {
        return personQrcode;
    }

    /**
     * 设置个人二维码图片地址
     *
     * @param personQrcode 个人二维码图片地址
     */
    public void setPersonQrcode(String personQrcode) {
        this.personQrcode = personQrcode;
    }

    /**
     * @return del_flag
     */
    public Short getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取是否会员 0 是 1 不是 
     *
     * @return is_member - 是否会员 0 是 1 不是 
     */
    public Short getIsMember() {
        return isMember;
    }

    /**
     * 设置是否会员 0 是 1 不是 
     *
     * @param isMember 是否会员 0 是 1 不是 
     */
    public void setIsMember(Short isMember) {
        this.isMember = isMember;
    }

    /**
     * 获取已关联游戏用户的游戏账号Id
     *
     * @return game_id - 已关联游戏用户的游戏账号Id
     */
    public Integer getGameId() {
        return gameId;
    }

    /**
     * 设置已关联游戏用户的游戏账号Id
     *
     * @param gameId 已关联游戏用户的游戏账号Id
     */
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    /**
     * 获取是否合作商 0是  1不是
     *
     * @return is_partner - 是否合作商 0是  1不是
     */
    public Short getIsPartner() {
        return isPartner;
    }

    /**
     * 设置是否合作商 0是  1不是
     *
     * @param isPartner 是否合作商 0是  1不是
     */
    public void setIsPartner(Short isPartner) {
        this.isPartner = isPartner;
    }

    /**
     * 获取合伙人比例
     *
     * @return proportion - 合伙人比例
     */
    public BigDecimal getProportion() {
        return proportion;
    }

    /**
     * 设置合伙人比例
     *
     * @param proportion 合伙人比例
     */
    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    /**
     * 获取会员推荐码
     *
     * @return recommend_code - 会员推荐码
     */
    public String getRecommendCode() {
        return recommendCode;
    }

    /**
     * 设置会员推荐码
     *
     * @param recommendCode 会员推荐码
     */
    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }

    /**
     * 获取推荐奖励是否赠送 0 为赠送 1已赠送
     *
     * @return recommend_reward - 推荐奖励是否赠送 0 为赠送 1已赠送
     */
    public Short getRecommendReward() {
        return recommendReward;
    }

    /**
     * 设置推荐奖励是否赠送 0 为赠送 1已赠送
     *
     * @param recommendReward 推荐奖励是否赠送 0 为赠送 1已赠送
     */
    public void setRecommendReward(Short recommendReward) {
        this.recommendReward = recommendReward;
    }
}